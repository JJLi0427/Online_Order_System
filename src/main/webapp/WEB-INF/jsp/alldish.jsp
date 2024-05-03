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
                <input style="height: 30px; border-radius: 5px; border: none;" type="text" placeholder="查找菜名" required>
                <button style="height: 30px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;">🔍</button>
            </div>
            <br>
            <div class="search-container">
                <form action="${pageContext.request.contextPath}/dish/adddish" method="post">
                    <input style="width: 73px; height: 30px; border-radius: 5px; border: none;" type="text" name="dish_name" placeholder="菜名" required>
                    <input style="width: 73px; height: 30px; border-radius: 5px; border: none;" type="text" name="price" placeholder="价格" required>
                    <button style="height: 30px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;" type="submit">新增</button>
                </form>
            </div>
            <br>
            <div style="height: 300px; overflow: auto;">
                <table>
                    <tr>
                        <th style="width:100px;">序号</th>
                        <th style="width:100px;">菜名</th>
                        <th style="width:100px;">价格</th>
                        <th style="width:50px;">修改</th>
                        <th style="width:50px;">删除</th>
                    </tr>
                    <c:forEach var="dish" items="${list}">
                        <tr>
                            <td>${dish.dish_id}</td>
                            <td>${dish.dish_name}</td>
                            <td>${dish.price}</td>
                            <td><a href="${pageContext.request.contextPath}/dish/updatedish/${dish.dish_id}" style="text-decoration: none;">✍️</a></td>
                            <td><a href="${pageContext.request.contextPath}/dish/deletedish/${dish.dish_id}" style="text-decoration: none;">🗑️</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <a button href="${pageContext.request.contextPath}" class="button">退出后台</a>
        </div>
    </div>
</body>
</html>