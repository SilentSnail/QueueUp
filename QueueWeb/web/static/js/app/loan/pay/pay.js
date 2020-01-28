/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    layui.use(['laydate', 'form', 'upload'], function () {
        //日期
        var data = layui.laydate;
        data.render({
            elem:'#payTime',
            value: new Date()
        });

        //表单
        var form = layui.form;

        //有无借据
        form.on('switch(hasInvoice)', function () {
            if(this.checked){
                $('input[name="hasInvoice"]').val(1);
                $("#upload").show();
            }else {
                $('input[name="hasInvoice"]').val(0);
                $('input[name="files"]').val("");
                $("#upload").hide();
            }
        });

        ajax("/pay/getItem", {"parentCode":"d039cbb915a7495fab626d58dc3b12e5"}, function (data) {
            if(data.code == 1){
                var dt = data.data;
                $.each(dt, function (index, item) {
                    $('select[name="payType"]').append('<option value="'+item.code+'">'+item.name+'</option>');
                });
                form.render();
            }
        });

        ajax("/pay/getItem", {"parentCode":"ce0de96cfd364c91b1f0e4eea67adb2c"}, function (data) {
            if(data.code == 1){
                var dt = data.data;
                $.each(dt, function (index, item) {
                    $('select[name="payStatus"]').append('<option value="'+item.code+'">'+item.name+'</option>');
                });
                form.render();
            }
        });

        form.render();
        form.on('submit(commit)', function (data) {
            console.log(data.field);
        });

        //文件上传块
        var upload = layui.upload;

        upload.render({
            elem: '#upload',//容器选择器
            url:'/common/upload',//文件上传URL
            accept: 'images',//允许上传的文件类型
            acceptMime: 'image/*',//筛选文件类型
            size: 5120,//单位KB
            field:'file',
            done: function (res) {
                if(res.code == 1){
                    $('input[name="files"]').val($('input[name="files"]').val() + res.data + ",");
                }
            },
            error:function (err) {
                console.log(err);
            }
        });
    })
});