/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    /**
     * 定义切换选项卡效果
     */
    $('.layui-carousel-ind ul li').mouseover(function () {
        var objs = $(this).parent().parent().prev().children();
        var index = $(this).parent().children().index(this);
        $(objs).removeClass("layui-this");
        $(objs[index]).addClass("layui-this");
        $(this).siblings().removeClass("layui-this");
        $(this).addClass("layui-this");
    });
});

