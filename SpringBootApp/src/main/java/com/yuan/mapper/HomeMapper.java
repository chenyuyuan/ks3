package com.yuan.mapper;

import com.yuan.entity.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Repository
public interface HomeMapper {

    @Select("SELECT * FROM essay")
    ArrayList<Essay> getAllEssay();

    @Select("SELECT * FROM essay_content")
    ArrayList<EssayContent> getAllEssayContent();

    @Select("SELECT * FROM user")
    ArrayList<User> getAllUser();

    @Select("SELECT * FROM community")
    ArrayList<Community> getAllCommunity();

    @Select("SELECT essay.id, head, user_id, community_id, up, down, post_date, essay_content.content, user.account, community.name AS community_name, (\n" +
            "SELECT count(*) FROM comment WHERE comment.essay_id = essay.id\n" +
            ") AS comment_count\n" +
            "FROM essay, essay_content, community, user\n" +
            "WHERE essay.user_id=user.id AND essay.community_id = community.id AND essay.id = essay_content.essay_id\n" +
            "ORDER BY post_date DESC")
    ArrayList<CardEssay> getAllCardEssay();
}
