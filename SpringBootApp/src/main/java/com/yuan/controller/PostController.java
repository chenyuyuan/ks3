package com.yuan.controller;

import com.yuan.entity.CardFollowCommunity;
import com.yuan.entity.Tag;
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
        HttpSession session = request.getSession();
        String account = (String)session.getAttribute("account");
        System.out.println("Post:"+session.getId());
        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        System.out.println(account);

        ArrayList<Tag> listCardTag = postService.getAllCardTag();

        model.addAttribute("account", account);
        model.addAttribute("CardTag", listCardTag);

        return "post";
    }
}
