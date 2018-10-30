package com.queue.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.RoleUser;
import com.queue.entity.ValidLog;
import com.queue.service.RoleUserService;
import com.queue.service.ValidLogService;
import com.queue.shiro.bean.SecurityUserEntity;
import com.queue.util.DateUtils;
import com.queue.util.PageBean;
import com.queue.util.R;
import com.queue.util.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusong on 2018/10/12.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private RoleUserService userService;
    @Autowired
    private ValidLogService validLogService;

    /**
     * 查询用户信息
     * @param user
     * @return
     */
    @RequestMapping("/searchList")
    public R searchUserByParam(RoleUser user){
        PageBean page = new PageBean();
        page.setData(this.userService.getUserByParam(user));
        return R.okPage(page);
    }

    /**
     * 验证密码
     * @param password
     * @return
     */
    @RequestMapping("/checkPwd")
    public R checkPassword(@RequestParam("checkPwd") String password){
        SecurityUserEntity securityUser = (SecurityUserEntity) org.apache.shiro.SecurityUtils.getSubject().getPrincipal();
        RoleUser user = securityUser.getUser();
        if(!user.getPassword().equals(SecurityUtils.toMD5(password))){
            //5次密码不匹配应该直接踢出登录
            return R.error("密码不匹配");
        }
        String sign = SecurityUtils.getUUID();
        ValidLog valid = new ValidLog();
        valid.setCode(sign).setUserId(user.getUserId());
        valid.setEffectiveTime(DateUtils.getPlusTime(10L));
        this.validLogService.save(valid);
        return R.ok(sign);
    }

    /**
     * 修改密码
     * @param code
     * @param password
     * @return
     */
    @RequestMapping("/updatePwd")
    public R updatePassword(String code, String password, String checkPwd){
        SecurityUserEntity securityUser = (SecurityUserEntity) org.apache.shiro.SecurityUtils.getSubject().getPrincipal();
        RoleUser user = securityUser.getUser();
        if(user.getPassword().equals(SecurityUtils.toMD5(checkPwd))){
            ValidLog valid = this.validLogService.getOne(new QueryWrapper<ValidLog>().eq("code", code));
            if(valid.getUserId().equals(user.getUserId())){
                user.setPassword(SecurityUtils.toMD5(password));
                this.userService.updateById(user);
                return R.ok();
            }
        }
        return R.error("数据不匹配");
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public R logout(){
        Subject subject = org.apache.shiro.SecurityUtils.getSubject();
        subject.logout();
        return R.ok();
    }
}
