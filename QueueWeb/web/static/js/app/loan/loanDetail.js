/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    var DATA = {
        data:{

        }
    };

    $("#logout").click(function(){
        ajax("/user/logout", {}, function () {
            window.location = "/pages/login.html";
        });
    });

    function load(){
        ajax("/loan/Detail", DATA.data, function (res) {
            $("#show").innerHTML = res.data;
            $("#DetailShow").html(res.data);//借还记录
        });
    }
    load();
    //@Angry_Snail
});