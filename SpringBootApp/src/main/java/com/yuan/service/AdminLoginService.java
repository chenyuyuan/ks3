package com.yuan.service;

import com.yuan.mapper.AdminLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService {
    @Autowired
    private AdminLoginMapper adminLoginMapper;
    public String selectPasswodByAccount(String account) {
        return adminLoginMapper.selectAdminUserByAccount(account);
    }
}
