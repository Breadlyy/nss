package account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository is an interface of Spring Data JPA framework
 * JpaRepository extends another interface - CrudRepository
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {
     /**
      * Find all by order by last name asc list.
      *
      * @return the list
      */
     List<Account> findAllByOrderByLastNameAsc();

     /**
      * Find by email account.
      *
      * @param email the email
      * @return the account
      */
     Account findByEmail(String email);
}
