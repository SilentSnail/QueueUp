package com.queue.controller;

import com.queue.entity.RoleUser;
import com.queue.entity.vo.UserSearchVo;
import com.queue.service.RoleUserService;
import com.queue.utils.PageBean;
import com.queue.utils.R;
import com.queue.utils.SecurityEncryptUtils;
import com.queue.utils.ShiroUtils;
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

    /**
     * 查询用户列表
     * @param search
     * @return
     */
    @RequestMapping("/searchList")
    public R searchUserByParam(UserSearchVo search){
        PageBean page = new PageBean();
        page.setData(this.userService.getUserByParam(search));
        return R.okPage(page);
    }

    /**
     * 验证密码
     * @param password
     * @return
     */
    @RequestMapping("/checkPwd")
    public R checkPassword(@RequestParam("checkPwd") String password){
        RoleUser user = ShiroUtils.getLoginUser();
        if(!user.getPassword().equals(SecurityEncryptUtils.toMD5(password))){
            //5次密码不匹配应该直接踢出登录
            return R.error("密码不匹配");
        }
//        String sign = SecurityEncryptUtils.getUUID();
//        ValidLog valid = new ValidLog();
//        valid.setCode(sign).setUserId(user.getUserId());
//        valid.setEffectiveTime(DateUtils.getPlusTime(10L));
//        this.validLogService.save(valid);
//        return R.ok(sign);
        return R.ok();
    }

    /**
     * 修改密码
     * @param code
     * @param password
     * @return
     */
    @RequestMapping("/updatePwd")
    public R updatePassword(String code, String password, String checkPwd){
        RoleUser user = ShiroUtils.getLoginUser();
        if(user.getPassword().equals(SecurityEncryptUtils.toMD5(checkPwd))){//两次输入的密码需要一致
//            ValidLog valid = this.validLogService.getOne(new QueryWrapper<ValidLog>().eq("code", code));
//            if(valid.getUserId().equals(user.getUserId())){
//                user.setPassword(SecurityEncryptUtils.toMD5(password));
//                this.userService.updateById(user);
//                return R.ok();
//            }
        }
        return R.error("数据不匹配");
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public R logout(){
        ShiroUtils.getSubject().logout();
        return R.ok();
    }
}
