package com.queue.datasource;

/**
 * Created by liusong on 2018/4/9.
 */
public class HandleDataSource {

    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public HandleDataSource(){}

    public static void putDataSource(String dataSource){
        holder.set(dataSource);
    }

    public static String getDataSource(){
        return holder.get();
    }

    /**
     * 删除与当前线程绑定的数据源路由key
     */
    public static void removeRoute(){
        holder.remove();
    }
}
