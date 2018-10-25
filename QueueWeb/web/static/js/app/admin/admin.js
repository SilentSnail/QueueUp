/**
 * Created by liusong on 2018/4/17.
 */
$(function(){
    layui.use('element', function () {
        var element = layui.element;

    });

    $("#logout").click(function(){
        ajax("/user/logout", {}, function () {
            window.location = "/pages/login.html";
        });
    });

    $("closeThisTabs").click(function () {

    });

    $("closeOtherTabs").click(function () {

    });

    $("closeAllTabs").click(function () {

    });

    $(".layui-tab .layui-tab-title .layui-tab-close").click(function () {
        var id = $(this).parent().attr("lay-id");
        var iframes = $('iframe');
        console.log(iframes);
    });
});