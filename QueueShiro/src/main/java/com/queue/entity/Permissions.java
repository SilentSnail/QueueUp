package com.queue.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限信息
 */
public class Permissions extends Model<Permissions> {

    private Short pmsId;
    private String pmsCode;
    private String pmsName;
    private String pmsUrl;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String reviser;
    private Boolean isDelete;
    private String describeInf;

    public Short getPmsId() {
        return pmsId;
    }

    public Permissions setPmsId(Short pmsId) {
        this.pmsId = pmsId;
        return this;
    }

    public String getPmsCode() {
        return pmsCode;
    }

    public Permissions setPmsCode(String pmsCode) {
        this.pmsCode = pmsCode == null ? null : pmsCode.trim();
        return this;
    }

    public String getPmsName() {
        return pmsName;
    }

    public Permissions setPmsName(String pmsName) {
        this.pmsName = pmsName == null ? null : pmsName.trim();
        return this;
    }

    public String getPmsUrl() {
        return pmsUrl;
    }

    public Permissions setPmsUrl(String pmsUrl) {
        this.pmsUrl = pmsUrl == null ? null : pmsUrl.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Permissions setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Permissions setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Permissions setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getReviser() {
        return reviser;
    }

    public Permissions setReviser(String reviser) {
        this.reviser = reviser == null ? null : reviser.trim();
        return this;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public Permissions setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public String getDescribeInf() {
        return describeInf;
    }

    public Permissions setDescribeInf(String describeInf) {
        this.describeInf = describeInf == null ? null : describeInf.trim();
        return this;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }

    protected Serializable pkVal() {
        return this.pmsId;
    }
}