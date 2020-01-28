/**
 * Created by liusong on 2019/4/24.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function () {
    layui.use(["table", 'form'], function () {

        var table = layui.table;
        //加载表格数据
        table.render({
            elem:'#prmsBase',
            height:275,
            url:'/permissions/getBaseId',
            method:'POST',
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'
            },
            cols:[[
                {fixed: 'right', field: 'id', title: '选择', width:60, align:'center', toolbar: '#select'},
                {field: 'name', title: '名称', width:120},
                {field: 'parentName', title: '上级名称', width:80},
                {field: 'pmsLevel', title: '级别', width:80},
                {field: 'describeInf', title: '描述', width:180}
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
                first:false,//不显示首页
                last:false,//不显示尾页
                groups:5,//显示连续多少个页码
                limits:[5],
                limit:5
            }
        });

        var form = layui.form;
        form.on('submit(search)', function (data) {
            reLoad(data.field);
        });

        /**
         * 重新加载
         * @param table
         * @param data
         */
        function reLoad(param) {
            table.reload('prmsBase', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        table.on('row(rowClick)', function(obj){
            var data = obj.data;
            window.parent.setBaseId(data.id, data.name);//调用父页面方法
            parent.layer.close(index);
        });
        //操作结束
    });
});