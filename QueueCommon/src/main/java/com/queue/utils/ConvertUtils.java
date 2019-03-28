package com.queue.utils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by liusong on 2018/8/16.
 */
public class ConvertUtils {

    private static void setObjectValue(Object obj, Map<String, Object> params) throws SecurityException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = obj.getClass();
        for (Iterator it = params.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            String key = entry.getKey();
            Object propertyValue = entry.getValue();
            Field name = getSpecifiedField(clazz, key);
            if (name != null) {
                name.setAccessible(true);
                name.set(obj, propertyValue);
            }
        }
    }

    private static Field getSpecifiedField(Class<?> clazz, String fieldName) {
        Field f = null;
        try {
            f = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class superClass2=clazz.getSuperclass();
            if (superClass2.getName().equals(Object.class.getName())){
                return null;
            }
            return getSpecifiedField(superClass2, fieldName);
        }
        return f;
    }

    private static List<Field> getAllFieldList(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        List<Field> fieldsList = new ArrayList<Field>();// return object
        Class<?> superClass = clazz.getSuperclass();// father class
        if (!superClass.getName().equals(Object.class.getName())){
            fieldsList.addAll(getAllFieldList(superClass));
        }
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            // 排除因实现Serializable 接口而产生的属性serialVersionUID
            if (!field.getName().equals("serialVersionUID")) {
                fieldsList.add(field);
            }
        }
        return fieldsList;
    }

    private static Object getObjectValue(Object obj, Field name) throws SecurityException, IllegalAccessException {
        if (name == null) {
            System.out.println("[ReflectHWUtils.getObjectValue]" + obj.getClass().getName() + " does not has field ");
            return null;
        }
        name.setAccessible(true);
        return name.get(obj);
    }

    /**
     * map 转换为 实体类
     * @param map
     * @param clazz
     * @return
     */
    public static Object convertMapToObj(Map<String, Object> map,Class clazz) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException{
        Object obj=clazz.newInstance();
        ConvertUtils.setObjectValue(clazz.newInstance(), map);
        return obj;
    }

    /**
     * 实体类转换为Map
     * @param obj
     * @return
     */
    public static Map convertObjToMap(Object obj) throws SecurityException, NoSuchFieldException, IllegalAccessException {
        Map map = new HashMap();
        List<Field> fieldsList = ConvertUtils.getAllFieldList(obj.getClass());
        for (int i = 0; i < fieldsList.size(); i++) {
            Field f = fieldsList.get(i);
            Object propertyValue = ConvertUtils.getObjectValue(obj, f);
            map.put(f.getName(), propertyValue);
        }
        return map;
    }

    /**
     * 冒泡排序
     * @param ts 方法
     * @param sortType
     * @param <T>
     * @return
     */
    public static <T> T[] sort(T[] ts, Integer[] sortType){
        T t;
        int temp;
        for(int i = 0 ; i < ts.length-1; i ++) {
            for(int j = 0 ;j < ts.length-1-i ; j++) {
                if(sortType[j] > sortType[j+1]) { //交换两数位置
                    //排序
                    temp = sortType[j];
                    sortType[j] = sortType[j+1];
                    sortType[j+1] = temp;
                    //返回排序的结果
                    t = ts[j];
                    ts[j] = ts[j+1];
                    ts[j+1] = t;
                }
            }
        }
        return ts;
    }
}
