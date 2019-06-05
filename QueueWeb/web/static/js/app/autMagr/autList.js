/**
 * Created by liusong on 2018/4/17.
 */
$(function () {

    layui.use(["table", 'form', 'element'], function () {
        var element = layui.element;

        element.on('tab(authorSearch)', function () {
            var cols = [
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
            ];
            loadDT('.authorInfo', '/authority/search', cols)
        });

        element.on('tab(userAuthor)', function (elem) {

        });

        element.on('tab(roleAuthor)', function (elem) {

        });

        element.on('tab(publicAuthor)', function (elem) {

        });

        var table = layui.table;

        function loadDT(id, url, cols) {
            //加载表格数据
            table.render({
                elem:id,
                height:275,
                url:url,
                method:'POST',
                where:{type:"", status:""},
                request:{
                    pageName:'page.pageNo',
                    limitName:'page.pageSize'
                },
                response:{
                    statusCode:'1'//返回状态码 1成功，0失败
                },
                cols:[cols],
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
        }

        function reLoad(id, param){
            table.reload(id, {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        //表单
        var form = layui.form;
        form.on('submit(search)', function (data) {
            reLoad('.authorInfo', data.field)
        });
    });
});