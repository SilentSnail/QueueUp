/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    var DATA = {
        data:{
            loanType:1,//类型
            loadName:'',//借款人姓名
            idCard:'',//身份证号
            phone:'',//手机号
            amount:'',//借款金额
            loadTime:'',//借款时间
            repaymentTime:'',//还款时间
            actualRepaymentTime:'',//最终还款时间
            remark:'',//备注
            isIou:0//是否有借据
        }
    };

    $(".form-datetime").datetimepicker({
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        format: "yyyy-mm-dd hh:ii"
    });

    $("#logout").click(function(){
        ajax("/user/logout", {}, function () {
            window.location = "/pages/login.html";
        });
    });

    $("#submit").click(function(){
        getData();
        ajax("/loan/save", DATA.data, function (res) {
            if(res.code){
                alert("保存成功");
            }
        });
    });

    function getData() {
        DATA.data.loanType = parseInt($("#loanType").val());
        DATA.data.loadName = $("#loadName").val();
        DATA.data.idCard = $("#idCard").val();
        DATA.data.phone = $("#phone").val();
        DATA.data.amount = $("#amount").val();
        DATA.data.loadTime = $("#loadTime").val();
        DATA.data.repaymentTime = $("#repaymentTime").val();
        DATA.data.actualRepaymentTime = $("#actualRepaymentTime").val();
        DATA.data.remark = $("#remark").val();
        DATA.data.isIou = parseInt($("input[name='isIou']:checked").val());
    }
});