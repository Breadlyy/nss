package com.nss.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Integer> {
     List<Account> findAllByOrderByLastNameAsc();
     Account findByEmail(String email);
}
