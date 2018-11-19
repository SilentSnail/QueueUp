package com.queue.utils;

import com.queue.entity.RoleUser;
import com.queue.shiro.bean.SecurityUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Created by liusong on 2018/11/7.
 */
public class ShiroUtils {

    public static Session getSession(){
        return getSubject().getSession();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    /**
     * 获取登录用户
     * @return
     */
    public static RoleUser getLoginUser(){
        return getSecurityUserEntity().getUser();
    }

    public static SecurityUserEntity getSecurityUserEntity(){
        return (SecurityUserEntity) getSubject().getPrincipal();
    }
}
