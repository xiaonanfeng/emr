package com.zxit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * VMisEmrMarMedicine entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_MAR_MEDICINE")
public class VMisEmrMarMedicine implements java.io.Serializable {

    // Fields

    private Integer id;
    private double grp;
    private Integer leader;
    private String emrId;
    private Integer type;
    private Integer medId;
    private String usage;
    private String dose;
    private String name;
    private String spell;
    private String specs;
    private String useUnits;

    /*update by 谢永富*/
    private Integer units;//单位。填写单位编码，包括ml、g、mg、u、粒、片、L、IU、μg等
    private String units_text;

    private Integer amount;//数量
    private Integer frequency;//频次。FREQUENCY 填写频次编码，包括立即、每3分钟1次、每5分钟1次、每1分钟1次、每2分钟1次
    private String frequency_text;

    private String drip;//滴速

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrMarMedicine() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrMarMedicine(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public VMisEmrMarMedicine(Integer id, String emrId, Integer type, Integer medId,
                              String usage, String dose, String name, String spell,
                              String specs, String useUnits) {
        this.id = id;
        this.emrId = emrId;
        this.type = type;
        this.medId = medId;
        this.usage = usage;
        this.dose = dose;
        this.name = name;
        this.spell = spell;
        this.specs = specs;
        this.useUnits = useUnits;
    }

    // Property accessors
    @Id
    @Column(name = "ID", nullable = false, precision = 10, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", length = 20)
    public String getEmrId() {
        return this.emrId;
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

    @Column(name = "NAME", length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SPELL", length = 64)
    public String getSpell() {
        return this.spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    @Column(name = "SPECS", length = 16)
    public String getSpecs() {
        return this.specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Column(name = "USE_UNITS", length = 128)
    public String getUseUnits() {
        return this.useUnits;
    }

    public void setUseUnits(String useUnits) {
        this.useUnits = useUnits;
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

    @Transient
    public String getUnits_text() {
        return units_text;
    }

    public void setUnits_text(String units_text) {
        this.units_text = units_text;
    }

    @Transient
    public String getFrequency_text() {
        return frequency_text;
    }

    public void setFrequency_text(String frequency_text) {
        this.frequency_text = frequency_text;
    }


}