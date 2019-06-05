/**
 * Created by liusong on 2018/4/17.
 */
// var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var userId;

$(function () {

    layui.use(['table'], function () {

        loadDT();

        var table = layui.table;

        //加载借款数据
        function loadInfo(){
            //加载表格数据
            table.render({
                elem:'#loanInfoList',
                height:275,
                url:'/loan/findByCode',
                method:'POST',
                where:{userId:userId},
                request:{
                    pageName:'page.pageNo',
                    limitName:'page.pageSize'
                },
                response:{
                    statusCode:'1'
                },
                cols:[[
                    {field: 'loanType', title: '标记', width:60, templet:function(d){
                            if(d.loanType == 0) return '借出';
                            else if(d.loanType == 1) return '收款';
                            else return '无效';
                        }},
                    {field: 'loanTime', title: '日期', width:120, templet:function(d){
                            return parseDate(d.loanTime);
                        }},
                    {field: 'loanChannel', title: '途径', width:80, templet:function (d) {
                            if(d.loanChannel == 0) return '其他';
                            else if(d.loanChannel == 1) return '现金';
                            else if(d.loanChannel == 2) return '支付宝';
                            else if(d.loanChannel == 3) return '微信';
                            else if(d.loanChannel == 4) return '转账';
                            else return '未知';
                        }},
                    {field: 'amount', title: '金额', width:120},
                    {field: 'remark', title: '备注', width:360},
                    {fixed: 'right', field: 'code', title: '操作', width:80, align:'center', toolbar: '#select'}
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
        }

        function reLoad(param) {
            table.reload('loanInfoList', {
                where:param,
                page:{
                    curr:1
                }
            });
        }

        reLoad({'userId':userId})

        function showData(data) {
            $("#info_name").text(data.name);
            var sex = "男";
            if(data.sex == "female"){
                sex = "女";
            }
            $("#info_sex").text(sex);
            $("#info_age").text(data.age);
            $("#info_birthday").text(data.birthday);
            $("#info_idCard").text(data.idCard);
            $("#info_address").text(data.address);
            $("#info_phone").text(data.phone);
            $("#info_qqNo").text(data.qqNo);
            $("#info_wxNo").text(data.weChat);
            $("#info_remark").text(data.remark);
            loadInfo();
        }

        function loadDT() {
            var id = urlParam('code', window.location.href);
            ajax('/director/findByCode', {code:id}, function (res) {
                var data = res.direInfo;
                userId = data.id;
                showData(data);
                if(res.amount > 0){
                    $("#loan_Info").text("欠款：" + res.amount + "元");
                }else if(res.amount < 0){
                    $("#loan_Info").text("当前已借出：" + Math.abs(res.amount));
                }else{
                    $("#loan_Info").text("");
                }
            });
        }
    });
});
