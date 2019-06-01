package com.yuan.service;


import com.yuan.entity.GoodsInformation;
import com.yuan.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    //查询所有商品信息
    //public List<Goods> queryByIdService() {
    //    return goodsMapper.queryGoodsById();
    //}

    //查询所有商品信息
    public List<GoodsInformation> query_ByIdService() {
        return goodsMapper.queryGoodsInformationById();
    }

    //根据名字查询商品信息
    public List<GoodsInformation> queryByGoodsNameService(String goods_name) {
        return goodsMapper.queryGoodsInformationByGoodsName(goods_name);
    }

    //发布时插入商品信息
    public void insert_Service(int goods_id,String goods_name,int price,String goods_detail,int class_id,String goods_picture_1, String goods_picture_2,String goods_picture_3,String goods_picture_4,int goods_state,int user_id)
    {
        goodsMapper.insertGoodsInformation(goods_id, goods_name, price, goods_detail, class_id,goods_picture_1,goods_picture_2,goods_picture_3,goods_picture_4,goods_state,user_id);
    }

    //查找最大id
    public int query_LastIdService(){
        return goodsMapper.queryGoodsLastId();
    }
    //插入商品信息
    //public void insertService(int id, String title, int star, String name, String city, int hot) {
    //    goodsMapper.insertGoods(id, title, star, name, city, hot);
    //}

    //根据id修改商品信息
    public void updateGoodsInformationService(int goods_id, int hot) {
        goodsMapper.updateGoodsInformation(goods_id, hot);
    }

    //根据id删除商品信息
    //public void deleteService(int id) {
    //    goodsMapper.deleteGoods(id);
    //}

    //根据id查找商品信息
    public GoodsInformation selectGoodsInformationByItemId(int goods_id) {
        return goodsMapper.selectGoodsInformationById(goods_id);
    }

    public GoodsInformation selectGoodsByItemId(int goods_id) {
        return goodsMapper.selectGoodsById(goods_id);
    }
}
