package com.yuan.controller;

import com.yuan.entity.CardFollowCommunity;
import com.yuan.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class PostController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private PostService postService;
    @GetMapping(value = "/post")
    public String pageLogin(Model model, HttpServletRequest request) {
        ArrayList<CardFollowCommunity> listCardFollowCommunity = postService.getAllFollowCommunity();


        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(account);

        model.addAttribute("account", account);
        model.addAttribute("CardFollowCommunity", listCardFollowCommunity);

        return "post";
    }
}