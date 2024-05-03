<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
    <script>
        function showNormal() {
            document.getElementById('normal').style.display = 'block';
            document.getElementById('updateForm').style.display = 'none';
            document.getElementById('search').style.display = 'none';
        }
        function updateDish(dish_id, dish_name, price) {
            document.getElementById('normal').style.display = 'none';
            document.getElementById('updateForm').style.display = 'block';
            document.getElementById('search').style.display = 'none';
            document.getElementById('update_dish_id').value = dish_id;
            document.getElementById('update_dish_name').value = dish_name;
            document.getElementById('update_price').value = price;
        }
        function searchDish() {
            document.getElementById('normal').style.display = 'none';
            document.getElementById('updateForm').style.display = 'none';
            document.getElementById('search').style.display = 'block';
        }
    </script>
</head>
<body>
    <c:choose>
        <c:when test="${searchMode}">
            <script type="text/javascript">
                window.onload = searchDish;
            </script>
        </c:when>
        <c:otherwise>
            <script type="text/javascript">
                window.onload = showNormal;
            </script>
        </c:otherwise>
    </c:choose>
    <div class="container">
        <div class="glass-effect">
            <div id="normal">
                <h1 class="title">菜单管理</h1>
                <div class="search-container">
                    <form action="${pageContext.request.contextPath}/dish/searchdish" method="post" onsubmit="searchDish()">
                        <input style="width: 100px; height: 30px; border-radius: 5px; border: none;" type="text" name="dish_name" placeholder="查找菜名" required>
                        <button style="height: 30px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;" type="submit">🔍</button>
                    </form>
                </div>
                <br>
                <div class="search-container">
                    <form action="${pageContext.request.contextPath}/dish/adddish" method="post">
                        <input style="width: 90px; height: 30px; border-radius: 5px; border: none;" type="text" name="dish_name" placeholder="菜名" required>
                        <input style="width: 90px; height: 30px; border-radius: 5px; border: none;" type="text" name="price" placeholder="价格" required>
                        <button style="height: 30px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;" type="submit">新增菜品</button>
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
                                <td><a href="javascript:updateDish(${dish.dish_id}, '${dish.dish_name}', ${dish.price})" style="text-decoration: none;" onclick="updateDish()">✍️</a></td>
                                <td><a href="${pageContext.request.contextPath}/dish/deletedish/${dish.dish_id}" style="text-decoration: none;">🗑️</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <a button href="${pageContext.request.contextPath}" class="button">退出后台</a>
            </div>

            <div id="updateForm" style="display: none;">
                <h1 class="title">修改菜品</h1>
                <form action="${pageContext.request.contextPath}/dish/updatedish" method="post" onsubmit="showNormal()">
                    <input type="hidden" id="update_dish_id" name="dish_id">
                    <input style="height: 50px; border-radius: 5px; border: none;" id="update_dish_name" type="text" name="dish_name" required>
                    <input style="height: 50px; border-radius: 5px; border: none;" id="update_price" type="text" name="price" required>
                    <button style="height: 50px; background-color: rgb(134, 234, 247); border-radius: 5px; border: none;" type="submit">完成修改</button>
                </form>
            </div>

            <div id="search" style="display: none;">
                <h1 class="title">查询结果</h1>
                <div style="height: 100px; overflow: auto;">
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
                                <td><a href="javascript:updateDish(${dish.dish_id}, '${dish.dish_name}', ${dish.price})" style="text-decoration: none;" onclick="updateDish()">✍️</a></td>
                                <td><a href="${pageContext.request.contextPath}/dish/deletedish/${dish.dish_id}" style="text-decoration: none;">🗑️</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <a href="${pageContext.request.contextPath}/dish/alldish" button class="button">返回</a>
            </div>
        </div>
    </div>
</body>
</html>