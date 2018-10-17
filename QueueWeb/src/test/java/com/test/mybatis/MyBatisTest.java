package com.test.mybatis;

import com.queue.entity.RoleUser;
import com.queue.service.RoleUserService;
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
        RoleUser param = new RoleUser();
        param.setUsername("admin");
        RoleUser user = this.userService.getUserByParam(param).get(0);
        if(!ObjectUtils.isEmpty(user)){
            System.out.println(user.toString());
        }
    }
}
