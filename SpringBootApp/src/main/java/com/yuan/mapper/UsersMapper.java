package com.yuan.mapper;

import com.yuan.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsersMapper {

    //查询用户信息，通过用户名
    @Select("SELECT * FROM user WHERE account = #{account}")
    User findUserByAccount(@Param("account") String account);

    //获取所有用户
    @Select("SELECT * FROM user")
    ArrayList<User> getAllUser();

    //查询用户信息，通过userid
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(@Param("id") int id);

    //查询用户输入密码是否正确
    @Select("SELECT * FROM user WHERE account = #{account} and password=#{password}")
    User filterByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    //增加新用户
    @Insert("INSERT INTO user (account,password) VALUES (#{account},#{password})")
    void insertUserInfoIntoUsers(@Param("account") String account,@Param("password") String password);
}