package com.queue.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liusong
 * @since 2018-11-16
 */
public class Directories extends Model<Directories> {

    private static final long serialVersionUID = 1L;

        /**
     * id
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Long id;

        /**
     * 关联用户编码
     */
         private String userCode;

        /**
     * 联系人名字
     */
         private String name;

        /**
     * 出生年月
     */
         private LocalDate birthday;

        /**
     * 性别
     */
         private String sex;

        /**
     * 身份证号
     */
         private String idCard;

        /**
     * 联系电话
     */
         private String phone;

        /**
     * 邮箱
     */
         private String email;

        /**
     * QQ
     */
         private String qqNo;

        /**
     * 微信
     */
         private String weChat;

        /**
     * 联系地址
     */
         private String address;

        /**
     * 备注
     */
         private String remark;

        /**
     * 标记
     */
         private Integer sign;

        /**
     * 状态
     */
         private Integer status;

        /**
     * 添加时间
     */
         private LocalDateTime createTime;

        /**
     * 更新时间
     */
         private LocalDateTime updateTime;

        /**
     * true:删除 false:未删除
     */
         private Boolean delStatus;


    public Long getId() {
        return id;
    }

    public Directories setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserCode() {
        return userCode;
    }

    public Directories setUserCode(String userCode) {
        this.userCode = userCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public Directories setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Directories setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public Directories setSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getIdCard() {
        return idCard;
    }

    public Directories setIdCard(String idCard) {
        this.idCard = idCard;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Directories setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Directories setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getQqNo() {
        return qqNo;
    }

    public Directories setQqNo(String qqNo) {
        this.qqNo = qqNo;
        return this;
    }

    public String getWeChat() {
        return weChat;
    }

    public Directories setWeChat(String weChat) {
        this.weChat = weChat;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Directories setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public Directories setRemark(String remark) {
        this.remark = remark;
        return this;
    }

    public Integer getSign() {
        return sign;
    }

    public Directories setSign(Integer sign) {
        this.sign = sign;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Directories setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Directories setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public Directories setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public Boolean getDelStatus() {
        return delStatus;
    }

    public Directories setDelStatus(Boolean delStatus) {
        this.delStatus = delStatus;
        return this;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Directories{" +
        "id=" + id +
        ", userCode=" + userCode +
        ", name=" + name +
        ", birthday=" + birthday +
        ", sex=" + sex +
        ", idCard=" + idCard +
        ", phone=" + phone +
        ", email=" + email +
        ", qqNo=" + qqNo +
        ", weChat=" + weChat +
        ", address=" + address +
        ", remark=" + remark +
        ", sign=" + sign +
        ", status=" + status +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", delStatus=" + delStatus +
        "}";
    }
}
