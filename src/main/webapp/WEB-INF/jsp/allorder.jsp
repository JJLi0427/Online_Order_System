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
            <div id="normal">
                <h1 class="title">订单管理</h1>
                <div style="height: 300px; overflow: auto;">
                    <table>
                        <tr>
                            <th style="width:100px;">序号</th>
                            <th style="width:100px;">口味偏好</th>
                            <th style="width:100px;">时间</th>
                            <th style="width:100px;">菜品</th>
                            <th style="width:100px;">用户ID</th>
                            <th style="width:100px;">完成情况</th>
                        </tr>
                        <c:forEach var="order" items="${list}">
                            <tr>
                                <td>${order.order_id}</td>
                                <td>${order.prefer}</td>
                                <td>${order.time}</td>
                                <td>${order.dish_list}</td>
                                <td>${order.user_id}</td>
                                <td>${order.complete}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <a button href="${pageContext.request.contextPath}/#manager" class="button">返回</a>
            </div>
        </div>
    </div>
</body>
</html>