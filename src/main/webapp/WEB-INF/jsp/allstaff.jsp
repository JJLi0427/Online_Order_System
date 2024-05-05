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
            <h1 class="title">员工管理</h1>
            <div style="height: 300px; overflow: auto;">
                <table>
                    <tr>
                        <th style="width:100px;">序号</th>
                        <th style="width:100px;">名字</th>
                        <th style="width:100px;">密码</th>
                        <th style="width:50px;">删除</th>
                    </tr>
                    <c:forEach var="staff" items="${list}">
                        <tr>
                            <td>${staff.staff_id}</td>
                            <td>${staff.staff_name}</td>
                            <td>${staff.password}</td>
                            <td><a href="${pageContext.request.contextPath}/staff/deletestaff/${staff.staff_id}" style="text-decoration: none;">🗑️</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <form action="${pageContext.request.contextPath}/staff/addstaff" method="post">
                <input style="width: 100px; height: 30px; border-radius: 5px; border: none;" type="text" name="staff_name" placeholder="用户名" required>
                <input style="width: 100px; height: 30px; border-radius: 5px; border: none;" type="text" name="password" placeholder="密码" required>
                <button style="height: 30px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;" type="submit">添加店员</button>
            </form>
            <a button href="${pageContext.request.contextPath}/manage" class="button">返回</a>
        </div>
    </div>
</body>
</html>