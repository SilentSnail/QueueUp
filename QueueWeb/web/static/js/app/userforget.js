/**
 * Created by liusong on 2018/6/23.
 */
$(function() {

    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.$;
        form.on('submit(validCheck)', function (data) {
            $('#validCheck').hide();
            $('#changePassword').show();
            // ajax("/valid/rePassword", {"username":val}, function (data) {
            //     if(data.code == 500){
            //         showMessage(data.data)
            //     }
            // });
            console.log(data.field);
        });

        form.on('submit(repassword)', function(res){
            console.log(res.field);
            // ajax("/valid/register", $('#sky-form').serialize(), function(data){
            //     if(data.code == 1){
            //         showMessage("注册成功");
            //         window.location = "/pages/login.html";
            //     }else{
            //         showMessage(data.data);
            //     }
            // });
        });
    });
});