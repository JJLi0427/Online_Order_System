<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div class="container">
        <div class="glass-effect">
            <h1 class="title">管理员</h1>
            <a href="${pageContext.request.contextPath}/dish/alldish" button class="button">菜品</a>
            <a href="${pageContext.request.contextPath}/staff/allstaff" button class="button">员工</a>
            <a href="${pageContext.request.contextPath}/user/alluser" button class="button">用户</a>
            <a href="${pageContext.request.contextPath}/order/allorder/manager" button class="button">订单</a>
            <a href="${pageContext.request.contextPath}/index" button class="button">退出</a>
        </div>
    </div>
</body>