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
            console.log(this);
        }
    });
};

/**
 * 获取分页参数
 * @param data
 * @param param
 * @returns {*}
 */
getPageParam = function (data, param) {
    if (param) {
        data['page.pageNo'] = param.currentPage;
        data['page.pageSize'] = param.dataSize;
    }
    return data;
};

/**
 * 对象转数组
 * @param obj
 * @returns {Array}
 */
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

/**
 * 格式化日期，去掉日期后面的时间
 * @param str
 * @returns {*}
 */
parseDate = function (str) {
    if(str){
        return /\d{4}-\d{1,2}-\d{1,2}/g.exec(str);
    }
    return '';
};

/**
 * 获取URL参数
 * @param name 参数名
 * @param url 需要获取参数的URL
 * @returns {*}
 */
urlParam = function (name, url) {
    var reg = new RegExp('(\\?|\\&)' + name + '=([^&]*)(&|$)');
    var r = null;
    if (url) {
        r = url.substr(1).match(reg);
    } else {
        r = window.location.search.substr(1).match(reg);
    }
    if (r != null) return decodeURI(r[2]);
    return null;
};