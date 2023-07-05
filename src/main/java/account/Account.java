package account;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * The type Account.
 */
@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
    @Column(name = "role")
    private String role;
    @Column(name = "password")
    private String password;
    @Column(name = "ticket")
    private Integer ticket;

    /**
     * Instantiates a new Account.
     *
     * @param id        the id
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param role      the role
     * @param ticket    the ticket
     * @param password  the password
     */
    public Account(int id, String firstName, String lastName, String email, String role, Integer ticket, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
        this.ticket = ticket;
    }

    /**
     * Instantiates a new Account.
     */
    public Account() {

    }

    /**
     * Instantiates a new Account.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     */
    public Account(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Instantiates a new Account.
     *
     * @param email    the email
     * @param password the password
     */
    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
