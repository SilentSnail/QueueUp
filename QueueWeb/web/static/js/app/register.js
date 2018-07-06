/**
 * Created by liusong on 2018/6/23.
 */
$(function() {
    $('#sky-form').validate({
        rules: {
            username: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 6,
                maxlength: 20
            },
            passwordConfirm: {
                required: true,
                equalTo: '#password'
            },
            phone:{
                required:true,
                minlength: 11,
                maxlength: 11
            },
            terms: {
                required: true
            }
        },
        messages: {
            username: {
                required: '您还未填入用户名'
            },
            email: {
                required: '请输入您的常用邮箱地址',
                email: '请输入正确的邮箱地址'
            },
            password: {
                required: '请填入您的登录密码',
                minlength: "密码最少6位",
                maxlength: "密码最多20位"
            },
            passwordConfirm: {
                required: '请填入您的登录密码',
                equalTo: '两次密码不一致'
            },
            phone:{
                required:"请填入您的常用手机号码",
                minlength: "手机号码不真确",
                maxlength: "请填写正确的手机号码"
            },
            terms: {
                required: '您必须同意条款才能继续注册！'
            }
        },
        errorPlacement: function(error, element) {
            error.insertAfter(element.parent());
        }
    });
    $('#sky-form').submit(function(event){
        if(event.result){
            event.preventDefault();
            ajax("/valid/register", $('#sky-form').serialize(), function(data){
                if(data.code == 1){
                    showMessage("注册成功");
                    window.location = "/pages/login.html";
                }else{
                    showMessage(data.msg);
                }
            })
        }
    });
    $('#username').blur(function () {
        var val = $(this).val();
        if(val == "") return;
        ajax("/valid/checkName", {"username":val}, function (data) {
            if(data.code == 500){
                showMessage(data.msg)
            }
        });
    });
});