<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
    <div id="index" class="container">
        <div class="glass-effect">
            <h1 class="title">在线点餐系统</h1>
            <div class="button-container">
                <button onclick="showUserLogin()" class="button">顾客登录</button>
                <button onclick="showStaffLogin()" class="button">后台登录</button>
            </div>
        </div>
    </div>
    <div id="userlogin" class="container" style="display:none;">
        <div class="glass-effect">
            <h1 class="title">欢迎光临</h1>
            <form id="login-form">
                <input type="text" placeholder="手机号" required>
                <input type="number" placeholder="用餐人数" min="1" max="9" required>
                <input type="number" placeholder="餐桌号" min="1" max="16" required>
                <div class="button-container">
                    <button class="button" type="submit">登录</button>
                    <button onclick="showIndex()" class="button">返回</button>
                </div>
            </form>
        </div>
    </div>
    <div id="stafflogin" class="container" style="display:none;">
        <div class="glass-effect">
            <h1 class="title">餐厅后台</h1>
            <form id="login-form" onsubmit="return false;">
                <input id="username" type="text" placeholder="用户" required>
                <input id="password" type="text" placeholder="密码" required>
                <div class="button-container">
                    <button onclick="showManager(false)" class="button">登录</button>
                    <button onclick="showIndex()" class="button">返回</button>
                </div>
            </form>
        </div>
    </div>
    <div id="manager" class="container" style="display:none;">
        <div class="glass-effect">
            <h1 class="title">管理员</h1>
            <a href="${pageContext.request.contextPath}/dish/alldish" button class="button">菜品</a>
            <a href="${pageContext.request.contextPath}/staff/allstaff" button class="button">员工</a>
            <a href="${pageContext.request.contextPath}/user/alluser" button class="button">用户</a>
            <a href="${pageContext.request.contextPath}/order/allorder" button class="button">订单</a>
            <button onclick="showIndex()" class="button">返回</button>
        </div>
    </div>
    <script>
        window.onload = function() {
            if (window.location.hash === '#manager') {
                showManager(true);
            }
        };
        function showUserLogin() {
            document.getElementById('index').style.display = 'none';
            document.getElementById('stafflogin').style.display = 'none';
            document.getElementById('manager').style.display = 'none';
            document.getElementById('userlogin').style.display = 'block';
        }
        function showStaffLogin() {
            document.getElementById('index').style.display = 'none';
            document.getElementById('userlogin').style.display = 'none';
            document.getElementById('manager').style.display = 'none';
            document.getElementById('stafflogin').style.display = 'block';
        }
        function showIndex() {
            document.getElementById('index').style.display = 'block';
            document.getElementById('userlogin').style.display = 'none';
            document.getElementById('stafflogin').style.display = 'none';
            document.getElementById('manager').style.display = 'none';
        }
        function showManager(check) {
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
            if ((username === 'root' && password === 'root') || check) {
                document.getElementById('index').style.display = 'none';
                document.getElementById('manager').style.display = 'block';
                document.getElementById('userlogin').style.display = 'none';
                document.getElementById('stafflogin').style.display = 'none';
            } else {
                alert('用户名或密码错误');
            }
        }
    </script>
</body>
</html>