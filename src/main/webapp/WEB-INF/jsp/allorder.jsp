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
            <h1 class="title">订单管理</h1>
            <div style="height: 300px; overflow: auto;">
                <table>
                    <tr>
                        <th style="width:100px;">序号</th>
                        <th style="width:100px;">口味偏好</th>
                        <th style="width:200px;">菜品</th>
                        <th style="width:100px;">时间</th>
                        <th style="width:100px;">用户电话</th>
                        <th style="width:50px;">餐桌</th>
                        <th style="width:50px;">总价</th>
                        <th style="width:50px;">完成</th>
                        <th style="width:50px;">操作</th>
                    </tr>
                    <c:forEach var="order" items="${list}">
                        <tr>
                            <td>${order.order_id}</td>
                            <td>${order.prefer}</td>
                            <td>${order.dish_list}</td>
                            <td>${order.time}</td>
                            <td>${order.phone}</td>
                            <td>${order.table}</td>
                            <td>${order.total}</td>
                            <td>${order.complete}</td>
                            <c:choose>
                                <c:when test='${order.complete == false}'><td><a href="${pageContext.request.contextPath}/order/completeorder/${order.order_id}/${type}" style="text-decoration: none;">✅</a></td></c:when>
                                <c:otherwise><td>⚪</td></c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <a button href="<c:choose><c:when test='${type == "staff"}'>${pageContext.request.contextPath}/index</c:when><c:otherwise>${pageContext.request.contextPath}/manage</c:otherwise></c:choose>" class="button">返回</a>
        </div>
    </div>
</body>
</html>