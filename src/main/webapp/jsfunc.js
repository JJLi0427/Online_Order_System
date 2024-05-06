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
    document.getElementById('search').style.display = 'block';
}

var dish_list = "";
var prefer = "";

function updatedishlist() {
    var inputs = document.getElementsByName("num");
    var newdish_list = "";
    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        var row = input.parentNode.parentNode;
        var dishName = row.children[0].innerText;
        var price = row.children[1].innerText;
        var num = input.value;
        newdish_list += dishName + "/" + price + "/" + num + ",";
    }
    dish_list = newdish_list.slice(0, -1);
};

function updateprefer() {
    prefer = document.getElementById('prefer').value;
}

function sendOrder(user_id) {
    var timestamp = new Date().getTime();
    var order = {
        prefer: prefer,
        dish_list: dish_list,
        user_id: user_id,
        time: timestamp
    };

    fetch('${pageContext.request.contextPath}/order/addorder', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(order)
    }).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    }).then(data => {
        console.log('Success:', data);
    }).catch((error) => {
        console.error('Error:', error);
    });
};