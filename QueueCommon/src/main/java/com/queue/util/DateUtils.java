package com.queue.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liusong on 2018/7/12.
 */
public class DateUtils {

    public static String getDataStr(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

}
