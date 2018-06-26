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
                minlength: 3,
                maxlength: 20
            },
            passwordConfirm: {
                required: true,
                minlength: 3,
                maxlength: 20,
                equalTo: '#password'
            },
            phone:{
                required:true,
                minlength: 11,
                maxlength: 11
            },
            firstname: {
                required: false
            },
            lastname: {
                required: false
            },
            gender: {
                required: false
            },
            terms: {
                required: true
            }
        },
        messages: {
            login: {
                required: '您还未填入用户名'
            },
            email: {
                required: '请输入您的常用邮箱地址',
                email: '请输入正确的邮箱地址'
            },
            password: {
                required: '请填入您的登录密码'
            },
            passwordConfirm: {
                required: '请填入您的登录密码',
                equalTo: '两次密码不一致'
            },
            firstname: {
                required: '您贵姓？'
            },
            lastname: {
                required: '您怎么称呼？'
            },
            gender: {
                required: '您是男士/女士？或者？'
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
                    window.location = "/pages/login.html";
                }else{
                    alert(data.msg);
                }
            })
        }
    });
});