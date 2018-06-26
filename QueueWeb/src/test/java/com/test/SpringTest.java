package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;

import java.util.UUID;

/**
 * Created by liusong on 2018/4/8.
 */
@ContextConfiguration(locations = ("classpath:spring-context.xml"))
//@RunWith(SpringJUnit4ClassRunner.class)//测试运行于Spring测试环境,自动创建Spring的应用上下文
@RunWith(JUnit4.class)//指用JUnit4来运行
public class SpringTest {

    @Test
    public void test(){
        System.out.printf("3213");
        System.out.println(UUID.randomUUID().toString());
    }
}
