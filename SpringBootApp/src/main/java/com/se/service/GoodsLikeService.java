package com.se.service;

import com.se.entity.GoodsLike;
import com.se.mapper.GoodsLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsLikeService {
    @Autowired
    private GoodsLikeMapper goodsLikeMapper;

    //查找收藏信息
    public List<GoodsLike> queryService() {
        return goodsLikeMapper.queryGoodsLike();
    }

    //插入收藏信息
    public void insertService(int id, int user_id, int goods_id, int like_state) {
        goodsLikeMapper.insertGoodsLike(id, user_id, goods_id, like_state);
    }
}
