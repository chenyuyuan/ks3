package com.yuan.mapper;

import com.yuan.entity.GoodsClass;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GoodsClassMapper {
    //查询所有类别信息
    @Select("SELECT * FROM goods_class")
    List<GoodsClass> queryGoodsClass();
}
