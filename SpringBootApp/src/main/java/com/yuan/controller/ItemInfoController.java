package com.yuan.controller;

import com.yuan.entity.Users;
import com.yuan.service.GoodsService;
import com.yuan.service.ItemInfoService;
import com.yuan.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

@RestController
@RequestMapping("/api")
public class ItemInfoController {
    @Autowired
    private GoodsService goodsService;
    @CrossOrigin
    @RequestMapping(value = "/getiteminfopage", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Hashtable getItemInfoPage(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        Hashtable hashtable=new Hashtable();//存放要返回的数据

        String itemId=request.getParameter("itemId");
        if(!isNumeric(itemId)){
            hashtable.put("statusCode", 400);
            hashtable.put("msg", "id非法");
            hashtable.put("data","");
            return hashtable;
        }
        System.out.println("itemId is "+itemId);
        int itemid = parseInt(itemId);
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        // String account = (String)session.getAttribute("account");
        hashtable.put("statusCode",200);
        hashtable.put("msg","");
        hashtable.put("data",goodsService.selectGoodsByItemId(itemid));
        return hashtable;

    }
    @Autowired
    private UsersService usersService;
    @CrossOrigin
    @RequestMapping(value = "/getsellerinfo", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Users getSellerInfo(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String sellerId=request.getParameter("sellerId");
        System.out.println("sellerId is "+sellerId);
        int sellerid = parseInt(sellerId);
//        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        //String account = (String)session.getAttribute("account");
        return usersService.selectUserById(sellerid);

    }
    @Autowired
    private ItemInfoService itemInfoService;
    @CrossOrigin
    @RequestMapping(value = "/buying", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Hashtable buyingGoods(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        Hashtable hashtable=new Hashtable();//存放要返回的数据

        String itemid_str=request.getParameter("itemid");
        String user_addr_pro=request.getParameter("user_addr_pro");
        String user_addr_city=request.getParameter("user_addr_city");
        String user_addr_det=request.getParameter("user_addr_det");

        System.out.println("itemId is "+itemid_str);
        int itemidint = parseInt(itemid_str);
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session
        //String account = (String)session.getAttribute("account");
        hashtable.put("statusCode",200);
        hashtable.put("msg","购买成功");
        System.out.println(itemidint);
        System.out.println("pro:"+user_addr_pro+" city:"+user_addr_city+" det:"+user_addr_det);
        itemInfoService.buying(itemidint,user_addr_pro,user_addr_city,user_addr_det);
        System.out.println("购买成功");
        return hashtable;

    }
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
