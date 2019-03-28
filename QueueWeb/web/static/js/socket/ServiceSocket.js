/**
 * Created by liusong on 2018/4/19.
 */

var socket = null;
var token;

function ServiceSocket() {
    if('WebSocket' in window){
        if(socket != null){
            closeSocket();
        }
        var username = document.getElementById("username").value;
        if(username){
            var url = "ws://localhost:8080/ws/socket/service/" + username;
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
    socket.onclose = close;
}

function closeSocket(){
    socket.close();
}

function close() {
    showMessage("链接已断开");
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
    if(json.custom)
        showMessage(json.custom);
    else
        showMessage(json.msg);
};

function clearShow() {
    document.getElementById("showMessage").innerHTML = "";
}

function showMessage(message) {
    var div = document.getElementById("showMessage");
    message = "<br/>" + message;
    div.innerHTML += message;
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