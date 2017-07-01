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

import org.springframework.format.annotation.DateTimeFormat;

/**
 * VMisEmrAar entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_AAR")
public class VMisEmrAar implements java.io.Serializable {

    // Fields

    private Long id;
    private String emrId;
    private Long artcId;
    private Date useTime;
    private Integer amount;
    private double grp;// 组号
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private String name;
    private String useUnits;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrAar() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrAar(Long id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_AAR", sequenceName = "SEQ_MIS_EMR_AAR", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_AAR", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "ARTC_ID", precision = 10, scale = 0)
    public Long getArtcId() {
        return this.artcId;
    }

    public void setArtcId(Long artcId) {
        this.artcId = artcId;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "USE_TIME", length = 7)
    public Date getUseTime() {
        return this.useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    @Column(name = "AMOUNT", precision = 8, scale = 0)
    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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

    @Column(name = "GRP")
    public double getGrp() {
        return grp;
    }

    public void setGrp(double grp) {
        this.grp = grp;
    }

    @Column(name = "NAME", length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "USE_UNITS", length = 128)
    public String getUseUnits() {
        return this.useUnits;
    }

    public void setUseUnits(String useUnits) {
        this.useUnits = useUnits;
    }

}