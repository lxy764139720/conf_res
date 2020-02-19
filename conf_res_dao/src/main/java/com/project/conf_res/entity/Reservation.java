package com.project.conf_res.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private int uid;
    private int rid;
    private int member;
    @NotNull(message = "请输入预约日期")
    @FutureOrPresent(message = "预约日期必须在当天或之后")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; //会议时间
    private String time; //会议时段
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime resTime; //申请预约时间
    private String state;
    private String usage;
    @NotBlank(message = "请输入联系方式")
    private String tel;
    private String info;

    private User user;
    private ConfRoom room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDateTime getResTime() {
        return resTime;
    }

    public void setResTime(LocalDateTime resTime) {
        this.resTime = resTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ConfRoom getRoom() {
        return room;
    }

    public void setRoom(ConfRoom room) {
        this.room = room;
    }
}
