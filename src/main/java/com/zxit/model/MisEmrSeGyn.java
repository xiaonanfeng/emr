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
 * 电子病历_专项_妇科
 */

@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_SE_GYN")
public class MisEmrSeGyn implements java.io.Serializable {

    // Fields

    private String id;
    private Integer martialStatus;
    private Integer marAge;
    private String pregnancy;
    private String childbirth;
    private Integer sexLife;
    private Integer aom;
    private Integer period;
    private Integer cycle;
    private Date lmp;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrSeGyn() {
    }

    /**
     * minimal constructor
     */
    public MisEmrSeGyn(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrSeGyn(String id, Integer martialStatus, Integer marAge,
                       String pregnancy, String childbirth, Integer sexLife, Integer aom,
                       Integer period, Integer cycle, Date lmp, Date createTime,
                       Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.martialStatus = martialStatus;
        this.marAge = marAge;
        this.pregnancy = pregnancy;
        this.childbirth = childbirth;
        this.sexLife = sexLife;
        this.aom = aom;
        this.period = period;
        this.cycle = cycle;
        this.lmp = lmp;
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

    @Column(name = "MARTIAL_STATUS", precision = 4, scale = 0)
    public Integer getMartialStatus() {
        return this.martialStatus;
    }

    public void setMartialStatus(Integer martialStatus) {
        this.martialStatus = martialStatus;
    }

    @Column(name = "MAR_AGE", precision = 4, scale = 0)
    public Integer getMarAge() {
        return this.marAge;
    }

    public void setMarAge(Integer marAge) {
        this.marAge = marAge;
    }

    @Column(name = "PREGNANCY", length = 20)
    public String getPregnancy() {
        return this.pregnancy;
    }

    public void setPregnancy(String pregnancy) {
        this.pregnancy = pregnancy;
    }

    @Column(name = "CHILDBIRTH", length = 20)
    public String getChildbirth() {
        return this.childbirth;
    }

    public void setChildbirth(String childbirth) {
        this.childbirth = childbirth;
    }

    @Column(name = "SEX_LIFE", precision = 4, scale = 0)
    public Integer getSexLife() {
        return this.sexLife;
    }

    public void setSexLife(Integer sexLife) {
        this.sexLife = sexLife;
    }

    @Column(name = "AOM", precision = 4, scale = 0)
    public Integer getAom() {
        return this.aom;
    }

    public void setAom(Integer aom) {
        this.aom = aom;
    }

    @Column(name = "PERIOD", precision = 4, scale = 0)
    public Integer getPeriod() {
        return this.period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Column(name = "CYCLE", precision = 4, scale = 0)
    public Integer getCycle() {
        return this.cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LMP")
    public Date getLmp() {
        return this.lmp;
    }

    public void setLmp(Date lmp) {
        this.lmp = lmp;
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

    @Override
    public String toString() {
        return "MisEmrSeGyn [id=" + id + ", martialStatus=" + martialStatus
                + ", marAge=" + marAge + ", pregnancy=" + pregnancy
                + ", childbirth=" + childbirth + ", sexLife=" + sexLife
                + ", aom=" + aom + ", period=" + period + ", cycle=" + cycle
                + ", lmp=" + lmp + ", createTime=" + createTime
                + ", lastModifyTime=" + lastModifyTime + ", xzbm=" + xzbm + "]";
    }


}