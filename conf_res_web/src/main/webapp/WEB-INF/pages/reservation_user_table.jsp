<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="user_top.jsp"/>
<link href="/css/table_style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="../../vendor/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
    //预约看板的色码表
    let colorArr = ["#35C3B4", "#739BE4", "#00B0EC", "#FCCB00", "#FF8D44", "#FF7372", "#6349CD"];//7,1,2,3,4,5,6

    //初始化加载数据
    $(function () {
        //获取开放会议室列表
        getRoomList();
        //获取周次
        getWeekList();
        // //获取预约信息
        // getReservation();
    });

    //清除当前显示的课表
    function clearTable() {
        $.each($("#resTable tr:not(:first-child)"), function (i, tr) {
            //		alert($(tr).find("td:not(:first-child)").length);
            $(tr).find("td:not(:first-child)").empty();
        });
    }

    //获取开放会议室列表
    function getRoomList() {
        $.ajax({
            type: "get",
            url: "/confroom_list",
            success: function (data) {
                if ("error" === $.trim(data)) {
                    alert("会议室列表加载失败");
                } else {
                    for (let i = 0; i < data.length; i++) {
                        $("#room_name").append("<option value=" + data[i].name + ">" + data[i].name + "</option>")
                    }
                }
            }
        })
    }

    //获取周次
    function getWeekList() {
        $.ajax({
            type: "get",
            url: "/week_list",
            success: function (data) {
                if ("error" === $.trim(data)) {
                    alert("周次加载失败");
                } else {
                    for (let i = 0; i < data.length; i++) {
                        $("#week").append("<option value=" + i + ">" + data[i] + "</option>")
                    }
                }
            }
        })
    }

    //获取预约信息
    function getReservation() {
        //清除当前显示的预约看板
        clearTable();
        $.ajax({
            type: "get",
            url: "/reservation_list/" + $("#room_name").val() + "/" + $("#week").val(),
            success: function (data) {
                if ("error" === $.trim(data)) {
                    alert("预约信息加载失败");
                } else {
                    console.log(data);
                    for (let i = 0; i < data.length; i++) {
                        let xq = data[i].date.dayOfWeek;
                        if (xq === "MONDAY") {
                            xq = 1;
                        } else if (xq === "TUESDAY") {
                            xq = 2;
                        } else if (xq === "WEDNESDAY") {
                            xq = 3;
                        } else if (xq === "THURSDAY") {
                            xq = 4;
                        } else if (xq === "FRIDAY") {
                            xq = 5;
                        } else if (xq === "SATURDAY") {
                            xq = 6;
                        } else if (xq === "SUNDAY") {
                            xq = 7;
                        }
                        let jc = data[i].time;
                        if (jc === "8:00-10:00") {
                            jc = 1;
                        } else if (jc === "10:00-12:00") {
                            jc = 2;
                        } else if (jc === "14:00-16:00") {
                            jc = 3;
                        } else if (jc === "16:00-18:00") {
                            jc = 4;
                        } else if (jc === "19:00-21:00") {
                            jc = 5;
                        } else if (jc === "21:00-23:00") {
                            jc = 6;
                        } //jc:节次 xq:星期
                        console.log(jc);
                        console.log(xq);
                        $("<div />", {
                            text: data[i].user.name,
                            onclick: "window.location.href='/reservation/administrator_detail?rid='+jsonList[i].rid;"
                        }).css("background", colorArr[xq % colorArr.length]).appendTo($("#resTable tr:eq(" + jc + ") td:eq(" + xq + ")"));
                    }
                }
            }
        });
    }
</script>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 预约看板 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div id="" style="width: 100%;height: 500px;">
                <table style="width: 100%;height: 100%;border-collapse: collapse;">
                    <tr style="height: 100%;">

                        <td>
                            <div class="dataDiv" style="width: 100%;height: 100%;">
                                <div class="dataHeader">

                                    <div style="height: 10px"></div>
                                    <div>
                                        <select name="room_name" id="room_name"
                                                style="width: 400px;height: 40px;border: 2px solid #F3F3F3;
                                                margin-left: 40px;margin-right: 40px;"
                                                onchange="getReservation();">
                                            <option>请选择要查看的会议室名称</option>
                                        </select>
                                        <select name="week" id="week"
                                                style="width: 400px;height: 40px;border: 2px solid #F3F3F3;
                                                margin-left: 40px;margin-right: 40px;"
                                                onchange="getReservation();">
                                            <option>请选择要查看的周次</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="dataBody">
                                    <table class="resTable" border="1" bordercolor="#F3F3F3" id="resTable"
                                           style="height: 420px;">
                                        <tbody>
                                        <tr>
                                            <th style="width: 7%;"></th>
                                            <th>星期一</th>
                                            <th>星期二</th>
                                            <th>星期三</th>
                                            <th>星期四</th>
                                            <th>星期五</th>
                                            <th>星期六</th>
                                            <th>星期七</th>
                                        </tr>

                                        <tr>
                                            <td>01-02</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>03-04</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>05-06</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>07-08</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>09-10</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>

                                        <tr>
                                            <td>11-12</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
<jsp:include page="bottom.jsp"/>