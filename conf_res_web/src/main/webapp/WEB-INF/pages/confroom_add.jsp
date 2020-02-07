<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="administrator_top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加会议室 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form action="/confroom/add" modelAttribute="ROOM" id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section">
                            <label for="name" class="field prepend-icon">
                                <form:input path="name" cssClass="gui-input" placeholder="会议室名称"/>
                                <label for="name" class="field-icon">
                                    <i class="fa fa-building-o"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section">
                            <label for="member" class="field prepend-icon">
                                <form:input path="member" cssClass="gui-input" placeholder="可容纳人数"/>
                                <label for="member" class="field-icon">
                                    <i class="fa fa-building-o"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section">
                            <label for="location" class="field prepend-icon">
                                <form:input path="location" cssClass="gui-input" placeholder="会议室地址"/>
                                <label for="location" class="field-icon">
                                    <i class="fa fa-building-o"></i>
                                </label>
                            </label>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存</button>
                            <button type="button" class="button" onclick="window.history.go(-1);"> 返回
                            </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>