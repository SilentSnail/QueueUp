package com.queue.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化工具类
 * Created by liusong on 2018/9/19.
 */
public class SerializeUtils {

    private static Map<Class<?>, Schema<?>> schemaCache = new ConcurrentHashMap();

    /**
     * 构建schema集合
     * @param classType
     * @param <T>
     * @return
     */
    private static <T> Schema<T> getSchema(Class<T> classType){
        Schema<T> schema = (Schema<T>) schemaCache.get(classType);
        if(schema == null){
            schema = RuntimeSchema.createFrom(classType);
            if(schema != null){
                schemaCache.put(classType, schema);
            }
        }
        return schema;
    }

    /**
     * 序列化
     * @param obj 序列化的内容
     * @param <T> 返回字节数组
     * @return
     */
    public static <T> byte[] toSerialize(T obj){
        Class<T> classType = (Class<T>) obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        Schema<T> schema = getSchema(classType);
        return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
    }

    /**
     * 随机反序列化类的构造参数
     * @param bytes 数据
     * @param classType 构造类型
     * @param <T> 返回构造类型对应的实体类
     * @return
     */
    public static <T> T deSerialize(byte[] bytes, Class<T> classType){
        return deSerialize(bytes, classType, true);
    }

    /**
     * 反序列化类的构造参数,依据参数是否排序后获取
     * @param bytes 数据
     * @param classType 构造类型
     * @param isSort 是否排序后取第一个，否者随机
     * @param <T> 返回构造类型对应的实体类
     * @return
     */
    public static <T> T deSerialize(byte[] bytes, Class<T> classType, Boolean isSort){
        try {
            Constructor<T>[] cons = (Constructor<T>[]) classType.getConstructors();
            if(isSort){//是否排序 排序后 使用无参构造，否者随机获取构造方法
                Integer[] sort = new Integer[cons.length];
                for (int i = 0; i < sort.length; i++) {
                    sort[i] = cons[i].getParameterTypes().length;
                }
                cons = ConvertUtils.sort(cons, sort);
            }
            Constructor<T> con = cons[0];
            con.setAccessible(true);//成员变量为private 设置此项才有访问权限
            //不管有参无参，都可以进行构造，但是构造参数必须为引用数据类型,无法构造基本数据类型
            T msg = con.newInstance(new Object[con.getParameterTypes().length]);
            Schema<T> schema = getSchema(classType);
            ProtostuffIOUtil.mergeFrom(bytes, msg, schema);
            return msg;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
