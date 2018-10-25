package com.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.RoleUser;
import com.queue.entity.ValidLog;
import com.queue.mail.entity.MailMessage;
import com.queue.mail.service.MailMessageService;
import com.queue.service.RoleUserService;
import com.queue.service.ValidLogService;
import com.queue.shiro.bean.SecurityUserEntity;
import com.queue.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liusong on 2018/4/10.
 */
@RestController
@RequestMapping("/valid")
public class ValidController {

    private static Logger log = LogManager.getLogger(ValidController.class);

    @Autowired
    private RoleUserService userService;
    @Autowired
    private MailMessageService mailService;
    @Autowired
    private ValidLogService validLogService;

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
            return R.error("未知账号");
        } catch (IncorrectCredentialsException e){
            return R.error("密码错误");
        } catch (ExcessiveAttemptsException e){
            return R.error("账户已锁定");
        } catch (Exception e){
            return R.error("未知错误");
        }
    }

    @RequestMapping("/register")
    public R register(RoleUser user){
        try {
            if(this.userService.save(user)){
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
    public R rePassword(@RequestParam(value = "email") String email, HttpServletRequest request){
        try {
            Asserts.isEmpty(email, "邮箱不能为空");
            RoleUser user = new RoleUser();
            user.setEmail(email);
            user = this.userService.getOne(new QueryWrapper<RoleUser>().eq("email", email));
            if(ObjectUtils.isEmpty(user)){
                return R.error("该邮箱尚未注册，请确认邮箱是否正确");
            }
            String uuid = SecurityUtils.getUUID();
            String sign = SecurityUtils.toMD5(JSONObject.toJSONString(user));
            //保存
            ValidLog valid = new ValidLog();
            valid.setCode(uuid).setLogIp(HttpContextUtils.getIpAddress(request));
            valid.setSign(sign).setUserId(user.getUserId());
            valid.setEffectiveTime(DateUtils.getPlusTime(10L));
            this.validLogService.saveValidByEntity(valid);
            //开始发邮件
            String url = "http://localhost:8080/valid/change/" + uuid + "/" + sign;
            String content = "密码重置链接：" + url + "<br/> 链接十分钟内有效";
            MailMessage mail = new MailMessage("密码重置", content, email);
//            this.mailService.sendMail(mail);//邮件先不发
            return R.ok(mail);
        } catch (Exception e) {
            log.error(e);
            return R.error("未知错误");
        }
    }

    @RequestMapping("/checkName")
    public R checkUser(@RequestParam(value = "username") String name){
        try {
            RoleUser user = this.userService.getOne(new QueryWrapper<RoleUser>().eq("userName", name));
            if(ObjectUtils.isEmpty(user)){
                return R.ok();
            }
            return R.error("用户已存在");
        } catch (Exception e) {
            log.error(e);
            return R.error();
        }
    }

    @RequestMapping("/change/{id}/{code}")
    public R initPwd(@PathVariable String id, @PathVariable String code){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("code", id);
        param.put("sign", code);
        try {
            ValidLog valid = this.validLogService.searchByParam(param);
            if(ObjectUtils.isEmpty(valid)){
                return R.error("验证已过期");
            }
            this.userService.changePassword(valid.getUserId());
            return R.ok();
        } catch (Exception e) {
            log.error(e);
            return R.error("未知错误");
        }
    }
}
