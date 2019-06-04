package com.yuan.entity;

public class GoodsInformation {
    private int goods_id;
    private String goods_name;
    private int price;
    private int hot;
    private String goods_detail;
    private int class_id;
    private String goods_picture_1;
    private String goods_picture_2;
    private String goods_picture_3;
    private String goods_picture_4;
    private int goods_state;
    private int user_id;

    public int getgoods_id() {
        return goods_id;
    }

    public void setgoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getgoods_name() {
        return goods_name;
    }

    public void setgoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public String getgoods_detail() {
        return goods_detail;
    }

    public void setgoods_detail(String name) {
        this.goods_detail = goods_detail;
    }

    public int getclass_id() {
        return class_id;
    }

    public void setclass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getgoods_picture_1() {
        return goods_picture_1;
    }

    public void setgoods_picture_1(String goods_picture_1) {
        this.goods_picture_1 = goods_picture_1;
    }

    public String getgoods_picture_2() {
        return goods_picture_2;
    }

    public void setgoods_picture_2(String goods_picture_2) {
        this.goods_picture_2 = goods_picture_2;
    }

    public String getgoods_picture_3() {
        return goods_picture_3;
    }

    public void setgoods_picture_3(String goods_picture_3) {
        this.goods_picture_3 = goods_picture_3;
    }

    public String getgoods_picture_4() {
        return goods_picture_4;
    }

    public void setgoods_picture_4(String goods_picture_4) {
        this.goods_picture_4 = goods_picture_4;
    }

    public int getorder_state() {
        return goods_state;
    }

    public void setorder_state(int goods_state) {
        this.goods_state = goods_state;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }
}
