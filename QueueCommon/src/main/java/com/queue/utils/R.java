package com.queue.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liusong on 2018/4/10.
 */
public class R extends HashMap<String,Object> {

    //Code 1 成功 0 失败
    public R(){ put("code", 1); }

    private R (Map<String,Object> map) {
        super.putAll(map);
        this.put("code", 1);
    }

    public R put(String key, Object value){
        super.put(key, value);
        return this;
    }

    public static R ok(){
        return new R();
    }

    public static R ok(String message){
        return new R().put("data", message);
    }

    public static R ok(Map<String, Object> map){
        return new R(map);
    }

    public static R ok(Object value){
        return new R().put("data", value);
    }

    public static R error(){
        return new R().error(500, "系统异常，请联系管理员");
    }

    public static R error(String message){
        return new R().error(0, message);
    }

    public static R error(int code, String message){
        return new R().put("code", code).put("msg", message);
    }

    public static R okPage(PageBean value){
        return new R().put("page", value);
    }
}
