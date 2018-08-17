package com.test;

import com.queue.mail.send.SendMail;
import com.queue.mail.service.MailMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by liusong on 2018/4/8.
 */
@ContextConfiguration(locations = ("classpath:spring-context.xml"))
@RunWith(SpringJUnit4ClassRunner.class)//测试运行于Spring测试环境,自动创建Spring的应用上下文
//@RunWith(JUnit4.class)//指用JUnit4来运行
public class SpringTest {

    @Autowired
    private MailMessageService mailService;

    @Test
    public void test(){
        this.mailService.getMailPool().setRunnable(new SendMail());
    }
}
