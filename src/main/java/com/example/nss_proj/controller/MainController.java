package com.example.nss_proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("theDate", new java.util.Date());
        return "index";
    }
}
