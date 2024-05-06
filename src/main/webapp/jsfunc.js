// for index.jsp
function customAlert(msg, duration) {
    var el = document.createElement("div");
    el.setAttribute("style", "position:absolute;top:75%;left:50%;transform:translate(-50%, -50%);background:rgba(255, 255, 255, 0.1);backdrop-filter:blur(10px);padding:20px;border-radius:15px;color:white;");
    el.innerHTML = msg;
    setTimeout(function() {
        el.parentNode.removeChild(el);
    }, duration);
    document.body.appendChild(el);
}

window.onload = function() {
    if (window.location.hash === '#stafflogin') {
        showStaffLogin();
        customAlert('验证失败，请重新登录', 1000);
    }
    if (window.location.hash === '#userlogin') {
        showUserLogin();
        customAlert('验证失败，请重新登录', 1000);
    }
};

function showUserLogin() {
    document.getElementById('index').style.display = 'none';
    document.getElementById('stafflogin').style.display = 'none';
    document.getElementById('userlogin').style.display = 'block';
};

function showStaffLogin() {
    document.getElementById('index').style.display = 'none';
    document.getElementById('userlogin').style.display = 'none';
    document.getElementById('stafflogin').style.display = 'block';
};

function showIndex() {
    document.getElementById('index').style.display = 'block';
    document.getElementById('userlogin').style.display = 'none';
    document.getElementById('stafflogin').style.display = 'none';
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

// for userorder.jsp
function showsuccess() {
    document.getElementById('userorder').style.display = 'none';
    document.getElementById('success').style.display = 'block';
};

function sendOrder() {
    var dish_list = "";
    var prefer = "";
    var dish_name = document.getElementsByName("dish_name");
    var price = document.getElementsByName("price");
    var inputs = document.getElementsByName("num");
    var totalNum = 0;
    for (var i = 0; i < inputs.length; i++) {
        totalNum += Number(inputs[i].value);
        if (inputs[i].value === "0") {
            continue;
        }
        dish_list += dish_name[i].value.toString() + "/" + price[i].value.toString() + "/" + inputs[i].value.toString() + ",";
    }
    dish_list = dish_list.slice(0, -1);
    if (totalNum === 0) {
        customAlert("未选择任何菜品，不能提交订单", 1000);
        return;
    }
    document.getElementById('prefer').value = prefer;
    document.getElementById('dish_list').value = dish_list;
    document.getElementById('login-form').submit();
};