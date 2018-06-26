package com.queue.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Created by liusong on 2018/4/9.
 */
@Aspect
@Component
public class DataSourceAspect {
    private Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    private static final String MASTER = "write";
    private static final String SLAVE = "read";
    private static final String REGEXP = "^(get|query|select|find|load|search)[a-z|0-9]*";

    public DataSourceAspect() {
    }

    @Before("within(com.queue..*)")
    public void before(JoinPoint point) {
        String method = point.getSignature().getName().toLowerCase();
        try {
            //读取数据源
            if(Pattern.matches(REGEXP, method)) {
                logger.debug(method + " SLAVE");
                HandleDataSource.putDataSource(SLAVE);
            } else {//写入数据源
                logger.debug(method + " MASTER");
                HandleDataSource.putDataSource(MASTER);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
