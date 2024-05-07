<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/jsfunc.js"></script>
</head>
<body>
    <c:choose>
        <c:when test="${success}"><script type="text/javascript">window.onload = showsuccess;</script></c:when>
    </c:choose>
    <div class="container">
        <div class="glass-effect">
            <div id="userorder">
                <h1 class="title">点餐</h1>
                <div style="height: 300px; overflow: auto;">
                    <table>
                        <tr>
                            <th style="width:100px;">菜名</th>
                            <th style="width:100px;">价格</th>
                            <th style="width:100px;">加购</th>
                        </tr>
                        <c:forEach var="dish" items="${list}">
                            <tr>
                                <td>${dish.dish_name}</td>
                                <td>${dish.price}</td>
                                <td><input type="hidden" id="dish_name" name="dish_name" value="${dish.dish_name}"><input type="hidden" id="price" name="price" value="${dish.price}"><input id="num" name="num" type="number" min="0" max="99"  value="0" style="background:rgba(255, 255, 255, 0.1);backdrop-filter:blur(10px);border-radius:5px;border:none;color:black;text-align:center;" required></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <form id="login-form"  action="${pageContext.request.contextPath}/order/addorder/${user_id}" method="post">
                    <br>
                    <input id="prefer" name="prefer" type="text" placeholder="口味偏好">
                    <div class="button-container">
                        <input type="hidden" id="dish_list" name="dish_list">
                        <button class="button" onclick="sendOrder()">下单</button>
                        <a button href="${pageContext.request.contextPath}/index" class="button">退出</a>
                    </div>
                </form>
            </div>

            <div id="success" style="display: none;">
                <h1 class="title">点餐成功</h1>
                <div style="height: 300px; overflow: auto;">
                    <table>
                        <tr>
                            <th style="width:100px;">口味偏好</th>
                            <th style="width:200px;">菜品</th>
                            <th style="width:100px;">时间</th>
                            <th style="width:50px;">总价</th>
                            <th style="width:50px;">完成</th>
                        </tr>
                        <c:forEach var="order" items="${userorder}">
                            <tr>
                                <td>${order.prefer}</td>
                                <td>${order.dish_list}</td>
                                <td>${order.time}</td>
                                <td>${order.total}</td>
                                <td>${order.complete}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <a button href="${pageContext.request.contextPath}/user/back/${user_id}" class="button">返回</a>
                <a button href="${pageContext.request.contextPath}/index" class="button">退出</a>
            </div>
        </div>
    </div>
</body>
</html>