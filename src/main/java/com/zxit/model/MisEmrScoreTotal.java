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
import javax.persistence.UniqueConstraint;

/**
 * MisEmrScoreTotal entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_SCORE_TOTAL", uniqueConstraints = @UniqueConstraint(columnNames = {
        "EMR_ID", "SCORE_LEVEL"}))
public class MisEmrScoreTotal implements java.io.Serializable {

    // Fields

    private Long id;
    private String emrId;
    private Integer scoreLevel;
    private Double totalScore;
    private String createUserid;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrScoreTotal() {
    }

    /**
     * minimal constructor
     */
    public MisEmrScoreTotal(Long id, String emrId) {
        this.id = id;
        this.emrId = emrId;
    }

    /**
     * full constructor
     */
    public MisEmrScoreTotal(Long id, String emrId, Integer scoreLevel,
                            Double totalScore, String createUserid, Date createTime,
                            Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.emrId = emrId;
        this.scoreLevel = scoreLevel;
        this.totalScore = totalScore;
        this.createUserid = createUserid;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_SCORE_TOTAL", sequenceName = "SEQ_MIS_EMR_SCORE_TOTAL", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_SCORE_TOTAL", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", nullable = false, length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "SCORE_LEVEL", precision = 4, scale = 0)
    public Integer getScoreLevel() {
        return this.scoreLevel;
    }

    public void setScoreLevel(Integer scoreLevel) {
        this.scoreLevel = scoreLevel;
    }

    @Column(name = "TOTAL_SCORE", precision = 5)
    public Double getTotalScore() {
        return this.totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    @Column(name = "CREATE_USERID", length = 8)
    public String getCreateUserid() {
        return this.createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 7, updatable = false)
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

}