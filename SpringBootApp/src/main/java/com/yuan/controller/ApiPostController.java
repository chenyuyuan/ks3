package com.yuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuan.result.Result;
import com.yuan.result.ResultFactory;
import com.yuan.service.PostService;
import com.yuan.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ApiPostController {

    @Autowired
    private PostService postService;

    @CrossOrigin
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Login(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {

        //Integer id = params.getInteger("userId");
        String head = params.getString("head");
        String content = params.getString("content");
        int community_id = Integer.parseInt(params.getString("community_id"));

        Hashtable hashtable = new Hashtable();//存放要返回的数据
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("posting");

        postService.postEssay(head,community_id);
        int maxId = postService.maxidInEssay();
        postService.postEssayContent(maxId,content);

        System.out.println(session.getId());
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
