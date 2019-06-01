package com.se.entity;

//import com.sun.istack.internal.NotNull;

public class Users {
    private int id;
    private String account;
    private String password;
    private String user_star;
    private String user_tel;
    private String real_name;
    private String user_addr_pro;
    private String user_addr_city;
    private String user_addr_det;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_star() {
        return user_star;
    }

    public void setUser_star(String user_star) {
        this.user_star = user_star;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getUser_addr_pro() {
        return user_addr_pro;
    }

    public void setUser_addr_pro(String user_addr_pro) {
        this.user_addr_pro = user_addr_pro;
    }

    public String getUser_addr_city() {
        return user_addr_city;
    }

    public void setUser_addr_city(String user_addr_city) {
        this.user_addr_city = user_addr_city;
    }

    public String getUser_addr_det() {
        return user_addr_det;
    }

    public void setUser_addr_det(String user_addr_det) {
        this.user_addr_det = user_addr_det;
    }
}
