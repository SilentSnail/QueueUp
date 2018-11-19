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
 * @since 2018-11-09
 */
public class Authority extends Model<Authority> {

    private static final long serialVersionUID = 1L;

        /**
     * 权限ID
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 权限编码
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
         private Integer resId;

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
         private Integer status;

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

    public Integer getResId() {
        return resId;
    }

    public Authority setResId(Integer resId) {
        this.resId = resId;
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

    public Integer getStatus() {
        return status;
    }

    public Authority setStatus(Integer status) {
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
        ", resId=" + resId +
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
