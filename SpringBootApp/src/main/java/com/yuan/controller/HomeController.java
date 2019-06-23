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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/home")
    public String pageHome(Model model, HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        System.out.println("Home: "+session.getId());
        System.out.println(account);

        String name = "yuan";
        ArrayList<CardEssay> listCardEssay = homeService.getAllCardEssay(user_id);
        ArrayList<CardApplyCommunity> listCardApplyCommunity = homeService.getAllCardApplyCommunity();
        ArrayList<Community> listCardCommunity = homeService.getAllCommunity();
        for(int i=0;i<listCardEssay.size();i++){
            if(listCardEssay.get(i).getState()==0){
                listCardEssay.remove(i);
            }
        }

        model.addAttribute("name", name);
        model.addAttribute("cardEssay", listCardEssay);
        model.addAttribute("cardCommunity", listCardCommunity);
        model.addAttribute("cardApplyCommunity", listCardApplyCommunity);
        return "home";
    }

    @GetMapping(value = "/home/like")
    public String pageHomeLike(Model model, HttpServletRequest request) {
        String name = "yuan";
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        System.out.println("Home: "+session.getId());
        System.out.println(account);

        ArrayList<CardEssay> listCardEssay = homeService.getAllCardEssay(user_id);
        ArrayList<CardApplyCommunity> listCardApplyCommunity = homeService.getAllCardApplyCommunity();

        for(int i=0;i<listCardEssay.size();i++){
            if(listCardEssay.get(i).getState()==0){
                listCardEssay.remove(i);
            }
        }
        Collections.sort(listCardEssay, new Comparator<CardEssay>() {
            @Override
            public int compare(CardEssay o1, CardEssay o2) {
                if(o1.getUp() <= o2.getUp()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        model.addAttribute("name", name);
        model.addAttribute("cardEssay", listCardEssay);
        model.addAttribute("cardApplyCommunity", listCardApplyCommunity);
        return "home";
    }

    @GetMapping(value = "/home/advice")
    public String pageHomeAdvice(Model model, HttpServletRequest request) {
        String name = "yuan";
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        System.out.println("Home: "+session.getId());
        System.out.println(account);

        ArrayList<CardEssay> listCardEssay = homeService.getAllCardEssay(user_id);
        ArrayList<CardApplyCommunity> listCardApplyCommunity = homeService.getAllCardApplyCommunity();

        for(int i=0;i<listCardEssay.size();i++){
            if(listCardEssay.get(i).getState()==0){
                listCardEssay.remove(i);
            }
        }
        Collections.sort(listCardEssay, new Comparator<CardEssay>() {
            @Override
            public int compare(CardEssay o1, CardEssay o2) {
                if(o1.getUp() <= o2.getUp()) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });

        model.addAttribute("name", name);
        model.addAttribute("cardEssay", listCardEssay);
        model.addAttribute("cardApplyCommunity", listCardApplyCommunity);
        return "home";
    }

    @GetMapping(value = "/home/hot")
    public String pageHomeHot(Model model, HttpServletRequest request) {
        String name = "yuan";
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        System.out.println("Home: "+session.getId());
        System.out.println(account);

        ArrayList<CardEssay> listCardEssay = homeService.getAllCardEssay(user_id);
        ArrayList<CardApplyCommunity> listCardApplyCommunity = homeService.getAllCardApplyCommunity();

        for(int i=0;i<listCardEssay.size();i++){
            if(listCardEssay.get(i).getState()==0){
                listCardEssay.remove(i);
            }
        }
        Collections.sort(listCardEssay, new Comparator<CardEssay>() {
            @Override
            public int compare(CardEssay o1, CardEssay o2) {
                double hot1,hot2;
                try {
                    hot1=o1.getHot(o1.getUp(),o1.getDown(),o1.getPost_date());
                    hot2=o2.getHot(o2.getUp(),o2.getDown(),o2.getPost_date());
                    System.out.println("hot1:"+hot1);
                    System.out.println("hot2:"+hot2);
                    if( hot1 <= hot2) {
                        return 1;
                    }
                    else {
                        return -1;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return 1;
            }
        });


        model.addAttribute("name", name);
        model.addAttribute("cardEssay", listCardEssay);
        model.addAttribute("cardApplyCommunity", listCardApplyCommunity);
        return "home";
    }


    public static double getHot(int up, int down, String post_date) throws ParseException{
        double ans=0;
        int x = up - down;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeThen = String.valueOf(simpleDateFormat.parse(post_date).getTime());
        int t = ((int)(System.currentTimeMillis()) - (int)(Long.parseLong(timeThen))) / 1000;
        int z=(Math.abs(x)>1)?Math.abs(x):1;
        int y=0;
        if(x>0)y=1;else if(x<0)y=-1;else y=0;
        ans = Math.log10(z) + ((double)y*(double)t)/4500;
        return ans;
    }

}
