/**
 * Created by liusong on 2018/4/17.
 */
$(function () {

    layui.use(["table", 'laydate', 'form'], function () {

        var layer = layui.layer;

        var table = layui.table;
        //加载表格数据
        table.render({
            elem:'#pmsList',
            height:472,
            url:'/permissions/list',
            method:'POST',
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'//返回状态码 1成功，0失败
            },
            cols:[[
                {field: 'name', title: '资源名称', width:90},
                {field: 'url', title: '资源路径', width:180},
                {field: 'parentId', title: '上级编号', width:90},
                {field: 'createTime', title: '创建时间', width:120, templet:function(d){
                        return parseDateTime(d.createTime);
                    }},
                {field: 'creator', title: '创建人', width:90},
                {field: 'reviser', title: '更新人', width:90},
                {field: 'describeInf', title: '描述', width:240},
                {fixed: 'right', field: 'code', title: '操作', width:95, align:'center', toolbar: '#editHtml'}
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
                groups:5,
                limits:[5, 10, 15, 20, 50],
                limit:10
            }
        });

        var form = layui.form;
        form.on('submit(search)', function (data) {
            reLoad(data.field)
        });

        function reLoad(param) {
            table.reload('pmsList', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        $(document).on('click', '#addButton', function () {
            parent.layer.open({
                type: 2,
                title:'新增资源',
                area: ['650px', '450px'],
                fixed: false, //不固定
                maxmin: true,
                content: '/pages/settings/editPage/editPermission.html',
                end: function(){
                    reLoad({});
                }
            });
        });

        //tool(pmsList) 修改pmsList即可
        table.on('tool(pmsList)', function(obj){
            var data = obj.data;
            if(obj.event === 'remove'){//删除
                ajax('/permissions/delByCode', {'code':data.code}, function (data) {
                    if(data.code == 1){
                        layer.msg("成功");
                        reLoad({});
                    }else {
                        layer.msg("失败，错误原因："+ data.msg);
                    }
                })
            } else if(obj.event === 'change'){//编辑
                parent.layer.open({
                    type: 2,
                    title:'编辑资源',
                    area: ['650px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '/pages/settings/editPage/editPermission.html',
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
        //操作结束
    });

});