/**
 * Created by liusong on 2018/4/17.
 */

$('#login-button').click(function (event) {
    event.preventDefault();
    currClass = $(this).attr("class");
    if(currClass == "usr_login"){
        login()
    }else if(currClass == "usr_repwd"){
        rePwd();
    }else{
        alert("出错了");
    }
});

$('.select_label').click(function() {
    $('.select_label').removeClass('select_label-active');
    $(this).addClass('select_label-active');
});

$('#js-usr-login').click(function() {
    $('input[name="email"]').hide().val("");
    $('input[name="username"]').show();
    $('input[name="password"]').show();
    $('#remeber').show();
    $('#login-button').removeClass("usr_repwd");
    $('#login-button').addClass("usr_login");
});
$('#js-usr-repwd').click(function() {
    $('input[name="email"]').show();
    $('input[name="username"]').hide().val("");
    $('input[name="password"]').hide().val("");
    $('#remeber').hide();
    $('#login-button').removeClass("usr_login");
    $('#login-button').addClass("usr_repwd");
});

login = function () {
    ajax("/valid/login", $('#submit').serialize(), function (data) {
        if(data.code == 1){
            $('.select_list').hide();//隐藏选项
            $('form').fadeOut(500);//淡入淡出方式隐藏form
            $('.wrapper').addClass('form-success');//添加样式
            window.location = "/pages/admin/admin.html"
        }else{
            alert(data.msg);
        }
    });
}

rePwd = function () {
    ajax("/valid/rePassword", $('#submit').serialize(), function (data) {
        if(data.code == 1){
            alert("密码重置邮件已发送!");
        }else{
            alert(data.msg);
        }
    });
}