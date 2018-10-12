package com.test;

import com.queue.mail.entity.MailMessage;
import com.queue.mail.send.SendMail;
import com.queue.mail.service.MailMessageService;
import com.queue.util.RedisUtils;
import com.queue.util.SecurityUtils;
import com.queue.util.SerializeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

/**
 * Created by liusong on 2018/4/8.
 */
@ContextConfiguration(locations = ("classpath:spring-context.xml"))
@RunWith(SpringJUnit4ClassRunner.class)//测试运行于Spring测试环境,自动创建Spring的应用上下文
//@RunWith(JUnit4.class)//指用JUnit4来运行
public class SpringTest {

    @Autowired
    private MailMessageService mailService;
    @Autowired
    private RedisUtils<String, byte[]> redisUtil;

    @Test
    public void test(){
        this.mailService.getMailPool().setRunnable(new SendMail());
    }

    @Test
    public void checkRedis(){
        MailMessage message = new MailMessage("title", "message", "123@163.com");
        String uuid = SecurityUtils.getUUID();
        this.redisUtil.setValue(uuid, SerializeUtils.toSerialize(message));
        byte[] obj = this.redisUtil.get(uuid);
        MailMessage msg;
        if(!ObjectUtils.isEmpty(obj)){
            msg = SerializeUtils.deSerialize(obj, MailMessage.class, true);
            System.out.println(msg);
        }
    }
}