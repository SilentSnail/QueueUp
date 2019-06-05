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
        elem:'#repaymentTime'
    });

    //表单
    form = layui.form;

    //有无借据
    form.on('switch(isIou)', function (data) {
        if(this.checked){
            $('input[name="isIou"]').val(1);
            $("#upload").show();
        }else {
            $('input[name="isIou"]').val(0);
            $("#upload").hide();
        }
    });

    form.render();
    form.on('submit(commit)', function (data) {
        var hidder = layer.load(1, {shade: [0.5,'#000']});
        var json = data.field;
        ajax('/loan/update', json, function (res) {
            layer.close(hidder);
            if(res.data){
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
    if(code){
        ajax('/loan/findByCode', {code:code}, function (res) {
            var data = res.data;
            if(res.code == "1"){
                form.render();//form需要重新渲染
                data = data[0];
                // $('select[name="loanChannel"]').val(data.loanChannel).attr("disabled", "disabled");
                $('select[name="loanChannel"]').val(data.loanChannel);
                $('input[name="amount"]').val(data.amount);
                $('input[name="loanTime"]').val(data.loanTime);
                $('input[name="repaymentTime"]').val(data.repaymentTime);
                $('textarea[name="remark"]').text(data.remark);
                $('input[name="code"]').val(data.code);
                //选中
                if(data.loanType == 1){
                    $('input[name="loanType"]').val(data.loanType);
                    $('input[lay-filter="loanType"]').attr("checked", true);//设置选中
                }
                //不允许修改单据类型
                $('input[lay-filter="loanType"]').attr("disabled", "disabled");
                if(data.isIou == 1){
                    $('input[name="isIou"]').val(data.isIou);
                    $('input[lay-filter="isIou"]').attr("checked", true);
                    //如果有附件
                    $('input[lay-filter="isIou"]').attr("disabled", "disabled");
                }
                form.render();
            }
        });
    }
};