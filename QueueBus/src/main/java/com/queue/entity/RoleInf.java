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
public class RoleInf extends Model<RoleInf> {

    private static final long serialVersionUID = 1L;

        /**
     * 角色ID
     */
         @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

        /**
     * 角色编码
     */
         private String roleCode;

        /**
     * 角色名称
     */
         private String roleName;

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
     * 修改人
     */
         private String reviser;

        /**
     * 是否删除
     */
         private Boolean isDelete;


    public Integer getRoleId() {
        return roleId;
    }

    public RoleInf setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public RoleInf setRoleCode(String roleCode) {
        this.roleCode = roleCode;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleInf setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public RoleInf setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public RoleInf setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public RoleInf setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getReviser() {
        return reviser;
    }

    public RoleInf setReviser(String reviser) {
        this.reviser = reviser;
        return this;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public RoleInf setDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    @Override
    public String toString() {
        return "RoleInf{" +
        "roleId=" + roleId +
        ", roleCode=" + roleCode +
        ", roleName=" + roleName +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", reviser=" + reviser +
        ", isDelete=" + isDelete +
        "}";
    }
}
