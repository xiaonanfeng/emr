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
 * MisEmrScoreRecord entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_SCORE_RECORD")
public class MisEmrScoreRecord implements java.io.Serializable {

    // Fields

    private Long id;
    private String emrId;
    private Integer scoreLevel;
    private Integer itemid;
    private Integer time;
    private Double score;
    private Date createTime;
    private String remark;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrScoreRecord() {
    }

    /**
     * minimal constructor
     */
    public MisEmrScoreRecord(Long id, String emrId) {
        this.id = id;
        this.emrId = emrId;
    }

    /**
     * full constructor
     */
    public MisEmrScoreRecord(Long id, String emrId, Integer scoreLevel,
                             Integer itemid, Integer time, Double score, Date createTime) {
        this.id = id;
        this.emrId = emrId;
        this.scoreLevel = scoreLevel;
        this.itemid = itemid;
        this.time = time;
        this.score = score;
        this.createTime = createTime;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_SCORE_RECORD", sequenceName = "SEQ_MIS_EMR_SCORE_RECORD", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_SCORE_RECORD", strategy = GenerationType.SEQUENCE)
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

    @Column(name = "ITEMID", precision = 8, scale = 0)
    public Integer getItemid() {
        return this.itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    @Column(name = "TIME", precision = 4, scale = 0)
    public Integer getTime() {
        return this.time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Column(name = "SCORE", precision = 5)
    public Double getScore() {
        return this.score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "REMARK")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "MisEmrScoreRecord [id=" + id + ", emrId=" + emrId
                + ", scoreLevel=" + scoreLevel + ", itemid=" + itemid
                + ", time=" + time + ", score=" + score + ", createTime="
                + createTime + "]";
    }


}