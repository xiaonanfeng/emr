package com.zxit.model;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * MisEmrAe entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_AE")
public class MisEmrAe implements java.io.Serializable {

    // Fields

    private String id;
    private Double rbg;
    private Integer rbgTest;
    private Double bos;
    private Integer ecg;
    private Date ecgTime;
    private String ecgDiag;
    private Integer ecgMonitor;//宁波要求添加心电监护情况
    private String ecgTo;
    private String ecgLead;
    private String aeOther;
    private String ohters;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private Integer bosTest;
    /**
     * update by  南晓峰
     */
    private String ecgOther;


    // Constructors

    /**
     * default constructor
     */
    public MisEmrAe() {
    }

    /**
     * minimal constructor
     */
    public MisEmrAe(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrAe(String id, Double rbg, Double bos, Integer ecg, Date ecgTime,
                    String ecgDiag, String ecgTo, String aeOther, String ohters,
                    Date createTime, Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.rbg = rbg;
        this.bos = bos;
        this.ecg = ecg;
        this.ecgTime = ecgTime;
        this.ecgDiag = ecgDiag;
        this.ecgTo = ecgTo;
        this.aeOther = aeOther;
        this.ohters = ohters;
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

    @Column(name = "RBG", precision = 4, scale = 1)
    public Double getRbg() {
        return this.rbg;
    }

    public void setRbg(Double rbg) {
        this.rbg = rbg;
    }

    @Column(name = "RBG_TEST")
    public Integer getRbgTest() {
        return rbgTest;
    }

    public void setRbgTest(Integer rbgTest) {
        this.rbgTest = rbgTest;
    }

    @Column(name = "BOS", precision = 4, scale = 1)
    public Double getBos() {
        return this.bos;
    }

    public void setBos(Double bos) {
        this.bos = bos;
    }

    @Column(name = "ECG", precision = 4, scale = 0)
    public Integer getEcg() {
        return this.ecg;
    }

    public void setEcg(Integer ecg) {
        this.ecg = ecg;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ECG_TIME", length = 7)
    public Date getEcgTime() {
        return this.ecgTime;
    }

    public void setEcgTime(Date ecgTime) {
        this.ecgTime = ecgTime;
    }

    @Column(name = "ECG_DIAG", length = 64)
    public String getEcgDiag() {
        return this.ecgDiag;
    }

    public void setEcgDiag(String ecgDiag) {
        this.ecgDiag = ecgDiag;
    }

    @Column(name = "ECG_MONITOR")
    public Integer getEcgMonitor() {
        return ecgMonitor;
    }

    public void setEcgMonitor(Integer ecgMonitor) {
        this.ecgMonitor = ecgMonitor;
    }

    @Column(name = "ECG_TO", length = 20)
    public String getEcgTo() {
        return this.ecgTo;
    }

    public void setEcgTo(String ecgTo) {
        this.ecgTo = ecgTo;
    }

    @Column(name = "ECG_LEAD")
    public String getEcgLead() {
        return ecgLead;
    }

    public void setEcgLead(String ecgLead) {
        this.ecgLead = ecgLead;
    }


    @Column(name = "AE_OTHER", length = 64)
    public String getAeOther() {
        return this.aeOther;
    }

    public void setAeOther(String aeOther) {
        this.aeOther = aeOther;
    }

    @Column(name = "OHTERS", length = 64)
    public String getOhters() {
        return this.ohters;
    }

    public void setOhters(String ohters) {
        this.ohters = ohters;
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

    @Column(name = "ECG_OTHER", length = 200)
    public String getEcgOther() {
        return ecgOther;
    }

    public void setEcgOther(String ecgOther) {
        this.ecgOther = ecgOther;
    }

    @Column(name = "BOS_TEST")
    public Integer getBosTest() {
        return bosTest;
    }

    public void setBosTest(Integer bosTest) {
        this.bosTest = bosTest;
    }


}