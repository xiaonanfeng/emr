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
 * MIS_电子病历_专项_产科
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_SE_OB")
public class MisEmrSeOb implements java.io.Serializable {

    // Fields

    private String id;
    private Integer fetalHeart;
    private Integer uterContrac;
    private Integer caul;
    private Integer amnioticFluid;
    private Integer bloodSee;
    private Integer cervix;
    private Integer present;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private String obother;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrSeOb() {
    }

    /**
     * minimal constructor
     */
    public MisEmrSeOb(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrSeOb(String id, Integer fetalHeart, Integer uterContrac,
                      Integer caul, Integer amnioticFluid, Integer bloodSee, Integer cervix,
                      Integer present, Date createTime, Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.fetalHeart = fetalHeart;
        this.uterContrac = uterContrac;
        this.caul = caul;
        this.amnioticFluid = amnioticFluid;
        this.bloodSee = bloodSee;
        this.cervix = cervix;
        this.present = present;
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

    @Column(name = "FETAL_HEART", precision = 4, scale = 0)
    public Integer getFetalHeart() {
        return this.fetalHeart;
    }

    public void setFetalHeart(Integer fetalHeart) {
        this.fetalHeart = fetalHeart;
    }

    @Column(name = "UTER_CONTRAC", precision = 4, scale = 0)
    public Integer getUterContrac() {
        return this.uterContrac;
    }

    public void setUterContrac(Integer uterContrac) {
        this.uterContrac = uterContrac;
    }

    @Column(name = "CAUL", precision = 4, scale = 0)
    public Integer getCaul() {
        return this.caul;
    }

    public void setCaul(Integer caul) {
        this.caul = caul;
    }

    @Column(name = "AMNIOTIC_FLUID", precision = 4, scale = 0)
    public Integer getAmnioticFluid() {
        return this.amnioticFluid;
    }

    public void setAmnioticFluid(Integer amnioticFluid) {
        this.amnioticFluid = amnioticFluid;
    }

    @Column(name = "BLOOD_SEE", precision = 4, scale = 0)
    public Integer getBloodSee() {
        return this.bloodSee;
    }

    public void setBloodSee(Integer bloodSee) {
        this.bloodSee = bloodSee;
    }

    @Column(name = "CERVIX", precision = 4, scale = 0)
    public Integer getCervix() {
        return this.cervix;
    }

    public void setCervix(Integer cervix) {
        this.cervix = cervix;
    }

    @Column(name = "PRESENT", precision = 4, scale = 0)
    public Integer getPresent() {
        return this.present;
    }

    public void setPresent(Integer present) {
        this.present = present;
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

    @Column(name = "OB_OTHER", precision = 8, scale = 0, length = 200)
    public String getObother() {
        return obother;
    }

    public void setObother(String obother) {
        this.obother = obother;
    }


}