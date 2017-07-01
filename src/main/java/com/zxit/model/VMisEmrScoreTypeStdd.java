package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VMisEmrScoreTypeStdd entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_SCORE_TYPE_STDD")
public class VMisEmrScoreTypeStdd implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer typeid;
    private Integer flag;
    private String typename;
    private Integer maxscore;
    private String remark;
    private String name;
    private Double value;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrScoreTypeStdd() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrScoreTypeStdd(Integer id, Integer typeid) {
        this.id = id;
        this.typeid = typeid;
    }

    /**
     * full constructor
     */
    public VMisEmrScoreTypeStdd(Integer id, Integer typeid, Integer flag,
                                String typename, Integer maxscore, String remark, String name,
                                Double value) {
        this.id = id;
        this.typeid = typeid;
        this.flag = flag;
        this.typename = typename;
        this.maxscore = maxscore;
        this.remark = remark;
        this.name = name;
        this.value = value;
    }

    // Property accessors
    @Id
    @Column(name = "ID", precision = 8, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "TYPEID", nullable = false, precision = 8, scale = 0)
    public Integer getTypeid() {
        return this.typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    @Column(name = "NAME", length = 800)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "VALUE", precision = 5)
    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}