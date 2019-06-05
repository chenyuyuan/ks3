package com.yuan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = "/register")
    public String pageLogin(Model model) {
        String name = "yuan";
        model.addAttribute("name", name);
        return "register";
    }
}
