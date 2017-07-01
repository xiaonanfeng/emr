package com.zxit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * MisEmrScoreType entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_SCORE_TYPE")

public class MisEmrScoreType implements java.io.Serializable {


    // Fields    

    private Integer typeid;
    private String typename;
    private Integer maxscore;
    private String remark;
    private Integer flag;
    private Integer xzbm;
    private Set<MisEmrScoreStandard> misEmrScoreStandards = new HashSet<MisEmrScoreStandard>(0);


    // Constructors

    /**
     * default constructor
     */
    public MisEmrScoreType() {
    }

    /**
     * minimal constructor
     */
    public MisEmrScoreType(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * full constructor
     */
    public MisEmrScoreType(Integer typeid, String typename, Integer maxscore, String remark, Integer flag, Integer xzbm, Set<MisEmrScoreStandard> misEmrScoreStandards) {
        this.typeid = typeid;
        this.typename = typename;
        this.maxscore = maxscore;
        this.remark = remark;
        this.flag = flag;
        this.xzbm = xzbm;
        this.misEmrScoreStandards = misEmrScoreStandards;
    }


    // Property accessors
    @Id

    @Column(name = "TYPEID", unique = true, nullable = false, precision = 8, scale = 0)

    public Integer getTypeid() {
        return this.typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(name = "TYPENAME", length = 128)

    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Column(name = "MAXSCORE", precision = 4, scale = 0)

    public Integer getMaxscore() {
        return this.maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }

    @Column(name = "REMARK", length = 2000)

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "misEmrScoreType")
    public Set<MisEmrScoreStandard> getMisEmrScoreStandards() {
        return this.misEmrScoreStandards;
    }

    public void setMisEmrScoreStandards(Set<MisEmrScoreStandard> misEmrScoreStandards) {
        this.misEmrScoreStandards = misEmrScoreStandards;
    }


}