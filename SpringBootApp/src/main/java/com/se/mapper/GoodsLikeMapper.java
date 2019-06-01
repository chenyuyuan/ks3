package com.se.mapper;

import com.se.entity.GoodsLike;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GoodsLikeMapper {

    //查找收藏信息
    @Select("SELECT * FROM goods_like")
    List<GoodsLike> queryGoodsLike();

    //插入收藏信息
    @Insert("INSERT INTO goods_like(id, user_id, goods_id, like_state) VALUES(#{id}, #{user_id}, #{goods_id}, #{like_state})")
    void insertGoodsLike(@Param("id") int id, @Param("user_id") int user_id, @Param("goods_id") int goods_id, @Param("like_state") int like_state);
}
