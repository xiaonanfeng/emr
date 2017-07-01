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
 * MisEmrNursingDrug entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_NURSING_DRUG")
public class MisEmrNursingDrug implements java.io.Serializable {

    // Fields

    private String id;
    private String emrId;
    private Long medId;
    private String usage;
    private String dose;
    private Date useTime;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrNursingDrug() {
    }

    /**
     * minimal constructor
     */
    public MisEmrNursingDrug(String id, String emrId) {
        this.id = id;
        this.emrId = emrId;
    }

    /**
     * full constructor
     */
    public MisEmrNursingDrug(String id, String emrId, Long medId, String usage,
                             String dose, Date useTime) {
        this.id = id;
        this.emrId = emrId;
        this.medId = medId;
        this.usage = usage;
        this.dose = dose;
        this.useTime = useTime;
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

    @Column(name = "EMR_ID", nullable = false, length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "MED_ID", precision = 10, scale = 0)
    public Long getMedId() {
        return this.medId;
    }

    public void setMedId(Long medId) {
        this.medId = medId;
    }

    @Column(name = "USAGE", length = 64)
    public String getUsage() {
        return this.usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Column(name = "DOSE", length = 256)
    public String getDose() {
        return this.dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "USE_TIME", length = 7)
    public Date getUseTime() {
        return this.useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

}