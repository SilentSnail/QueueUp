package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public class LoginHistory extends Model<LoginHistory> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "login_id", type = IdType.AUTO)
    private String loginId;

    private String username;

    private LocalDateTime loginTime;

    private String cookieInfo;

    private Integer status;


    public String getLoginId() {
        return loginId;
    }

    public LoginHistory setLoginId(String loginId) {
        this.loginId = loginId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public LoginHistory setUsername(String username) {
        this.username = username;
        return this;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public LoginHistory setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
        return this;
    }

    public String getCookieInfo() {
        return cookieInfo;
    }

    public LoginHistory setCookieInfo(String cookieInfo) {
        this.cookieInfo = cookieInfo;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public LoginHistory setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.loginId;
    }

    @Override
    public String toString() {
        return "LoginHistory{" +
        "loginId=" + loginId +
        ", username=" + username +
        ", loginTime=" + loginTime +
        ", cookieInfo=" + cookieInfo +
        ", status=" + status +
        "}";
    }
}
