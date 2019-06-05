package com.queue.entity.vo;

public class PermissionSaveVo {

    private String code;
    private String name;
    private String url;
    private Integer parentId;
    private String describeInf;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getDescribeInf() {
        return describeInf;
    }

    public void setDescribeInf(String describeInf) {
        this.describeInf = describeInf;
    }
}
