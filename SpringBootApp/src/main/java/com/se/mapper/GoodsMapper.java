package com.se.mapper;

import com.se.entity.GoodsInformation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsMapper {

    //发布时插入商品信息
    @Insert("INSERT INTO goods_information(goods_id,goods_name,price,goods_detail,class_id,goods_picture_1,goods_picture_2,goods_picture_3,goods_picture_4,goods_state,user_id) VALUES(#{goods_id}, #{goods_name}, #{price}, #{goods_detail}, #{class_id},#{goods_picture_1},#{goods_picture_2},#{goods_picture_3},#{goods_picture_4},#{goods_state},#{user_id})")
    void insertGoodsInformation(@Param("goods_id") int goods_id,@Param("goods_name") String goods_name, @Param("price") int price, @Param("goods_detail") String goods_detail, @Param("class_id") int class_id, @Param("goods_picture_1") String goods_picture_1, @Param("goods_picture_2") String goods_picture_2, @Param("goods_picture_3") String goods_picture_3, @Param("goods_picture_4") String goods_picture_4, @Param("goods_state") int goods_state, @Param("user_id") int user_id);

//    //查询最后一个id
//    @Select("SELECT @@identity")
//    List<GoodsInformation> queryGoodslastId();

    //查询最后一个id
    @Select("SELECT max(goods_id) FROM goods_information")
    int queryGoodsLastId();

    //插入商品信息
    //@Insert("INSERT INTO goods(id, title, star, name, city, hot) VALUES(#{id}, #{title}, #{star}, #{name}, #{city}, #{hot})")
    //void insertGoods(@Param("id") int id, @Param("title") String title, @Param("star") int star, @Param("name") String name, @Param("city") String city, @Param("hot") int hot);

    //查询所有商品信息
    //@Select("SELECT * FROM goods")
    //List<Goods> queryGoodsById();

    //查询所有商品信息
    //@Select("SELECT * FROM goods_information")
    @Select("SELECT * FROM goods_information")
    List<GoodsInformation> queryGoodsInformationById();

    //根据名字查询商品信息
    @Select("SELECT * FROM goods_information WHERE goods_name = #{goods_name}")
    List<GoodsInformation> queryGoodsInformationByGoodsName(@Param("goods_name") String goods_name);

    //根据id修改商品信息
    @Update("Update goods_information set hot = #{hot} WHERE goods_id = #{goods_id}")
    void updateGoodsInformation(@Param("goods_id") int goods_id, @Param("hot") int hot);

    //根据id删除商品信息
    //@Delete("DELETE from goods WHERE id = #{id}")
    //void deleteGoods(@Param("id") int id);

    //根据id查询商品信息
    @Select("SELECT * FROM goods_information WHERE goods_id = #{goods_id}")
    GoodsInformation selectGoodsInformationById(@Param("goods_id") int goods_id);

    @Select("SELECT * FROM goods_information WHERE goods_id = #{goods_id}")
    GoodsInformation selectGoodsById(@Param("goods_id") int goods_id);

}
