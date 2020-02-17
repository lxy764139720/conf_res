package com.project.conf_res.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ConfRoom {
    private int id;
    @NotNull(message = "会议室名不能为空")
    @NotEmpty(message = "会议室名不能为空")
    private String name;
    private int member;
    @NotNull(message = "会议室位置不能为空")
    @NotEmpty(message = "会议室位置不能为空")
    private String location;
    private String state;

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

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
