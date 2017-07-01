package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VMisEmrCommit entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_COMMIT")
public class VMisEmrCommit implements java.io.Serializable {

    // Fields

    private String id;
    private Date createTime;
    private Integer committimescope;
    private Integer isCommitted;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrCommit() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrCommit(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public VMisEmrCommit(String id, Date createTime, Integer committimescope) {
        this.id = id;
        this.createTime = createTime;
        this.committimescope = committimescope;
    }

    // Property accessors
    @Id
    @Column(name = "ID", nullable = false, length = 20)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATE_TIME", nullable = false, length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "COMMITTIMESCOPE", precision = 22, scale = 0)
    public Integer getCommittimescope() {
        return this.committimescope;
    }

    public void setCommittimescope(Integer committimescope) {
        this.committimescope = committimescope;
    }

    @Column(name = "IS_COMMITTED")
    public Integer getIsCommitted() {
        return isCommitted;
    }

    public void setIsCommitted(Integer isCommitted) {
        this.isCommitted = isCommitted;
    }

}