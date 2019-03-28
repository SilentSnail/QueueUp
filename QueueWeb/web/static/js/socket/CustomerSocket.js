/**
 * Created by liusong on 2018/4/17.
 */

var socket = null;
var token;

function socketConnection() {
    if('WebSocket' in window){
        if(socket != null){
            closeWebSocket();
        }
        var username = document.getElementById("username").value;
        if(username){
            var url = "ws://localhost:8080/ws/socket/custom/" + username;
            createConn(url);
        }else{
            alert("请输入用户名");
        }
    }else{
        showMessage("当前浏览器不支持websocket");
    }
}

function createConn(url) {
    socket = new WebSocket(url);
    socket.onopen = connSuccess;
    socket.onerror = connError;
    socket.onmessage = getMessage;
    socket.onclose = onclose;
}

function connSuccess() {
    showMessage("链接服务器成功");
};

function connError(){
    showMessage("系统异常");
};

function getMessage(event){
    var json = JSON.parse(event.data);
    if(json.token){
        token = json.token;
    }
    if(json.service)
        showMessage(json.service);
    else
        showMessage(json.msg);
};

//调用关闭方法
function closeWebSocket() {
    socket.close();
}

//关闭成功后调用
function onclose() {
    showMessage("链接已断开");
}

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
    closeWebSocket();
}

function showMessage(message) {
    var div = document.getElementById("showMessage");
    message = "<br/>" + message;
    div.innerHTML += message;
}

function clearShow() {
    document.getElementById("showMessage").innerHTML = "";
}

function sendMessage(conn){
    if(socket){
        var msg = document.getElementById("message").value;
        var sendMsg = '{"conn":"' + conn +'","token":"' + token + '","msg":"'+msg+'"}';
        if(msg){
            socket.send(sendMsg);
        }
    }else{
        showMessage("链接已关闭");
    }
}