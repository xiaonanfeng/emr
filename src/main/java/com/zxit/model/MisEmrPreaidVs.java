package com.zxit.model;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * MisEmrPreaidVs entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_PREAID_VS")
public class MisEmrPreaidVs implements java.io.Serializable {

    // Fields

    private String id;
    private String primDiag;
    private String primDiagR;
    private String doctorSign;
    private String nurseSign;
    private Date signDate;
    private String sceneTreat;
    private String sceneDrug;
    private String sceneRecord;
    private String itwChange;
    private String itwTreat;
    private String itwDrug;
    private String itwRecord;
    private String arrivalVs;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private String drugOther;
    private String aarOther;

    private String preaidVsStat;//救治成功率

    /**
     * update By 南晓峰
     */
    //SENRCD_OTHER
    private String senRcdOther;


    // Constructors

    /**
     * default constructor
     */
    public MisEmrPreaidVs() {
    }

    /**
     * minimal constructor
     */
    public MisEmrPreaidVs(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrPreaidVs(String id, String primDiag, String primDiagR,
                          String doctorSign, String nurseSign, Date signDate,
                          String sceneTreat, String sceneDrug, String sceneRecord,
                          String itwChange, String itwTreat, String itwDrug,
                          String itwRecord, String arrivalVs, Date createTime,
                          Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.primDiag = primDiag;
        this.primDiagR = primDiagR;
        this.doctorSign = doctorSign;
        this.nurseSign = nurseSign;
        this.signDate = signDate;
        this.sceneTreat = sceneTreat;
        this.sceneDrug = sceneDrug;
        this.sceneRecord = sceneRecord;
        this.itwChange = itwChange;
        this.itwTreat = itwTreat;
        this.itwDrug = itwDrug;
        this.itwRecord = itwRecord;
        this.arrivalVs = arrivalVs;
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

    @Column(name = "PRIM_DIAG")
    public String getPrimDiag() {
        return this.primDiag;
    }

    public void setPrimDiag(String primDiag) {
        this.primDiag = primDiag;
    }

    @Column(name = "PRIM_DIAG_R", length = 64)
    public String getPrimDiagR() {
        return this.primDiagR;
    }

    public void setPrimDiagR(String primDiagR) {
        this.primDiagR = primDiagR;
    }

    @Column(name = "DOCTOR_SIGN", length = 64)
    public String getDoctorSign() {
        return this.doctorSign;
    }

    public void setDoctorSign(String doctorSign) {
        this.doctorSign = doctorSign;
    }

    @Column(name = "NURSE_SIGN", length = 64)
    public String getNurseSign() {
        return this.nurseSign;
    }

    public void setNurseSign(String nurseSign) {
        this.nurseSign = nurseSign;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SIGN_DATE", length = 64)
    public Date getSignDate() {
        return this.signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Column(name = "SCENE_TREAT", length = 32)
    public String getSceneTreat() {
        return this.sceneTreat;
    }

    public void setSceneTreat(String sceneTreat) {
        this.sceneTreat = sceneTreat;
    }

    @Column(name = "SCENE_DRUG", length = 32)
    public String getSceneDrug() {
        return this.sceneDrug;
    }

    public void setSceneDrug(String sceneDrug) {
        this.sceneDrug = sceneDrug;
    }

    @Column(name = "SCENE_RECORD", length = 1000)
    public String getSceneRecord() {
        return this.sceneRecord;
    }

    public void setSceneRecord(String sceneRecord) {
        this.sceneRecord = sceneRecord;
    }

    @Column(name = "ITW_CHANGE", length = 200)
    public String getItwChange() {
        return this.itwChange;
    }

    public void setItwChange(String itwChange) {
        this.itwChange = itwChange;
    }

    @Column(name = "ITW_TREAT", length = 32)
    public String getItwTreat() {
        return this.itwTreat;
    }

    public void setItwTreat(String itwTreat) {
        this.itwTreat = itwTreat;
    }

    @Column(name = "ITW_DRUG", length = 32)
    public String getItwDrug() {
        return this.itwDrug;
    }

    public void setItwDrug(String itwDrug) {
        this.itwDrug = itwDrug;
    }

    @Column(name = "ITW_RECORD", length = 1000)
    public String getItwRecord() {
        return this.itwRecord;
    }

    public void setItwRecord(String itwRecord) {
        this.itwRecord = itwRecord;
    }

    @Column(name = "ARRIVAL_VS", length = 200)
    public String getArrivalVs() {
        return this.arrivalVs;
    }

    public void setArrivalVs(String arrivalVs) {
        this.arrivalVs = arrivalVs;
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

    @Column(name = "SENRCD_OTHER", length = 4000)
    public String getSenRcdOther() {
        return senRcdOther;
    }

    public void setSenRcdOther(String senRcdOther) {
        this.senRcdOther = senRcdOther;
    }

    @Column(name = "DRUG_OTHER")
    public String getDrugOther() {
        return drugOther;
    }

    public void setDrugOther(String drugOther) {
        this.drugOther = drugOther;
    }

    @Column(name = "AAR_OTHER")
    public String getAarOther() {
        return aarOther;
    }


    public void setAarOther(String aarOther) {
        this.aarOther = aarOther;
    }

    @Transient
    public String getPreaidVsStat() {
        return preaidVsStat;
    }

    public void setPreaidVsStat(String preaidVsStat) {
        this.preaidVsStat = preaidVsStat;
    }
}