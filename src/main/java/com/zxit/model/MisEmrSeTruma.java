package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;


/**
 * MIS_电子病历_专项_创伤
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_SE_TRUMA")
public class MisEmrSeTruma implements java.io.Serializable {

    // Fields

    private String id;
    private Integer phiTotal;
    private Integer phiBr;
    private Integer phiCons;
    private Integer phiSbp;
    private Integer phiPr;
    private Integer dglsTotal;
    private Integer dglsEr;
    private Integer dglsVr;
    private Integer dglsMr;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrSeTruma() {
    }

    /**
     * minimal constructor
     */
    public MisEmrSeTruma(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrSeTruma(String id, Integer phiTotal, Integer phiBr, Integer phiCons,
                         Integer phiSbp, Integer phiPr, Integer dglsTotal, Integer dglsEr,
                         Integer dglsVr, Integer dglsMr, Date createTime, Date lastModifyTime,
                         Integer xzbm) {
        this.id = id;
        this.phiTotal = phiTotal;
        this.phiBr = phiBr;
        this.phiCons = phiCons;
        this.phiSbp = phiSbp;
        this.phiPr = phiPr;
        this.dglsTotal = dglsTotal;
        this.dglsEr = dglsEr;
        this.dglsVr = dglsVr;
        this.dglsMr = dglsMr;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "PHI_TOTAL", precision = 4, scale = 0)
    public Integer getPhiTotal() {
        return this.phiTotal;
    }

    public void setPhiTotal(Integer phiTotal) {
        this.phiTotal = phiTotal;
    }

    @Column(name = "PHI_BR", precision = 4, scale = 0)
    public Integer getPhiBr() {
        return this.phiBr;
    }

    public void setPhiBr(Integer phiBr) {
        this.phiBr = phiBr;
    }

    @Column(name = "PHI_CONS", precision = 4, scale = 0)
    public Integer getPhiCons() {
        return this.phiCons;
    }

    public void setPhiCons(Integer phiCons) {
        this.phiCons = phiCons;
    }

    @Column(name = "PHI_SBP", precision = 4, scale = 0)
    public Integer getPhiSbp() {
        return this.phiSbp;
    }

    public void setPhiSbp(Integer phiSbp) {
        this.phiSbp = phiSbp;
    }

    @Column(name = "PHI_PR", precision = 4, scale = 0)
    public Integer getPhiPr() {
        return this.phiPr;
    }

    public void setPhiPr(Integer phiPr) {
        this.phiPr = phiPr;
    }

    @Column(name = "DGLS_TOTAL", precision = 4, scale = 0)
    public Integer getDglsTotal() {
        return this.dglsTotal;
    }

    public void setDglsTotal(Integer dglsTotal) {
        this.dglsTotal = dglsTotal;
    }

    @Column(name = "DGLS_ER", precision = 4, scale = 0)
    public Integer getDglsEr() {
        return this.dglsEr;
    }

    public void setDglsEr(Integer dglsEr) {
        this.dglsEr = dglsEr;
    }

    @Column(name = "DGLS_VR", precision = 4, scale = 0)
    public Integer getDglsVr() {
        return this.dglsVr;
    }

    public void setDglsVr(Integer dglsVr) {
        this.dglsVr = dglsVr;
    }

    @Column(name = "DGLS_MR", precision = 4, scale = 0)
    public Integer getDglsMr() {
        return this.dglsMr;
    }

    public void setDglsMr(Integer dglsMr) {
        this.dglsMr = dglsMr;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false, length = 7, updatable = false)
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