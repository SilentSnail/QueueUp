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
 * @since 2019-06-18
 */
public class ForageType extends Model<ForageType> {

    private static final long serialVersionUID = 1L;

        /**
     * 编码
     */
         @TableId(value = "code", type = IdType.ID_WORKER_STR)
    private String code;

        /**
     * 种类名称
     */
         private String forageName;

        /**
     * 上级编码
     */
         private String parentCode;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 创建人
     */
         private String creator;

        /**
     * 状态 1有效 0 无效
     */
         private Integer status;

        /**
     * 更新人
     */
         private String updator;

        /**
     * 更新时间
     */
         private LocalDateTime updateTime;

        /**
     * true 删除 false 未删除
     */
         private Boolean delStatus;

        /**
     * true 删除 false 未删除
     */
         private Integer typeLevel;


    public String getCode() {
        return code;
    }

    public ForageType setCode(String code) {
        this.code = code;
        return this;
    }

    public String getForageName() {
        return forageName;
    }

    public ForageType setForageName(String forageName) {
        this.forageName = forageName;
        return this;
    }

    public String getParentCode() {
        return parentCode;
    }

    public ForageType setParentCode(String parentCode) {
        this.parentCode = parentCode;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ForageType setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public ForageType setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ForageType setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getUpdator() {
        return updator;
    }

    public ForageType setUpdator(String updator) {
        this.updator = updator;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public ForageType setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Boolean getDelStatus() {
        return delStatus;
    }

    public ForageType setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    public Integer getTypeLevel() {
        return typeLevel;
    }

    public void setTypeLevel(Integer typeLevel) {
        this.typeLevel = typeLevel;
    }

    @Override
    protected Serializable pkVal() {
        return this.code;
    }

    @Override
    public String toString() {
        return "ForageType{" +
        "code=" + code +
        ", forageName=" + forageName +
        ", parentCode=" + parentCode +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", status=" + status +
        ", updator=" + updator +
        ", updateTime=" + updateTime +
        ", delStatus=" + delStatus +
        ", typeLevel=" + typeLevel +
        "}";
    }
}
