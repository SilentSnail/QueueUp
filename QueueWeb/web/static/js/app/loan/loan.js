/**
 * Created by liusong on 2018/4/17.
 */
$(function () {

    layui.use(["table", 'laydate', 'form'], function () {
        var table = layui.table;
        //加载表格数据
        table.render({
            elem:'#showLoanList',
            width:1705,
            height:472,
            url:'/loan/list',
            method:'POST',
            where:{type:1, status:1},
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'
            },
            cols:[[
                {fixed: 'left', field: 'id', title: '操作', width:115, align:'center', toolbar: '#toolHtml'},
                {field: 'id', title: 'ID', fixed: 'left', width:60},
                {field: 'loanType', title: '类型', fixed: 'left', width:60, templet:function(d){
                    if(d.loanType == 1) return '借出'; else return '借入';
                }},
                {field: 'loadName', title: '姓名', fixed: 'left', width:80},
                {field: 'idCard', title: '身份证号', fixed: 'left', width:180},
                {field: 'phone', title: '手机号', fixed: 'left', width:140},
                {field: 'amount', title: '金额', fixed: 'left', width:120},
                {field: 'loadTime', title: '借款时间', fixed: 'left', width:180},
                {field: 'repaymentTime', title: '还款时间', fixed: 'left', width:180},
                {field: 'status', title: '状态', fixed: 'left', width:80, templet:function(d){
                    if(d.status == '1') return "有效";
                    else if(d.status == '0') return '无效';
                    else if(d.status == '-1') return '删除';
                }},
                {field: 'isIou', title: '借据', fixed: 'left', width:80, templet:function(d){
                    if(d.isIou == 0) return '无'; else return '有';
                }},
                {field: 'actualRepaymentTime', title: '最终还款时间', fixed: 'left', width:180},
                {field: 'remark', title: '备注', fixed: 'left', width:240}
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

        //日期
        var data = layui.laydate;
        data.render({
            elem:'#startTime'
        });
        data.render({
            elem:'#endTime'
        });

        //表单
        var form = layui.form;
        form.on('submit(search)', function (data) {
            table.reload('showLoanList', {
                where:data.field,
                page:{
                    curr:1
                }
            });
        });

        table.on('tool(loanData)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    ajax('/loan/remove', {id:data.id}, function (res) {
                        layer.close(index);
                        table.reload('showLoanList', {
                            page:{
                                curr:1
                            }
                        });
                    });
                });
            }
        });
    });
    //@Angry_Snail
});