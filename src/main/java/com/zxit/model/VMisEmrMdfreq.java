package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VMisEmrMdfreq entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_MDFREQ")
public class VMisEmrMdfreq implements java.io.Serializable {

    // Fields

    private Long id;
    private Integer reqResult;
    private Date createTime;
    private Integer timescope;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrMdfreq() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrMdfreq(Long id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public VMisEmrMdfreq(Long id, Integer reqResult, Date createTime,
                         Integer timescope) {
        this.id = id;
        this.reqResult = reqResult;
        this.createTime = createTime;
        this.timescope = timescope;
    }

    // Property accessors
    @Id
    @Column(name = "ID", nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "REQ_RESULT", precision = 1, scale = 0)
    public Integer getReqResult() {
        return this.reqResult;
    }

    public void setReqResult(Integer reqResult) {
        this.reqResult = reqResult;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "TIMESCOPE", precision = 22, scale = 0)
    public Integer getTimescope() {
        return this.timescope;
    }

    public void setTimescope(Integer timescope) {
        this.timescope = timescope;
    }

}