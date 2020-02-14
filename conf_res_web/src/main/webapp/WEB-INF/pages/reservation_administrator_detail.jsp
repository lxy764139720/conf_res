<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="administrator_top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 预约详情 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
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
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4">${RESERVATION.resTime}</div>
                        <div class="col-md-2">联系电话</div>
                        <div class="col-md-4">${RESERVATION.tel}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">备注</div>
                        <div class="col-md-10">${RESERVATION.info}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 审核情况 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">审核状态</div>
                        <div class="col-md-10">${RESERVATION.state}</div>
                    </div>
                    <c:if test="${RESERVATION.state == '待审核'}">
                        <form:form id="admin-form" name="addForm" action=""
                                   modelAttribute="AUDITLOG">
                            <div class="section" id="items">
                                <label for="info" class="field prepend-icon">
                                    <form:input path="info" cssClass="gui-input" placeholder="审核备注"/>
                                    <label for="info" class="field-icon">
                                        <i class="fa fa-info"></i>
                                    </label>
                                </label>
                            </div>
                        </form:form>
                    </c:if>
                    <div class="section row">
                    </div>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="window.history.go(-1);"> 返回</button>
                        <c:if test="${RESERVATION.state == '待审核'}">
                            <button type="button" class="button" id="pass"
                                    onclick="if(document.getElementById('admin-form')){
                                            document.getElementById('admin-form').action='/audit/pass'
                                            ;document.getElementById('admin-form').submit()}
                                            window.location.href='/audit/pass?id=${RESERVATION.id}'"> 通过
                            </button>
                            <button type="button" class="button" id="reject"
                                    onclick="if(document.getElementById('admin-form')){
                                            document.getElementById('admin-form').action='/audit/reject'
                                            ;document.getElementById('admin-form').submit()}
                                            window.location.href='/audit/reject?id=${RESERVATION.id}'"> 拒绝
                            </button>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>
