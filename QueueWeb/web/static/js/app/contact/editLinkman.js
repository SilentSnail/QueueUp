/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var form;
//依据ID加载数据
layui.use(['laydate', 'form'], function () {
    //日期
    var data = layui.laydate;
    data.render({
        elem:'#birthday'
    });

    //表单
    form = layui.form;
    form.render();
    form.on('submit(commit)', function (data) {
        var hidder = layer.load(1, {shade: [0.5,'#000']});
        ajax('/director/update', data.field, function (res) {
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
});

function loadDT(code) {
    if(code)(
        ajax('/director/findInfo', {code:code}, function (res) {
            var data = res.data;
            if(res.code == "1"){
                form.render('select');//不知道为嘛得先加一个这个后面的才会生效，不加这个不行
                $('input[name="name"]').val(data.name);
                $('input[name="birthday"]').val(data.birthday).attr("disabled", "disabled");
                $('select[name="sign"]').val(data.sign);
                $('select[name="sex"]').val(data.sex).attr("disabled", "disabled");
                $('input[name="idCard"]').val(data.idCard);
                $('input[name="phone"]').val(data.phone);
                $('input[name="email"]').val(data.email);
                $('input[name="qqNo"]').val(data.qqNo);
                $('input[name="weChat"]').val(data.weChat);
                $('input[name="address"]').val(data.address);
                $('input[name="userCode"]').val(data.userCode);
                $('textarea[name="remark"]').text(data.remark);
                form.render('select');
            }
        })
    )

}