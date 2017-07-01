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
 * MIS_电子病历_专项_儿科
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_SE_PED")
public class MisEmrSePed implements java.io.Serializable {

    // Fields

    private String id;
    private Integer apgar1;
    private Integer apgarAp1;
    private Integer apgarP1;
    private Integer apgarG1;
    private Integer apgarAc1;
    private Integer apgarR1;
    private Integer apgar5;
    private Integer apgarAp5;
    private Integer apgarP5;
    private Integer apgarG5;
    private Integer apgarAc5;
    private Integer apgarR5;
    private Integer apgar10;
    private Integer apgarAp10;
    private Integer apgarP10;
    private Integer apgarG10;
    private Integer apgarAc10;
    private Integer apgarR10;
    private Integer apgar15;
    private Integer apgarAp15;
    private Integer apgarP15;
    private Integer apgarG15;
    private Integer apgarAc15;
    private Integer apgarR15;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrSePed() {
    }

    /**
     * minimal constructor
     */
    public MisEmrSePed(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrSePed(String id, Integer apgar1, Integer apgarAp1, Integer apgarP1,
                       Integer apgarG1, Integer apgarAc1, Integer apgarR1, Integer apgar5,
                       Integer apgarAp5, Integer apgarP5, Integer apgarG5, Integer apgarAc5,
                       Integer apgarR5, Integer apgar10, Integer apgarAp10, Integer apgarP10,
                       Integer apgarG10, Integer apgarAc10, Integer apgarR10, Integer apgar15,
                       Integer apgarAp15, Integer apgarP15, Integer apgarG15, Integer apgarAc15,
                       Integer apgarR15, Date createTime, Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.apgar1 = apgar1;
        this.apgarAp1 = apgarAp1;
        this.apgarP1 = apgarP1;
        this.apgarG1 = apgarG1;
        this.apgarAc1 = apgarAc1;
        this.apgarR1 = apgarR1;
        this.apgar5 = apgar5;
        this.apgarAp5 = apgarAp5;
        this.apgarP5 = apgarP5;
        this.apgarG5 = apgarG5;
        this.apgarAc5 = apgarAc5;
        this.apgarR5 = apgarR5;
        this.apgar10 = apgar10;
        this.apgarAp10 = apgarAp10;
        this.apgarP10 = apgarP10;
        this.apgarG10 = apgarG10;
        this.apgarAc10 = apgarAc10;
        this.apgarR10 = apgarR10;
        this.apgar15 = apgar15;
        this.apgarAp15 = apgarAp15;
        this.apgarP15 = apgarP15;
        this.apgarG15 = apgarG15;
        this.apgarAc15 = apgarAc15;
        this.apgarR15 = apgarR15;
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

    @Column(name = "APGAR_1", precision = 4, scale = 0)
    public Integer getApgar1() {
        return this.apgar1;
    }

    public void setApgar1(Integer apgar1) {
        this.apgar1 = apgar1;
    }

    @Column(name = "APGAR_AP_1", precision = 4, scale = 0)
    public Integer getApgarAp1() {
        return this.apgarAp1;
    }

    public void setApgarAp1(Integer apgarAp1) {
        this.apgarAp1 = apgarAp1;
    }

    @Column(name = "APGAR_P_1", precision = 4, scale = 0)
    public Integer getApgarP1() {
        return this.apgarP1;
    }

    public void setApgarP1(Integer apgarP1) {
        this.apgarP1 = apgarP1;
    }

    @Column(name = "APGAR_G_1", precision = 4, scale = 0)
    public Integer getApgarG1() {
        return this.apgarG1;
    }

    public void setApgarG1(Integer apgarG1) {
        this.apgarG1 = apgarG1;
    }

    @Column(name = "APGAR_AC_1", precision = 4, scale = 0)
    public Integer getApgarAc1() {
        return this.apgarAc1;
    }

    public void setApgarAc1(Integer apgarAc1) {
        this.apgarAc1 = apgarAc1;
    }

    @Column(name = "APGAR_R_1", precision = 4, scale = 0)
    public Integer getApgarR1() {
        return this.apgarR1;
    }

    public void setApgarR1(Integer apgarR1) {
        this.apgarR1 = apgarR1;
    }

    @Column(name = "APGAR_5", precision = 4, scale = 0)
    public Integer getApgar5() {
        return this.apgar5;
    }

    public void setApgar5(Integer apgar5) {
        this.apgar5 = apgar5;
    }

    @Column(name = "APGAR_AP_5", precision = 4, scale = 0)
    public Integer getApgarAp5() {
        return this.apgarAp5;
    }

    public void setApgarAp5(Integer apgarAp5) {
        this.apgarAp5 = apgarAp5;
    }

    @Column(name = "APGAR_P_5", precision = 4, scale = 0)
    public Integer getApgarP5() {
        return this.apgarP5;
    }

    public void setApgarP5(Integer apgarP5) {
        this.apgarP5 = apgarP5;
    }

    @Column(name = "APGAR_G_5", precision = 4, scale = 0)
    public Integer getApgarG5() {
        return this.apgarG5;
    }

    public void setApgarG5(Integer apgarG5) {
        this.apgarG5 = apgarG5;
    }

    @Column(name = "APGAR_AC_5", precision = 4, scale = 0)
    public Integer getApgarAc5() {
        return this.apgarAc5;
    }

    public void setApgarAc5(Integer apgarAc5) {
        this.apgarAc5 = apgarAc5;
    }

    @Column(name = "APGAR_R_5", precision = 4, scale = 0)
    public Integer getApgarR5() {
        return this.apgarR5;
    }

    public void setApgarR5(Integer apgarR5) {
        this.apgarR5 = apgarR5;
    }

    @Column(name = "APGAR_10", precision = 4, scale = 0)
    public Integer getApgar10() {
        return this.apgar10;
    }

    public void setApgar10(Integer apgar10) {
        this.apgar10 = apgar10;
    }

    @Column(name = "APGAR_AP_10", precision = 4, scale = 0)
    public Integer getApgarAp10() {
        return this.apgarAp10;
    }

    public void setApgarAp10(Integer apgarAp10) {
        this.apgarAp10 = apgarAp10;
    }

    @Column(name = "APGAR_P_10", precision = 4, scale = 0)
    public Integer getApgarP10() {
        return this.apgarP10;
    }

    public void setApgarP10(Integer apgarP10) {
        this.apgarP10 = apgarP10;
    }

    @Column(name = "APGAR_G_10", precision = 4, scale = 0)
    public Integer getApgarG10() {
        return this.apgarG10;
    }

    public void setApgarG10(Integer apgarG10) {
        this.apgarG10 = apgarG10;
    }

    @Column(name = "APGAR_AC_10", precision = 4, scale = 0)
    public Integer getApgarAc10() {
        return this.apgarAc10;
    }

    public void setApgarAc10(Integer apgarAc10) {
        this.apgarAc10 = apgarAc10;
    }

    @Column(name = "APGAR_R_10", precision = 4, scale = 0)
    public Integer getApgarR10() {
        return this.apgarR10;
    }

    public void setApgarR10(Integer apgarR10) {
        this.apgarR10 = apgarR10;
    }

    @Column(name = "APGAR_15", precision = 4, scale = 0)
    public Integer getApgar15() {
        return this.apgar15;
    }

    public void setApgar15(Integer apgar15) {
        this.apgar15 = apgar15;
    }

    @Column(name = "APGAR_AP_15", precision = 4, scale = 0)
    public Integer getApgarAp15() {
        return this.apgarAp15;
    }

    public void setApgarAp15(Integer apgarAp15) {
        this.apgarAp15 = apgarAp15;
    }

    @Column(name = "APGAR_P_15", precision = 4, scale = 0)
    public Integer getApgarP15() {
        return this.apgarP15;
    }

    public void setApgarP15(Integer apgarP15) {
        this.apgarP15 = apgarP15;
    }

    @Column(name = "APGAR_G_15", precision = 4, scale = 0)
    public Integer getApgarG15() {
        return this.apgarG15;
    }

    public void setApgarG15(Integer apgarG15) {
        this.apgarG15 = apgarG15;
    }

    @Column(name = "APGAR_AC_15", precision = 4, scale = 0)
    public Integer getApgarAc15() {
        return this.apgarAc15;
    }

    public void setApgarAc15(Integer apgarAc15) {
        this.apgarAc15 = apgarAc15;
    }

    @Column(name = "APGAR_R_15", precision = 4, scale = 0)
    public Integer getApgarR15() {
        return this.apgarR15;
    }

    public void setApgarR15(Integer apgarR15) {
        this.apgarR15 = apgarR15;
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
        return "MisEmrSePed [id=" + id + ", apgar1=" + apgar1 + ", apgarAp1="
                + apgarAp1 + ", apgarP1=" + apgarP1 + ", apgarG1=" + apgarG1
                + ", apgarAc1=" + apgarAc1 + ", apgarR1=" + apgarR1
                + ", apgar5=" + apgar5 + ", apgarAp5=" + apgarAp5
                + ", apgarP5=" + apgarP5 + ", apgarG5=" + apgarG5
                + ", apgarAc5=" + apgarAc5 + ", apgarR5=" + apgarR5
                + ", apgar10=" + apgar10 + ", apgarAp10=" + apgarAp10
                + ", apgarP10=" + apgarP10 + ", apgarG10=" + apgarG10
                + ", apgarAc10=" + apgarAc10 + ", apgarR10=" + apgarR10
                + ", apgar15=" + apgar15 + ", apgarAp15=" + apgarAp15
                + ", apgarP15=" + apgarP15 + ", apgarG15=" + apgarG15
                + ", apgarAc15=" + apgarAc15 + ", apgarR15=" + apgarR15
                + ", createTime=" + createTime + ", lastModifyTime="
                + lastModifyTime + ", xzbm=" + xzbm + "]";
    }


}