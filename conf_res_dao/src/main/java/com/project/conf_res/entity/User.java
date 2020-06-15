package com.project.conf_res.entity;

import javax.validation.constraints.NotBlank;

public class User {
    private int id;
    @NotBlank(message = "请输入用户账号")
    private String account;
    private String password;
    @NotBlank(message = "请输入用户姓名")
    private String name;
    private int rNumber;    //预约数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getrNumber() {
        return rNumber;
    }

    public void setrNumber(int rNumber) {
        this.rNumber = rNumber;
    }

}
