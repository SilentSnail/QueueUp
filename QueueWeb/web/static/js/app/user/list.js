/**
 * Created by liusong on 2018/4/17.
 */
$(function () {
    var DATA = {
        search:{
            username:''
        },
        param:{
            start:1,
            length:10
        }
    };

    function load() {
        ajax("/user/searchList", getPageParam(DATA.search, DATA.param), function (res) {
            if(res.code == "1"){
                console.log(res.pager);
            }
        });
    }
    load();

    function reLoad(){
        var search = getPageParam(DATA.search, DATA.param);
        $("#userList").datagrid({
            dataSource:{
                cols:[
                    {name: 'userId', label: 'ID'},
                    {name: 'userCode', label: '用户编码'},
                    {name: 'username', label: '登陆名'},
                    {name: 'password', label: '密码'},
                    {name: 'phone', label: '手机号'},
                    {name: 'email', label: '邮箱'},
                    {name: 'roleId', label: '角色ID'},
                    {name: 'isDelete', label: '是否删除'},
                    {name: 'createTime', label: '创建时间'},
                    {name: 'creator', label: '创建人'},
                    {name: 'updateTime', label: '更新时间'},
                    {name: 'reviser', label: '更新人'}
                ]
            },
            remote:function (search) {
                return {
                    url:"/user/searchList"
                }
            }
        });
    }
    reLoad();
});