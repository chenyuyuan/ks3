package com.yuan.entity;

public class CardApplyCommunity {
    private int id;
    private String name;
    private int apply_user_id ;
    private String apply_user_account;
    private int support_number;
    private int i_support_community;
    private String introduction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getApply_user_id() {
        return apply_user_id;
    }

    public void setApply_user_id(int apply_user_id) {
        this.apply_user_id = apply_user_id;
    }

    public String getApply_user_account() {
        return apply_user_account;
    }

    public void setApply_user_account(String apply_user_account) {
        this.apply_user_account = apply_user_account;
    }

    public int getSupport_number() {
        return support_number;
    }

    public void setSupport_number(int support_number) {
        this.support_number = support_number;
    }

    public int getI_support_community() {
        return i_support_community;
    }

    public void setI_support_community(int i_support_community) {
        this.i_support_community = i_support_community;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
