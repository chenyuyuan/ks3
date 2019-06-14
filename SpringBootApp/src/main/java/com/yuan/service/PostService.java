package com.yuan.service;

import com.yuan.entity.CardFollowCommunity;
import com.yuan.entity.Tag;
import com.yuan.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;


    public void postEssay(String head, int community_id) {postMapper.postEssay(head,community_id);}
    public int maxidInEssay() {return postMapper.maxidInEssay();}
    public void postEssayContent(int essay_id, String content) {postMapper.postEssayContent(essay_id,content);}

    public ArrayList<Tag> getAllCardTag(){return postMapper.getAllCardTag();}

    public void insEssayTag(int essay_id,int tag_id) {postMapper.insEssayTag(essay_id,tag_id);}
}
