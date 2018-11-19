/**
 * Created by liusong on 2018/4/17.
 */
var index = parent.layer.getFrameIndex(window.name); //获取窗口索引

//依据ID加载数据
function loadDT(id) {
    ajax('/loan/find', {id:id}, function (res) {
        console.log(res);
    });
}

$(function () {

    //@Angry_Snail
});