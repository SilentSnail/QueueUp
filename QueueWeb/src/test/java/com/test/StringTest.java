package com.test;

import com.queue.utils.SecurityEncryptUtils;
import com.test.tool.UserInfo;

import java.lang.reflect.Constructor;

/**
 * Created by liusong on 2018/8/20.
 */
public class StringTest {

    public static void main(String[] args) {
        System.out.println(SecurityEncryptUtils.getUUID());
    }

    public static void getSql(){
        String[] country = new String[]{"菲律宾", "中国香港", "哥伦比亚", "哥斯达黎加", "韩国", "加拿大", "捷克", "柬埔寨"};
        String[] unit = new String[]{"比索", "港元", "比索", "科朗", "韩元", "加元", "克朗", "瑞尔"};
        String[] code = new String[]{"PHPG","HKD", "COP", "CRCH", "KRWJ", "CAD", "CZK", "KHR"};
        for (int i = 0; i < country.length; i++) {
            System.out.println("insert into city (sign, code, name, postalcode, parent_id) values ('sign', 'code', 'name', 'postalcode', 'parent_id');");
        }
    }


    public static void constructor(){
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
