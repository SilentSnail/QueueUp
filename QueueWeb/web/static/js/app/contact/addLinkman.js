/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function () {

    layui.use(["table", 'laydate', 'form'], function () {
        var form = layui.form;
        form.on('submit(commit)', function (data) {
            var hidder = layer.load(1, {shade: [0.5,'#000']});
            ajax('/director/save', data.field, function (res) {
                layer.close(hidder);
                if(res.code == 1){
                    parent.layer.msg('保存成功');
                    parent.layer.close(index);
                } else {
                    parent.layer.msg('保存失败');
                }
            });
        });

        var data = layui.laydate;
        data.render({
            elem:'#birthday'
        });

        $('.layui-btn-primary').click(function () {
            parent.layer.close(index);
        })
    });
});

