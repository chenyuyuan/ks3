package com.yuan.entity;

public class FollowUser {
    private int id;
    private int user_id;
    private int followed_user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFollowed_user_id() {
        return followed_user_id;
    }

    public void setFollowed_user_id(int followed_user_id) {
        this.followed_user_id = followed_user_id;
    }
}
