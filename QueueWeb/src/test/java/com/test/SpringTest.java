package com.test;

import com.alibaba.fastjson.JSONObject;
import com.queue.entity.dto.SysUserDto;
import com.queue.entity.vo.UserSearchVo;
import com.queue.mail.entity.MailMessage;
import com.queue.service.RoleUserService;
import com.queue.utils.RedisUtils;
import com.queue.utils.SecurityEncryptUtils;
import com.queue.utils.SerializeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by liusong on 2018/4/8.
 */
@ContextConfiguration(locations = ("classpath:spring-context.xml"))
@RunWith(SpringJUnit4ClassRunner.class)//测试运行于Spring测试环境,自动创建Spring的应用上下文
//@RunWith(JUnit4.class)//指用JUnit4来运行
public class SpringTest {

    @Autowired
    private RoleUserService userService;
    @Autowired
    private RedisUtils<String, byte[]> redisUtil;

    @Test
    public void test(){
        List<SysUserDto> list = this.userService.getUserByParam(new UserSearchVo());
//        RoleUser user = this.userService.getById("1");
        System.out.println(JSONObject.toJSONString(list));
    }

    @Test
    public void checkRedis(){
        MailMessage message = new MailMessage("title", "message", "123@163.com");
        String uuid = SecurityEncryptUtils.getUUID();
        this.redisUtil.setValue(uuid, SerializeUtils.toSerialize(message));
        byte[] obj = this.redisUtil.get(uuid);
        MailMessage msg;
        if(!ObjectUtils.isEmpty(obj)){
            msg = SerializeUtils.deSerialize(obj, MailMessage.class, true);
            System.out.println(msg);
        }
    }
}