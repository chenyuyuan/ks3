package com.yuan.mapper;

import com.yuan.entity.CardFollowCommunity;
import com.yuan.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Repository
public interface PostMapper {

    @Select("SELECT community.id AS community_id, follow_community.user_id AS follow_user_id,name AS community_name\n" +
            "FROM community, follow_community\n" +
            "WHERE community.id = follow_community.community_id AND follow_community.user_id = 2")
    ArrayList<CardFollowCommunity> getAllFollowCommunity();

    @Insert("INSERT INTO essay (head,user_id,community_id) VALUES (#{head},2,#{community_id})")
    void postEssay(@Param("head") String head,@Param("community_id") int community_id);

    @Select("SELECT max(id) FROM essay")
    int maxidInEssay();

    @Insert("INSERT INTO essay_content (essay_id,content) VALUES (#{essay_id},#{content})")
    void postEssayContent(@Param("essay_id") int essay_id,@Param("content") String content);

    @Select("SELECT * FROM tag_list")
    ArrayList<Tag> getAllCardTag();

    @Insert("INSERT INTO essay_tag (essay_id,tag_id) VALUES (#{essay_id},#{tag_id})")
    void insEssayTag(@Param("essay_id") int essay_id,@Param("tag_id") int tag_id);
}
