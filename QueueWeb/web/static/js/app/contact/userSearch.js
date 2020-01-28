/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function () {

    layui.use(["table", 'laydate', 'form'], function () {

        var table = layui.table;
        //加载表格数据
        table.render({
            elem:'#showUser',
            height:275,
            url:'/director/search',
            method:'POST',
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'
            },
            cols:[[
                {field: 'sign', title: '标记', width:80, templet:function(d){
                    if(d.sign == 1) return '亲友';
                    else if(d.sign == 2) return '好友';
                    else if(d.sign == 3) return '客户';
                    else if(d.sign == 4) return '供应商';
                    else return '';
                }},
                {field: 'name', title: '姓名', width:100},
                {field: 'sex', title: '性别', width:80, templet:function(d){
                    if(d.sex == 'female') return '女';
                    else return '男';
                }},
                {field: 'birthday', title: '出生年月', width:140, templet:function(d){
                    return parseDate(d.birthday);
                }},
                {field: 'phone', title: '手机号', width:140},
                {field: 'id', hide:true}
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
            table.reload('showUser', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        var data = layui.laydate;
        data.render({
            elem:'#startTime'
        });
        data.render({
            elem:'#endTime'
        });

        // table.on('tool(userClick)', function(obj){
        //     var data = obj.data;
        //     if(obj.event === 'enter'){//查看
        //         window.parent.setUserInfo(data.id, data.name);//调用父页面方法
        //         parent.layer.close(index);
        //     }
        // });

        table.on('row(userClick)', function(obj){
            //标注选中样式
            // obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
            var data = obj.data;
            window.parent.setUserInfo(data.id, data.name);//调用父页面方法
            parent.layer.close(index);
        });
        //操作结束
    });
});

