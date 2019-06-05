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
 * @since 2019-05-11
 */
public class Authority extends Model<Authority> {

    private static final long serialVersionUID = 1L;

        /**
     * ID
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 编码
     */
         private String code;

        /**
     * 角色ID
     */
         private Integer roleId;

        /**
     * 用户ID
     */
         private Long userId;

        /**
     * 资源ID
     */
         private Integer pmsId;

        /**
     * 权限类型 0 共有权限 1 角色权限 2 用户私有权限
     */
         private Integer autType;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 创建人
     */
         private String creator;

        /**
     * 状态1有效 0 无效
     */
         private Boolean status;

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
     * 描述
     */
         private String describeInf;


    public Integer getId() {
        return id;
    }

    public Authority setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Authority setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public Authority setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Authority setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Integer getPmsId() {
        return pmsId;
    }

    public Authority setPmsId(Integer pmsId) {
        this.pmsId = pmsId;
        return this;
    }

    public Integer getAutType() {
        return autType;
    }

    public Authority setAutType(Integer autType) {
        this.autType = autType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Authority setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Authority setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public Boolean getStatus() {
        return status;
    }

    public Authority setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Authority setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getReviser() {
        return reviser;
    }

    public Authority setReviser(String reviser) {
        this.reviser = reviser;
        return this;
    }

    public Boolean getDelStatus() {
        return delStatus;
    }

    public Authority setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    public String getDescribeInf() {
        return describeInf;
    }

    public Authority setDescribeInf(String describeInf) {
        this.describeInf = describeInf;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Authority{" +
        "id=" + id +
        ", code=" + code +
        ", roleId=" + roleId +
        ", userId=" + userId +
        ", pmsId=" + pmsId +
        ", autType=" + autType +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", status=" + status +
        ", updateTime=" + updateTime +
        ", reviser=" + reviser +
        ", delStatus=" + delStatus +
        ", describeInf=" + describeInf +
        "}";
    }
}
