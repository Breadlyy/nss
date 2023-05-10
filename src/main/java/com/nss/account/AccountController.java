package com.nss.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.List;


@Controller
public class AccountController {

    private AccountService accountService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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
    public String saveAccount(@ModelAttribute("account") Account account)
    {

        String password = account.getPassword();
        String hashedPassword = passwordEncoder.encode(password);
        account.setPassword(hashedPassword);
        accountService.save(account);
        if(account.getRole() == "seller") return "redirect:accounts/seller-page";
        //return "redirect:/api/account/list";
        return "accounts/seller-page";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("account") Account account)
    {
        String password = accountService.findByEmail(account.getEmail()).getPassword();
        if (password.equals(account.getPassword()))
        {
            return "accounts/seller-page";
        }
        //return "redirect:/api/account/list";
        return null;
    }
}
