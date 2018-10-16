package com.queue.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色信息
 */
public class RoleInf extends Model<RoleInf> {

    private Short roleId;
    private String roleCode;
    private String roleName;
    private Date createTime;
    private String creator;
    private Date updateTime;
    private String reviser;
    private Boolean isDelete;

    public Short getRoleId() {
        return roleId;
    }

    public RoleInf setRoleId(Short roleId) {
        this.roleId = roleId;
        return this;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public RoleInf setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleInf setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public RoleInf setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public RoleInf setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public RoleInf setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getReviser() {
        return reviser;
    }

    public RoleInf setReviser(String reviser) {
        this.reviser = reviser == null ? null : reviser.trim();
        return this;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public RoleInf setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
        return this;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }

    protected Serializable pkVal() {
        return this.roleId;
    }
}