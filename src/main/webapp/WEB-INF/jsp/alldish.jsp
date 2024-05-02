<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="menuManagementStyles.css">
</head>
<body>
    <div class="container">
        <div class="glass-effect">
            <h1 class="title">菜单管理</h1>
            <table>
                <tr>
                    <th>后台id</th>
                    <th>菜名</th>
                    <th>价格</th>
                </tr>
                <c:forEach var="dish" items="${list}">
                    <tr>
                        <td>${dish.dish_id}</td>
                        <td>${dish.dish_name}</td>
                        <td>${dish.price}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>