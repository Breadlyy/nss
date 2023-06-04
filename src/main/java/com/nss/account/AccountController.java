package com.nss.account;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.util.List;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class AccountController {

    private final AccountService accountService;
    private final SessionRepository sessionRepository;

    @Autowired
    public AccountController(AccountService accountService, SessionRepository sessionRepository)
    {
        this.accountService = accountService;
        this.sessionRepository = sessionRepository;
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
        account.setActive(true);
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
    public String saveAccount(@ModelAttribute("account") Account account, HttpSession session)
    {
        sessionRepository.saveSession(session.getId(), account.getEmail());
        accountService.registerNewUserAccount(account);
        if(account.getRole().equals("seller")) return "accounts/seller-page";
        if(account.getRole().equals("buyer")) return "accounts/buyer-page";
        //return "redirect:/api/account/list";
        return null;
    }
    @PostMapping("/signIn")
    public String login(@ModelAttribute("account") Account account, HttpSession session)
    {
        sessionRepository.saveSession(session.getId(), account.getEmail());
        Account user = accountService.login(account.getEmail(), account.getPassword());
        if(user != null) return "accounts/seller-page";
        return "accounts/buyer-page";
    }
    @PostMapping("api/user")
    public Account createUser(@RequestBody Account user){
        return this.accountService.registerNewUserAccount(user);
    }
//    @GetMapping("/user")
//    public String user()
//    {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.getName();
//        return "accounts/buyer-page";
//    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String sessionId = session.getId();
        session.invalidate(); // Инвалидируем сессию
        sessionRepository.deleteSession(sessionId); // Удаляем сессию из базы данных
        return "redirect:signInForm";
    }
    @GetMapping("/currentUser")
    public void user(HttpSession session, HttpServletResponse response) throws IOException {
       String username = sessionRepository.getUsernameBySessionId(session.getId());
        response.getWriter().write(username);
    }
    @GetMapping("/currentSession")
    public void sesseion(HttpSession session, HttpServletResponse response) throws IOException {
        response.getWriter().write(session.getId());
    }
}
