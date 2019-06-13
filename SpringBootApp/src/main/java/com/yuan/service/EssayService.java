package com.yuan.service;

import com.yuan.entity.CardComment;
import com.yuan.entity.CardComment2;
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
    public void insViewLogs(int user_id, int essay_id) {
        essayMapper.insViewLogs(user_id,essay_id);
    }

    public ArrayList<CardComment2> getCardComment(int essay_id) {return essayMapper.getCardComment(essay_id);}
    public void insComment(int user_id, int essay_id,String content) {
        essayMapper.insComment(user_id,essay_id,content);
    }

}
