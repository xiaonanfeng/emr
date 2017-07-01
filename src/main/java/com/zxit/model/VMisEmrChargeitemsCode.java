package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VMisEmrChargeitemsCode entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_CHARGEITEMS_CODE")
public class VMisEmrChargeitemsCode implements java.io.Serializable {

    // Fields

    private String id;
    private String itemcode;
    private String itemname;
    private Integer type;
    private Double standards;
    private Integer flag;
    private Integer sortId;
    private String name;
    private Integer code;
    private Integer orderid;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrChargeitemsCode() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrChargeitemsCode(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public VMisEmrChargeitemsCode(String id, String itemcode, String itemname,
                                  Integer type, Double standards, Integer flag, Integer sortId,
                                  String name, Integer code, Integer orderid) {
        this.id = id;
        this.itemcode = itemcode;
        this.itemname = itemname;
        this.type = type;
        this.standards = standards;
        this.flag = flag;
        this.sortId = sortId;
        this.name = name;
        this.code = code;
        this.orderid = orderid;
    }

    // Property accessors
    @Id
    @Column(name = "ID", nullable = false, length = 8)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Column(name = "TYPE", precision = 4, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Column(name = "SORT_ID", precision = 4, scale = 0)
    public Integer getSortId() {
        return this.sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Column(name = "NAME", length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "CODE", precision = 4, scale = 0)
    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(name = "ORDERID", precision = 4, scale = 0)
    public Integer getOrderid() {
        return this.orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

}