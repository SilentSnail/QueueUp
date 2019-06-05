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
 * @since 2019-04-23
 */
public class Permissions extends Model<Permissions> {

    private static final long serialVersionUID = 1L;

        /**
     * 资源ID
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 资源编码
     */
         private String code;

        /**
     * 资源名称
     */
         private String name;

        /**
     * 资源URL
     */
         private String url;

        /**
     * 上级ID
     */
         private Integer parentId;

        /**
     * 级别
     */
        private Integer pmsLevel;

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
     * true:删除 false:未删除
     */
         private Boolean delStatus;

    /**
     * 图标
     */
    private String iconSign;

        /**
     * 描述
     */
         private String describeInf;


    public Integer getId() {
        return id;
    }

    public Permissions setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Permissions setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Permissions setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Permissions setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Permissions setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getPmsLevel() {
        return pmsLevel;
    }

    public Permissions setPmsLevel(Integer pmsLevel) {
        this.pmsLevel = pmsLevel;
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

    public Boolean getDelStatus() {
        return delStatus;
    }

    public Permissions setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    public String getIconSign() {
        return iconSign;
    }

    public Permissions setIconSign(String iconSign) {
        this.iconSign = iconSign;
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
        return this.id;
    }

    @Override
    public String toString() {
        return "Permissions{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", url=" + url +
        ", parentId=" + parentId +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", reviser=" + reviser +
        ", delStatus=" + delStatus +
        ", iconSign=" + iconSign +
        ", describeInf=" + describeInf +
        "}";
    }
}
