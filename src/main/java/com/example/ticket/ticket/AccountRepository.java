package com.example.ticket.ticket;

import com.example.ticket.ticket.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository is an interface of Spring Data JPA framework
 * JpaRepository extends another interface - CrudRepository
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {
    /**
     * Find all by email account.
     *
     * @param email the email
     * @return the account
     */
    Account findAllByEmail(String email);
}
