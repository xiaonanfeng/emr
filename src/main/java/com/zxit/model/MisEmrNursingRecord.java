package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * MisEmrNursingRecord entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_NURSING_RECORD")
public class MisEmrNursingRecord implements java.io.Serializable {

    // Fields
    private String id;
    private String name;
    private Integer gendle;
    private Integer age;
    private String treatAddr;
    private Date treatTime;
    private Double tempreture;
    private Integer paulse;
    private Integer rate;
    private Integer bpL;
    private Integer bpH;
    private Double spo2;
    private Double eco2;
    private Integer mentalstate;
    private Integer posture;
    private Integer cyanosis;
    private Integer skin;
    private String changeRecord;
    private String nursingCare;
    private Double postT;
    private Integer postP;
    private Integer postR;
    private Integer postBpl;
    private Integer postBph;
    private Double postSpo2;
    private Double postEco2;
    private Integer outcome;
    private String remark;
    private String hsid;
    private Date createTime;
    private String modifyUserid;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrNursingRecord() {
    }

    /**
     * minimal constructor
     */
    public MisEmrNursingRecord(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrNursingRecord(String id, String name, Integer gendle,
                               Integer age, String treatAddr, Date treatTime, Double tempreture,
                               Integer paulse, Integer rate, Integer bpL, Integer bpH, Double spo2,
                               Double eco2, Integer mentalstate,
                               Integer posture, Integer cyanosis, Integer skin, String changeRecord,
                               String nursingCare, Double postT, Integer postP, Integer postR,
                               Integer postBpl, Integer postBph, Double postSpo2, Double postEco2,
                               Integer outcome, String remark, String hsid, Date createTime,
                               String modifyUserid, Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.name = name;
        this.gendle = gendle;
        this.age = age;
        this.treatAddr = treatAddr;
        this.treatTime = treatTime;
        this.tempreture = tempreture;
        this.paulse = paulse;
        this.rate = rate;
        this.bpL = bpL;
        this.bpH = bpH;
        this.spo2 = spo2;
        this.eco2 = eco2;
        this.mentalstate = mentalstate;
        this.posture = posture;
        this.cyanosis = cyanosis;
        this.skin = skin;
        this.changeRecord = changeRecord;
        this.nursingCare = nursingCare;
        this.postT = postT;
        this.postP = postP;
        this.postR = postR;
        this.postBpl = postBpl;
        this.postBph = postBph;
        this.postSpo2 = postSpo2;
        this.postEco2 = postEco2;
        this.outcome = outcome;
        this.remark = remark;
        this.hsid = hsid;
        this.createTime = createTime;
        this.modifyUserid = modifyUserid;
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

    @Column(name = "NAME", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "GENDLE", precision = 4, scale = 0)
    public Integer getGendle() {
        return this.gendle;
    }

    public void setGendle(Integer gendle) {
        this.gendle = gendle;
    }

    @Column(name = "AGE", precision = 8, scale = 0)
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "TREAT_ADDR", length = 128)
    public String getTreatAddr() {
        return this.treatAddr;
    }

    public void setTreatAddr(String treatAddr) {
        this.treatAddr = treatAddr;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TREAT_TIME", length = 7)
    public Date getTreatTime() {
        return this.treatTime;
    }

    public void setTreatTime(Date treatTime) {
        this.treatTime = treatTime;
    }

    @Column(name = "TEMPRETURE", precision = 4, scale = 1)
    public Double getTempreture() {
        return this.tempreture;
    }

    public void setTempreture(Double tempreture) {
        this.tempreture = tempreture;
    }

    @Column(name = "PAULSE", precision = 4, scale = 0)
    public Integer getPaulse() {
        return this.paulse;
    }

    public void setPaulse(Integer paulse) {
        this.paulse = paulse;
    }

    @Column(name = "RATE", precision = 4, scale = 0)
    public Integer getRate() {
        return this.rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Column(name = "BP_L", precision = 4, scale = 0)
    public Integer getBpL() {
        return this.bpL;
    }

    public void setBpL(Integer bpL) {
        this.bpL = bpL;
    }

    @Column(name = "BP_H", precision = 4, scale = 0)
    public Integer getBpH() {
        return this.bpH;
    }

    public void setBpH(Integer bpH) {
        this.bpH = bpH;
    }

    @Column(name = "SPO2", precision = 5)
    public Double getSpo2() {
        return this.spo2;
    }

    public void setSpo2(Double spo2) {
        this.spo2 = spo2;
    }

    @Column(name = "ECO2", precision = 5)
    public Double getEco2() {
        return this.eco2;
    }

    public void setEco2(Double eco2) {
        this.eco2 = eco2;
    }


    @Column(name = "MENTALSTATE", precision = 4, scale = 0)
    public Integer getMentalstate() {
        return this.mentalstate;
    }

    public void setMentalstate(Integer mentalstate) {
        this.mentalstate = mentalstate;
    }

    @Column(name = "POSTURE", precision = 4, scale = 0)
    public Integer getPosture() {
        return this.posture;
    }

    public void setPosture(Integer posture) {
        this.posture = posture;
    }

    @Column(name = "CYANOSIS", precision = 4, scale = 0)
    public Integer getCyanosis() {
        return this.cyanosis;
    }

    public void setCyanosis(Integer cyanosis) {
        this.cyanosis = cyanosis;
    }

    @Column(name = "SKIN", precision = 4, scale = 0)
    public Integer getSkin() {
        return this.skin;
    }

    public void setSkin(Integer skin) {
        this.skin = skin;
    }

    @Column(name = "CHANGE_RECORD", length = 4000)
    public String getChangeRecord() {
        return this.changeRecord;
    }

    public void setChangeRecord(String changeRecord) {
        this.changeRecord = changeRecord;
    }

    @Column(name = "NURSING_CARE", length = 128)
    public String getNursingCare() {
        return this.nursingCare;
    }

    public void setNursingCare(String nursingCare) {
        this.nursingCare = nursingCare;
    }

    @Column(name = "POST_T", precision = 4, scale = 1)
    public Double getPostT() {
        return this.postT;
    }

    public void setPostT(Double postT) {
        this.postT = postT;
    }

    @Column(name = "POST_P", precision = 4, scale = 0)
    public Integer getPostP() {
        return this.postP;
    }

    public void setPostP(Integer postP) {
        this.postP = postP;
    }

    @Column(name = "POST_R", precision = 4, scale = 0)
    public Integer getPostR() {
        return this.postR;
    }

    public void setPostR(Integer postR) {
        this.postR = postR;
    }

    @Column(name = "POST_BPL", precision = 4, scale = 0)
    public Integer getPostBpl() {
        return this.postBpl;
    }

    public void setPostBpl(Integer postBpl) {
        this.postBpl = postBpl;
    }

    @Column(name = "POST_BPH", precision = 4, scale = 0)
    public Integer getPostBph() {
        return this.postBph;
    }

    public void setPostBph(Integer postBph) {
        this.postBph = postBph;
    }

    @Column(name = "POST_SPO2", precision = 5)
    public Double getPostSpo2() {
        return this.postSpo2;
    }

    public void setPostSpo2(Double postSpo2) {
        this.postSpo2 = postSpo2;
    }

    @Column(name = "POST_ECO2", precision = 5)
    public Double getPostEco2() {
        return this.postEco2;
    }

    public void setPostEco2(Double postEco2) {
        this.postEco2 = postEco2;
    }

    @Column(name = "OUTCOME", precision = 4, scale = 0)
    public Integer getOutcome() {
        return this.outcome;
    }

    public void setOutcome(Integer outcome) {
        this.outcome = outcome;
    }

    @Column(name = "REMARK", length = 200)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "HSID", length = 8)
    public String getHsid() {
        return this.hsid;
    }

    public void setHsid(String hsid) {
        this.hsid = hsid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false, length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "MODIFY_USERID", length = 8)
    public String getModifyUserid() {
        return this.modifyUserid;
    }

    public void setModifyUserid(String modifyUserid) {
        this.modifyUserid = modifyUserid;
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

    @Override
    public String toString() {
        return "MisEmrNursingRecord [id=" + id + ", name=" + name + ", gendle="
                + gendle + ", age=" + age + ", treatAddr=" + treatAddr
                + ", treatTime=" + treatTime + ", tempreture=" + tempreture
                + ", paulse=" + paulse + ", rate=" + rate + ", bpL=" + bpL
                + ", bpH=" + bpH + ", spo2=" + spo2 + ", eco2=" + eco2
                + ", mentalstate=" + mentalstate + ", posture=" + posture
                + ", cyanosis=" + cyanosis + ", skin=" + skin
                + ", changeRecord=" + changeRecord + ", nursingCare="
                + nursingCare + ", postT=" + postT + ", postP=" + postP
                + ", postR=" + postR + ", postBpl=" + postBpl + ", postBph="
                + postBph + ", postSpo2=" + postSpo2 + ", postEco2=" + postEco2
                + ", outcome=" + outcome + ", remark=" + remark + ", hsid="
                + hsid + ", createTime=" + createTime + ", modifyUserid="
                + modifyUserid + ", lastModifyTime=" + lastModifyTime
                + ", xzbm=" + xzbm + "]";
    }


}