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

/**
 * MisEmrActivity entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_ACTIVITY")
public class MisEmrActivity implements java.io.Serializable {

    private Long id;
    private String ip;
    private String action;
    private Date actiontime;
    private String orgId;
    private Integer success;
    private String memberId;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrActivity() {
    }

    /**
     * minimal constructor
     */
    public MisEmrActivity(Long id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrActivity(Long id, String ip, String action, Date actiontime,
                          String orgId) {
        this.id = id;
        this.ip = ip;
        this.action = action;
        this.actiontime = actiontime;
        this.orgId = orgId;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_ACTIVITY", sequenceName = "SEQ_MIS_EMR_ACTIVITY", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_ACTIVITY", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "IP", length = 15)
    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "ACTION", length = 50)
    public String getAction() {
        return this.action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACTIONTIME", length = 7)
    public Date getActiontime() {
        return this.actiontime;
    }

    public void setActiontime(Date actiontime) {
        this.actiontime = actiontime;
    }

    @Column(name = "ORG_ID", length = 20)
    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "SUCCESS")
    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    @Column(name = "MEMBERID")
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


}