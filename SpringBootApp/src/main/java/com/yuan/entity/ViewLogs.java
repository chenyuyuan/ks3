package com.yuan.entity;

public class ViewLogs {
    private int id;
    private int user_id;
    private int essay_id;
    private String view_time;

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

    public int getEssay_id() {
        return essay_id;
    }

    public void setEssay_id(int essay_id) {
        this.essay_id = essay_id;
    }

    public String getView_time() {
        return view_time;
    }

    public void setView_time(String view_time) {
        this.view_time = view_time;
    }
}
