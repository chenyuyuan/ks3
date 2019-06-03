package com.yuan.dao;

import com.yuan.dao.entity.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TestMapper {
    @Select("SELECT * FROM test")
    List<Test> queryById();

    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM test WHERE account = #{account}")
    Test findUserByAccount(@Param("account") String account);


    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO test(id, account,password) VALUES(#{id}, #{account}, #{password})")
    void insertUser(@Param("id") int id, @Param("account") String account, @Param("password") String password);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from test WHERE id = #{id}")
    void deleteUser(@Param("id") int id);





}
