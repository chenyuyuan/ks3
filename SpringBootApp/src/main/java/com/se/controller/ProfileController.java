package com.se.controller;

import com.se.entity.InfoDeal;
import com.se.entity.Users;
import com.se.entity.GoodsInformation;
import com.se.result.Result;
import com.se.result.ResultFactory;
import com.se.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")

public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @CrossOrigin
    @ResponseBody
    //查询所有商品信息
    @RequestMapping(value="/queryDealById", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<InfoDeal> dealQueryById(){
        return profileService.queryByIdService();
    }
//    @CrossOrigin
//    @ResponseBody
//    //根据卖家id查询交易信息
//    @RequestMapping(value = "/queryDealByBuyId", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
//    public List<Goods> dealQueryByBuyId(HttpServletRequest request, HttpServletResponse response) {
//        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
//        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
//        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
//        String account = (String)session.getAttribute("account");
//        return profileService.queryByBuyIdService(account);
//    }
    @CrossOrigin
    @ResponseBody
    //根据account查询用户信息
    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public Users userQueryById(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        return profileService.queryByUserIdService(account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询已卖出信息
    @RequestMapping(value = "/queryGoodBySoldId", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryBySoldId(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryBySoldStateService(1,account);
    }
    @CrossOrigin
    @ResponseBody
    //根据用户id查询未卖出信息
    @RequestMapping(value = "/queryGoodByOnSaleId", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnSaleId(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByOnSaleStateService(0,account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询已收到信息
    @RequestMapping(value = "/queryGoodByArriveState", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnArriveState(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByArriveStateService(1,account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询未收到信息
    @RequestMapping(value = "/queryGoodByOnTheWayState", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnTheWayState(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByOnTheWayStateService(0,account);
    }

    @CrossOrigin
    @ResponseBody
    //根据用户id查询收藏信息
    @RequestMapping(value = "/queryGoodByOnLikeState", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<GoodsInformation> goodQueryByOnLikeState(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        String account = (String)session.getAttribute("account");
        return profileService.queryByOnLikeStateService(1,account);
    }

    //根据id修改商品信息
//    @CrossOrigin
//    @ResponseBody
//    @RequestMapping(value="/updateAddr", method= RequestMethod.PUT, produces="application/json; charset=UTF-8")
//    public Users addrUpdate(String account, String user_addr) {
//        profileService.updateAddrService(account,user_addr);
//        return profileService.queryByUserIdService(account);
//    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/updateAddrs", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result updateAddr(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String account=request.getParameter("account");
        String user_addr_pro=request.getParameter("user_addr_pro");
        String user_addr_city=request.getParameter("user_addr_city");
        String user_addr_det=request.getParameter("user_addr_det");
        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        if(account==null||user_addr_pro==null||user_addr_city==null||user_addr_det==null){
            String message = String.format("地址修改失败，详细信息[地址为空]。");
            return ResultFactory.buildFailResult(message);
        }
//        Users foundUser=profileService.updateAddrService(account, user_addr);
        profileService.updateAddrService(user_addr_pro, user_addr_city, user_addr_det, account);
        System.out.println("account:"+account+" user_addr_pro:"+user_addr_pro);

//        String account = (String)session.getAttribute("account");
        System.out.println(session.getId());
        hashtable.put("msg","修改成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/updatePsw", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public Result updatePsw(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String account=request.getParameter("account");
        String oldpsw=request.getParameter("oldpsw");
        String newpsw=request.getParameter("newpsw");
        String confirmnewpsw=request.getParameter("confirmnewpsw");
        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        if(account==null||oldpsw==null || newpsw==null || confirmnewpsw==null){
            String message = String.format("密码修改失败。");
            return ResultFactory.buildFailResult(message);
        }
        Users user = profileService.queryByUserIdService(account);
        System.out.println(user.getPassword());
        if(!oldpsw.equals(user.getPassword())){
            String message = String.format("密码修改失败，旧密码输入不正确。");
            System.out.println(message);
            return ResultFactory.buildFailResult(message);
        }
        else if(!newpsw.equals(confirmnewpsw)){
            String message = String.format("密码修改失败，两次密码输入不一致。");
            return ResultFactory.buildFailResult(message);
        }
        profileService.updatePswService(newpsw,account);
        System.out.println(oldpsw);
        System.out.println(session.getId());
        hashtable.put("msg","修改成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }
}
