package com.test;

import com.queue.utils.DateUtils;
import org.apache.shiro.util.StringUtils;

/**
 * Created by liusong on 2018/7/11.
 */
public class RandomTest {

    public static void main(String[] args) {
        String idCard = "429005200201261800";
        if(StringUtils.hasText(idCard)){
            System.out.println(DateUtils.parseDate(idCard.substring(6, 14), "yyyyMMdd"));
        }
    }
}
