package account;

import java.util.List;

public interface AccountService {
    public Account registerNewUserAccount(Account account);
    public Account login(String email, String password);
    public List<Account> findAll();
    public Account findByEmail(String email);
    public Account findById(int id);
    public void save(Account account);
    public void deleteById(int id);

}
