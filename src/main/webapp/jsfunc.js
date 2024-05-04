// for index.jsp
function customAlert(msg, duration) {
    var el = document.createElement("div");
    el.setAttribute("style", "position:absolute;top:70%;left:50%;transform:translate(-50%, -50%);background:rgba(255, 255, 255, 0.1);backdrop-filter:blur(10px);padding:20px;border-radius:15px;color:white;");
    el.innerHTML = msg;
    setTimeout(function() {
        el.parentNode.removeChild(el);
    }, duration);
    document.body.appendChild(el);
}

window.onload = function() {
    if (window.location.hash === '#manager') {
        showManager(true);
    }
    if (window.location.hash === '#stafflogin') {
        showStaffLogin();
        customAlert('用户名或密码错误', 1000);
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
    if (check) {
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