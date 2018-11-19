package com.queue.interceptor;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by liusong on 2018/10/26.
 */
//@Configuration
@Deprecated
public class ConvertLocalDateTime implements Converter<String, LocalDateTime> {

    @Deprecated
    @Override
    public LocalDateTime convert(String time) {
        System.out.println(time);
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
