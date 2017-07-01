package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * MisEmrChargesNote entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_CHARGES_NOTE")
public class MisEmrChargesNote implements java.io.Serializable {

    // Fields

    private String id;
    private String emrId;
    private Integer chargeType;
    private String itemcode;
    private Double charge;
    private Double received;
    private Double balance;
    private String remark;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrChargesNote() {
    }

    /**
     * minimal constructor
     */
    public MisEmrChargesNote(String id, String emrId) {
        this.id = id;
        this.emrId = emrId;
    }

    /**
     * full constructor
     */
    public MisEmrChargesNote(String id, String emrId, Integer chargeType,
                             String itemcode, Double charge, Double received, Double balance) {
        this.id = id;
        this.emrId = emrId;
        this.chargeType = chargeType;
        this.itemcode = itemcode;
        this.charge = charge;
        this.received = received;
        this.balance = balance;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 40)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", nullable = false, length = 20, updatable = false)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "CHARGE_TYPE", precision = 4, scale = 0, updatable = false)
    public Integer getChargeType() {
        return this.chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    @Column(name = "ITEMCODE", length = 8, updatable = false)
    public String getItemcode() {
        return this.itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    @Column(name = "CHARGE", precision = 8)
    public Double getCharge() {
        return this.charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    @Column(name = "RECEIVED", precision = 8)
    public Double getReceived() {
        return this.received;
    }

    public void setReceived(Double received) {
        this.received = received;
    }

    @Column(name = "BALANCE", precision = 8)
    public Double getBalance() {
        return this.balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Column(name = "REMARK", length = 200)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}