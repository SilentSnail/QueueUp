package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
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
         private LocalDateTime createTime;

        /**
     * 创建人
     */
         private String creator;

        /**
     * 更新时间
     */
         private LocalDateTime updateTime;

        /**
     * 修改人
     */
         private String reviser;


    public Long getUserId() {
        return userId;
    }

    public RoleUser setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public RoleUser setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RoleUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RoleUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RoleUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RoleUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public RoleUser setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public RoleUser setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RoleUser setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public RoleUser setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public RoleUser setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getReviser() {
        return reviser;
    }

    public RoleUser setReviser(String reviser) {
        this.reviser = reviser;
        return this;
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
}
