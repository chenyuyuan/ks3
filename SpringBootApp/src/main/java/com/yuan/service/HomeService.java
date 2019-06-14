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

    public ArrayList<CardEssay> getAllCardEssay(int user_id) {return homeMapper.getAllCardEssay(user_id);}
    public ArrayList<CardApplyCommunity> getAllCardApplyCommunity() {return homeMapper.getAllCardApplyCommunity();}


    public void UpUp(int user_id, int essay_id) {
        if(homeMapper.getUpEssay(user_id,essay_id)==null) {
            homeMapper.insUpEssay(user_id,essay_id);
            homeMapper.addUpCount(essay_id);
        }
        else {
            homeMapper.delUpEssay(user_id,essay_id);
            homeMapper.minusUpCount(essay_id);
        }
    }
    public void DownDown(int user_id, int essay_id) {
        if(homeMapper.getDownEssay(user_id,essay_id)==null) {
            homeMapper.insDownEssay(user_id,essay_id);
            homeMapper.addDownCount(essay_id);
        }
        else {
            homeMapper.delDownEssay(user_id,essay_id);
            homeMapper.minusDownCount(essay_id);
        }
    }

    public void communityAuditPass(int essay_id,String msg){homeMapper.communityAuditPass(essay_id,msg);}
    public void communityAuditNotPass(int essay_id,String msg){homeMapper.communityAuditNotPass(essay_id,msg);}

}
