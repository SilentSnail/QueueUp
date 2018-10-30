/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    layui.use(['laydate', 'form'], function () {
        //日期
        var data = layui.laydate;
        data.render({
            elem:'#payTime',
            type:'datetime'
        });

        //表单
        var form = layui.form;
        form.render();
        form.on('submit(commit)', function (data) {
            console.log(data.field);
        });
    })
});