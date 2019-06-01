package com.se.service;
import com.se.entity.Goods;
import com.se.entity.InfoDeal;
import com.se.entity.Users;
import com.se.entity.GoodsInformation;
import com.se.entity.OrderState;
import com.se.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileMapper profileMapper;

    //查询所有商品信息
    public List<InfoDeal> queryByIdService() {
        return profileMapper.queryDealById();
    }

    //根据用户id查询交易信息
//    public List<Goods> queryByBuyIdService(String account) {
//        return profileMapper.queryDealByBuyId(account);
//    }

    //根据account查询用户信息
    public Users queryByUserIdService(String account) {
        return profileMapper.queryUserByAccount(account);
    }

    //根据id查询用户信息
    //public Users queryTrueByUserIdService(int id) {
    //    return profileMapper.queryUserById(id);
    //}

    //查询所有用户信息
    public List<Users> queryUserService() {
        return profileMapper.queryUser();
    }

    //根据用户id查询已卖出信息
    public List<GoodsInformation> queryBySoldStateService(int goods_state, String account) {
        return profileMapper.queryGoodBySoldStateId(goods_state,account);
    }

    //根据用户id查询未卖出信息
    public List<GoodsInformation> queryByOnSaleStateService(int goods_state,String account) {
        return profileMapper.queryGoodByOnSaleStateId(goods_state,account);
    }

    //根据用户id查询未收到信息
    public List<GoodsInformation> queryByArriveStateService(int order_state, String account) {
        return profileMapper.queryGoodByArriveStateId(order_state,account);
    }

    //根据用户id查询已收到信息
    public List<GoodsInformation> queryByOnTheWayStateService(int order_state,String account) {
        return profileMapper.queryGoodByOnTheWayStateId(order_state,account);
    }

    //根据用户id查询收藏信息
    public List<GoodsInformation> queryByOnLikeStateService(int like_state,String account) {
        return profileMapper.queryGoodByLikeStateId(like_state,account);
    }

    //根据id修改地址
    public void updateAddrService(String user_addr_pro, String user_addr_city, String user_addr_det, String account) {
        profileMapper.updateAddr(user_addr_pro, user_addr_city, user_addr_det, account);
    }

    //根据id修改密码
    public void updatePswService(String password, String account) {
        profileMapper.updatePsw(password, account);
    }

}
