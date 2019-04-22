package com.test;

import com.queue.utils.SecurityEncryptUtils;
import com.test.tool.CheckTest;
import com.test.tool.UserInfo;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by liusong on 2018/8/20.
 */
public class StringTest {

    public static void main(String[] args) {
        String[] strs = new String[]{"1","tom","2","tom","3","tom","4","jack"};

        //lambda方式
        String uuid = lambdaToolFunction(strs, (p)-> p.equals("tom"));
        System.out.println(uuid);

        //Stream API方式
        Stream stream = Arrays.stream(strs);//构建一个Stream
        stream.filter((p)-> p.equals("tom"));//进行数据筛选和转换
        stream.limit(strs.length);//返回stream前面的n个元素
//        stream.skip(2);//与limit相反，忽略掉前N个元素（或者说去掉前N个元素）
        stream.forEach(System.out::println);//输出

        Map map = new IdentityHashMap<>();
    }

    public static String lambdaToolFunction(String[] ids, CheckTest<String> ck){
        for (String id: ids) {
            if(ck.test(id)){
                return SecurityEncryptUtils.getUUID();
            }
        }
        return "";
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
