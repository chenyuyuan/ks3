package com.yuan.controller;

import com.yuan.entity.Essay;
import com.yuan.entity.EssayContent;
import com.yuan.entity.User;
import com.yuan.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/home")
    public String pageLogin(Model model) {
        String name = "yuan";
        ArrayList<Essay> list_Essay = homeService.getAllEssay();
        ArrayList<EssayContent> list_Essay_Content = homeService.getAllEssayContent();
        model.addAttribute("name", name);
        model.addAttribute("essay", list_Essay);
        model.addAttribute("essay_Content", list_Essay_Content);
        return "test";
    }
}
