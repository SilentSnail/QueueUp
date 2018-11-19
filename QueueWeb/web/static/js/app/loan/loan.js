/**
 * Created by liusong on 2018/4/17.
 */
$(function () {

    layui.use(["table", 'laydate', 'form'], function () {
        var table = layui.table;
        //加载表格数据
        table.render({
            elem:'#showLoanList',
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
                {field: 'loanType', title: '类型', width:60, templet:function(d){
                    if(d.loanType == 1) return '借出'; else return '借入';
                }},
                {field: 'name', title: '姓名', width:80},
                {field: 'sex', title: '性别', width:80, templet:function(d){
                    if(d.sex == 'female') return '女';
                    else return '男';
                }},
                {field: 'phone', title: '手机号', width:140},
                {field: 'amount', title: '金额', width:120},
                {field: 'address', title: '联系地址', width:180},
                {fixed: 'right', field: 'id', title: '操作', width:115, align:'center', toolbar: '#toolHtml'}
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
            if(obj.event === 'detail'){//查看
                parent.layer.open({
                    type: 2,
                    title:'查看借款',
                    area: ['660px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '/pages/loan/loan_detail.html',
                    success:function(layero, index){//调用子页面的方法
                        $(layero).find('iframe')[0].contentWindow.loadDT(data.id);
                    }
                });
            } else if(obj.event === 'change'){//编辑
                parent.layer.open({
                    type: 2,
                    title:'修改借款',
                    area: ['660px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '/pages/loan/editLoanInfo.html',
                    success:function(layero, index){
                        //调用子页面的方法
                        $(layero).find('iframe')[0].contentWindow.loadDT(data.id);
                    }
                });
            }
        });
    });
    //@Angry_Snail
});