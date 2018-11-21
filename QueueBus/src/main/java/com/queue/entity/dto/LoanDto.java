package com.queue.entity.dto;

import java.time.LocalDate;

/**
 * Created by liusong on 2018/11/21.
 */
public class LoanDto {

    private String code;
    private Integer loanType;
    private Double amount;
    private LocalDate loanTime;
    private Integer loanChannel;
    private LocalDate repaymentTime;
    private String remark;
    private Integer isIou;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getLoanType() {
        return loanType;
    }

    public void setLoanType(Integer loanType) {
        this.loanType = loanType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(LocalDate loanTime) {
        this.loanTime = loanTime;
    }

    public Integer getLoanChannel() {
        return loanChannel;
    }

    public void setLoanChannel(Integer loanChannel) {
        this.loanChannel = loanChannel;
    }

    public LocalDate getRepaymentTime() {
        return repaymentTime;
    }

    public void setRepaymentTime(LocalDate repaymentTime) {
        this.repaymentTime = repaymentTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsIou() {
        return isIou;
    }

    public void setIsIou(Integer isIou) {
        this.isIou = isIou;
    }
}
