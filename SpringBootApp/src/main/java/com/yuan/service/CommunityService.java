package com.yuan.service;

import com.yuan.entity.CardEssay;
import com.yuan.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommunityService {
    @Autowired
    private CommunityMapper communityMapper;

    public ArrayList<CardEssay> getCommunityCardEssay(int community_id) {return communityMapper.getCommunityCardEssay(community_id);}

    public String getCommunityName(int community_id) {return communityMapper.getCommunityName(community_id);}
}
