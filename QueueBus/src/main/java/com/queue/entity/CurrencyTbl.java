package com.queue.entity;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * 货币类型
 */
public class CurrencyTbl extends Model<CurrencyTbl> {

    private Long cId;
    private String curId;
    private String curName;
    private Short curStatus;
    private Short delStatus;

    public Long getcId() {
        return cId;
    }

    public CurrencyTbl setcId(Long cId) {
        this.cId = cId;
        return this;
    }

    public String getCurId() {
        return curId;
    }

    public CurrencyTbl setCurId(String curId) {
        this.curId = curId == null ? null : curId.trim();
        return this;
    }

    public String getCurName() {
        return curName;
    }

    public CurrencyTbl setCurName(String curName) {
        this.curName = curName == null ? null : curName.trim();
        return this;
    }

    public Short getCurStatus() {
        return curStatus;
    }

    public CurrencyTbl setCurStatus(Short curStatus) {
        this.curStatus = curStatus;
        return this;
    }

    public Short getDelStatus() {
        return delStatus;
    }

    public CurrencyTbl setDelStatus(Short delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    protected Serializable pkVal() {
        return this.cId;
    }
}