package ticket;

import com.example.ticket.ticket.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAllByEmail(String email);
}
