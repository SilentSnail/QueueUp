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
                {field: 'sign', title: '标记', width:60, templet:function(d){
                    if(d.sign == 1) return '亲友';
                    else if(d.sign == 2) return '好友';
                    else if(d.sign == 3) return '客户';
                    else if(d.sign == 4) return '供应商';
                    else return '';
                }},
                {field: 'name', title: '姓名', width:80},
                {field: 'sex', title: '性别', width:80, templet:function(d){
                    if(d.sex == 'female') return '女';
                    else return '男';
                }},
                {field: 'birthday', title: '出生年月', width:120, templet:function(d){
                    return parseDate(d.birthday);
                }},
                {field: 'phone', title: '手机号', width:120},
                {field: 'email', title: '邮箱', width:120},
                {field: 'address', title: '地址', width:300},
                {fixed: 'right', field: 'id', title: '操作', width:115, align:'center', toolbar: '#editHtml'}
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
            table.reload('showLoanList', {
                where:data.field,
                page:{
                    curr:1
                }
            });
        });

        table.on('tool(linkMan)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){//查看
                //调用父页面方法
                window.parent.addItem('/pages/contact/linkmanDetail.html?id='+data.id, data.name+'详情');
            } else if(obj.event === 'change'){//编辑
                parent.layer.open({
                    type: 2,
                    title:'编辑',
                    area: ['660px', '450px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '/pages/contact/editLinkman.html',
                    success:function(page, index){
                        //调用子页面的方法
                        $(page).find('iframe')[0].contentWindow.loadDT(data.id);
                    }
                });
            }
        });
        //操作结束
    });

});