package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public class ValidLog extends Model<ValidLog> {

    private static final long serialVersionUID = 1L;

        /**
     * 验证日志ID
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 验证Code
     */
         private String code;

        /**
     * 当前访问IP
     */
         private String logIp;

        /**
     * 用户ID
     */
         private Long userId;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 标记
     */
         private String sign;

        /**
     * 失效时间
     */
         private LocalDateTime effectiveTime;

        /**
     * 状态 0：无效  1：有效
     */
         private Integer status;


    public Integer getId() {
        return id;
    }

    public ValidLog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ValidLog setCode(String code) {
        this.code = code;
        return this;
    }

    public String getLogIp() {
        return logIp;
    }

    public ValidLog setLogIp(String logIp) {
        this.logIp = logIp;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public ValidLog setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ValidLog setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public ValidLog setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public LocalDateTime getEffectiveTime() {
        return effectiveTime;
    }

    public ValidLog setEffectiveTime(LocalDateTime effectiveTime) {
        this.effectiveTime = effectiveTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ValidLog setStatus(Integer status) {
        this.status = status;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ValidLog{" +
        "id=" + id +
        ", code=" + code +
        ", logIp=" + logIp +
        ", userId=" + userId +
        ", createTime=" + createTime +
        ", sign=" + sign +
        ", effectiveTime=" + effectiveTime +
        ", status=" + status +
        "}";
    }
}
