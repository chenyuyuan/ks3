package com.yuan.dao.entity;

public class GoodsLike {
    private int id;
    private int user_id;
    private int goods_id;
    private int like_state;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getUserId() {
        return user_id;
    }

    public int getGoodsId() {
        return goods_id;
    }

    public void setGoodsId(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getLikeState() {
        return like_state;
    }

    public void setLikeState(int like_state) {
        this.like_state = like_state;
    }
}
