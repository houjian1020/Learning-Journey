package com.springboot.demo.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.UUID;

@TableName("audit_orga_area")
public class AuditOrgaArea {
    @TableId(value = "RowGuid", type = IdType.ASSIGN_UUID)
    private String rowguid;
    @TableField(value = "BelongXiaQuCode")
    private String belongXiaQuCode;

    @TableField(value = "OperateUserName")
    private String operateUserName;

    @TableField(value = "OperateDate")
    private Date operateDate;

    @TableField(value = "ROW_ID")
    private Integer rowId;
    @TableField(value = "YearFlag")
    private String yearFlag;
    @TableField(value = "XiaQuCode")
    private String xiaQuCode;
    @TableField(value = "XiaQuName")
    private String xiaQuName;
    @TableField(value = "OuGuid")
    private String ouGuid;
    @TableField(value = "OuName")
    private String ouName;
    @TableField(value = "CityLevel")
    private String cityLevel;
    @TableField(value = "OrderNum")
    private Integer orderNum;
    @TableField(value = "IndividuationFold")
    private String individuationFold;
    @TableField(value = "siteguid")
    private String siteGuid;
    @TableField(value = "BaseAreaCode")
    private String baseAreaCode;
    @TableField(value = "ADDRESS")
    private String address;
    @TableField(value = "INTROIMG")
    private String introimg;
    @TableField(value = "INTRODUCTION")
    private String introduction;
    @TableField(value = "LINK_TEL")
    private String linkTel;
    @TableField(value = "WORKTIME")
    private String workTime;

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getBelongXiaQuCode() {
        return belongXiaQuCode;
    }

    public void setBelongXiaQuCode(String belongXiaQuCode) {
        this.belongXiaQuCode = belongXiaQuCode;
    }

    public String getOperateUserName() {
        return operateUserName;
    }

    public void setOperateUserName(String operateUserName) {
        this.operateUserName = operateUserName;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setRowId(Integer rowId) {
        this.rowId = rowId;
    }

    public String getYearFlag() {
        return yearFlag;
    }

    public void setYearFlag(String yearFlag) {
        this.yearFlag = yearFlag;
    }

    public String getXiaQuCode() {
        return xiaQuCode;
    }

    public void setXiaQuCode(String xiaQuCode) {
        this.xiaQuCode = xiaQuCode;
    }

    public String getXiaQuName() {
        return xiaQuName;
    }

    public void setXiaQuName(String xiaQuName) {
        this.xiaQuName = xiaQuName;
    }

    public String getOuGuid() {
        return ouGuid;
    }

    public void setOuGuid(String ouGuid) {
        this.ouGuid = ouGuid;
    }

    public String getOuName() {
        return ouName;
    }

    public void setOuName(String ouName) {
        this.ouName = ouName;
    }

    public String getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(String cityLevel) {
        this.cityLevel = cityLevel;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getIndividuationFold() {
        return individuationFold;
    }

    public void setIndividuationFold(String individuationFold) {
        this.individuationFold = individuationFold;
    }

    public String getSiteGuid() {
        return siteGuid;
    }

    public void setSiteGuid(String siteGuid) {
        this.siteGuid = siteGuid;
    }

    public String getBaseAreaCode() {
        return baseAreaCode;
    }

    public void setBaseAreaCode(String baseAreaCode) {
        this.baseAreaCode = baseAreaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroimg() {
        return introimg;
    }

    public void setIntroimg(String introimg) {
        this.introimg = introimg;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLinkTel() {
        return linkTel;
    }

    public void setLinkTel(String linkTel) {
        this.linkTel = linkTel;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }
}
