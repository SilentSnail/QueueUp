package com.queue.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 货币汇率信息
 */
public class ExchangeRate extends Model<ExchangeRate> {

    private Long excId;
    private String convertFrontName;
    private Double convertFrontNum;
    private String convertLaterName;
    private Double convertLaterNum;
    private String searchType;
    private String fraudFrontName;
    private Double fraudFrontNum;
    private String fraudLaterName;
    private Double fraudLaterNum;
    private Date createTime;

    public Long getExcId() {
        return excId;
    }

    public void setExcId(Long excId) {
        this.excId = excId;
    }

    public String getConvertFrontName() {
        return convertFrontName;
    }

    public void setConvertFrontName(String convertFrontName) {
        this.convertFrontName = convertFrontName == null ? null : convertFrontName.trim();
    }

    public Double getConvertFrontNum() {
        return convertFrontNum;
    }

    public void setConvertFrontNum(Double convertFrontNum) {
        this.convertFrontNum = convertFrontNum;
    }

    public String getConvertLaterName() {
        return convertLaterName;
    }

    public void setConvertLaterName(String convertLaterName) {
        this.convertLaterName = convertLaterName == null ? null : convertLaterName.trim();
    }

    public Double getConvertLaterNum() {
        return convertLaterNum;
    }

    public void setConvertLaterNum(Double convertLaterNum) {
        this.convertLaterNum = convertLaterNum;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType == null ? null : searchType.trim();
    }

    public String getFraudFrontName() {
        return fraudFrontName;
    }

    public void setFraudFrontName(String fraudFrontName) {
        this.fraudFrontName = fraudFrontName == null ? null : fraudFrontName.trim();
    }

    public Double getFraudFrontNum() {
        return fraudFrontNum;
    }

    public void setFraudFrontNum(Double fraudFrontNum) {
        this.fraudFrontNum = fraudFrontNum;
    }

    public String getFraudLaterName() {
        return fraudLaterName;
    }

    public void setFraudLaterName(String fraudLaterName) {
        this.fraudLaterName = fraudLaterName == null ? null : fraudLaterName.trim();
    }

    public Double getFraudLaterNum() {
        return fraudLaterNum;
    }

    public void setFraudLaterNum(Double fraudLaterNum) {
        this.fraudLaterNum = fraudLaterNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    protected Serializable pkVal(){ return this.excId; }
}