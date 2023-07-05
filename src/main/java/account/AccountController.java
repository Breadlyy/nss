package account;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Account controller.
 */
@Controller
public class AccountController {

    private final AccountServiceIml accountServiceIml;

    /**
     * Instantiates a new Account controller.
     *
     * @param accountServiceIml the account service iml
     */
    @Autowired
    public AccountController(AccountServiceIml accountServiceIml) {
        this.accountServiceIml = accountServiceIml;

    }

    /**
     * Home page string.
     *
     * @return html template with buttons "sign up" and "sign in"
     */
    @GetMapping("/")
    public String homePage() {
        return "accounts/home-page";
    }

//    @GetMapping("list")
//    public String listEmployees(Model theModel) {
//
//        List<Account> accounts = accountServiceIml.findAll();
//        // add to the spring model
//        theModel.addAttribute("accounts", accounts);
//
//        return "accounts/list-account";
//    }

    /**
     * Show form string.
     *
     * @param model the model
     * @return html template with registration form for user
     */
    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "accounts/account-form";
    }

    /**
     * Sign in string.
     *
     * @param model the model
     * @return login form. will find the user in accordance with email and also check hashed password
     */
    @GetMapping("/signInForm")
    public String sign_in(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "accounts/sign-in-form";
    }

    /**
     * Save account string.
     *
     * @param account gets from the model of registration template
     * @param model   the model
     * @return save user in db. In case of blank email or password will trigger the registration interceptor
     */
    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("account") Account account, Model model) {
        Account ac = accountServiceIml.registerNewUserAccount(account);
        if(ac == null) return null;
        Account acc = accountServiceIml.findByEmail(account.getEmail());
        model.addAttribute("userId", acc.getId());
        if (account.getRole().equals("seller")) return "accounts/seller-page";
        if (account.getRole().equals("buyer")) return "accounts/buyer-page";
        //return "redirect:/api/account/list";
        return null;
    }

    /**
     * Login string.
     *
     * @param account gets from the model of log in template
     * @param model   the model
     * @return in case of successful sign in will return either seller or buyer template, dependence on role
     */
    @PostMapping("/signIn")
    public String login(@ModelAttribute("account") Account account, Model model) {
        Account user = accountServiceIml.login(account.getEmail(), account.getPassword());
        Account acc = accountServiceIml.findByEmail(account.getEmail());
        model.addAttribute("userId", acc.getId());
        if (user.getRole().equals("seller")) return "accounts/seller-page";
        return "accounts/buyer-page";
    }

    /**
     * Logout string.
     *
     * @param session the session
     * @return logout the user
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String sessionId = session.getId();
        session.invalidate(); // Инвалидируем сессию
        return "redirect:signInForm";
    }
//    @GetMapping("/accounts")
//    public void accounts(HttpServletResponse response) throws IOException {
//        response.getWriter().write(accountServiceIml.findAll().toString());
//    }
}
