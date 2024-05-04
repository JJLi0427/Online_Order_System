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
                <h1 class="title">员工管理</h1>
                <br>
                <div style="height: 300px; overflow: auto;">
                    <table>
                        <tr>
                            <th style="width:100px;">序号</th>
                            <th style="width:100px;">名字</th>
                            <th style="width:100px;">当前订单</th>
                            <th style="width:50px;">密码</th>
                        </tr>
                        <c:forEach var="staff" items="${list}">
                            <tr>
                                <td>${staff.staff_id}</td>
                                <td>${staff.staff_name}</td>
                                <td>${staff.order_id}</td>
                                <td>${staff.password}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <a button href="${pageContext.request.contextPath}/index.jsp#manager" class="button">返回</a>
            </div>
        </div>
    </div>
</body>
</html>