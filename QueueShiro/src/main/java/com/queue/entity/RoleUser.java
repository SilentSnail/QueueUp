package com.queue.entity;

import com.alibaba.fastjson.JSON;
import com.queue.util.EncryptionUtils;
import com.queue.util.StreamUtils;

import java.io.Serializable;
import java.util.Date;

public class RoleUser implements Serializable {

    private String userCode;//用户编码
    private String username;//用户名
    private String password;//密码
    private String phone;//手机号码
    private String email;
    private Short roleId;
    private Short isDelete;
    private Long userId;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String reviser;
    private static final long serialVersionUID = 1L;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Short getRoleId() {
        return roleId;
    }

    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser == null ? null : reviser.trim();
    }

    public RoleUser(){}

    public RoleUser(String username){
        this.setUsername(username);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    public RoleUser initRoleUser(){
        this.setUserCode(StreamUtils.getUUID());
        this.setCreateTime(new Date());
        this.setCreator(this.getUsername());
        this.setIsDelete((short) 0);
        this.setRoleId((short)0);
        this.setPassword(EncryptionUtils.toMD5(this.getPassword()));
        return this;
    }
}