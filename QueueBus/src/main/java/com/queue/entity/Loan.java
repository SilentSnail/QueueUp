package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-11-20
 */
public class Loan extends Model<Loan> {

    private static final long serialVersionUID = 1L;

        /**
     * 唯一标识
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        /**
     * 借出唯一编码
     */
         private String code;

        /**
     * 类型 0借出 1借入
     */
         private Integer loanType;

        /**
     * 借款人ID
     */
         private Long userId;

        /**
     * 借款金额
     */
         private Double amount;

        /**
     * 借款日期
     */
         private LocalDate loanTime;

        /**
     * 承诺还款时间
     */
         private LocalDate repaymentTime;

        /**
     * 状态 1有效 0 无效
     */
         private Integer status;

        /**
     * 备注
     */
         private String remark;

        /**
     * 是否有欠条
     */
         private Integer isIou;


    public Long getId() {
        return id;
    }

    public Loan setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Loan setCode(String code) {
        this.code = code;
        return this;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public Loan setLoanType(Integer loanType) {
        this.loanType = loanType;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Loan setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Loan setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public LocalDate getLoanTime() {
        return loanTime;
    }

    public Loan setLoanTime(LocalDate loanTime) {
        this.loanTime = loanTime;
        return this;
    }

    public LocalDate getRepaymentTime() {
        return repaymentTime;
    }

    public Loan setRepaymentTime(LocalDate repaymentTime) {
        this.repaymentTime = repaymentTime;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Loan setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Loan setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getIsIou() {
        return isIou;
    }

    public Loan setIsIou(Integer isIou) {
        this.isIou = isIou;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Loan{" +
        "id=" + id +
        ", code=" + code +
        ", loanType=" + loanType +
        ", userId=" + userId +
        ", amount=" + amount +
        ", loanTime=" + loanTime +
        ", repaymentTime=" + repaymentTime +
        ", status=" + status +
        ", remark=" + remark +
        ", isIou=" + isIou +
        "}";
    }
}
