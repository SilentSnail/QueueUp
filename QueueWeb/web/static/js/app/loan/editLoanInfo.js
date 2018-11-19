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
        elem:'#loadTime'
    });
    data.render({
        elem:'#repaymentTime'
    });

    //表单
    form = layui.form;
    form.render();
    form.on('submit(commit)', function (data) {
        //加载遮罩
        var hidder = layer.load(1, {shade: [0.5,'#000']});
        ajax('/loan/save', data.field, function (res) {
            layer.close(hidder);
            if(res.code == 1){
                if(res.data){
                    status = 1;
                }
            }
            if(status == 1){
                parent.layer.msg('保存成功');
                parent.layer
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

function loadDT(id) {
    if(id)(
        ajax('/loan/find', {id:id}, function (res) {
            var data = res.data;
            if(res.code == "1"){
                form.render('select');//不知道为嘛得先加一个这个后面的才会生效，不加这个不行
                $('select[name="loanType"]').val(data.loanType);
                $('select[name="isIou"]').val(data.isIou);
                $('input[name="loadName"]').val(data.loadName);
                $('input[name="amount"]').val(data.amount);
                $('input[name="idCard"]').val(data.idCard);
                $('input[name="phone"]').val(data.phone);
                $('input[name="loadTime"]').val(data.loadTime);
                $('input[name="repaymentTime"]').val(data.repaymentTime);
                $('textarea[name="remark"]').text(data.remark);
                $('input[name="code"]').val(data.code);
                $('input[name="id"]').val(data.id);
                $('input[name="actualRepaymentTime"]').val(data.actualRepaymentTime);
                $('input[name="status"]').val(data.status);
                form.render('select');
            }
        })
    )

}