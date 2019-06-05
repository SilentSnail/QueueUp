/**
 * Created by liusong on 2018/4/17.
 */
$(function () {

    $("#checkCode").click(function () {
        console.log("刷新验证码");
        this.src = "";
        this.src = "/valid/loginCheckCode?t=" + Math.random();
    });

    layui.use('form', function () {
        var form = layui.form;
        form.on('submit(submit)', function(res){
            var msg = layer.msg('正在登陆...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000});
            ajax("/valid/login", res.field, function (data) {
                layer.close(msg);
                if(data.code == 1){
                    window.location = "/pages/admin/admin.html";
                }else{
                    layer.alert(data.data, {icon: 5});
                }
            });
        });

        /**
         * 复杂方式
         * @param event
         */
        document.onkeydown = function (event) {
            var v = event || window.event || arguments.callee.caller.arguments[0];
            if(v && v.keyCode == 13){
                $('#login').click();
            }
        };
    });
});