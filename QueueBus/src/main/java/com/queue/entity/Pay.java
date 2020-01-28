package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2019-06-27
 */
public class Pay extends Model<Pay> {

    private static final long serialVersionUID = 1L;

        /**
     * 订单编码
     */
         @TableId(value = "pay_code", type = IdType.AUTO)
    private String payCode;

        /**
     * 订单号
     */
         private String orderNo;

        /**
     * 商品名称
     */
         private String assetName;

        /**
     * 品牌名称
     */
         private String brandName;

        /**
     * 单价
     */
         private Integer price;

        /**
     * 单价
     */
         private Integer num;

        /**
     * 附加费
     */
         private Integer surcharge;

        /**
     * 支出时间
     */
         private LocalDateTime payTime;

        /**
     * 计量单位
     */
         private String measure;

        /**
     * 收款人
     */
         private String payee;

        /**
     * 付款方式
     */
         private String payType;

        /**
     * 支付状态
     */
         private String payStatus;

        /**
     * 交易流水号
     */
         private String payNo;

        /**
     * 是否有发票
     */
         private Boolean hasInvoice;

        /**
     * 备注
     */
         private String remark;

        /**
     * 创建时间
     */
         private LocalDateTime createTime;

        /**
     * 创建人
     */
         private String creator;

        /**
     * 删除时间
     */
         private LocalDateTime delTime;

        /**
     * 是否删除
     */
         private Boolean delStatus;


    public String getPayCode() {
        return payCode;
    }

    public Pay setPayCode(String payCode) {
        this.payCode = payCode;
        return this;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public Pay setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String getAssetName() {
        return assetName;
    }

    public Pay setAssetName(String assetName) {
        this.assetName = assetName;
        return this;
    }

    public String getBrandName() {
        return brandName;
    }

    public Pay setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Pay setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public Pay setNum(Integer num) {
        this.num = num;
        return this;
    }

    public Integer getSurcharge() {
        return surcharge;
    }

    public Pay setSurcharge(Integer surcharge) {
        this.surcharge = surcharge;
        return this;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public Pay setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
        return this;
    }

    public String getMeasure() {
        return measure;
    }

    public Pay setMeasure(String measure) {
        this.measure = measure;
        return this;
    }

    public String getPayee() {
        return payee;
    }

    public Pay setPayee(String payee) {
        this.payee = payee;
        return this;
    }

    public String getPayType() {
        return payType;
    }

    public Pay setPayType(String payType) {
        this.payType = payType;
        return this;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public Pay setPayStatus(String payStatus) {
        this.payStatus = payStatus;
        return this;
    }

    public String getPayNo() {
        return payNo;
    }

    public Pay setPayNo(String payNo) {
        this.payNo = payNo;
        return this;
    }

    public Boolean getHasInvoice() {
        return hasInvoice;
    }

    public Pay setHasInvoice(Boolean hasInvoice) {
        this.hasInvoice = hasInvoice;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Pay setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Pay setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Pay setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public LocalDateTime getDelTime() {
        return delTime;
    }

    public Pay setDelTime(LocalDateTime delTime) {
        this.delTime = delTime;
        return this;
    }

    public Boolean getDelStatus() {
        return delStatus;
    }

    public Pay setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.payCode;
    }

    @Override
    public String toString() {
        return "Pay{" +
        "payCode=" + payCode +
        ", orderNo=" + orderNo +
        ", assetName=" + assetName +
        ", brandName=" + brandName +
        ", price=" + price +
        ", num=" + num +
        ", surcharge=" + surcharge +
        ", payTime=" + payTime +
        ", measure=" + measure +
        ", payee=" + payee +
        ", payType=" + payType +
        ", payStatus=" + payStatus +
        ", payNo=" + payNo +
        ", hasInvoice=" + hasInvoice +
        ", remark=" + remark +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", delTime=" + delTime +
        ", delStatus=" + delStatus +
        "}";
    }
}
