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
                <h1 class="title">用户管理</h1>
                <br>
                <div style="height: 300px; overflow: auto;">
                    <table>
                        <tr>
                            <th style="width:100px;">序号</th>
                            <th style="width:100px;">电话</th>
                            <th style="width:100px;">餐桌号</th>
                            <th style="width:50px;">用餐人数</th>
                        </tr>
                        <c:forEach var="user" items="${list}">
                            <tr>
                                <td>${user.user_id}</td>
                                <td>${user.phone}</td>
                                <td>${user.table}</td>
                                <td>${user.people}</td>
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