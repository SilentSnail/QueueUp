package com.queue.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-16
 */
public class RoleUser extends Model<RoleUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 主键id 唯一标识
     */
    @TableId(value = "user_code", type = IdType.AUTO)
    private String userCode;
    /**
     * 登陆名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 角色ID 默认为0
     */
    private Integer roleId;
    /**
     * 是否删除 1：删除 0：未删除
     */
    private Integer isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 修改人
     */
    private String reviser;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
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
        this.creator = creator;
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
        this.reviser = reviser;
    }

    @Override
    protected Serializable pkVal() {
        return this.userCode;
    }

    @Override
    public String toString() {
        return "RoleUser{" +
        "userId=" + userId +
        ", userCode=" + userCode +
        ", username=" + username +
        ", password=" + password +
        ", phone=" + phone +
        ", email=" + email +
        ", roleId=" + roleId +
        ", isDelete=" + isDelete +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", reviser=" + reviser +
        "}";
    }

    public RoleUser initRoleUser(){
        this.setIsDelete(0);
        this.setRoleId(1);
        return this;
    }
}
