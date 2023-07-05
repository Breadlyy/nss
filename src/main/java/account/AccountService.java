package account;

import java.util.List;

/**
 * The interface Account service.
 */
public interface AccountService {
    /**
     * Register new user account account.
     *
     * @param account the account
     * @return the account
     */
    public Account registerNewUserAccount(Account account);

    /**
     * Login account.
     *
     * @param email    the email
     * @param password the password
     * @return the account
     */
    public Account login(String email, String password);

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<Account> findAll();

    /**
     * Find by email account.
     *
     * @param email the email
     * @return the account
     */
    public Account findByEmail(String email);

    /**
     * Find by id account.
     *
     * @param id the id
     * @return the account
     */
    public Account findById(int id);

    /**
     * Save.
     *
     * @param account the account
     */
    public void save(Account account);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(int id);

}
