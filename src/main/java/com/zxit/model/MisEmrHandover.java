package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * MisEmrHandover entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_HANDOVER")
public class MisEmrHandover implements java.io.Serializable {

    // Fields

    private String id;
    private Date hoTime;
    private String hoMainreason;
    private Integer hoP;
    private Integer hoR;
    private Integer hoBpL;
    private Integer hoBpH;
    private Integer hoConscious;
    private String hoDiag;
    private String hoTreat;
    private String hoDoctor;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private Integer hdCommit;


    private String hoTreatOther;//其他处理
    private String diagOther;//其他诊断
    private String statOther;//其他体征


    // Constructors

    /**
     * default constructor
     */
    public MisEmrHandover() {
    }

    /**
     * minimal constructor
     */
    public MisEmrHandover(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrHandover(String id, Date hoTime, String hoMainreason,
                          Integer hoP, Integer hoR, Integer hoBpL, Integer hoBpH, Integer hoConscious,
                          String hoDiag, String hoTreat, String hoDoctor, Date createTime,
                          Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.hoTime = hoTime;
        this.hoMainreason = hoMainreason;
        this.hoP = hoP;
        this.hoR = hoR;
        this.hoBpL = hoBpL;
        this.hoBpH = hoBpH;
        this.hoConscious = hoConscious;
        this.hoDiag = hoDiag;
        this.hoTreat = hoTreat;
        this.hoDoctor = hoDoctor;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HO_TIME", length = 7)
    public Date getHoTime() {
        return this.hoTime;
    }

    public void setHoTime(Date hoTime) {
        this.hoTime = hoTime;
    }

    @Column(name = "HO_MAINREASON", length = 40)
    public String getHoMainreason() {
        return this.hoMainreason;
    }

    public void setHoMainreason(String hoMainreason) {
        this.hoMainreason = hoMainreason;
    }

    @Column(name = "HO_P", precision = 4, scale = 0)
    public Integer getHoP() {
        return this.hoP;
    }

    public void setHoP(Integer hoP) {
        this.hoP = hoP;
    }

    @Column(name = "HO_R", precision = 4, scale = 0)
    public Integer getHoR() {
        return this.hoR;
    }

    public void setHoR(Integer hoR) {
        this.hoR = hoR;
    }

    @Column(name = "HO_BP_L", precision = 4, scale = 0)
    public Integer getHoBpL() {
        return this.hoBpL;
    }

    public void setHoBpL(Integer hoBpL) {
        this.hoBpL = hoBpL;
    }

    @Column(name = "HO_BP_H", precision = 4, scale = 0)
    public Integer getHoBpH() {
        return this.hoBpH;
    }

    public void setHoBpH(Integer hoBpH) {
        this.hoBpH = hoBpH;
    }

    @Column(name = "HO_CONSCIOUS", precision = 4, scale = 0)
    public Integer getHoConscious() {
        return this.hoConscious;
    }

    public void setHoConscious(Integer hoConscious) {
        this.hoConscious = hoConscious;
    }

    @Column(name = "HO_DIAG", length = 64)
    public String getHoDiag() {
        return this.hoDiag;
    }

    public void setHoDiag(String hoDiag) {
        this.hoDiag = hoDiag;
    }

    @Column(name = "HO_TREAT", length = 64)
    public String getHoTreat() {
        return this.hoTreat;
    }

    public void setHoTreat(String hoTreat) {
        this.hoTreat = hoTreat;
    }

    @Column(name = "HO_DOCTOR", length = 64)
    public String getHoDoctor() {
        return this.hoDoctor;
    }

    public void setHoDoctor(String hoDoctor) {
        this.hoDoctor = hoDoctor;
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

    @Column(name = "HO_TREAT_OTHER")
    public String getHoTreatOther() {
        return hoTreatOther;
    }

    public void setHoTreatOther(String hoTreatOther) {
        this.hoTreatOther = hoTreatOther;
    }

    @Column(name = "DIAG_OTHER")
    public String getDiagOther() {
        return diagOther;
    }

    public void setDiagOther(String diagOther) {
        this.diagOther = diagOther;
    }

    @Column(name = "STAT_OTHER")
    public String getStatOther() {
        return statOther;
    }

    public void setStatOther(String statOther) {
        this.statOther = statOther;
    }

    @Transient
    //@Column(name = "HD_COMMIT")
    public Integer getHdCommit() {
        return hdCommit;
    }

    public void setHdCommit(Integer hdCommit) {
        this.hdCommit = hdCommit;
    }


}