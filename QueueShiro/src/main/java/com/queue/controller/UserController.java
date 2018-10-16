package com.queue.controller;

import com.queue.entity.RoleUser;
import com.queue.service.RoleUserService;
import com.queue.util.PageBean;
import com.queue.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusong on 2018/10/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RoleUserService userService;

    @RequestMapping("/searchList")
    public R searchUserByParam(RoleUser user){
        PageBean page = new PageBean();
        page.setData(this.userService.getUserByParam(user));
        return R.okPage(page);
    }
}
