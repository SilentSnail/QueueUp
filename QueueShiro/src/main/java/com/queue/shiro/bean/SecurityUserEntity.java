package com.queue.shiro.bean;

import com.queue.entity.RoleUser;
import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by liusong on 2018/4/26.
 */
public class SecurityUserEntity extends UsernamePasswordToken implements Serializable {

    private String id;
    private String loginName;
    private RoleUser user;
    private Set<String> urlSet;
    private Set<String> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public RoleUser getUser() {
        return user;
    }

    public void setUser(RoleUser user) {
        this.user = user;
    }

    public Set<String> getUrlSet() {
        return urlSet;
    }

    public void setUrlSet(Set<String> urlSet) {
        this.urlSet = urlSet;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public SecurityUserEntity(String loginName){
        this.loginName = loginName;
    }

    public SecurityUserEntity(String loginName, String password){
        this.loginName = loginName;
        this.setUsername(loginName);
        this.setPassword(password.toCharArray());
    }

    public SecurityUserEntity(String id, String loginName, Set<String> urls){
        this.id = id;
        this.loginName = loginName;
        this.urlSet = urls;
    }
}
