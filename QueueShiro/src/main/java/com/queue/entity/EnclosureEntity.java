package com.queue.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;

/**
 * Created by liusong on 2018/7/6.
 */
public class EnclosureEntity {

    private String enCode;
    private String fileName;//文件名称
    private String assetsCode;//资产Code
    private String sourcePath;//资源地址
    private Date createTime;//上传时间
    private String creator;//上传人
    private Integer status;//状态
    private Integer delStatus;//是否删除

    public String getEnCode() {
        return enCode;
    }

    public void setEnCode(String enCode) {
        this.enCode = enCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAssetsCode() {
        return assetsCode;
    }

    public void setAssetsCode(String assetsCode) {
        this.assetsCode = assetsCode;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public EnclosureEntity(){}

    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
