package com.yuan.mapper;

import com.yuan.entity.CardEssay;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommunityMapper {
    @Select("SELECT audit_state as state, essay.id, head, user_id, community_id, up, down, post_date, essay_content.content, user.account, community.name AS community_name, (SELECT count(*) FROM comment WHERE comment.essay_id = essay.id) AS comment_count,\n" +
            "(SELECT count(*) FROM up_essay WHERE up_essay.user_id = 2 AND up_essay.essay_id = essay.id) AS i_up, \n" +
            "(SELECT count(*) FROM down_essay WHERE down_essay.user_id = 2 AND down_essay.essay_id = essay.id) AS i_down,\n" +
            "(SELECT count(*) FROM star_essay WHERE star_essay.user_id = 2 AND star_essay.essay_id = essay.id) AS i_star\n" +
            "FROM essay, essay_content, community, user\n" +
            "WHERE essay.user_id=user.id AND essay.community_id = community.id AND essay.id = essay_content.essay_id AND community.id = #{community_id}\n" +
            "ORDER BY post_date DESC")
    ArrayList<CardEssay> getCommunityCardEssay(@Param("community_id") int community_id);

    @Select("SELECT name FROM community WHERE id = #{community_id}")
    String getCommunityName(@Param("community_id") int community_id);

}
