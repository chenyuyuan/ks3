package com.yuan.mapper;
import com.yuan.entity.InfoDeal;
import com.yuan.entity.GoodsInformation;
import com.yuan.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface ProfileMapper {
    //查询所有交易信息
    @Select("SELECT * FROM info_deal")
    List<InfoDeal> queryDealById();

    //根据用户id查询交易信息
//    @Select("SELECT goods_information.* FROM info_deal, orders, goods_information, users WHERE info_deal.buy_id = users.id and orders.order_id = info_deal.order_id and orders.goods_id = goods_information.id and users.account = #{account}")
//    List<Goods> queryDealByBuyId(@Param("account") String account);

    //根据用户account查询用户信息
    @Select("SELECT * FROM users WHERE account = #{account}")
    Users queryUserByAccount(@Param("account") String account);

    //根据用户id查询用户信息
    //@Select("SELECT * FROM users WHERE id = #{id}")
    //Users queryUserById(@Param("id") int id);

    //查询所有用户信息
    @Select("SELECT * FROM users")
    List<Users> queryUser();

    //根据用户id查询已卖出信息
    @Select("SELECT goods_information.* FROM info_deal, orders, goods_information, users WHERE info_deal.sold_id = users.id and orders.order_id = info_deal.order_id and orders.goods_id = goods_information.goods_id and goods_information.goods_state = #{goods_state} and users.account = #{account}")
    List<GoodsInformation> queryGoodBySoldStateId(@Param("goods_state") int goods_state, @Param("account") String account);

    //根据用户id查询未卖出信息
    @Select("SELECT goods_information.* FROM info_deal,orders, goods_information, users WHERE info_deal.sold_id = users.id and orders.order_id = info_deal.order_id and orders.goods_id = goods_information.goods_id and goods_information.goods_state = #{goods_state} and users.account = #{account}")
    List<GoodsInformation> queryGoodByOnSaleStateId(@Param("goods_state") int goods_state, @Param("account") String account);

    //根据用户id查询未收到信息
    @Select("SELECT goods_information.* FROM info_deal, order_state ,orders, goods_information, users WHERE info_deal.buy_id = users.id and info_deal.order_id = order_state.order_id and orders.order_id = info_deal.order_id and orders.goods_id = goods_information.goods_id and order_state.order_state = #{order_state} and users.account = #{account}")
    List<GoodsInformation> queryGoodByArriveStateId(@Param("order_state") int order_state, @Param("account") String account);

    //根据用户id查询已收到信息
    @Select("SELECT goods_information.* FROM info_deal, order_state ,orders, goods_information, users WHERE info_deal.buy_id = users.id and info_deal.order_id = order_state.order_id and orders.order_id = order_state.order_id and orders.goods_id = goods_information.goods_id and order_state.order_state = #{order_state} and users.account = #{account}")
    List<GoodsInformation> queryGoodByOnTheWayStateId(@Param("order_state") int order_state, @Param("account") String account);

    //根据用户id查询收藏信息
    @Select("SELECT goods_information.* FROM goods_information, users, goods_like WHERE goods_like.user_id = users.id and goods_like.goods_id = goods_information.goods_id and goods_like.like_state = #{like_state} and users.account = #{account}")
    List<GoodsInformation> queryGoodByLikeStateId(@Param("like_state") int like_state, @Param("account") String account);

    //根据用户account修改地址信息
    @Update("Update users set user_addr_pro = #{user_addr_pro} , user_addr_city = #{user_addr_city} , user_addr_det = #{user_addr_det} WHERE account = #{account}")
    void updateAddr(@Param("user_addr_pro") String user_addr_pro, @Param("user_addr_city") String user_addr_city, @Param("user_addr_det") String user_addr_det, @Param("account") String account);

    //根据用户account修改密码
    @Update("Update users set password = #{password} WHERE account = #{account}")
    void updatePsw(@Param("password") String password, @Param("account") String account);

}
