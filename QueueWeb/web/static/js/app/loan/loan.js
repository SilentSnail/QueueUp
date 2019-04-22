/**
 * Created by liusong on 2018/4/17.
 */
$(function () {

    layui.use(["table", 'laydate', 'form'], function () {
        var table = layui.table;
        //加载表格数据
        table.render({
            elem:'#showLoanList',
            height:275,
            url:'/loan/list',
            method:'POST',
            where:{type:"", status:""},
            request:{
                pageName:'page.pageNo',
                limitName:'page.pageSize'
            },
            response:{
                statusCode:'1'
            },
            cols:[[
                {field: 'name', title: '姓名', width:80},
                {field: 'sex', title: '性别', width:80, templet:function(d){
                    if(d.sex == 'female') return '女';
                    else return '男';
                }},
                {field: 'idCard', title: '身份证号', width:180},
                {field: 'loanType', title: '类型', width:80, templet:function(d){
                    if(d.loanType == 1) return '借款';
                    if(d.loanType == 0) return '已两清';
                    else return '借出';
                }},
                {field: 'phone', title: '手机号', width:120},
                {field: 'amount', title: '金额', width:120},
                {field: 'address', title: '联系地址', width:240},
                {fixed: 'right', field: 'code', title: '操作', width:95, align:'center', toolbar: '#toolHtml'}
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
                limits:[5, 10, 20, 50],
                limit:5
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
            reLoad(data.field)
        });

        function reLoad(param){
            table.reload('showLoanList', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        $('.addLoan').click(function () {
            parent.layer.open({
                type: 2,
                title:'借款/还款',
                area: ['660px', '500px'],
                fixed: false, //不固定
                maxmin: true,
                content: '/pages/loan/addLoanInfo.html',
                success:function(layero, index){

                }
            });
        });

        table.on('tool(loanData)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){//修改
                // parent.layer.open({
                //     type: 2,
                //     title:'修改借款',
                //     area: ['660px', '500px'],
                //     fixed: false, //不固定
                //     maxmin: true,
                //     content: '/pages/loan/editLoanInfo.html',
                //     success:function(layero, index){//调用子页面的方法
                //         $(layero).find('iframe')[0].contentWindow.loadDT(data.code);
                //     }
                // });
                window.parent.addItem('/pages/contact/linkmanDetail.html?code='+data.code, data.name+'详情');
            } else if(obj.event === 'repay'){//还款
                parent.layer.open({
                    type: 2,
                    title:'还款',
                    area: ['660px', '500px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '/pages/loan/addLoanInfo.html?type=1&userId=' + data.code
                });
            }
        });
    });
});