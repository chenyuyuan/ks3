package com.se.service;

import com.se.entity.Test;

import com.se.entity.Users;
import com.se.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private com.se.mapper.UsersMapper UsersMapper;
    public Users selectUserByAccount(String account) {
        return UsersMapper.findUserByAccount(account);
    }

    public Users selectUserById(int id) {
        return UsersMapper.findUserById(id);
    }


    public Users toLogin(String account, String password){
        return UsersMapper.filterByAccountAndPassword(account, password);
    }

    public void toRegister(String account, String password,String telephone){
        UsersMapper.insertUserInfoIntoUsers(account, password,telephone);
    }
}
