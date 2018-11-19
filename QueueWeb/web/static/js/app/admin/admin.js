/**
 * Created by liusong on 2018/4/17.
 */
//显示上一个
$(".layadmin-pagetabs .layui-icon-prev").click(function () {
    var show = $(".layui-tab .layui-tab-title .layui-this");
    var prev = $(show).prev();
    if(prev.length > 0){//如果有上一个
        $(show).removeClass('layui-this');
        $(prev).addClass('layui-this');
        $('iframe[src="'+$(show).attr("lay-id")+'"]').parent().removeClass('layui-show');
        $('iframe[src="'+$(prev).attr("lay-id")+'"]').parent().addClass('layui-show');
    }
});

//显示下一个
$(".layadmin-pagetabs .layui-icon-next").click(function () {
    var show = $(".layui-tab .layui-tab-title .layui-this");
    var next = $(show).next();
    if(next.length > 0){//如果有下一个
        $(show).removeClass('layui-this');
        $(next).addClass('layui-this');
        $('iframe[src="'+$(show).attr("lay-id")+'"]').parent().removeClass('layui-show');
        $('iframe[src="'+$(next).attr("lay-id")+'"]').parent().addClass('layui-show');
    }
});

//关闭当前页
$("#closeThisTabs").click(function () {
    var show = $(".layui-tab .layui-tab-title .layui-this");
    if($(show).attr('name') == 'home'){//如果是首页，不删除
        return;
    }
    var next = $(show).next();//下一个
    if(next.length > 0){//如果有下一个显示下一个
        $(next).addClass('layui-this');
        $('iframe[src="'+$(next).attr("lay-id")+'"]').parent().addClass('layui-show');
    }else{//显示上一个
        var prev = $(show).prev();
        $(prev).addClass('layui-this');
        $('iframe[src="'+$(prev).attr("lay-id")+'"]').parent().addClass('layui-show');
    }
    $('iframe[src="'+$(show).attr("lay-id")+'"]').parent().remove();//移除当前项
    $(show).remove();//删除
});

//关闭其他页
$("#closeOtherTabs").click(function () {
    $(".layui-tab .layui-tab-title .layui-this").siblings().each(function () {
        if($(this).attr('name') == 'home'){
            return;
        }
        removeById($(this).attr('lay-id'))
        $(this).remove();
    });
});

//关闭所有页
$("#closeAllTabs").click(function () {
    $(".layui-tab .layui-tab-title li[name='home']").siblings().each(function () {
        removeById($(this).attr('lay-id'))
        $(this).remove();
    });
    var home = $(".layui-tab .layui-tab-title li[name='home']");
    $(home).addClass('layui-this');
    $('iframe[src="'+$(home).attr("lay-id")+'"]').parent().addClass('layui-show');
});

// 点击刷新按钮
$(".layui-header .layui-layout-left .layui-icon-refresh-3").click(function () {
    var show = $(".layui-tab .layui-tab-title .layui-this");
    var iframe = $('iframe[src="'+$(show).attr("lay-id")+'"]')[0];
    $(iframe).attr('src', $(iframe).attr('src'));//重新加载
});

//移除iframe
function removeById(id){
    var div = $('iframe[src="'+id+'"]').parent();
    if($(div).hasClass('layui-show')){//如果当前显示
        if($(div).next().length == 0){//没有下一个兄弟节点
            $(div).prev().addClass('layui-show');
        }else{//存在下一个兄弟节点
            $(div).next().addClass('layui-show');
        }
    }
    $(div).remove();
}

//点击项，显示自身 动态添加的元素得这么写才会生效 否者直接.click 会出现不生效的问题
$(".layui-tab-title").on('click', 'li', function () {
    $(this).siblings().removeClass('layui-this');
    $(this).addClass('layui-this');
    showById($(this).attr("lay-id"));
});

//点击关闭按钮 动态添加的元素得这么写才会生效 否者直接.click 会出现不生效的问题
$(".layui-tab-title").on('click', 'li .layui-tab-close', function () {
    var parent = $(this).parent();
    if($(parent).next().length == 0){//没有下一个兄弟节点
        $(parent).prev().addClass('layui-this');
    }else{//存在下一个兄弟节点
        $(parent).next().addClass('layui-this');
    }
    removeById($(this).parent().attr("lay-id"));
    $(parent).remove();//删除
});

//显示iframe
function showById(id){
    var div = $('iframe[src="'+id+'"]').parent();
    if($(div).hasClass('layui-show')){//如果当前正在显示
        //啥也不干
    }else{
        $(div).siblings().removeClass('layui-show');//移除所有的显示
        $(div).addClass('layui-show');//显示自身
    }
}

//添加显示
function addItem(id, title) {
    //移除显示块
    $('.layui-tab-title').children().removeClass('layui-this');
    $('.layui-body').children().removeClass('layui-show');
    //是否之前加入过
    var check = true;
    $('.layui-tab-title').children().each(function () {
        if($(this).attr('lay-id') == id){
            $(this).addClass('layui-this');
            check = false;
            return;
        }
    });
    //没有加入，添加，否者直接显示
    if(check){
        var show = '<li lay-id="'+id+'" class="layui-this"><span>'+title+'</span><i class="layui-icon layui-unselect layui-tab-close">ဆ</i></li>'
        var body = '<div class="layadmin-tabsbody-item layui-show"><iframe src="'+id+'" frameborder="0" class="layadmin-iframe"></iframe></div>'
        $('.layui-tab-title').append(show);
        $('.layui-body').append(body);
    }
    showById(id);
}

//导入element
layui.use(['element', 'layer'], function () {
    var layer = layui.layer;
    //点击添加
    $('.layui-side-scroll a').click(function () {
        var id = $(this).attr('lay-href');
        if(id == undefined){
            return;
        } else if(id == '') {
            layer.msg("功能正在添加中");
        } else {
            addItem(id, $(this).html());
        }
    });
});

//退出登录
$("#logout").click(function(){
    ajax("/user/logout", {}, function () {
        window.location = "/pages/login.html";
    });
});