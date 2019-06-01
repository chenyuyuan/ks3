package com.se.service;

import com.se.entity.GoodsClass;

import java.util.List;

import com.se.mapper.GoodsClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsClassService {
    @Autowired
    private GoodsClassMapper goodsClassMapper;

    //查询所有类别信息
    public List<GoodsClass> queryGoodsClassService() {
        return goodsClassMapper.queryGoodsClass();
    }
}
