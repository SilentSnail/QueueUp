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
public class ExchangeRate extends Model<ExchangeRate> {

    private static final long serialVersionUID = 1L;

        /**
     * 汇率ID
     */
         @TableId(value = "EXC_ID", type = IdType.AUTO)
    private Long excId;

        /**
     * 转换前名称
     */
         private String convertFrontName;

        /**
     * 转换前金额
     */
         private Double convertFrontNum;

        /**
     * 转换后名称
     */
         private String convertLaterName;

        /**
     * 转换后金额
     */
         private Double convertLaterNum;

        /**
     * 转换类型
     */
         private String searchType;

        /**
     * 互相转换名称
     */
         private String fraudFrontName;

        /**
     * 互相转换金额
     */
         private Double fraudFrontNum;

        /**
     * 互相转换后名称
     */
         private String fraudLaterName;

        /**
     * 互相转换后金额
     */
         private Double fraudLaterNum;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;


    public Long getExcId() {
        return excId;
    }

    public ExchangeRate setExcId(Long excId) {
        this.excId = excId;
        return this;
    }

    public String getConvertFrontName() {
        return convertFrontName;
    }

    public ExchangeRate setConvertFrontName(String convertFrontName) {
        this.convertFrontName = convertFrontName;
        return this;
    }

    public Double getConvertFrontNum() {
        return convertFrontNum;
    }

    public ExchangeRate setConvertFrontNum(Double convertFrontNum) {
        this.convertFrontNum = convertFrontNum;
        return this;
    }

    public String getConvertLaterName() {
        return convertLaterName;
    }

    public ExchangeRate setConvertLaterName(String convertLaterName) {
        this.convertLaterName = convertLaterName;
        return this;
    }

    public Double getConvertLaterNum() {
        return convertLaterNum;
    }

    public ExchangeRate setConvertLaterNum(Double convertLaterNum) {
        this.convertLaterNum = convertLaterNum;
        return this;
    }

    public String getSearchType() {
        return searchType;
    }

    public ExchangeRate setSearchType(String searchType) {
        this.searchType = searchType;
        return this;
    }

    public String getFraudFrontName() {
        return fraudFrontName;
    }

    public ExchangeRate setFraudFrontName(String fraudFrontName) {
        this.fraudFrontName = fraudFrontName;
        return this;
    }

    public Double getFraudFrontNum() {
        return fraudFrontNum;
    }

    public ExchangeRate setFraudFrontNum(Double fraudFrontNum) {
        this.fraudFrontNum = fraudFrontNum;
        return this;
    }

    public String getFraudLaterName() {
        return fraudLaterName;
    }

    public ExchangeRate setFraudLaterName(String fraudLaterName) {
        this.fraudLaterName = fraudLaterName;
        return this;
    }

    public Double getFraudLaterNum() {
        return fraudLaterNum;
    }

    public ExchangeRate setFraudLaterNum(Double fraudLaterNum) {
        this.fraudLaterNum = fraudLaterNum;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ExchangeRate setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.excId;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
        "excId=" + excId +
        ", convertFrontName=" + convertFrontName +
        ", convertFrontNum=" + convertFrontNum +
        ", convertLaterName=" + convertLaterName +
        ", convertLaterNum=" + convertLaterNum +
        ", searchType=" + searchType +
        ", fraudFrontName=" + fraudFrontName +
        ", fraudFrontNum=" + fraudFrontNum +
        ", fraudLaterName=" + fraudLaterName +
        ", fraudLaterNum=" + fraudLaterNum +
        ", createTime=" + createTime +
        "}";
    }
}
