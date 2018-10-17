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
public class Loan extends Model<Loan> {

    private static final long serialVersionUID = 1L;

        /**
     * 借款ID
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        /**
     * 借款Code
     */
         private String code;

        /**
     * 借款类型  1：借出  2：借入
     */
         private Integer loanType;

        /**
     * 借款人姓名
     */
         private String loadName;

        /**
     * 身份证号
     */
         private String idCard;

        /**
     * 手机号
     */
         private String phone;

        /**
     * 借款金额
     */
         private Double amount;

        /**
     * 借款时间
     */
         private LocalDateTime loadTime;

        /**
     * 还款时间
     */
         private LocalDateTime repaymentTime;

        /**
     * 最终还款时间
     */
         private LocalDateTime actualRepaymentTime;

        /**
     * 状态 1：有效  2：无效
     */
         private Integer status;

        /**
     * 备注
     */
         private String remark;

        /**
     * 是否有借据 1：有  0：没有
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

    public String getLoadName() {
        return loadName;
    }

    public Loan setLoadName(String loadName) {
        this.loadName = loadName;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public Loan setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Loan setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Loan setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public LocalDateTime getLoadTime() {
        return loadTime;
    }

    public Loan setLoadTime(LocalDateTime loadTime) {
        this.loadTime = loadTime;
        return this;
    }

    public LocalDateTime getRepaymentTime() {
        return repaymentTime;
    }

    public Loan setRepaymentTime(LocalDateTime repaymentTime) {
        this.repaymentTime = repaymentTime;
        return this;
    }

    public LocalDateTime getActualRepaymentTime() {
        return actualRepaymentTime;
    }

    public Loan setActualRepaymentTime(LocalDateTime actualRepaymentTime) {
        this.actualRepaymentTime = actualRepaymentTime;
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
        ", loadName=" + loadName +
        ", idCard=" + idCard +
        ", phone=" + phone +
        ", amount=" + amount +
        ", loadTime=" + loadTime +
        ", repaymentTime=" + repaymentTime +
        ", actualRepaymentTime=" + actualRepaymentTime +
        ", status=" + status +
        ", remark=" + remark +
        ", isIou=" + isIou +
        "}";
    }
}
