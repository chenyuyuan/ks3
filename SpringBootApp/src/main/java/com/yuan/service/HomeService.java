package com.yuan.service;

import com.yuan.entity.Essay;
import com.yuan.entity.EssayContent;
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
}
