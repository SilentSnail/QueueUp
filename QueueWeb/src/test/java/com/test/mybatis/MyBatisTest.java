package com.test.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.RoleUser;
import com.queue.service.RoleUserService;
import com.queue.utils.SecurityEncryptUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

/**
 * Created by liusong on 2018/10/15.
 */
@ContextConfiguration(locations = ("classpath:spring-context.xml"))
@RunWith(SpringJUnit4ClassRunner.class)
public class MyBatisTest {

    @Autowired
    private RoleUserService userService;

    @Test
    public void getUserInfo(){
        RoleUser us = this.userService.getOne(new QueryWrapper<RoleUser>().eq("username", "admin"));
        if(!ObjectUtils.isEmpty(us)){
            us.setPassword(SecurityEncryptUtils.toMD5("123456"));
            boolean check = this.userService.updateById(us);
            System.out.println(check);
        }
    }
}
