/**
 * Created by liusong on 2018/4/17.
 */

function setParentInfo(parentCode, parentName, parentLevel){
    $("#parentId").val(parentCode);
    $(".parentName").val(parentName);
    $(".typeLevel").val(parentLevel+1);
}

$(function () {

    layui.use(["table", 'form'], function () {

        var table = layui.table;
        table.render({
            elem:'#showForageInfo',
            height:275,
            url:'/forageType/find',
            method:'POST',
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'//返回状态码 1成功，0失败
            },
            cols:[[
                {fixed: 'left', field: 'code', title: '操作', width:110, align:'center', toolbar: '#editHtml'},
                {field: 'forageName', title: '名称', width:140},
                {field: 'parentName', title: '上级名称', width:140},
                {field: 'status', title: '状态', width:80, templet:function(d){
                        if(d.status == 1) return '有效';
                        else return '无效';
                    }},
                {field: 'createTime', title: '创建时间', width:120, templet:function(d){
                        return parseDate(d.createTime);
                    }},
                {field: 'creator', title: '创建人', width:90},
                {field: 'updateTime', title: '更新时间', width:120, templet:function(d){
                        return parseDate(d.updateTime);
                    }},
                {field: 'updator', title: '更新人', width:90},
                {field: 'typeLevel', title: '级别', width:100}
            ]],
            parseData:function (res) {
                return {
                    "code": res.code, //解析接口状态
                    "msg": res.data, //解析提示文本
                    "count": res.page.totalCount, //解析数据长度
                    "data": res.page.list //解析数据列表
                }
            },
            page: {
                prev:'上一页',
                next:'下一页',
                first:'首页',
                last:'尾页',
                groups:3,
                limits:[5, 10, 15, 20, 50],
                limit:5
            }
        });

        function reLoad(param){
            table.reload('showForageInfo', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        var form = layui.form;
        form.on('submit(search)', function (data) {
            reLoad(data.field);
            // return false;//阻止表单跳转
        });

        var addForm = layui.form;
        addForm.on('submit(commit)', function (data) {
            var msg = layer.msg('正在添加...', {icon: 16,shade: [0.5, '#f5f5f5'],scrollbar: false,offset: '0px', time:100000});
            ajax('/forageType/add', data.field, function (data) {
                layer.close(msg);
                if(data.code == 1){
                    layer.alert("添加成功");
                    resetAdd();
                    reLoad({});
                }else{
                    layer.alert(data.msg);
                }
            })
        });

        $('.searchParent').click(function () {
            // var level = $('input[name="typeLevel"]').val();
            // if("" == level){
            //     layer.alert("请先输入种类级别", {icon:5});
            //     return;
            // }
            var level = "";
            parent.layer.open({
                type: 2,
                title:'种类查询',
                area: ['515px', '410px'],
                fixed: false, //不固定
                maxmin: false,
                content: '/pages/forage/edit/forageBaseSearch.html?level='+ level,
                success:function(page, index){
                    //调用子页面的方法
                    $(page).find('iframe')[0].contentWindow.type = "typeMag";
                }
            });
        });

        table.on('tool(forageFilter)', function(obj){
            var data = obj.data;
            if(obj.event === 'del') {//删除
                ajax('/forageType/delByCode', {"code": data.code}, function(data){
                    if(data.code == 1){
                        layer.alert("删除成功", {icon: 1});
                        reLoad({});
                    }else{
                        layer.alert(data.msg);
                    }
                });
            }else if(obj.event === 'change'){
                parent.layer.open({
                    type: 2,
                    title:'编辑信息',
                    area: ['460px', '350px'],
                    fixed: false, //不固定
                    maxmin: false,
                    content: '/pages/forage/edit/forageEdit.html',
                    success:function(page, index){
                        //调用子页面的方法
                        $(page).find('iframe')[0].contentWindow.loadDT(data.code);
                    },
                    end: function(){
                        reLoad({});
                    }
                });
            }
        });
    });
});

function resetAdd() {
    $('input[name="forageName"]').val("");
    $('input[name="typeLevel"]').val("0");
    $('#parentId').val("");
    $('.parentName').val("");
}

