package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisEmrScoreConfig entity. @author MyEclipse Persistence Tools
 * 病历评分等级
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_SCORE_CONFIG")
public class MisEmrScoreConfig implements java.io.Serializable {

    // Fields

    private Long id;
    private String scorename;
    private Double startvalue;
    private Double endvalue;
    private Integer flag;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrScoreConfig() {
    }

    /**
     * minimal constructor
     */
    public MisEmrScoreConfig(Long id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrScoreConfig(Long id, String scorename, Double startvalue,
                             Double endvalue, Integer flag, Integer xzbm) {
        this.id = id;
        this.scorename = scorename;
        this.startvalue = startvalue;
        this.endvalue = endvalue;
        this.flag = flag;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "SCORENAME", length = 64)
    public String getScorename() {
        return this.scorename;
    }

    public void setScorename(String scorename) {
        this.scorename = scorename;
    }

    @Column(name = "STARTVALUE", precision = 5)
    public Double getStartvalue() {
        return this.startvalue;
    }

    public void setStartvalue(Double startvalue) {
        this.startvalue = startvalue;
    }

    @Column(name = "ENDVALUE", precision = 5)
    public Double getEndvalue() {
        return this.endvalue;
    }

    public void setEndvalue(Double endvalue) {
        this.endvalue = endvalue;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

}