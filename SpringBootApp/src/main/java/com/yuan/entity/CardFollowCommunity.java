package com.yuan.entity;

public class CardFollowCommunity {
    private int community_id;
    private int follow_user_id;
    private String community_name;

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getFollow_user_id() {
        return follow_user_id;
    }

    public void setFollow_user_id(int follow_user_id) {
        this.follow_user_id = follow_user_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }
}
