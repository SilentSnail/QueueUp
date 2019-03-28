/**
 * Created by liusong on 2018/4/17.
 */
// var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
var userId;

$(function () {
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
    loadDT();

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
    }

    $('#addLoan').click(function () {
        if(userId == undefined){
            parent.layer.alert("未获取到用户信息", {icon:2});
            return;
        } else {
            parent.layer.open({
                type: 2,
                title:'新增借款',
                area: ['660px', '500px'],
                fixed: false, //不固定
                maxmin: true,
                content: '/pages/loan/addLoanInfo.html?userId='+userId,
                success:function(layero, index){

                }
            });
        }
    });
});
