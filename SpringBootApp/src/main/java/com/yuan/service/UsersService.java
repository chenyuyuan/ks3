package com.yuan.service;

import com.yuan.mapper.UsersMapper;
import com.yuan.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersMapper usersMapper;
    public String selectUserByAccountGetPasswprd(String account) {
        return usersMapper.findUserByAccount(account);
    }

    public Users selectUserById(int id) {
        return usersMapper.findUserById(id);
    }


    public Users toLogin(String account, String password){
        return usersMapper.filterByAccountAndPassword(account, password);
    }

    public void toRegister(String account, String password,String telephone){
        usersMapper.insertUserInfoIntoUsers(account, password,telephone);
    }
}
