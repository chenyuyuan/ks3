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

    @Select("SELECT comment.id, comment.user_id, account, name AS community_name, content, comment.up, comment.down, comment.post_date,head AS essay_head\n" +
            "FROM comment, user, community, essay \n" +
            "WHERE comment.user_id = user.id AND comment.essay_id = essay.id AND essay.community_id = community.id")
    ArrayList<CardComment> getAllComment();

    @Select("SELECT essay.id, head, user_id, community_id, up, down, post_date, essay_content.content, user.account, community.name AS community_name, (SELECT count(*) FROM comment WHERE comment.essay_id = essay.id) AS comment_count,\n" +
            "(SELECT count(*) FROM up_essay WHERE up_essay.user_id = 2 AND up_essay.essay_id = essay.id) AS i_up, \n" +
            "(SELECT count(*) FROM down_essay WHERE down_essay.user_id = 2 AND down_essay.essay_id = essay.id) AS i_down,\n" +
            "(SELECT count(*) FROM star_essay WHERE star_essay.user_id = 2 AND star_essay.essay_id = essay.id) AS i_star\n" +
            "FROM essay, essay_content, community, user\n" +
            "WHERE essay.user_id=user.id AND essay.community_id = community.id AND essay.id = essay_content.essay_id\n" +
            "ORDER BY post_date DESC")
    ArrayList<CardEssay> getAllCardEssay();

    @Select("SELECT apply_community.id, name, user_id AS apply_user_id, support_number,introduction,\n" +
            "(SELECT account FROM user WHERE id = user_id) AS apply_user_account,\n" +
            "(SELECT count(*) FROM apply_community_support_user \n" +
            "WHERE apply_community_support_user.user_id = 2 AND apply_community_support_user.apply_community_id = apply_community.id\n" +
            ") AS i_support_community\n" +
            "FROM apply_community,apply_community_support_user")
    ArrayList<CardApplyCommunity> getAllCardApplyCommunity();
}
