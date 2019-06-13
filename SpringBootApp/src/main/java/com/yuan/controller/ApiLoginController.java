package com.yuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.yuan.entity.User;
import com.yuan.result.Result;
import com.yuan.result.ResultFactory;
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
public class ApiLoginController {

    @Autowired
    private UsersService usersService;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Login(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        //Integer id = params.getInteger("userId");
        String account = params.getString("account");
        String password = params.getString("password");

        Hashtable hashtable = new Hashtable();//存放要返回的数据
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("正在登陆");
        System.out.println("账号:" + account + " 密码:" + password);

        if(account == null || password == null){
            String message = String.format("wronginput");
            return ResultFactory.buildFailResult(message);
        }
        User user = usersService.selectUserByAccount(account);
        if (!Objects.equals(user.getPassword(), password)) {
            String message = String.format("loginerror");
            return ResultFactory.buildFailResult(message);
        }
        session.setAttribute("account",account);
        session.setAttribute("user_id",user.getId());
        if (session.isNew()) {
            System.out.println("session创建成功，session的id是："+session.getId());
        }else {
            System.out.println("服务器已经存在session，session的id是："+session.getId());
        }
        System.out.println(session.getId());
        hashtable.put("msg","login successfully");
        return ResultFactory.buildSuccessResult(hashtable);
    }
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Register(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {
        String account = params.getString("account");
        String password = params.getString("password");
        String telephone = request.getParameter("telephone");
        Hashtable hashtable = new Hashtable();//存放要返回的数据
        System.out.print("account:" + account + ",password:" + password + ",telephone:" + telephone);

        if(account == null || password == null) {
            String message = String.format("failed(password)");
            return ResultFactory.buildFailResult(message);
        }

        User user=usersService.selectUserByAccount(account);
        if (user.getAccount() != null || user.getAccount() == "") {
            String message = String.format("failed(account)");
            return ResultFactory.buildFailResult(message);
        }
        else {
            usersService.toRegister(account, password);
            String message = String.format("success");
            return ResultFactory.buildSuccessResult(message);
        }
    }
}
