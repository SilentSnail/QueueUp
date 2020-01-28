/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var type;
$(function () {

    layui.use(['table', 'form'], function () {
        var code = urlParam('code', window.location.href);
        var level = urlParam('level', window.location.href);
        var table = layui.table;
        table.render({
            elem:'#parentList',
            height:275,
            where:{"code":code, "typeLevel": level},
            url:'/forageType/find',
            method:'POST',
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'
            },
            cols:[[
                {field: 'forageName', title: '名称', width:100},
                {field: 'status', title: '状态', width:80, templet:function(d){
                        if(d.status == 1) return '有效';
                        else return '无效';
                    }},
                {field: 'createTime', title: '创建时间', width:120, templet:function(d){
                        return parseDate(d.createTime);
                    }},
                {field: 'creator', title: '创建人', width:80},
                {field: 'typeLevel', title: '分类级别', width:100},
                {field: 'code', hide:true}
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
            table.reload('parentList', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        table.on('row(parentClick)', function(obj){
            var data = obj.data;
            for (let i = 0; i < window.parent.length; i++) {
                var href = window.parent[i].location.href
                if(type == "typeMag" & href.indexOf("forageTypeMag.html") > 0){
                    window.parent[i].setParentInfo(data.code, data.forageName, data.typeLevel);
                }else if(type == "edit" & href.indexOf("forageEdit.html") > 0){
                    window.parent[i].setParentInfo(data.code, data.forageName, data.typeLevel);
                }
            }
            parent.layer.close(index);
            //标注选中样式
            // obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });
    })
});

