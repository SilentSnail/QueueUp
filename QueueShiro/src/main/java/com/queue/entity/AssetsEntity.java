package com.queue.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;
import java.util.Map;

/**
 * 固定资产实体类
 * Created by liusong on 2018/7/6.
 */
public class AssetsEntity {

    private String code;//编码
    private Date inputDate;//输入日期
    private Integer buyNum;//数量
    private String unitName;//领用单位名称
    private String unitNumber;//领用单位编号
    private Double price;//单价
    private String cateGoryCode;//分类号
    private String cateGoryName;//分类名称
    private String assetsName;//资产名称
    private String assetType;//资产型号
    private String assetsSpec;//规格
    private String vendorName;//厂商名称
    private String vendorCode;//出厂号
    private Date buyDate;//购置日期
    private Date productionDate;//出厂日期
    private Date warrantyPeriod;//保修期限
    private String countryCode;//国码
    private String countryName;//国别
    private String invoiceCode;//发票号码
    private String acceptCode;//验收编号
    private String currStatus;//现状
    private String fundsSubject;//经费科目
    private String userCode;//领用人
    private String assetsOrigin;//设备来源
    private String useDirection;//使用方向
    private String buyType;//采购方式
    private String fundsCardNo;//经费卡号
    private String fundsDirector;//经费负责人
    private String supplierName;//供货商
    private Integer depreciationType;//折旧方式
    private String depositId;//存放地编号
    private String depositAddress;//存放地名称
    private Integer isImport;//是否为进口设备
    private String importContractNo;//进口合同号
    private String dutyFreeNO;//免税单号
    private Double foreignCurrency;//外币价格
    private Double lateFee;//滞纳金
    private String importDirector;//负责人
    private String remark;//备注
    private String position;//经纬度, 以逗号分隔
    private Map<String, EnclosureEntity> enclosures;//附件

    private Integer status;
    private Integer delStatus;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCateGoryCode() {
        return cateGoryCode;
    }

    public void setCateGoryCode(String cateGoryCode) {
        this.cateGoryCode = cateGoryCode;
    }

    public String getCateGoryName() {
        return cateGoryName;
    }

    public void setCateGoryName(String cateGoryName) {
        this.cateGoryName = cateGoryName;
    }

    public String getAssetsName() {
        return assetsName;
    }

    public void setAssetsName(String assetsName) {
        this.assetsName = assetsName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetsSpec() {
        return assetsSpec;
    }

    public void setAssetsSpec(String assetsSpec) {
        this.assetsSpec = assetsSpec;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Date warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getAcceptCode() {
        return acceptCode;
    }

    public void setAcceptCode(String acceptCode) {
        this.acceptCode = acceptCode;
    }

    public String getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(String currStatus) {
        this.currStatus = currStatus;
    }

    public String getFundsSubject() {
        return fundsSubject;
    }

    public void setFundsSubject(String fundsSubject) {
        this.fundsSubject = fundsSubject;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAssetsOrigin() {
        return assetsOrigin;
    }

    public void setAssetsOrigin(String assetsOrigin) {
        this.assetsOrigin = assetsOrigin;
    }

    public String getUseDirection() {
        return useDirection;
    }

    public void setUseDirection(String useDirection) {
        this.useDirection = useDirection;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public String getFundsCardNo() {
        return fundsCardNo;
    }

    public void setFundsCardNo(String fundsCardNo) {
        this.fundsCardNo = fundsCardNo;
    }

    public String getFundsDirector() {
        return fundsDirector;
    }

    public void setFundsDirector(String fundsDirector) {
        this.fundsDirector = fundsDirector;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getDepreciationType() {
        return depreciationType;
    }

    public void setDepreciationType(Integer depreciationType) {
        this.depreciationType = depreciationType;
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getDepositAddress() {
        return depositAddress;
    }

    public void setDepositAddress(String depositAddress) {
        this.depositAddress = depositAddress;
    }

    public Integer getIsImport() {
        return isImport;
    }

    public void setIsImport(Integer isImport) {
        this.isImport = isImport;
    }

    public String getImportContractNo() {
        return importContractNo;
    }

    public void setImportContractNo(String importContractNo) {
        this.importContractNo = importContractNo;
    }

    public String getDutyFreeNO() {
        return dutyFreeNO;
    }

    public void setDutyFreeNO(String dutyFreeNO) {
        this.dutyFreeNO = dutyFreeNO;
    }

    public Double getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(Double foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public String getImportDirector() {
        return importDirector;
    }

    public void setImportDirector(String importDirector) {
        this.importDirector = importDirector;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Map<String, EnclosureEntity> getEnclosures() {
        return enclosures;
    }

    public void setEnclosures(Map<String, EnclosureEntity> enclosures) {
        this.enclosures = enclosures;
    }

    public void addEnclosures(String key, EnclosureEntity source){
        if(this.getEnclosures() != null)
            this.getEnclosures().put(key, source);
    }

    public void delEnclosures(String key){
        if(this.getEnclosures() != null)
            this.getEnclosures().remove(key);
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

    public AssetsEntity(){}

    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
