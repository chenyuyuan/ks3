package com.yuan.controller;

import com.alibaba.fastjson.JSONObject;
import com.yuan.mapper.AdminLoginMapper;
import com.yuan.result.Result;
import com.yuan.result.ResultFactory;
import com.yuan.service.AdminLoginService;
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
public class ApiLoginAdminController {
    @Autowired
    private AdminLoginService adminLoginService;

    @CrossOrigin
    @RequestMapping(value = "/loginadmin", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result Login(@RequestBody JSONObject params, HttpServletRequest request, HttpServletResponse response) {

        //Integer id = params.getInteger("userId");
        String account = params.getString("account");
        String password = params.getString("password");

        Hashtable hashtable = new Hashtable();//存放要返回的数据
        HttpSession session = request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        System.out.println("管理员正在登陆");
        System.out.println("账号:" + account + " 密码:" + password);

        if(account == null || password == null){
            String message = String.format("wronginput");
            return ResultFactory.buildFailResult(message);
        }
        String getpass = adminLoginService.selectPasswodByAccount(account);
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
        hashtable.put("msg","success");
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
