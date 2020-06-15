<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="user_top.jsp"/>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../../css/dcalendar.picker.css"/>
<script type="text/javascript" src="../../js/dcalendar.picker.js"></script>
<script type="text/javascript">
    <c:forEach items="${MESSAGE}" var="msg">
    alert("${msg}");
    </c:forEach>
    $(function () {
        $('#date').dcalendarpicker({
            format: 'yyyy-MM-dd'
        });
    });
</script>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 申请预约 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form id="admin-form" name="addForm" action="/reservation/add" modelAttribute="RESERVATION">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt40 mb40">
                            <span> 会议室信息 </span>
                        </div>
                        <form:hidden path="rid"/>
                        <div class="section row" id="items">
                            <div class="col-md-2" style="margin-top: 13px">会议室名称</div>
                            <div class="col-md-2">
                                <label for="room.name" class="field prepend-icon">
                                    <form:input path="room.name" cssClass="gui-input"
                                                placeholder="${RESERVATION.room.name}" readonly="true"/>
                                    <label for="room.name" class="field-icon">
                                        <i class="fa fa-building-o"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-2" style="margin-top: 13px">可容纳人数</div>
                            <div class="col-md-2">
                                <label for="room.member" class="field prepend-icon">
                                    <form:input path="room.member" cssClass="gui-input"
                                                placeholder="${RESERVATION.room.member}" readonly="true"/>
                                    <label for="room.member" class="field-icon">
                                        <i class="fa fa-building-o"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-md-2" style="margin-top: 13px">会议室位置</div>
                            <div class="col-md-2">
                                <label for="room.location" class="field prepend-icon">
                                    <form:input path="room.location" cssClass="gui-input"
                                                placeholder="${RESERVATION.room.location}" readonly="true"/>
                                    <label for="room.location" class="field-icon">
                                        <i class="fa fa-building-o"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section-divider mt40 mb40">
                            <span> 预约信息 </span>
                        </div>
                        <div class="section row" id="items">
                            <div class="col-sm-2" style="margin-top: 13px">预约日期</div>
                            <div class='col-sm-2'>
                                <label for="date" class="field prepend-icon">
                                    <form:input path="date" cssClass="gui-input" placeholder="预约日期"
                                                cssStyle="padding-left: 36px"/>
                                    <label for="date" class="field-icon">
                                        <i class="glyphicon glyphicon-calendar"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-sm-2" style="margin-top: 13px">预约时段</div>
                            <div class="col-sm-2">
                                <label for="time" class="field prepend-icon">
                                    <form:select path="time" cssClass="gui-input" items="${TIME}"
                                                 cssStyle="padding-left: 36px"/>
                                    <label for="time" class="field-icon">
                                        <i class="fa fa-clock-o"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-sm-2" style="margin-top: 13px">领导与会</div>
                            <div class="col-sm-2">
                                <label for="leader" class="field prepend-icon">
                                    <form:select path="leader" cssClass="gui-input" items="${LEADER}"
                                                 cssStyle="padding-left: 36px"/>
                                    <label for="leader" class="field-icon">
                                        <i class="fa fa-trophy"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row" id="items">
                            <div class="col-sm-2" style="margin-top: 13px">与会人数</div>
                            <div class="col-sm-2">
                                <label for="member" class="field prepend-icon">
                                    <form:input path="member" cssClass="gui-input" placeholder="与会人数"/>
                                    <label for="member" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-sm-2" style="margin-top: 13px">会议内容</div>
                            <div class="col-sm-2">
                                <label for="usage" class="field prepend-icon">
                                    <form:input path="usage" cssClass="gui-input" placeholder="会议内容"/>
                                    <label for="usage" class="field-icon">
                                        <i class="fa fa-comments"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="col-sm-2" style="margin-top: 13px">联系电话</div>
                            <div class="col-sm-2">
                                <label for="tel" class="field prepend-icon">
                                    <form:input path="tel" cssClass="gui-input" placeholder="联系电话"/>
                                    <label for="tel" class="field-icon">
                                        <i class="fa fa-phone"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section" id="items">
                            <label for="info" class="field prepend-icon">
                                <form:input path="info" cssClass="gui-input" placeholder="备注"/>
                                <label for="info" class="field-icon">
                                    <i class="fa fa-info"></i>
                                </label>
                            </label>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 提交</button>
                            <button type="button" class="button" onclick="window.history.go(-1);"> 返回</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>