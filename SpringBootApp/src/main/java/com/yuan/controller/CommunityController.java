package com.yuan.controller;


import com.yuan.entity.Community;
import com.yuan.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CommunityController {

    @Autowired
    private HomeService homeService;


    @GetMapping(value = "/community/{community_id}")
    public String pageHomeAdminCommunity(Model model, HttpServletRequest request) {
        String name = "yuan";
        ArrayList<Community> listCommunity = homeService.getAllCommunity();

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);

        model.addAttribute("name", name);
        model.addAttribute("cardCommunity", listCommunity);
        return "community";
    }

}
