/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

//方法必须写在外面，写在里面调不到
function setUserInfo(id, name) {
    $(".userName").val(name);
    $("#userId").val(id);
}

$(function () {

    layui.use(['laydate', 'form', 'upload'], function () {
        var userCode = urlParam('userId', window.location.href);
        var type = urlParam('type', window.location.href);
        if('1' == type){
            $('input[name="loanType"]').val(1);
            $('input[lay-filter="loanType"]').attr("checked", true);//设置选中
        }
        if(userCode){
            ajax("/director/findInfo", {"code":userCode}, function (data) {
                $(".userName").val(data.data.name).attr("readonly", "readonly");//传过来的值 设置只读
                $("#userId").val(data.data.id);
                $(".searchUser").addClass("layui-btn-disabled").unbind();
            })
        }
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
        form.on('switch(loanType)', function () {
            if(this.checked){
                $('input[name="loanType"]').val(1);
            }else {
                $('input[name="loanType"]').val(0);
            }
        });

        //有无借据
        form.on('switch(isIou)', function () {
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
            ajax('/loan/save', json, function (res) {
                layer.close(hidder);
                if(res.code == 1){
                    parent.layer.msg('保存成功');
                    parent.layer.close(index);
                } else {
                    parent.layer.msg('保存失败');
                }
            })
        });

        $(".searchUser").click(function () {
            layer.open({
                type: 2,
                title:'借款人查询',
                area: ['556px', '407px'],
                fixed: true, //不固定
                maxmin: false,
                content: '/pages/contact/userSearch.html',
                success: function () {

                }
            });
        });

        $('.exit').click(function () {
            parent.layer.close(index);
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
                console.log(res);
            },
            error:function (err) {
                console.log(err);
            }
        });
    });
});