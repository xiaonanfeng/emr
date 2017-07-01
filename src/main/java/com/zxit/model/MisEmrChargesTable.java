package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

/**
 * MisEmrChargesTable entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_CHARGES_TABLE")
public class MisEmrChargesTable implements java.io.Serializable {

    // Fields

    private String id;
    private Double chargeTotal;
    private Double receivedTotal;
    private Double balanceTotal;
    private Integer reasoncode;
    private String remark;
    private String collectorId;
    private String invoiceNo;
    private String createUserid;
    private Date createTime;
    private String modifyUserid;
    private Date lastModifyTime;
    private Integer xzbm;
    private Integer chargeKind;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrChargesTable() {
    }

    /**
     * minimal constructor
     */
    public MisEmrChargesTable(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrChargesTable(String id, Double chargeTotal,
                              Double receivedTotal, Double balanceTotal, Integer reasoncode,
                              String remark, String collectorId, String invoiceNo,
                              String createUserid, Date createTime, String modifyUserid,
                              Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.chargeTotal = chargeTotal;
        this.receivedTotal = receivedTotal;
        this.balanceTotal = balanceTotal;
        this.reasoncode = reasoncode;
        this.remark = remark;
        this.collectorId = collectorId;
        this.invoiceNo = invoiceNo;
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

    @Column(name = "CHARGE_TOTAL", precision = 8)
    public Double getChargeTotal() {
        return this.chargeTotal;
    }

    public void setChargeTotal(Double chargeTotal) {
        this.chargeTotal = chargeTotal;
    }

    @Column(name = "RECEIVED_TOTAL", precision = 8)
    public Double getReceivedTotal() {
        return this.receivedTotal;
    }

    public void setReceivedTotal(Double receivedTotal) {
        this.receivedTotal = receivedTotal;
    }

    @Column(name = "BALANCE_TOTAL", precision = 8)
    public Double getBalanceTotal() {
        return this.balanceTotal;
    }

    public void setBalanceTotal(Double balanceTotal) {
        this.balanceTotal = balanceTotal;
    }

    @Column(name = "REASONCODE", precision = 4, scale = 0)
    public Integer getReasoncode() {
        return this.reasoncode;
    }

    public void setReasoncode(Integer reasoncode) {
        this.reasoncode = reasoncode;
    }

    @Column(name = "REMARK", length = 200)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "COLLECTOR_ID", length = 8)
    public String getCollectorId() {
        return this.collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    @Column(name = "INVOICE_NO", length = 32)
    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
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

    @Column(name = "CHARGEKIND")
    public Integer getChargeKind() {
        return chargeKind;
    }

    public void setChargeKind(Integer chargeKind) {
        this.chargeKind = chargeKind;
    }

    @Override
    public String toString() {
        return "MisEmrChargesTable [id=" + id + ", chargeTotal=" + chargeTotal
                + ", receivedTotal=" + receivedTotal + ", balanceTotal="
                + balanceTotal + ", reasoncode=" + reasoncode + ", remark="
                + remark + ", collectorId=" + collectorId + ", invoiceNo="
                + invoiceNo + ", createUserid=" + createUserid
                + ", createTime=" + createTime + ", modifyUserid="
                + modifyUserid + ", lastModifyTime=" + lastModifyTime
                + ", xzbm=" + xzbm + "]";
    }


}