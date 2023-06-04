package com.nss.account;

//import com.nss.account.config.AccountPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }
    public Account registerNewUserAccount(Account account) {
        Account user = new Account();
        String password = passwordEncoder.encode(account.getPassword());
        user.setFirstName(account.getFirstName());
        user.setLastName(account.getLastName());
        user.setEmail(account.getEmail());
        user.setRole(account.getRole());
        user.setPassword(password);

//        Authentication authentication = new UsernamePasswordAuthenticationToken(account.getEmail(), password);
//// Установка аутентификации в контекст безопасности
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return accountRepository.save(user);
    }
    public Account login(String email, String password)
    {
        Account user = this.findByEmail(email);
        if (passwordEncoder.matches(password, user.getPassword())) {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), password);

// Установка аутентификации в контекст безопасности
//            SecurityContextHolder.getContext().setAuthentication(authentication);
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

    public Account findByActive(boolean b) {
        Optional<Account> result = Optional.ofNullable(accountRepository.findByActive(true));

        Account account = null;
        if(result.isPresent())
        {
            account = result.get();
        }
        else
        {
            throw new RuntimeException("Did not find account ");
        }
        return account;
    }
}
