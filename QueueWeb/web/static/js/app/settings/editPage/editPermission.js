/**
 * Created by liusong on 2019/4/24.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var url;

function loadDT(code){
    ajax('/permissions/searchByCode', {'code': code}, function (data) {
        if(data.code == 1){
            url = '/permissions/changeInfo';
            var pms = data.data;
            $('input[name="name"]').val(pms.name);
            $('input[name="parentCode"]').val(pms.parentId);
            $('input[name="url"]').val(pms.url);
            $('textarea[name="describeInf"]').val(pms.describeInf);
            $('input[name="iconSign"]').val(pms.iconSign);
            $('input[name="code"]').val(pms.code);
            $('.parentName').val(pms.baseName);
        } else {
            parent.layer.msg(data.msg);
            parent.layer.close(index);
        }
    })
}

function setBaseId(id, name){
    $('input[name="parentCode"]').val(id);
    $('.parentName').val(name);
}

$(function () {


    url = '/permissions/save';

    layui.use(['form'], function () {
        var form = layui.form;

        form.verify({
            permissionCheck:[/\s*|(\/[^\s]+)+/,"资源格式不正确"]
        });

        form.on('submit(commit)', function (data) {
            var hidder = layer.load(1, {shade: [0.5,'#000']});
            ajax(url, data.field, function (res) {
                layer.close(hidder);
                if(res.code == 1){
                    parent.layer.msg('保存成功');
                    parent.layer.close(index);
                } else {
                    parent.layer.msg('保存失败');
                }
            })
        });

        $(document).on('click', '#search', function () {
            layer.open({
                type: 2,
                title:'父资源查询',
                area: ['556px', '407px'],
                fixed: true, //不固定
                maxmin: false,
                content: '/pages/settings/editPage/basePrmsSearch.html',
                success: function () {

                }
            });
        });

        $(document).on('click', '.exit', function () {
            parent.layer.close(index);
        });
    });

});