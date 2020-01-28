/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var form;
function setParentInfo(parentCode, parentName, parentLevel){
    $("#parentId").val(parentCode);
    $(".parentName").val(parentName);
    $('input[name="typeLevel"]').val(parentLevel+1);
}

$(function () {

    layui.use('form', function () {
        form = layui.form;
        form.on('submit(commit)', function (data) {
            ajax('/forageType/change', data.field, function (data) {
                if(data.code == 1){
                    parent.layer.alert("修改成功", {icon: 1});
                    parent.layer.close(index);
                }else {
                    parent.layer.alert(data.msg, {icon: 5});
                }
            })
        });

        $('.searchParent').click(function () {
            var code = $("#code").val();
            var level = $('input[name="typeLevel"]').val();
            parent.layer.open({
                type: 2,
                title:'种类查询',
                area: ['515px', '410px'],
                fixed: false, //不固定
                maxmin: false,
                content: '/pages/forage/edit/forageBaseSearch.html?code='+code+'&level='+level,
                success:function(page, index){
                    //调用子页面的方法
                    $(page).find('iframe')[0].contentWindow.type = "edit";
                }
            });
        });
    })
});

function loadDT(code){
    ajax('/forageType/getByCode', {"code":code}, function (data) {
        if(data.code == 1){
            var dt = $.parseJSON(data.data);
            $('input[name="name"]').val(dt.name);
            $('select[name="status"]').val(dt.status);
            $('input[name="parentName"]').val(dt.parentName);
            $("#parentId").val(dt.parentCode);
            $('#code').val(code);
            $('input[name="typeLevel"]').val(dt.typeLevel);
            form.render();
        }
    });
}

