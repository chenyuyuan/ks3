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
    public String pageCommunity(Model model, HttpServletRequest request,@PathVariable int community_id) {
        System.out.print("Community:");
        String name = "yuan";
        ArrayList<Community> listCommunity = homeService.getAllCommunity();
        ArrayList<CardEssay> listCardEssay = communityService.getCommunityCardEssay(community_id);

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);
        String community_name = communityService.getCommunityName(community_id);
        for(int i=0;i<listCardEssay.size();i++){
            if(listCardEssay.get(i).getState()==0){
                listCardEssay.remove(i);
            }
        }

        model.addAttribute("name", name);
        model.addAttribute("community_name",community_name);
        model.addAttribute("community_id", community_id);
        model.addAttribute("cardCommunity", listCommunity);
        model.addAttribute("cardEssay", listCardEssay);
        return "community";
    }

    @GetMapping(value = "/communityadminaudit/{community_id}")
    public String pageCommunityAdminAudit(Model model, HttpServletRequest request,@PathVariable int community_id) {
        System.out.print("Community:");
        String name = "yuan";
        ArrayList<Community> listCommunity = homeService.getAllCommunity();
        ArrayList<CardEssay> listCardEssay = communityService.getCommunityCardEssay(community_id);

        for(int i=0;i<listCardEssay.size();i++){
            if(listCardEssay.get(i).getState()==1){
                listCardEssay.remove(i);
            }
        }
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        System.out.println(name);

        model.addAttribute("name", name);
        model.addAttribute("cardCommunity", listCommunity);
        model.addAttribute("cardEssay", listCardEssay);
        return "communityadminaudit";
    }

}
