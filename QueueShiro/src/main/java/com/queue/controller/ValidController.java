package com.queue.controller;

import com.queue.entity.RoleUser;
import com.queue.service.UserService;
import com.queue.shiro.bean.SecurityUserEntity;
import com.queue.util.Asserts;
import com.queue.util.SecurityUtils;
import com.queue.util.R;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liusong on 2018/4/10.
 */
@RestController
@RequestMapping("/valid")
public class ValidController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public R login(String username, String password, @RequestParam(defaultValue = "0") String member){
        try {
            Asserts.isEmpty(username, "用户名不能为空");
            Asserts.isEmpty(password, "密码不能为空");
        }catch (Exception e){
            return R.error(e.getMessage());
        }
        System.out.println(member);
        SecurityUserEntity token = new SecurityUserEntity(username, SecurityUtils.toMD5(password));
        Subject subject = org.apache.shiro.SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (UnknownAccountException e){
            log.error(e.getMessage());
            return R.error("未知账号");
        } catch (IncorrectCredentialsException e){
            log.error(e.getMessage());
            return R.error("密码错误");
        } catch (ExcessiveAttemptsException e){
            return R.error("账户已锁定");
        } catch (Exception e){
            log.error(e.getMessage());
            return R.error("未知错误");
        }
    }

    @RequestMapping("/register")
    public R register(RoleUser user){
        try {
            int res = userService.save(user.initRoleUser());
            if(res == 1){
                return R.ok();
            }else{
                return R.error("保存失败");
            }
        } catch (Exception e) {
            log.error(e);
            return R.error("系统异常，请联系管理员");
        }
    }

    @RequestMapping("/rePassword")
    public R rePassword(@RequestParam(value = "email") String email){
        try {
            Asserts.isEmpty(email, "邮箱不能为空");
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
        return R.ok();
    }

    @RequestMapping("/checkName")
    public R checkUser(@RequestParam(value = "username") String name){
        try {
            RoleUser user = userService.getUserByEntity(new RoleUser(name));
            Asserts.isNull(user, "无用户信息");
            return R.error("用户已存在");
        } catch (Exception e) {
            return R.ok();
        }
    }

}
