package com.queue.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by liusong on 2018/7/12.
 */
public class DateUtils {

    private static final String FORMAT = "yyyy-MM-dd hh:mm:ss";

    /**
     * 获取当前时间
     * @return
     */
    public static String getNowFormatTime(){
        return getFormatTime(LocalDateTime.now(), FORMAT);
    }

    /**
     * 依据格式，获取当前时间
     * @param format
     * @return
     */
    public static String getNowFormatTime(String format){
         return getFormatTime(LocalDateTime.now(), format);
    }

    /**
     * 按默认格式，返回格式化时间
     * @param time 时间
     * @return
     */
    public static String getFormatTime(LocalDateTime time){
        return time.format(DateTimeFormatter.ofPattern(FORMAT));
    }

    /**
     * 格式化日期
     * @param time 时间
     * @param format 格式
     * @return
     */
    public static String getFormatTime(LocalDateTime time, String format){
        return time.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 获取当前时间的time分钟之前的时间
     * @param time 可以为负数，如果为负数，则是当前时间的time分钟之后的时间
     * @return
     */
    public static LocalDateTime getDifferenceTime(Long time){
        return LocalDateTime.now().minusMinutes(time);
    }

    /**
     * 获取当前时间的time分钟之后的时间
     * @param time 可以为负数，如果为负数，则是当前时间的time分钟之前的时间
     * @return
     */
    public static LocalDateTime getPlusTime(Long time){
        return LocalDateTime.now().plusMinutes(time);
    }
}
