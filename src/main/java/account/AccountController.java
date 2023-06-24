package account;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;

    }

    @GetMapping("/")
    public String homePage()
    {
        return "accounts/home-page";
    }
    @GetMapping("list")
    public String listEmployees(Model theModel) {

        List<Account> accounts = accountService.findAll();
        // add to the spring model
        theModel.addAttribute("accounts", accounts);

        return "accounts/list-account";
    }
    @GetMapping("/showFormForAdd")
    public String showForm(Model model)
    {
        Account account = new Account();
        model.addAttribute("account", account);
        return "accounts/account-form";
    }
    @GetMapping("/signInForm")
    public String sign_in(Model model)
    {
        Account account = new Account();
        model.addAttribute("account", account);
        return "accounts/sign-in-form";
    }

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("account") Account account, Model model)
    {
        accountService.registerNewUserAccount(account);
        Account acc = accountService.findByEmail(account.getEmail());
        model.addAttribute("userId", acc.getId());
        if(account.getRole().equals("seller")) return "accounts/seller-page";
        if(account.getRole().equals("buyer")) return "accounts/buyer-page";
        //return "redirect:/api/account/list";
        return null;
    }
    @PostMapping("/signIn")
    public String login(@ModelAttribute("account") Account account, Model model)
    {
        Account user = accountService.login(account.getEmail(), account.getPassword());
        Account acc = accountService.findByEmail(account.getEmail());
        model.addAttribute("userId", acc.getId());
        if(user != null) return "accounts/seller-page";
        return "accounts/buyer-page";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String sessionId = session.getId();
        session.invalidate(); // Инвалидируем сессию
        return "redirect:signInForm";
    }
}