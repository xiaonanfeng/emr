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


/**
 * MisEmrMar entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_MAR")
public class MisEmrMar implements java.io.Serializable {
    // Fields

    private Integer id;
    private String emrId;
    private Integer leader;//作为一批？
    private double grp;//组号
    private Integer type;//现场？中途
    private Integer medId;
    private String usage;
    private String dose;

    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    /*update by 谢永富*/
    private Integer units;//单位。填写单位编码，包括ml、g、mg、u、粒、片、L、IU、μg等
    private Integer amount;//数量
    private Integer frequency;//频次。FREQUENCY 填写频次编码，包括立即、每3分钟1次、每5分钟1次、每1分钟1次、每2分钟1次
    private String drip;//滴速

    // Constructors

    /**
     * default constructor
     */
    public MisEmrMar() {
    }

    /**
     * minimal constructor
     */
    public MisEmrMar(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrMar(Integer id, Integer type,
                     Integer medId, String usage, String dose,
                     Date createTime, Date lastModifyTime, Integer xzbm) {
        super();
        this.id = id;
        this.type = type;
        this.medId = medId;
        this.usage = usage;
        this.dose = dose;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_MAR", sequenceName = "SEQ_MIS_EMR_MAR", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_MAR", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "EMR_ID")
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }


    @Column(name = "TYPE", precision = 4, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "MED_ID", precision = 10, scale = 0)
    public Integer getMedId() {
        return this.medId;
    }

    public void setMedId(Integer medId) {
        this.medId = medId;
    }

    @Column(name = "USAGE", length = 256)
    public String getUsage() {
        return this.usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Column(name = "DOSE", length = 64)
    public String getDose() {
        return this.dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
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


    @Column(name = "LEADER")
    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    @Column(name = "GRP")
    public double getGrp() {
        return grp;
    }

    public void setGrp(double grp) {
        this.grp = grp;
    }

    @Column(name = "UNITS")
    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    @Column(name = "AMOUNT")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "FREQUENCY")
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Column(name = "DRIP")
    public String getDrip() {
        return drip;
    }

    public void setDrip(String drip) {
        this.drip = drip;
    }


}