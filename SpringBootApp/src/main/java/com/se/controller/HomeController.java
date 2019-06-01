package com.se.controller;

import com.se.entity.*;

import com.se.result.Result;
import com.se.result.ResultFactory;
import com.se.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private GoodsClassService goodsClassService;
    @Autowired
    private GoodsLikeService goodsLikeService;
    @Autowired
    private UsersService usersService;

    @CrossOrigin
    @ResponseBody
    //查询所有商品信息
    @RequestMapping(value = "/queryGoodsInformationById", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<GoodsInformation> goodsInformationQueryById(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();
        return goodsService.query_ByIdService();
    }

    @CrossOrigin
    @ResponseBody
    //查询所有用户信息
    @RequestMapping(value = "/queryAllUsers", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<Users> usersQuery(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();
        return profileService.queryUserService();
    }

    @CrossOrigin
    @ResponseBody
    //查询所有类别信息
    @RequestMapping(value = "/queryGoodsClass", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<GoodsClass> goodsClassQuery(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();
        //return goodsClassService.queryGoodsClassService();
        return goodsClassService.queryGoodsClassService();
    }

    @CrossOrigin
    @ResponseBody
    //根据名字查询商品信息
    @RequestMapping("/queryGoodsInformationByGoodsName")
    public List<GoodsInformation> goodsInformationQueryByGoodsName() {
        return goodsService.queryByGoodsNameService("朱一龙");
    }

    //@CrossOrigin
    //@ResponseBody
    //插入商品信息
    //@RequestMapping("/insertGoods")
    //public List<Goods> goodsInsert(){
    //    goodsService.insertService(50, "朱一龙", 300, "bbb", "ccc", 5);
    //    return goodsService.queryByIdService();
    //}

    //修改热度
    @CrossOrigin
    @RequestMapping(value = "/updateGoodsInformation", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result updateAddr(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String id_string=request.getParameter("id");
        int goods_id = Integer.parseInt(id_string);
        //String title=request.getParameter("title");
        //String star_string=request.getParameter("star");
        //int star = Integer.parseInt(star_string);
        //String name=request.getParameter("name");
        //String city=request.getParameter("city");
        String hot_string=request.getParameter("hot");
        int hot = Integer.parseInt(hot_string);

        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        if(goods_id==' '||hot==' '){
            String message = String.format("热度修改失败");
            return ResultFactory.buildFailResult(message);
        }
//        Users foundUser=profileService.updateAddrService(account, user_addr);
        goodsService.updateGoodsInformationService(goods_id, hot);
        System.out.println("goods_id:"+goods_id+" hot:"+hot);

        //session.setAttribute("account",account);
        System.out.println(session.getId());
        hashtable.put("msg","修改成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }

    @CrossOrigin
    @ResponseBody
    //查询收藏
    @RequestMapping(value = "/queryGoodsLike", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public List<GoodsLike> goodsLikeQuery(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
//        HttpSession session=request.getSession();
        //return goodsClassService.queryGoodsClassService();
        return goodsLikeService.queryService();
    }

    @CrossOrigin
    @ResponseBody
    //通过用户名查询用户信息
    @RequestMapping(value = "/queryByAccount", method= RequestMethod.GET, produces="application/json; charset=UTF-8")
    public Users byAccountQuery(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));
        HttpSession session=request.getSession();
        String account = (String) session.getAttribute("account");
        // return session.getAttributeNames();
        System.out.println(account);
        return usersService.selectUserByAccount(account);
    }

    //增加收藏
    @CrossOrigin
    @RequestMapping(value = "/addGoodsLike", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Result addGoodsLike(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx, application/json");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        response.setHeader("Access-Control-Allow-Credentials", String.valueOf(true));

        String id_string=request.getParameter("id");
        int id = Integer.parseInt(id_string);
        String user_id_string=request.getParameter("user_id");
        int user_id = Integer.parseInt(user_id_string);
        String goods_id_string=request.getParameter("goods_id");
        int goods_id = Integer.parseInt(goods_id_string);

        Hashtable hashtable=new Hashtable();//存放要返回的数据
        HttpSession session=request.getSession();//获取request请求里的session, 如果是第一次请求, 则会创建一个新的session

        if(id==' ' || user_id==' ' || goods_id==' '){
            String message = String.format("增加收藏失败");
            return ResultFactory.buildFailResult(message);
        }
//        Users foundUser=profileService.updateAddrService(account, user_addr);
        goodsLikeService.insertService(id, user_id, goods_id, 1);
        System.out.println("id:"+id+" user_id:"+user_id+" goods_id:"+goods_id+" like_state:"+1);

        //session.setAttribute("account",account);
        System.out.println(session.getId());
        hashtable.put("msg","增加收藏成功");
        return ResultFactory.buildSuccessResult(hashtable);
    }

    //@CrossOrigin
    //@ResponseBody
    //根据id删除商品信息
    //@RequestMapping("/deleteGoods")
    //public String goodsDelete() {
    //    goodsService.deleteService(3);
    //    return "OK";
    //}

}
