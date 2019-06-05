package com.queue.entity.dto;

public class PermissionDto {

    private String code;
    private String name;
    private String url;
    private String describeInf;
    private Integer parentId;
    private Integer pmsLevel;
    private String baseName;
    private String iconSign;

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

    public String getDescribeInf() {
        return describeInf;
    }

    public void setDescribeInf(String describeInf) {
        this.describeInf = describeInf;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getPmsLevel() {
        return pmsLevel;
    }

    public void setPmsLevel(Integer pmsLevel) {
        this.pmsLevel = pmsLevel;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getIconSign() {
        return iconSign;
    }

    public void setIconSign(String iconSign) {
        this.iconSign = iconSign;
    }
}
