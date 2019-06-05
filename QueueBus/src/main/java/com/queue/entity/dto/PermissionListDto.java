package com.queue.entity.dto;

import java.time.LocalDateTime;

public class PermissionListDto {

    private String code;//资源ID
    private String name;//资源名称
    private String url;//资源URL
    private int parentId;//上级ID
    private LocalDateTime createTime;//创建时间
    private String creator;//创建人
    private String reviser;//更新人
    private String describeInf;//描述

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getReviser() {
        return reviser;
    }

    public void setReviser(String reviser) {
        this.reviser = reviser;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getDescribeInf() {
        return describeInf;
    }

    public void setDescribeInf(String describeInf) {
        this.describeInf = describeInf;
    }
}
