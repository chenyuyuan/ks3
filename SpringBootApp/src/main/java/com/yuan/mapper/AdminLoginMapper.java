package com.yuan.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminLoginMapper {

    //查询用户信息，通过用户名
    @Select("SELECT password FROM adminuser WHERE account = #{account}")
    String selectAdminUserByAccount(@Param("account") String account);
}

