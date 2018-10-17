package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-10-17
 */
public class CurrencyTbl extends Model<CurrencyTbl> {

    private static final long serialVersionUID = 1L;

        /**
     * 货币类型ID
     */
         @TableId(value = "C_ID", type = IdType.AUTO)
    private Long cId;

        /**
     * 货币类型Code
     */
         private String curId;

        /**
     * 货币类型名称
     */
         private String curName;

        /**
     * 货币类型状态 1：有效  0：无效
     */
         private Integer curStatus;

        /**
     * 删除状态 1:删除 0:未删除
     */
         private Integer delStatus;


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
        this.curId = curId;
        return this;
    }

    public String getCurName() {
        return curName;
    }

    public CurrencyTbl setCurName(String curName) {
        this.curName = curName;
        return this;
    }

    public Integer getCurStatus() {
        return curStatus;
    }

    public CurrencyTbl setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
        return this;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public CurrencyTbl setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.cId;
    }

    @Override
    public String toString() {
        return "CurrencyTbl{" +
        "cId=" + cId +
        ", curId=" + curId +
        ", curName=" + curName +
        ", curStatus=" + curStatus +
        ", delStatus=" + delStatus +
        "}";
    }
}
