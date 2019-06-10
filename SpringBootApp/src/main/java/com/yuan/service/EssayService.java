package com.yuan.service;

import com.yuan.entity.CardEssay;
import com.yuan.entity.Essay;
import com.yuan.mapper.EssayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EssayService {
    @Autowired
    private EssayMapper essayMapper;

    public CardEssay getCardEssay(int essay_id) {
        return essayMapper.getCardEssay(essay_id);
    }

}
