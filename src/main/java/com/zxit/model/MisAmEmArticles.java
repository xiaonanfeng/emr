package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisAmEmArticles entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_AM_EM_ARTICLES")
public class MisAmEmArticles implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer type;
    private String name;
    private String spell;
    private String comName;
    private String useUnits;
    private String specs;
    private String usage;
    private String approvalNo;
    private String standards;
    private String manufacturer;
    private String pack;
    private String contraindiction;
    private String attention;
    private String storage;

    // Constructors

    /**
     * default constructor
     */
    public MisAmEmArticles() {
    }

    /**
     * minimal constructor
     */
    public MisAmEmArticles(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisAmEmArticles(Integer id, Integer type, String name, String spell,
                           String comName, String useUnits, String specs, String usage,
                           String approvalNo, String standards, String manufacturer,
                           String pack, String contraindiction, String attention,
                           String storage) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.spell = spell;
        this.comName = comName;
        this.useUnits = useUnits;
        this.specs = specs;
        this.usage = usage;
        this.approvalNo = approvalNo;
        this.standards = standards;
        this.manufacturer = manufacturer;
        this.pack = pack;
        this.contraindiction = contraindiction;
        this.attention = attention;
        this.storage = storage;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 8, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "TYPE", precision = 8, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Column(name = "COM_NAME", length = 128)
    public String getComName() {
        return this.comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Column(name = "USE_UNITS", length = 128)
    public String getUseUnits() {
        return this.useUnits;
    }

    public void setUseUnits(String useUnits) {
        this.useUnits = useUnits;
    }

    @Column(name = "SPECS", length = 16)
    public String getSpecs() {
        return this.specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Column(name = "USAGE", length = 200)
    public String getUsage() {
        return this.usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    @Column(name = "APPROVAL_NO", length = 32)
    public String getApprovalNo() {
        return this.approvalNo;
    }

    public void setApprovalNo(String approvalNo) {
        this.approvalNo = approvalNo;
    }

    @Column(name = "STANDARDS", length = 64)
    public String getStandards() {
        return this.standards;
    }

    public void setStandards(String standards) {
        this.standards = standards;
    }

    @Column(name = "MANUFACTURER", length = 64)
    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name = "PACK", length = 64)
    public String getPack() {
        return this.pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    @Column(name = "CONTRAINDICTION", length = 1000)
    public String getContraindiction() {
        return this.contraindiction;
    }

    public void setContraindiction(String contraindiction) {
        this.contraindiction = contraindiction;
    }

    @Column(name = "ATTENTION", length = 200)
    public String getAttention() {
        return this.attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    @Column(name = "STORAGE", length = 200)
    public String getStorage() {
        return this.storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }


}