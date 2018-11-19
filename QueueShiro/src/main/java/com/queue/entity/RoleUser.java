package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-11-09
 */
public class RoleUser extends Model<RoleUser> {

    private static final long serialVersionUID = 1L;

        /**
     * 用户ID
     */
         @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

        /**
     * 唯一标识
     */
         private String userCode;

        /**
     * 用户名
     */
         private String username;

        /**
     * 密码
     */
         private String password;

        /**
     * 手机号
     */
         private String phone;

        /**
     * 邮箱
     */
         private String email;

        /**
     * 角色ID
     */
         private Integer roleId;

        /**
     * true:删除 false:未删除
     */
         private Boolean delStatus;

        /**
     * 状态 1有效 0锁定 -1无效
     */
         private Integer status;


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

    public Boolean getDelStatus() {
        return delStatus;
    }

    public RoleUser setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public RoleUser setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
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
        ", delStatus=" + delStatus +
        ", status=" + status +
        "}";
    }
}
