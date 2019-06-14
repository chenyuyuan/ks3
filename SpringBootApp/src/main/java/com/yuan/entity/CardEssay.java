package com.yuan.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CardEssay implements Serializable {
    private int id;
    private String head;
    private int user_id;
    private int community_id;
    private int up;
    private int down;
    private String post_date;
    private int state;

    private String content;

    private String account;

    private String community_name;

    private int comment_count;

    private int i_up;
    private int i_down;
    private int i_star;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getI_up() {
        return i_up;
    }

    public void setI_up(int i_up) {
        this.i_up = i_up;
    }

    public int getI_down() {
        return i_down;
    }

    public void setI_down(int i_down) {
        this.i_down = i_down;
    }

    public int getI_star() {
        return i_star;
    }

    public void setI_star(int i_star) {
        this.i_star = i_star;
    }

    public static double getHot(int up, int down, String post_date) throws ParseException {
        double ans=0;
        int x = up - down;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeThen = String.valueOf(simpleDateFormat.parse(post_date).getTime());
        int t = ((int)(System.currentTimeMillis()) - (int)(Long.parseLong(timeThen))) / 1000;
        int z=(Math.abs(x)>1)?Math.abs(x):1;
        int y=0;
        if(x>0)y=1;else if(x<0)y=-1;else y=0;
        ans = Math.log10(z) + ((double)y*(double)t)/4500;
        return ans;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
