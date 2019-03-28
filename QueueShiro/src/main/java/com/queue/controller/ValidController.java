package com.queue.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.RoleUser;
import com.queue.mail.entity.MailMessage;
import com.queue.mail.service.MailMessageService;
import com.queue.service.RoleUserService;
import com.queue.shiro.bean.SecurityUserEntity;
import com.queue.utils.*;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    private RedisUtils<String, byte[]> redisUtils;

    /**
     * 获取验证码
     * @param request
     * @param response
     */
    @RequestMapping("/validCode")
    public void getValidCode(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String codeId = SecurityEncryptUtils.getUUID();
        request.getSession().setAttribute("codeId", codeId);//先保存Session，如果验证码创建失败，则该ID无效
        try {
            String code = VerifyCodeUtil.getVerifyCode(response.getOutputStream());
            this.redisUtils.setValue(codeId, SerializeUtils.toSerialize(code.toLowerCase()), 120L);//120秒失效
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param member
     * @return
     */
    @RequestMapping("/login")
    public R login(String username, String password, String verifyCode, @RequestParam(defaultValue = "0") String member, HttpSession session){
        Object attr = session.getAttribute("codeId");
        if(ObjectUtils.isEmpty(attr)){//当前session未找到ID
            return R.error("验证码已失效");
        }
        String saveCode = SerializeUtils.deSerialize(redisUtils.get(String.valueOf(attr)), String.class);
        if(ObjectUtils.isEmpty(saveCode)){
            return R.error("验证码已失效");
        }
        if(verifyCode.toLowerCase().equals(saveCode)){
            try {
                Asserts.isEmpty(username, "用户名不能为空");
                Asserts.isEmpty(password, "密码不能为空");
            }catch (Exception e){
                return R.error(e.getMessage());
            }
            log.info(member);
            SecurityUserEntity token = new SecurityUserEntity(username, SecurityEncryptUtils.toMD5(password));
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
        return R.error("验证码错误");
    }

    /**
     * 忘记密码
     * @param email
     * @param request
     * @return
     */
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
            String uuid = SecurityEncryptUtils.getUUID();
            String sign = SecurityEncryptUtils.toMD5(JSONObject.toJSONString(user));
            //保存
//            ValidLog valid = new ValidLog();
//            valid.setCode(uuid).setLogIp(HttpContextUtils.getIpAddress(request));
//            valid.setSign(sign).setUserId(user.getUserId());
//            valid.setEffectiveTime(DateUtils.getPlusTime(10L));
//            this.validLogService.saveValidByEntity(valid);
            //开始发邮件
            String url = "http://localhost:8080/valid/change/" + uuid + "/" + sign;
            String content = "密码重置链接：" + url + "<br/> 链接十分钟内有效";
            MailMessage mail = new MailMessage("密码重置", content, email);
            this.mailService.sendMail(mail);//邮件先不发
            return R.ok();
        } catch (Exception e) {
            log.error(e);
            return R.error("未知错误");
        }
    }

    /**
     * 验证用户名
     * @param name
     * @return
     */
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

    /**
     * 重置密码，这里默认的是123456
     * @param id
     * @param code
     * @return
     */
    @RequestMapping("/change/{id}/{code}")
    public R initPwd(@PathVariable String id, @PathVariable String code){
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("code", id);
        param.put("sign", code);
        try {
//            ValidLog valid = this.validLogService.searchByParam(param);
//            if(ObjectUtils.isEmpty(valid)){
//                return R.error("验证已过期");
//            }
            return R.ok();
        } catch (Exception e) {
            log.error(e);
            return R.error("未知错误");
        }
    }

    @RequestMapping("/capt")
    public R getCaptchaImage(){

        return R.ok();
    }
}
