package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * MisEmrMdfreq entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_MDFREQ")
public class MisEmrMdfreq implements java.io.Serializable {

    // Fields

    private Long id;
    private String emrId;
    private String reqMember;
    private String recMember;
    private Integer mdfReason;
    private String mdfRemark;
    private Integer reqResult;
    private Date createTime;
    private String recRemark;
    private Date comtagain;
    private Integer red;//read
    private String orgId;


    private String name;
    private String chiefComplaint;
    private String mdfReason_text;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrMdfreq() {
    }

    /**
     * minimal constructor
     */
    public MisEmrMdfreq(Long id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrMdfreq(Long id, String emrId, String reqMember,
                        String recMember, Integer mdfReason, String mdfRemark, Date createTime) {
        this.id = id;
        this.emrId = emrId;
        this.reqMember = reqMember;
        this.recMember = recMember;
        this.mdfReason = mdfReason;
        this.mdfRemark = mdfRemark;
        this.createTime = createTime;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_MDFREQ", sequenceName = "SEQ_MIS_EMR_MDFREQ", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_MDFREQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "REQ_MEMBER", length = 8)
    public String getReqMember() {
        return this.reqMember;
    }

    public void setReqMember(String reqMember) {
        this.reqMember = reqMember;
    }

    @Column(name = "REC_MEMBER", length = 8)
    public String getRecMember() {
        return this.recMember;
    }

    public void setRecMember(String recMember) {
        this.recMember = recMember;
    }

    @Column(name = "MDF_REASON", precision = 4, scale = 0)
    public Integer getMdfReason() {
        return this.mdfReason;
    }

    public void setMdfReason(Integer mdfReason) {
        this.mdfReason = mdfReason;
    }

    @Column(name = "MDF_REMARK", length = 200)
    public String getMdfRemark() {
        return this.mdfRemark;
    }

    public void setMdfRemark(String mdfRemark) {
        this.mdfRemark = mdfRemark;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "REQ_RESULT")
    public Integer getReqResult() {
        return reqResult;
    }

    public void setReqResult(Integer reqResult) {
        this.reqResult = reqResult;
    }

    @Column(name = "REC_REMARK")
    public String getRecRemark() {
        return recRemark;
    }

    public void setRecRemark(String recRemark) {
        this.recRemark = recRemark;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COMTAGAIN", length = 7)
    public Date getComtagain() {
        return comtagain;
    }

    public void setComtagain(Date comtagain) {
        this.comtagain = comtagain;
    }

    @Column(name = "RED")
    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    @Column(name = "ORG_ID")
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Transient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Transient
    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    @Transient
    public String getMdfReason_text() {
        return mdfReason_text;
    }

    public void setMdfReason_text(String mdfReason_text) {
        this.mdfReason_text = mdfReason_text;
    }


}