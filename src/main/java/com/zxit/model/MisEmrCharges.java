package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

/**
 * MisEmrCharges entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_CHARGES")
public class MisEmrCharges implements java.io.Serializable {

    // Fields

    private String id;
    private String emrId;
    private Integer type;
    private String itemcode;
    private Double charge;
    private Double received;
    private Double balance;
    private Integer reasoncode;
    private String remark;
    private String collectorId;
    private String collectorText;

    private String invoiceNo;

    private String createUserid;
    private String modifyUserid;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    private String type_text;
    private String reason_text;


    // Constructors

    /**
     * default constructor
     */
    public MisEmrCharges() {
    }

    /**
     * minimal constructor
     */
    public MisEmrCharges(String id, String emrId, Date createTime) {
        this.id = id;
        this.emrId = emrId;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrCharges(String id, String emrId, Integer type, String itemcode,
                         Double charge, Double received,
                         String remark, String createUserid, Date createTime,
                         String modifyUserid, Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.emrId = emrId;
        this.type = type;
        this.itemcode = itemcode;
        this.charge = charge;
        this.received = received;
        this.remark = remark;
        this.createUserid = createUserid;
        this.createTime = createTime;
        this.modifyUserid = modifyUserid;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", nullable = false, length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
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

    @Column(name = "REMARK", length = 200)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "CREATE_USERID", length = 8, updatable = false)
    public String getCreateUserid() {
        return this.createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    @Column(name = "MODIFY_USERID", length = 8)
    public String getModifyUserid() {
        return this.modifyUserid;
    }

    public void setModifyUserid(String modifyUserid) {
        this.modifyUserid = modifyUserid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false, length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFY_TIME", length = 7)
    public Date getLastModifyTime() {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

    @Column(name = "BALANCE")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Column(name = "REASONCODE")
    public Integer getReasoncode() {
        return reasoncode;
    }

    public void setReasoncode(Integer reasoncode) {
        this.reasoncode = reasoncode;
    }

    @Column(name = "COLLECTOR_ID")
    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    @Column(name = "INVOICE_NO")
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Transient
    public String getType_text() {
        return type_text;
    }

    public void setType_text(String type_text) {
        this.type_text = type_text;
    }

    @Transient
    public String getReason_text() {
        return reason_text;
    }

    public void setReason_text(String reason_text) {
        this.reason_text = reason_text;
    }

    @Transient
    public String getCollectorText() {
        return collectorText;
    }

    public void setCollectorText(String collectorText) {
        this.collectorText = collectorText;
    }


}