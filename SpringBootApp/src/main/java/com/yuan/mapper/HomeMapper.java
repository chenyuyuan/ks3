package com.yuan.mapper;

import com.yuan.entity.Essay;
import com.yuan.entity.EssayContent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Repository
public interface HomeMapper {

    @Select("SELECT * FROM essay WHERE")
    ArrayList<Essay> getAllEssay();

    @Select("SELECT * FROM essay_content WHERE")
    ArrayList<EssayContent> getAllEssayContent();
}
