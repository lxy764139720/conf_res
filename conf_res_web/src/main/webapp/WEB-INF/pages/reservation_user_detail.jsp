<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="user_top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 预约详情 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt40 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">会议室名称</div>
                        <div class="col-md-4">${RESERVATION.room.name}</div>
                        <div class="col-md-2">会议室地址</div>
                        <div class="col-md-4">${RESERVATION.room.location}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">预约日期</div>
                        <div class="col-md-4">${RESERVATION.date}</div>
                        <div class="col-md-2">预约时段</div>
                        <div class="col-md-4">${RESERVATION.time}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">与会人数</div>
                        <div class="col-md-4">${RESERVATION.member}</div>
                        <div class="col-md-2">会议内容</div>
                        <div class="col-md-4">${RESERVATION.usage}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">申请人</div>
                        <div class="col-md-4">${RESERVATION.user.name}</div>
                        <div class="col-md-2">领导与会</div>
                        <div class="col-md-4">${RESERVATION.leader}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4">${RESERVATION.resTime}</div>
                        <div class="col-md-2">联系电话</div>
                        <div class="col-md-4">${RESERVATION.tel}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">备注</div>
                        <div class="col-md-10">${RESERVATION.info}</div>
                    </div>
                    <div class="section-divider mt40 mb40">
                        <span> 审核情况 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">审核状态</div>
                        <div class="col-md-4">${RESERVATION.state}</div>
                        <div class="col-md-2">审核备注</div>
                        <div class="col-md-4">${AUDITLOG.info}</div>
                    </div>
                    <div class="section row">
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="window.history.go(-1);"> 返回</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>
