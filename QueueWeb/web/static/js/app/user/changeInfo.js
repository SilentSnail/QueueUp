/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    var DATA = {
        data:{
            checkPwd:'',
            code:'',
            password:''
        },
        status:0
    };
    $("input[name=checkPwd]").blur(function () {
        ajax("/user/checkPwd", {checkPwd:this.value}, function (res) {
            if(res.code == 1){
                DATA.status = 1;//验证通过
                DATA.data.code = res.data;
            } else {
                alert("密码错误");
                DATA.status = -1;//验证未通过
            }
        });
    });
    $("button[name=submit]").click(function () {
        if(DATA.status == 0){
            alert("请输入密码");
        } else if(DATA.status == -1){
            alert("密码验证失败");
        }else{
            DATA.data.checkPwd = $("input[name=checkPwd]").val();
            DATA.data.password = $("input[name=password]").val();
            ajax("/user/updatePwd", DATA.data, function (res) {
                if(res.code == 1){
                    alert("修改成功");
                }else{
                    alert(res.data);
                }
            });
        }
    })
});