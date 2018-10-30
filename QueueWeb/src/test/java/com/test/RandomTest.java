package com.test;

import com.queue.util.DateUtils;

import java.time.LocalDate;

/**
 * Created by liusong on 2018/7/11.
 */
public class RandomTest {

    public static void main(String[] args) {
        String text = "2018-10-12 12:12:12";
        text = "2018-10-12";
        System.out.println(DateUtils.parseDateTime(text));
        LocalDate date = DateUtils.parseDate(text);
    }
}
