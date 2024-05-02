<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <div class="container">
        <div class="glass-effect">
            <h1 class="title">欢迎光临</h1>
            <form id="login-form">
                <input type="text" placeholder="手机号" required>
                <input type="number" placeholder="用餐人数" min="1" max="9" required>
                <input type="number" placeholder="餐桌号" min="1" max="16" required>
                <div class="button-container">
                    <button class="button" type="submit">登录</button>
                    <a href="index.jsp" class="button">返回</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>