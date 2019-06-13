package com.yuan.controller;

import com.yuan.entity.*;
import com.yuan.service.HomeService;
import com.yuan.service.UsersService;
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
public class HomeAdminController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/homeadmin")
    public String pageHomeAdmin(Model model, HttpServletRequest request) {
        String name = "yuan";
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        System.out.println("Home: "+session.getId());
        System.out.println(account);

        ArrayList<CardEssay> listCardEssay = homeService.getAllCardEssay(user_id);
        model.addAttribute("name", name);
        model.addAttribute("cardEssay", listCardEssay);
        return "adminhome";
    }
    @GetMapping(value = "/homeadmin/user")
    public String pageHomeAdminUser(Model model, HttpServletRequest request) {
        String name = "yuan";
        ArrayList<User> listUser = homeService.getAllUser();

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);

        model.addAttribute("name", name);
        model.addAttribute("cardUser", listUser);
        return "adminhomeuser";
    }
    @GetMapping(value = "/homeadmin/community")
    public String pageHomeAdminCommunity(Model model, HttpServletRequest request) {
        String name = "yuan";
        ArrayList<Community> listCommunity = homeService.getAllCommunity();

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);

        model.addAttribute("name", name);
        model.addAttribute("cardCommunity", listCommunity);
        return "adminhomecommunity";
    }
    @GetMapping(value = "/homeadmin/comment")
    public String pageHomeAdminComment(Model model, HttpServletRequest request) {
        String name = "yuan";
        ArrayList<CardComment> listComment = homeService.getAllComment();

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);

        model.addAttribute("name", name);
        model.addAttribute("cardComment", listComment);
        return "adminhomecomment";
    }
}
