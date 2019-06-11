package com.yuan.controller;

import com.yuan.entity.CardEssay;
import com.yuan.service.EssayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class EssayController {

    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private EssayService essayService;
    @GetMapping(value = "/essay/{essayid}")
    public String pageLogin(Model model, HttpServletRequest request,@PathVariable int essayid) {
        HttpSession session = request.getSession();

        String account = (String)session.getAttribute("account");
        System.out.println(essayid);
        System.out.println(session.getId());
        System.out.println(account);

        CardEssay cardEssay = essayService.getCardEssay(essayid);

        model.addAttribute("account", account);
        model.addAttribute("cardEssay", cardEssay);
        return "essay";
    }
}
