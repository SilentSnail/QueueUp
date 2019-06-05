package com.queue.entity.dto;

public class PrmsBaseListDto {

    private Integer id;
    private String name;
    private String parentName;
    private String pmsLevel;
    private String describeInf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPmsLevel() {
        return pmsLevel;
    }

    public void setPmsLevel(String pmsLevel) {
        this.pmsLevel = pmsLevel;
    }

    public String getDescribeInf() {
        return describeInf;
    }

    public void setDescribeInf(String describeInf) {
        this.describeInf = describeInf;
    }
}
