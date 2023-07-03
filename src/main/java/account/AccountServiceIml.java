package account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceIml implements AccountService {
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AccountServiceIml(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }
    public Account registerNewUserAccount(Account account) {
        String password = passwordEncoder.encode(account.getPassword());
        Account user = Account.builder().
                firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .password(password)
                .build();

        return accountRepository.save(user);
    }
    public Account login(String email, String password)
    {
        Account user = this.findByEmail(email);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else
        {
            return null;
        }
    }

    public List<Account> findAll()
    {
        return accountRepository.findAllByOrderByLastNameAsc();
    }
    public Account findByEmail(String email)
    {
        Account result = accountRepository.findByEmail(email);
        if(result != null)
        {
            return result;
        }
        else
        {
            throw new RuntimeException("Did not find account email - " + email);
        }
    }
    public Account findById(int id)
    {
        Optional<Account> result = accountRepository.findById(id);

        Account account = null;
        if(result.isPresent())
        {
            account = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find account id - " + id);
        }
        return account;
    }

    public void save(Account account)
    {
        accountRepository.save(account);
    }
    public void deleteById(int id) {
        accountRepository.deleteById(id);
    }

}
