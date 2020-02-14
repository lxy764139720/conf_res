<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="user_top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 我的预约 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light"
                                        onclick="window.location.href='/reservation/user_list';">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <button type="button" class="btn btn-default light"
                                        onclick="window.location.href='/reservation/to_confroom';">
                                    <i class="fa fa-plus"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <%--                            <th class="text-center hidden-xs">Select</th>--%>
                            <th class="hidden-xs">预约会议室</th>
                            <th class="hidden-xs">预约日期</th>
                            <th class="hidden-xs">申请时间</th>
                            <th class="hidden-xs">审核状态</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--@elvariable id="LIST" type="java.util.List"--%>
                        <c:forEach items="${LIST}" var="reservation">
                            <tr class="message-unread">
                                    <%--                                <td class="hidden-xs">--%>
                                    <%--                                    <label class="option block mn">--%>
                                    <%--                                        <input type="checkbox" name="mobileos" value="FR">--%>
                                    <%--                                        <span class="checkbox mn"></span>--%>
                                    <%--                                    </label>--%>
                                    <%--                                </td>--%>
                                <td>${reservation.room.name}</td>
                                <td><spring:eval expression="reservation.date"/></td>
                                <td><spring:eval expression="reservation.resTime"/></td>
                                <td>${reservation.state}</td>
                                <td>
                                    <a href="<c:url value="/reservation/user_detail?id=${reservation.id}"/>">查看</a>
                                    <a href="<c:url value="/reservation/to_edit?id=${reservation.id}"/>">编辑</a>
                                    <a href="<c:url value="/reservation/remove?id=${reservation.id}"/>">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>