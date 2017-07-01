package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * MisEmrScoreStandard entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_SCORE_STANDARD")
public class MisEmrScoreStandard implements java.io.Serializable {


    // Fields    

    private Integer id;
    private MisEmrScoreType misEmrScoreType;
    private String name;
    private Double value;
    private String remark;
    private Integer flag;
    private Integer xzbm;


    // Constructors

    /**
     * default constructor
     */
    public MisEmrScoreStandard() {
    }

    /**
     * minimal constructor
     */
    public MisEmrScoreStandard(Integer id, MisEmrScoreType misEmrScoreType) {
        this.id = id;
        this.misEmrScoreType = misEmrScoreType;
    }

    /**
     * full constructor
     */
    public MisEmrScoreStandard(Integer id, MisEmrScoreType misEmrScoreType, String name, Double value, String remark, Integer flag, Integer xzbm) {
        this.id = id;
        this.misEmrScoreType = misEmrScoreType;
        this.name = name;
        this.value = value;
        this.remark = remark;
        this.flag = flag;
        this.xzbm = xzbm;
    }


    // Property accessors
    @Id

    @Column(name = "ID", unique = true, nullable = false, precision = 8, scale = 0)

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPEID", nullable = false)

    public MisEmrScoreType getMisEmrScoreType() {
        return this.misEmrScoreType;
    }

    public void setMisEmrScoreType(MisEmrScoreType misEmrScoreType) {
        this.misEmrScoreType = misEmrScoreType;
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


}