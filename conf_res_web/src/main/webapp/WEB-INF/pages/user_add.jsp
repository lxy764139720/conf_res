<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="administrator_top.jsp"/>

<script type="text/javascript">
    <c:forEach items="${MESSAGE}" var="msg">
    alert("${msg}");
    </c:forEach>
</script>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加用户 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/user/add" modelAttribute="USER" id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt40 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-2" style="margin-top: 13px">用户账号</div>
                            <div class="col-md-10">
                                <label for="account" class="field prepend-icon">
                                    <form:input path="account" cssClass="gui-input" placeholder="用户账号"/>
                                    <label for="account" class="field-icon">
                                        <i class="fa fa-building-o"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2" style="margin-top: 13px">用户名称</div>
                            <div class="col-md-10">
                                <label for="name" class="field prepend-icon">
                                    <form:input path="name" cssClass="gui-input" placeholder="用户名称"/>
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-building-o"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>