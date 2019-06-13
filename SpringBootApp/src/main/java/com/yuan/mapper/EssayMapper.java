package com.yuan.mapper;

import com.yuan.entity.CardComment2;
import com.yuan.entity.CardEssay;
import com.yuan.entity.Community;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EssayMapper {
    @Select("SELECT essay.id, head, user_id, community_id, up, down, post_date, essay_content.content, user.account, community.name AS community_name, (SELECT count(*) FROM comment WHERE comment.essay_id = essay.id) AS comment_count,\n" +
            "(SELECT count(*) FROM up_essay WHERE up_essay.user_id = 2 AND up_essay.essay_id = essay.id) AS i_up, \n" +
            "(SELECT count(*) FROM down_essay WHERE down_essay.user_id = 2 AND down_essay.essay_id = essay.id) AS i_down,\n" +
            "(SELECT count(*) FROM star_essay WHERE star_essay.user_id = 2 AND star_essay.essay_id = essay.id) AS i_star\n" +
            "FROM essay, essay_content, community, user\n" +
            "WHERE essay.user_id=user.id AND essay.community_id = community.id AND essay.id = essay_content.essay_id AND essay_id = #{essay_id}\n" +
            "ORDER BY post_date DESC")
    CardEssay getCardEssay(@Param("essay_id") int essay_id);


    @Insert("INSERT INTO view_logs (user_id,essay_id) VALUES (#{user_id},#{essay_id})")
    void insViewLogs(@Param("user_id") int user_id,@Param("essay_id") int essay_id);

    @Select("SELECT comment.id, user.id AS user_id, account, content, post_date\n" +
            "FROM comment, user\n" +
            "WHERE user_id = user.id AND essay_id = #{essay_id}\n" +
            "ORDER BY post_date DESC")
    ArrayList<CardComment2> getCardComment(@Param("essay_id") int essay_id);

    @Insert("INSERT INTO comment (user_id,essay_id,father_comment_id,content) VALUES (#{user_id},#{essay_id},0,#{content})")
    void insComment(@Param("user_id") int user_id,@Param("essay_id") int essay_id,@Param("content") String content);
}
