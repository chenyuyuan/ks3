package com.yuan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value = {"/login","/"})
    public String pageLogin(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println("Login: "+session.getId());
        System.out.println(account);

        String name = "yuan";
        model.addAttribute("name", name);
        return "login";
    }

}
