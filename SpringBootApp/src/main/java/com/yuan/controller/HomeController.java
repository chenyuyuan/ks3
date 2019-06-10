package com.yuan.controller;

import com.yuan.entity.*;
import com.yuan.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/home")
    public String pageLogin(Model model, HttpServletRequest request) {
        String name = "yuan";
        ArrayList<CardEssay> listCardEssay = homeService.getAllCardEssay();
        ArrayList<CardApplyCommunity> listCardApplyCommunity = homeService.getAllCardApplyCommunity();


        HttpSession session = request.getSession();

        String account = (String)session.getAttribute("account");

        System.out.println(session.getId());
        System.out.println(name);


        model.addAttribute("name", name);
        model.addAttribute("cardEssay", listCardEssay);
        model.addAttribute("cardApplyCommunity", listCardApplyCommunity);
        return "home";
    }
}
