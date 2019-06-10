package com.yuan.service;

import com.yuan.entity.*;
import com.yuan.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HomeService {
    @Autowired
    private HomeMapper homeMapper;

    public ArrayList<Essay> getAllEssay() {
        return homeMapper.getAllEssay();
    }
    public ArrayList<EssayContent> getAllEssayContent() {
        return homeMapper.getAllEssayContent();
    }
    public ArrayList<User> getAllUser() {return homeMapper.getAllUser();}
    public ArrayList<Community> getAllCommunity() {return homeMapper.getAllCommunity();}
    public ArrayList<CardComment> getAllComment() {return homeMapper.getAllComment();}


    public ArrayList<CardEssay> getAllCardEssay() {return homeMapper.getAllCardEssay();}
    public ArrayList<CardApplyCommunity> getAllCardApplyCommunity() {return homeMapper.getAllCardApplyCommunity();}
}
