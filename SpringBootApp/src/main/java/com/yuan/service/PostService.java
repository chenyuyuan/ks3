package com.yuan.service;

import com.yuan.entity.CardFollowCommunity;
import com.yuan.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    public ArrayList<CardFollowCommunity> getAllFollowCommunity() {
        return postMapper.getAllFollowCommunity();
    }
    public void postEssay(String head, int community_id){postMapper.postEssay(head,community_id);}
    public int maxidInEssay(){return postMapper.maxidInEssay();}
    public void postEssayContent(int essay_id, String content){postMapper.postEssayContent(essay_id,content);}
}
