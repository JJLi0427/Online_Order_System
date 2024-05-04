// for index.jsp
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
};

function showStaffLogin() {
    document.getElementById('index').style.display = 'none';
    document.getElementById('userlogin').style.display = 'none';
    document.getElementById('manager').style.display = 'none';
    document.getElementById('stafflogin').style.display = 'block';
};

function showIndex() {
    document.getElementById('index').style.display = 'block';
    document.getElementById('userlogin').style.display = 'none';
    document.getElementById('stafflogin').style.display = 'none';
    document.getElementById('manager').style.display = 'none';
};

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
};

function submitForm(contextPath) {
    var phone = document.getElementById('phone').value;
    var people = document.getElementById('people').value;
    var table = document.getElementById('table').value;
    var actionUrl = contextPath + "/user/updateuser/" + phone + "/" + people + "/" + table;
    document.getElementById('login-form').action = actionUrl;
    document.getElementById('login-form').submit();
};

// for alldish.jsp
function showNormal() {
    document.getElementById('normal').style.display = 'block';
    document.getElementById('updateForm').style.display = 'none';
    document.getElementById('search').style.display = 'none';
};

function updateDish(dish_id, dish_name, price) {
    document.getElementById('normal').style.display = 'none';
    document.getElementById('updateForm').style.display = 'block';
    document.getElementById('search').style.display = 'none';
    document.getElementById('update_dish_id').value = dish_id;
    document.getElementById('update_dish_name').value = dish_name;
    document.getElementById('update_price').value = price;
};

function searchDish() {
    document.getElementById('normal').style.display = 'none';
    document.getElementById('updateForm').style.display = 'none';
    document.getElementById('search').style.display = 'block';
};