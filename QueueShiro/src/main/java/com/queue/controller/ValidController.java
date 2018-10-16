package com.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.queue.entity.RoleUser;
import com.queue.entity.ValidLog;
import com.queue.mail.entity.MailMessage;
import com.queue.mail.service.MailMessageService;
import com.queue.service.RoleUserService;
import com.queue.service.ValidLogService;
import com.queue.shiro.bean.SecurityUserEntity;
import com.queue.util.Asserts;
import com.queue.util.HttpContextUtils;
import com.queue.util.R;
import com.queue.util.SecurityUtils;
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
            if(userService.insert(user.initRoleUser())){
                return R.ok();
            }else{
                return R.error("保存失败");
            }
        } catch (Exception e) {
            return R.error("系统异常，请联系管理员");
        }
    }

    @RequestMapping("/rePassword")
    public R rePassword(@RequestParam(value = "email") String email, HttpServletRequest request){
        try {
            Asserts.isEmpty(email, "邮箱不能为空");
            RoleUser user = new RoleUser();
            user.setEmail(email);
            user = this.userService.selectOne(new EntityWrapper().eq("email", email));
            if(ObjectUtils.isEmpty(user)){
                return R.error("该邮箱尚未注册，请确认邮箱是否正确");
            }
            String uuid = SecurityUtils.getUUID();
            //保存
            ValidLog valid = new ValidLog();
            valid.setCode(uuid).setLogIp(HttpContextUtils.getIpAddress(request));
            String code = SecurityUtils.toMD5(JSONObject.toJSONString(valid));
            valid.setSign(code).setUserId(user.getUserId());
            this.validLogService.save(valid);
            //开始发邮件
            String url = "http://localhost:8080/valid/change/" + uuid + "/" + code;
            String content = "密码重置链接：" + url + "<br/> 链接十分钟内有效";
            MailMessage mail = new MailMessage("密码重置", content, email);
            this.mailService.sendMail(mail);
            return R.ok();
        } catch (Exception e) {
            e.printStackTrace();
                return R.error("未知错误");
        }
    }

    @RequestMapping("/checkName")
    public R checkUser(@RequestParam(value = "username") String name){
        try {
            RoleUser user = this.userService.selectOne(new EntityWrapper().eq("userName", name));
            Asserts.isNull(user, "无用户信息");
            return R.error("用户已存在");
        } catch (Exception e) {
            return R.ok();
        }
    }

    @RequestMapping("/change/{id}/{code}")
    public R initPwd(@PathVariable String id, @PathVariable String code){
        Map<String,Object> param = new HashMap();
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
            e.printStackTrace();
            return R.error("未知错误");
        }
    }
}
