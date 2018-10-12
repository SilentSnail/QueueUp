package com.queue.util;

/**
 * 断言类
 * Created by liusong on 2018/5/2.
 */
public class Asserts {

    public static void isTrue(boolean bool, String message){
        if(bool == false){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object obj, String msg){
        if(obj == null){
            throw new IllegalArgumentException(msg);
        }
    }

    public static void isEmpty(String str, String msg){
        if(str == null || str.length() == 0){
            throw new NullPointerException(msg);
        }
    }
}
