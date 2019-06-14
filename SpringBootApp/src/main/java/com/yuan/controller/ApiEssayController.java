package com.yuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuan.result.Result;
import com.yuan.result.ResultFactory;
import com.yuan.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;

@RestController
@RequestMapping("/api")
public class ApiEssayController {
    @Autowired
    private EssayService essayService;
    @CrossOrigin
    @RequestMapping(value = "/essay/comment", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result UpUp(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/api/essay/comment:");
        //Integer id = params.getInteger("userId");
        int essay_id = params.getInteger("essay_id");
        String content = params.getString("content");

        Hashtable hashtable = new Hashtable();//存放要返回的数据
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        System.out.println("commenting");
        System.out.println("essay_id:"+essay_id);
        System.out.println(session.getId());

        int user_id = account == null ? 0 : (int)session.getAttribute("user_id");
        essayService.insComment(user_id,essay_id,content);
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
