package com.test;

import com.test.tool.UserInfo;

import java.lang.reflect.Constructor;

/**
 * Created by liusong on 2018/8/20.
 */
public class StringTest {

    public static void main(String[] args) {
        Constructor<?>[] cons = UserInfo.class.getConstructors();
        Constructor con;
        for (int i = 0; i < cons.length; i++) {
            try {
                con = cons[i];
                Class[] classes = con.getParameterTypes();
                Object[] obj = new Object[classes.length];
                con.newInstance(obj);
                System.out.println(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
