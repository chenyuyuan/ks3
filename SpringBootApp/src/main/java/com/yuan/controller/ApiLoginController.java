package com.yuan.controller;


import com.alibaba.fastjson.JSONObject;
import com.yuan.entity.Users;
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
    public Result Login(@RequestBody JSONObject params , HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        //Integer id = params.getInteger("userId");
        String account = params.getString("account");
        String password = params.getString("password");

        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("正在登陆");
        System.out.println("账号:"+account+" 密码:"+password);

        if(account==null||password==null){
            String message = String.format("wronginput");
            return ResultFactory.buildFailResult(message);
        }
        String getpass=usersService.selectUserByAccountGetPasswprd(account);
        //System.out.println("account:"+account+" password:"+password);
        if (!Objects.equals(getpass, password)) {
            String message = String.format("loginerror");
            return ResultFactory.buildFailResult(message);
        }
        session.setAttribute("account",account);
        session.setAttribute("user_id",getpass);
        if (session.isNew()) {
            System.out.println("session创建成功，session的id是："+session.getId());
        }else {
            System.out.println("服务器已经存在session，session的id是："+session.getId());
        }
        System.out.println(session.getId());
        hashtable.put("msg","logined");
        return ResultFactory.buildSuccessResult(hashtable);
    }
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Register(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String telephone=request.getParameter("telephone");
        Hashtable hashtable=new Hashtable();//存放要返回的数据
        System.out.print("account:"+account+",password:"+password+",telephone:"+telephone);

        if(account==null||password==null){
            String message = String.format("注册失败，详细信息[用户名或密码为空]。");
            return ResultFactory.buildFailResult(message);
        }

        String foundPwd=usersService.selectUserByAccountGetPasswprd(account);
        //System.out.println("account:"+account+" password:"+password);
        if (foundPwd != null || foundPwd == "") {
            String message = String.format("注册失败，详细信息[用户名已存在]。");
            return ResultFactory.buildFailResult(message);
        }
        else{
            usersService.toRegister(account,password,telephone);
            String message = String.format("注册成功。");
            return ResultFactory.buildSuccessResult(message);
        }


    }
}
