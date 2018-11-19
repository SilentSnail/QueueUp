/**
 * Created by liusong on 2018/4/17.
 */
// var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

$(function () {
    function loadDT() {
        var id = urlParam('id', window.location.href);
        ajax('/director/find', {id:id}, function (res) {
            var data = res.data;
            showData(data);
        });
    }
    loadDT();

    function showData(data) {
        $("#info_name").text(data.name);
        $("#info_sex").text(data.sex);
        $("#info_age").text(data.name);
        $("#info_birthday").text(data.birthday);
        $("#info_idCard").text(data.idCard);
        $("#info_address").text(data.address);
        $("#info_phone").text(data.phone);
        $("#info_qqNo").text(data.qqNo);
        $("#info_wxNo").text(data.weChat);
        $("#info_remark").text(data.remark);
    }

    $('#addLoan').click(function () {
        parent.layer.open({
            type: 2,
            title:'新增借款',
            area: ['550px', '450px'],
            fixed: false, //不固定
            maxmin: true,
            content: '/pages/loan/addLoanInfo.html',
            success:function(layero, index){

            }
        });
    });
});
