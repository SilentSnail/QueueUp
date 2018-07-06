/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    $('.select_label').click(function() {
        $('.select_label').removeClass('select_label-active');
        $(this).addClass('select_label-active');
    });
    $('#js-usr-login').click(function() {
        $('#login-div').show();
        $('#repwd-div').hide();
        $('#hide-div').show();
        $('input[name="email"]').val("");
        $('#login').removeClass("usr_send");
        $('#login').addClass("usr_login");
    });
    $('#js-usr-repwd').click(function() {
        $('#login-div').hide();
        $('#repwd-div').show();
        $('#hide-div').hide();
        $('input[name="username"]').val("");
        $('input[name="password"]').val("");
        $('#login').removeClass("usr_login");
        $('#login').addClass("usr_send");
    });
    $('#from').submit(function (event) {
        event.preventDefault();
        currClass = $("#login").attr("class");
        if(currClass == "btn btn-primary usr_login"){
            if(validCheck(1)){
                send("/valid/login", 1)
            }
        }else if(currClass == "btn btn-primary usr_send"){
            if(validCheck(2)){
                send("/valid/rePassword", 2)
            }
        }else{
            alert("出错了");
        }
    });
    function validCheck(type) {
        if(type == 1){
            if($('input[name="username"]').val() == ""){
                showMessage("用户名不能为空");
                return false;
            }
            if($('input[name="password"]').val() == ""){
                showMessage("密码不能为空");
                return false;
            }
        }else{
            if($('input[name="email"]').val() == ""){
                showMessage("邮箱不能为空");
                return false;
            }
        }
        return true;
    }
    function send(url, type) {
        ajax(url, $('#from').serialize(), function (data) {
            if(data.code == 1){
                if(type == 1){
                    window.location = "/pages/admin/admin.html"
                }else{
                    showMessage("邮件发送成功")
                }
            }else{
                showMessage(data.msg);
            }
        });
    }
});