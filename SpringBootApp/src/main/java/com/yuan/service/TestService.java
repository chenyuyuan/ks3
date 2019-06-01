package com.yuan.service;


import com.yuan.entity.Test;
import com.yuan.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    public List<Test> queryById() {
        return testMapper.queryById();
    }


    /**
     * 根据名字查找用户
     */
    public Test selectUserByName(String account) {
        return testMapper.findUserByAccount(account);
    }

    /**
     * 插入用户
     */
    public void insertService(int id,String account,String password) {
        testMapper.insertUser(id, account, password);
    }

    /**
     * 根据id 删除用户
     */

    public void deleteService(int id) {
        testMapper.deleteUser(id);
    }

}
