package com.project.conf_res.global;

import java.util.ArrayList;
import java.util.List;

public class Contant {

    //用户身份
    public static final String ROLE_USER = "用户";
    public static final String ROLE_ADMINISTRATOR = "管理员";

    public static List<String> getRole() {
        List<String> list = new ArrayList<>();
        list.add(ROLE_USER);
        list.add(ROLE_ADMINISTRATOR);
        return list;
    }

    //预约时段
    public static final String TIME_1 = "8:00-10:00";
    public static final String TIME_2 = "10:00-12:00";
    public static final String TIME_3 = "14:00-16:00";
    public static final String TIME_4 = "16:00-18:00";
    public static final String TIME_5 = "19:00-21:00";
    public static final String TIME_6 = "21:00-23:00";

    public static List<String> getTime() {
        List<String> list = new ArrayList<>();
        list.add(TIME_1);
        list.add(TIME_2);
        list.add(TIME_3);
        list.add(TIME_4);
        list.add(TIME_5);
        list.add(TIME_6);
        return list;
    }

    //是否有领导与会
    public static final String LEADER_FALSE = "否";
    public static final String LEADER_TRUE = "是";

    public static List<String> getLeader() {
        List<String> list = new ArrayList<>();
        list.add(LEADER_FALSE);
        list.add(LEADER_TRUE);
        return list;
    }

    //会议室状态
    public static final String ROOM_STATE_OPEN = "开放";
    public static final String ROOM_STATE_OFF = "关闭";

    public static List<String> getRoomState() {
        List<String> list = new ArrayList<>();
        list.add(ROOM_STATE_OPEN);
        list.add(ROOM_STATE_OFF);
        return list;
    }

    //审核结果
    public static final String AUDIT_RESULT_PENDING = "待审核";
    public static final String AUDIT_RESULT_PASS = "已通过";
    public static final String AUDIT_RESULT_REJECT = "已拒绝";

    public static List<String> getAuditResult() {
        List<String> list = new ArrayList<>();
        list.add(AUDIT_RESULT_PENDING);
        list.add(AUDIT_RESULT_PASS);
        list.add(AUDIT_RESULT_REJECT);
        return list;
    }

    //周次
    public static final String WEEK1 = "本周";
    public static final String WEEK2 = "第二周";
    public static final String WEEK3 = "第三周";
    public static final String WEEK4 = "第四周";

    public static List<String> getWeek() {
        List<String> list = new ArrayList<>();
        list.add(WEEK1);
        list.add(WEEK2);
        list.add(WEEK3);
        list.add(WEEK4);
        return list;
    }
}
