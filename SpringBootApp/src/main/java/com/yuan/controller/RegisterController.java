package com.yuan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @GetMapping(value = "/register")
    public String pageRegister(Model model) {
        String name = "yuan";
        model.addAttribute("name", name);
        return "register";
    }
}
