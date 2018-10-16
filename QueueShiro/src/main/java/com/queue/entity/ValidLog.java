package com.queue.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 验证日志信息
 * Created by liusong on 2018/10/12.
 */
public class ValidLog extends Model<ValidLog> {

    private Long id;//id
    private String code;//code
    private String logIp;//访问者IP
    private Long userId;
    private Date createTime;//创建时间
    private String sign;//标记
    private Date effectiveTime;//有效时间
    private Integer status;//状态

    public Long getId() {
        return id;
    }

    public ValidLog setId(Long id) {
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

    public Long getUserId() {
        return userId;
    }

    public ValidLog setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getLogIp() {
        return logIp;
    }

    public ValidLog setLogIp(String logIp) {
        this.logIp = logIp;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ValidLog setCreateTime(Date createTime) {
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

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public ValidLog setEffectiveTime(Date effectiveTime) {
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
    public String toString(){
        return JSONObject.toJSONString(this);
    }

    protected Serializable pkVal() {
        return this.id;
    }
}
