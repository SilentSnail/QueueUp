/**
 * Created by liusong on 2018/6/23.
 */
ajax = function (url, data, callFun, param, options) {
    this.defaults = {
        type : 'POST',
        async : true,
        dataType : 'json',
        traditional : false,
        contentType : 'application/x-www-form-urlencoded;charset=utf-8'
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
};

function getPageParam(data, param) {
    if (param) {
        data['page.pageNo'] = param.currentPage;
        data['page.pageSize'] = param.dataSize;
    }
    return data;
};

function objToArr(obj) {
    var arr = [];
    for (var k in obj) {
        if ($.isArray(obj[k])) {
            for (var i = 0, len = obj[k].length; i < len; ++i) {
                arr.push({name: k, value: obj[k][i]});
            }
        } else {
            arr.push({name: k, value: obj[k]});
        }
    }
    return arr;
}