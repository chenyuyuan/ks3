package com.yuan.controller;


import com.yuan.entity.CardEssay;
import com.yuan.entity.Community;
import com.yuan.service.CommunityService;
import com.yuan.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class CommunityController {

    @Autowired
    private HomeService homeService;
    @Autowired
    private CommunityService communityService;

    @GetMapping(value = "/community/{community_id}")
    public String pageHomeAdminCommunity(Model model, HttpServletRequest request,@PathVariable int community_id) {
        String name = "yuan";
        ArrayList<Community> listCommunity = homeService.getAllCommunity();
        ArrayList<CardEssay> listCardEssay = communityService.getCommunityCardEssay(community_id);

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);

        model.addAttribute("name", name);
        model.addAttribute("cardCommunity", listCommunity);
        model.addAttribute("cardEssay", listCardEssay);
        return "community";
    }

}
