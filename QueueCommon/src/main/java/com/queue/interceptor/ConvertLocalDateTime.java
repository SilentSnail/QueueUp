package com.queue.interceptor;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by liusong on 2018/10/26.
 */
public class ConvertLocalDateTime implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
