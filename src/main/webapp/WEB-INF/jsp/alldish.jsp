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
            <h1 class="title">菜单管理</h1>
            <div class="search-container">
                <input style="height: 30px; border-radius: 5px; border: none;" type="text" placeholder="菜名" required>
                <button style="height: 30px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;">🔍</button>
            </div>
            <div style="height: 300px; overflow: auto;">
                <table>
                    <tr>
                        <th>后台ID</th>
                        <th>菜名</th>
                        <th>价格</th>
                        <th>修改</th>
                        <th>删除</th>
                    </tr>
                    <c:forEach var="dish" items="${list}">
                        <tr>
                            <td>${dish.dish_id}</td>
                            <td>${dish.dish_name}</td>
                            <td>${dish.price}</td>
                            <td><button style="background-color: rgb(138, 229, 138); border-radius: 50%; width: 10px; height: 12px; border: none;"></button></td>
                            <td><button style="background-color: rgb(220, 115, 115); border-radius: 50%; width: 10px; height: 12px; border: none;"></button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="button-container">
                <button class="button">新增</button>
                <button class="button">返回</button>
            </div>
        </div>
    </div>
</body>
</html>