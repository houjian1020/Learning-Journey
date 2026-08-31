package com.springboot.demo.entry;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
import java.util.UUID;

@TableName("audit_orga_area")
public class AuditOrgaArea {
    @TableId(value = "Rowguid", type = IdType.ASSIGN_UUID)
    private String rowguid;
    @TableField(value = "OperateUserName")
    private String operateUserName;
    @TableField(value = "OperateDate")
    private Date operateDate;
    @TableField(value = "XiaQuCode")
    private String xiaQuCode;
    @TableField(value = "XiaQuName")
    private String xiaQuName;
    @TableField(value = "OuGuid")
    private String ouGuid;
    @TableField(value = "OuName")
    private String ouName;
    @TableField(value = "CityLevel")
    private Integer cityLevel;
    @TableField(value = "OrderNum")
    private Integer orderNum;
    @TableField(value = "ADDRESS")
    private String address;

    public String getRowguid() {
        return rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
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

    public Integer getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(Integer cityLevel) {
        this.cityLevel = cityLevel;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
