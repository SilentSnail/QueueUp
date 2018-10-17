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
public class Permissions extends Model<Permissions> {

    private static final long serialVersionUID = 1L;

        /**
     * 权限ID
     */
         @TableId(value = "pms_id", type = IdType.AUTO)
    private Integer pmsId;

        /**
     * 权限编码
     */
         private String pmsCode;

        /**
     * 权限名称
     */
         private String pmsName;

        /**
     * 权限URL
     */
         private String pmsUrl;

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
     * 更新人
     */
         private String reviser;

        /**
     * 是否删除
     */
         private Boolean isDelete;

        /**
     * 描述
     */
         private String describeInf;


    public Integer getPmsId() {
        return pmsId;
    }

    public Permissions setPmsId(Integer pmsId) {
        this.pmsId = pmsId;
        return this;
    }

    public String getPmsCode() {
        return pmsCode;
    }

    public Permissions setPmsCode(String pmsCode) {
        this.pmsCode = pmsCode;
        return this;
    }

    public String getPmsName() {
        return pmsName;
    }

    public Permissions setPmsName(String pmsName) {
        this.pmsName = pmsName;
        return this;
    }

    public String getPmsUrl() {
        return pmsUrl;
    }

    public Permissions setPmsUrl(String pmsUrl) {
        this.pmsUrl = pmsUrl;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Permissions setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Permissions setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Permissions setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getReviser() {
        return reviser;
    }

    public Permissions setReviser(String reviser) {
        this.reviser = reviser;
        return this;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public Permissions setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    public String getDescribeInf() {
        return describeInf;
    }

    public Permissions setDescribeInf(String describeInf) {
        this.describeInf = describeInf;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.pmsId;
    }

    @Override
    public String toString() {
        return "Permissions{" +
        "pmsId=" + pmsId +
        ", pmsCode=" + pmsCode +
        ", pmsName=" + pmsName +
        ", pmsUrl=" + pmsUrl +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", reviser=" + reviser +
        ", isDelete=" + isDelete +
        ", describeInf=" + describeInf +
        "}";
    }
}
