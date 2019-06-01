package com.se.mapper;

import com.se.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ItemInfoMapper {

    @Insert("INSERT INTO orders (goods_id,addr_pro,addr_city,addr_det) VALUES(#{goods_id},#{addr_pro},#{addr_city},#{addr_det})")
    void Buying(@Param("goods_id") int goods_id,@Param("addr_pro") String addr_pro,@Param("addr_city") String addr_city,@Param("addr_det") String addr_det);
}
