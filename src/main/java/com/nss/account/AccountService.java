package com.nss.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
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
