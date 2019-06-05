package com.queue.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.queue.entity.RoleUser;
import com.queue.mail.entity.MailMessage;
import com.queue.mail.service.MailMessageService;
import com.queue.service.RoleUserService;
import com.queue.shiro.bean.SecurityUserEntity;
import com.queue.utils.*;
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
public class ValidController extends BaseController {

    @Autowired
    private RoleUserService userService;
    @Autowired
    private MailMessageService mailService;

    /**
     * 获取验证码
     * @param response
     */
    @RequestMapping("/loginCheckCode")
    public void getValidCode(HttpServletResponse response) {
        String codeId = SecurityEncryptUtils.getUUID();
        ShiroUtils.getSession().setAttribute("loginValidCode", codeId);//先保存Session，如果验证码创建失败，则该ID无效
        try {
            String code = VerifyCodeUtil.getVerifyCode(response);
            this.redisUtils.setValue(codeId, SerializeUtils.toSerialize(code.toLowerCase()), 120L);//120秒失效
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * 获取找回密码界面验证码
     * @param response
     * @return
     */
    @RequestMapping("/rePassValidCode")
    public void getCaptchaImage(HttpServletResponse response){
        String codeId = SecurityEncryptUtils.getUUID();
        ShiroUtils.getSession().setAttribute("rePassCode", codeId);//先保存Session，如果验证码创建失败，则该ID无效
        try {
            String code = VerifyCodeUtil.getVerifyCode(response);
            this.redisUtils.setValue(codeId, SerializeUtils.toSerialize(code.toLowerCase()), 180L);//120秒失效
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param remember
     * @return
     */
    @RequestMapping("/login")
    public R login(String username, String password, String verifyCode, String remember, HttpSession session){
        Object attr = ShiroUtils.getSession().getAttribute("loginValidCode");
        Asserts.isNull(attr, "验证码已失效");
        String saveCode = SerializeUtils.deSerialize(this.redisUtils.get(String.valueOf(attr)), String.class);
        Asserts.isEmpty(saveCode, "验证码已失效");
        Asserts.isEmpty(verifyCode, "验证码错误");
        if(saveCode.equals(verifyCode.toLowerCase())){
            try {
                Asserts.isEmpty(username, "用户名不能为空");
                Asserts.isEmpty(password, "密码不能为空");
            }catch (Exception e){
                return R.error(e.getMessage());
            }
            SecurityUserEntity token = new SecurityUserEntity(username, SecurityEncryptUtils.toMD5(password));
            Subject subject = org.apache.shiro.SecurityUtils.getSubject();
            try {
                if(!ObjectUtils.isEmpty(remember)){
                    token.setRememberMe(true);
                }
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
     * @return
     */
    @RequestMapping("/rePassword")
    public R rePassword(@RequestParam(value = "email") String email, String checkCode){
        try {
            Asserts.isEmpty(email, "邮箱不能为空");
            Object attr = ShiroUtils.getSession().getAttribute("rePassCode");
            Asserts.isNull(attr, "验证码已失效");
            String saveCode = SerializeUtils.deSerialize(this.redisUtils.get(String.valueOf(attr)), String.class);
            Asserts.isEmpty(saveCode, "验证码已失效");
            if(checkCode.toLowerCase().equals(saveCode)){
                RoleUser user = new RoleUser();
                user.setEmail(email);
                user = this.userService.getOne(new QueryWrapper<RoleUser>().eq("email", email));
                if(ObjectUtils.isEmpty(user)){
                    return R.error("该邮箱尚未注册，请确认邮箱是否正确");
                }
                //开始发邮件
                String code = new StringBuffer().append(VerifyCodeUtil.getCode(8)).toString();
//                String url = "http://localhost:8080/valid/change/" + uuid + "/" + sign;
                String content = "您的密码重置验证码为" + code + "<br/> 验证码五分钟内有效";
                String mailValidCodeId = SecurityEncryptUtils.getUUID();
                this.redisUtils.setValue(mailValidCodeId, SerializeUtils.toSerialize(mailValidCodeId), 300L);
                ShiroUtils.getSession().setAttribute("mailValidCodeId", mailValidCodeId);
                MailMessage mail = new MailMessage("密码重置", content, email);
                this.mailService.sendMail(mail);//发邮件需要先配置账号密码
                return R.ok();
            }
            return R.error("验证码错误");
        } catch (Exception e) {
            log.error(e);
            return R.error("未知错误");
        }
    }

    /**
     * 获取修改密码令牌
     * @param email
     * @param verCode
     * @param validCode
     * @return
     */
    @RequestMapping("/getSubject")
    public R checkValidCode(String email, String verCode, String validCode){
        Object mailAttr = ShiroUtils.getSession().getAttribute("mailValidCodeId");
        Object codeAttr = ShiroUtils.getSession().getAttribute("rePassCode");
        Asserts.isNull(mailAttr, "验证码已失效");
        Asserts.isNull(codeAttr, "验证码已失效");
        String savVerCode = SerializeUtils.deSerialize(this.redisUtils.get(String.valueOf(mailAttr)), String.class);
        String savValidCode = SerializeUtils.deSerialize(this.redisUtils.get(String.valueOf(codeAttr)), String.class);
        Asserts.isEmpty(savVerCode, "验证码已过期");
        Asserts.isEmpty(savValidCode, "验证码已过期");
        if(savVerCode.equals(verCode) & savValidCode.equals(validCode)){
            String subject = SecurityEncryptUtils.getUUID();
            //这里保存用户对象会好一点，图简单
            this.redisUtils.setValue(subject, SerializeUtils.toSerialize(email), 600L);
            return R.ok(subject);
        }
        return R.error("验证码错误");
    }

    /**
     * 重置密码
     * @return
     */
    @RequestMapping("/rePassChange")
    public R initPwd(@RequestParam String code, @RequestParam String password, String repass){
        String sbj = SerializeUtils.deSerialize(this.redisUtils.get(code), String.class);
        Asserts.isEmpty(sbj, "令牌已失效");
        //开始修改密码业务
        return R.ok();
    }

    /**
     * 重置密码 该功能已废弃
     * @param id
     * @param code
     * @return
     */
    @RequestMapping("/change/{id}/{code}")
    @Deprecated
    public R initPwd(@PathVariable String id, @PathVariable String code){
        Map<String,Object> param = new HashMap();
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
}
