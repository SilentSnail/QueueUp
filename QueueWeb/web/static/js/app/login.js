/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    layui.use('form', function () {
        var form = layui.form;
        form.on('submit(submit)', function(res){
            var msg = layer.msg('正在登陆...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000});
            ajax("/valid/login", res.field, function (data) {
                layer.close(msg);
                if(data.code == 1){
                    window.location = "/pages/admin/admin.html";
                }else{
                    layer.alert('用户名或密码错误', {icon: 5});
                }
            });
        });
    })
});