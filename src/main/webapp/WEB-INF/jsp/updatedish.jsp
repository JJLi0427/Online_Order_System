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
            <h1 class="title">修改菜品</h1>
            <form action="${pageContext.request.contextPath}/dish/updatedish" method="post">
                <input style="height: 50px; border-radius: 5px; border: none;" type="text" name="dish_name" value="${dish.dish_name}" required>
                <input style="height: 50px; border-radius: 5px; border: none;" type="text" name="price" value="${dish.price}" required>
                <button style="height: 50px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;" type="submit">完成修改</button>
            </form>
        </div>
    </div>
</body>
</html>