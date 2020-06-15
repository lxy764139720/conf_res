<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="administrator_top.jsp"/>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 用户列表 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light"
                                        onclick="window.location.href='/user/list';">
                                    <i class="fa fa-refresh"></i>
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
                            <th class="hidden-xs">用户账号</th>
                            <th class="hidden-xs">用户名称</th>
                            <th class="hidden-xs">用户密码</th>
                            <th class="hidden-xs">预约数量</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%--@elvariable id="LIST" type="java.util.List"--%>
                        <c:forEach items="${LIST}" var="user">
                            <tr class="message-unread">
                                    <%--勾选框--%>
                                    <%--<td class="hidden-xs">--%>
                                    <%--    <label class="option block mn">--%>
                                    <%--        <input type="checkbox" name="mobileos" value="FR">--%>
                                    <%--        <span class="checkbox mn"></span>--%>
                                    <%--    </label>--%>
                                    <%--</td>--%>
                                <td>${user.name}</td>
                                <td>${user.account}</td>
                                <td>${user.password}</td>
                                <td>${user.rNumber}</td>
                                <td>
                                    <a href="<c:url value="/user/remove?id=${user.id}"/>">删除</a>
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