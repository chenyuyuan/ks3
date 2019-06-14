package com.yuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuan.result.Result;
import com.yuan.result.ResultFactory;
import com.yuan.service.HomeService;
import com.yuan.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;

@RestController
@RequestMapping("/api")
public class ApiHomeController {
    @Autowired
    private HomeService homeService;

    @CrossOrigin
    @RequestMapping(value = "/home/up", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result UpUp(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/api/home/up:");
        //Integer id = params.getInteger("userId");
        int essay_id = params.getInteger("essay_id");

        Hashtable hashtable = new Hashtable();//存放要返回的数据
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("upping");
        System.out.println("essay_id:"+essay_id);
        System.out.println(session.getId());

        int user_id = (int)session.getAttribute("user_id");
        homeService.UpUp(user_id,essay_id);
        return ResultFactory.buildSuccessResult(hashtable);
    }

    @CrossOrigin
    @RequestMapping(value = "/home/down", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result DownDown(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/api/home/up:");
        int essay_id = params.getInteger("essay_id");

        Hashtable hashtable = new Hashtable();//存放要返回的数据
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("downing");
        System.out.println("essay_id:"+essay_id);
        System.out.println(session.getId());

        int user_id = (int)session.getAttribute("user_id");
        homeService.DownDown(user_id,essay_id);
        String message = String.format("success");
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @RequestMapping(value = "/homeadminaudit/pass", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result communityauditPass(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/api/homeadminauditpass:");
        int essay_id = params.getInteger("essay_id");
        String msg = params.getString("msg");
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("passing");
        System.out.println("essay_id:"+essay_id);
        System.out.println(session.getId());

        int user_id = (int)session.getAttribute("user_id");


        homeService.communityAuditPass(essay_id,msg);
        String message = String.format("success");
        return ResultFactory.buildSuccessResult(message);
    }
    @CrossOrigin
    @RequestMapping(value = "/homeadminaudit/notpass", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result communityauditNotPass(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("/api/homeadminauditpass:");
        int essay_id = params.getInteger("essay_id");
        String msg = params.getString("msg");
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("passing");
        System.out.println("essay_id:"+essay_id);
        System.out.println(session.getId());

        int user_id = (int)session.getAttribute("user_id");


        homeService.communityAuditNotPass(essay_id,msg);
        String message = String.format("success");
        return ResultFactory.buildSuccessResult(message);
    }
}
