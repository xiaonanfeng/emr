package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisEmrChargeItems entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_CHARGE_ITEMS")
public class MisEmrChargeItems implements java.io.Serializable {

    // Fields

    private String id;
    private Integer type;
    private String itemcode;
    private String itemname;
    private Double standards;
    private Integer flag;
    private String remark;
    private Integer xzbm;
    private Integer sortId;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrChargeItems() {
    }

    /**
     * minimal constructor
     */
    public MisEmrChargeItems(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrChargeItems(String id, Integer type, String itemcode,
                             String itemname, Double standards, Integer flag, String remark,
                             Integer xzbm) {
        this.id = id;
        this.type = type;
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.standards = standards;
        this.flag = flag;
        this.remark = remark;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 8)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "TYPE", precision = 4, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "ITEMCODE", length = 8)
    public String getItemcode() {
        return this.itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    @Column(name = "ITEMNAME", length = 64)
    public String getItemname() {
        return this.itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Column(name = "STANDARDS", precision = 8)
    public Double getStandards() {
        return this.standards;
    }

    public void setStandards(Double standards) {
        this.standards = standards;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "REMARK", length = 200)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

    @Column(name = "SORT_ID")
    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }


}