package com.yuan.entity;

//import com.sun.istack.internal.NotNull;

public class User {
    private int id;
    private String account;
    private String password;


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

}
