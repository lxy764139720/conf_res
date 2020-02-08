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

    public static List<String> getTime() {
        List<String> list = new ArrayList<>();
        list.add(TIME_1);
        list.add(TIME_2);
        list.add(TIME_3);
        list.add(TIME_4);
        list.add(TIME_5);
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

    //用户预约处理操作
    public static final String USER_CREATE = "创建";
    public static final String USER_UPDATE = "修改";
    public static final String USER_SUBMIT = "提交";
    public static final String USER_REMOVE = "删除";
    public static final String USER_CHECK = "查看";

    public static List<String> getUserOperation() {
        List<String> list = new ArrayList<>();
        list.add(USER_CREATE);
        list.add(USER_UPDATE);
        list.add(USER_SUBMIT);
        list.add(USER_REMOVE);
        list.add(USER_CHECK);
        return list;
    }

    //管理员预约处理操作
    public static final String ADMINISTRATOR_CHECK = "查看";
    public static final String ADMINISTRATOR_PASS = "通过";
    public static final String ADMINISTRATOR_REJECT = "拒绝";

    public static List<String> getAdministratorOperation() {
        List<String> list = new ArrayList<>();
        list.add(ADMINISTRATOR_CHECK);
        list.add(ADMINISTRATOR_PASS);
        list.add(ADMINISTRATOR_REJECT);
        return list;
    }

    //管理员增删会议室操作
    public static final String ROOM_ADD = "添加";
    public static final String ROOM_DELETE = "删除";
    public static final String ROOM_CLOSE = "关闭";
    public static final String ROOM_UPDATE = "修改";
    public static final String ROOM_CHECK = "查看";

    public static List<String> getRoomOperation() {
        List<String> list = new ArrayList<>();
        list.add(ROOM_ADD);
        list.add(ROOM_DELETE);
        list.add(ROOM_CLOSE);
        list.add(ROOM_UPDATE);
        list.add(ROOM_CHECK);
        return list;
    }
}
