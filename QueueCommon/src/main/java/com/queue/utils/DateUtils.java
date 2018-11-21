package com.queue.utils;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
     * 格式化日期
     * @param time 时间
     * @param format 格式
     * @return
     */
    public static String getFormatTime(LocalDateTime time, String format){
        return time.format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * 依据默认格式 格式化时间
     * @param text 日期字符串
     * @return
     */
    public static LocalDateTime parseDateTime(String text){
        try {
            return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(DATETIME_FORMAT));
        } catch (Exception e) {
            return LocalDateTime.of(parseDate(text), parseTime(null));
        }
    }

    /**
     * 依据日期格式 格式化日期
     * @param text
     * @return
     */
    public static LocalDate parseDate(String text){
        if(StringUtils.hasText(text)){
            return LocalDate.parse(text, DateTimeFormatter.ofPattern(DATE_FORMAT));
        }
        return LocalDate.now();
    }

    /**
     * 格式化时间
     * @param text 时间字符串
     * @return
     */
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
    public static LocalDateTime getTimeDifference(Long time){
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

    /**
     * 当前日期差
     * @param date 开始日期
     * @param type
     * @return
     */
    public static int getDateDifference(LocalDate date, String type){
        return getDateDifference(date, LocalDate.now(), type);
    }

    /**
     * 获取日期差
     * @param start 开始日期
     * @param end 结束日期
     * @param type
     * @return
     */
    public static int getDateDifference(LocalDate start, LocalDate end, String type){
        if("Y".equals(type.toUpperCase())){
            return start.until(end).getYears();
        } else if ("M".equals(type.toUpperCase())){
            return start.until(end).getMonths();
        } else if ("D".equals(type.toUpperCase())){
            return start.until(end).getDays();
        } else {
            throw new RuntimeException("未知类型");
        }
    }

    /**
     * 当前时间差
     * @param time
     * @param unit
     * @return
     */
    public static long getTimeDifference(LocalDateTime time, ChronoUnit unit){
        return getTimeDifference(time, LocalDateTime.now(), unit);
    }

    /**
     * 时间差 未测试
     * @param start
     * @param end
     * @param unit
     * @return
     */
    public static long getTimeDifference(LocalDateTime start, LocalDateTime end, ChronoUnit unit){
        return start.until(end, unit);
    }
}
