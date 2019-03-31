/**
 * Created by liusong on 2018/6/23.
 */
$(function() {

    $("#checkCode").click(function () {
        this.src = "/valid/rePassValidCode?t=" + Math.random();
    });

    $("button[name=getMailCheck]").click(function () {
        var email = $("#email").val();
        var verCode = $("#verCode").val();
        if(email == ""){
            layer.alert("请输入关联邮箱", {icon: 5});
            return;
        }
        if(verCode == ""){
            layer.alert("请输入验证码", {icon: 5});
            return;
        }
        ajax("/valid/rePassword", {"email":email, "checkCode": verCode}, function (res) {
            if(res.code == 1){
                parent.layer.alert("修改成功", {icon:1});
            }else{
                layer.alert(res.data, {icon: 5});
            }
        });
    });

    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.$;
        form.on('submit(validCheck)', function (data) {
            ajax("/valid/getSubject", data.field, function (data) {
                if(data.code == 1){//说明验证成功，可以进行密码修改
                    $('#validCheck').hide();
                    $('#changePassword').show();
                    $("#code").val(data.data); //得到令牌，用于密码修改验证
                }else{
                    layer.alert(data.data, {icon: 5});
                }
            });
        });

        form.on('submit(repassword)', function(res){
            ajax("/valid/rePassChange", res.field, function(data){
                if(data.code == 1){
                    layer.alert("修改成功", {icon: 5});
                    window.location = "/pages/login.html";
                }else{
                    layer.alert(data.data, {icon: 5});
                }
            });
        });
    });


});