/**
 * Created by liusong on 2018/6/23.
 */

ajax = function (url, data, callFun, param, options) {
    this.defaults = {
        type : 'POST',
        async : true,
        dataType : 'json',
        traditional : false,
        contentType : 'application/x-www-form-urlencoded'
    };
    var settings = $.extend({}, this.defaults, options);
    if(url) {
        if(url.indexOf('?') > 0) {
            url += '&_i='+ Math.random();
        } else {
            url += '?_i='+ Math.random();
        }
    }
    $.ajax({
        url: url,
        data: data,
        type : settings.type,
        async : settings.async,
        dataType : settings.dataType,
        traditional : settings.traditional,
        contentType : settings.contentType,
        success: function(data){
            callFun(data,param);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            //alert("服务器错误");
            console.log(XMLHttpRequest);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });
}