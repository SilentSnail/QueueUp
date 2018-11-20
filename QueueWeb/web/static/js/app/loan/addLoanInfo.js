/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function () {
    layui.use(['laydate', 'form'], function () {
        var userId = urlParam('userId', window.location.href);
        $("#userId").val(userId);
        //日期
        var data = layui.laydate;
        data.render({
            elem:'#loanTime',
            value: new Date()
        });
        data.render({
            elem:'#repaymentTime'
        });

        //表单
        var form = layui.form;

        //类型选择
        form.on('switch(loanType)', function (data) {
            if(this.checked){
                $('input[name="loanType"]').val(1);
            }else {
                $('input[name="loanType"]').val(0);
            }
        });

        //有无借据
        form.on('switch(isIou)', function (data) {
            if(this.checked){
                $('input[name="isIou"]').val(1);
            }else {
                $('input[name="isIou"]').val(0);
            }
        });

        form.render();
        form.on('submit(commit)', function (data) {
            var hidder = layer.load(1, {shade: [0.5,'#000']});
            console.log(data.field);
            ajax('/loan/save', data.field, function (res) {
                layer.close(hidder);
                if(res.code == 1){
                    parent.layer.msg('保存成功');
                    parent.layer.close(index);
                } else {
                    parent.layer.msg('保存失败');
                }
            })
        });

        $('.layui-btn-primary').click(function () {
            parent.layer.close(index);
        })
    })
});