package com.yuan.mapper;

import com.yuan.entity.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UsersMapper {

    //查询用户信息，通过用户名
    @Select("SELECT * FROM users WHERE account = #{account}")
    Users findUserByAccount(@Param("account") String account);

    //查询用户信息，通过userid
    @Select("SELECT * FROM users WHERE id = #{id}")
    Users findUserById(@Param("id") int id);

    //查询用户输入密码是否正确
    @Select("SELECT * FROM users WHERE account = #{account} and password=#{password}")
    Users filterByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    //增加新用户
    @Insert("INSERT INTO users (account,password,user_tel) VALUES (#{account},#{password},#{telephone})")
    void insertUserInfoIntoUsers(@Param("account") String account,@Param("password") String password,@Param("telephone") String telephone);
}