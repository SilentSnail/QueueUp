package com.queue.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by liusong on 2018/7/12.
 */
public class DateUtils {

    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * 获取当前时间
     * @return
     */
    public static String getNowFormatTime(){
        return getFormatTime(LocalDateTime.now(), DATETIME_FORMAT);
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
        return time.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
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

    public static LocalDateTime parseDateTime(String text){
        try {
            return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(DATETIME_FORMAT));
        } catch (Exception e) {
            return LocalDateTime.of(parseDate(text), parseTime(null));
        }
    }

    public static LocalDate parseDate(String text){
        if(StringUtils.hasText(text)){
            return LocalDate.parse(text, DateTimeFormatter.ofPattern(DATE_FORMAT));
        }
        return LocalDate.now();
    }

    public static LocalTime parseTime(String text){
        if(StringUtils.hasText(text)){
            return LocalTime.parse(text);
        }
        return LocalTime.of(0,0,0);
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
