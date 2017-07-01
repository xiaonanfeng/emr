package com.zxit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * MisAmEmMedicine entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_AM_EM_MEDICINE")
public class MisAmEmMedicine implements java.io.Serializable {

    // Fields
    private Integer id;
    private Integer type;
    private Integer category;
    private String name;
    private String spell;
    private String comName;
    private String useUnits;
    private String specs;
    private String approvalNo;
    private String standards;
    private String manufacturer;
    private String pack;
    private String ingredient;
    private String function;
    private String dose;
    private String adverseReact;
    private String contraindiction;
    private String attention;
    private String storage;

    // Constructors

    /**
     * default constructor
     */
    public MisAmEmMedicine() {
    }

    /**
     * minimal constructor
     */
    public MisAmEmMedicine(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisAmEmMedicine(Integer id, Integer type, Integer category,
                           String name, String spell, String comName, String useUnits,
                           String specs, String approvalNo, String standards,
                           String manufacturer, String pack, String ingredient,
                           String function, String dose, String adverseReact,
                           String contraindiction, String attention, String storage) {
        this.id = id;
        this.type = type;
        this.category = category;
        this.name = name;
        this.spell = spell;
        this.comName = comName;
        this.useUnits = useUnits;
        this.specs = specs;
        this.approvalNo = approvalNo;
        this.standards = standards;
        this.manufacturer = manufacturer;
        this.pack = pack;
        this.ingredient = ingredient;
        this.function = function;
        this.dose = dose;
        this.adverseReact = adverseReact;
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

    @Column(name = "CATEGORY", precision = 1, scale = 0)
    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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

    @Column(name = "INGREDIENT", length = 200)
    public String getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Column(name = "FUNCTION", length = 200)
    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Column(name = "DOSE", length = 1000)
    public String getDose() {
        return this.dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    @Column(name = "ADVERSE_REACT", length = 1000)
    public String getAdverseReact() {
        return this.adverseReact;
    }

    public void setAdverseReact(String adverseReact) {
        this.adverseReact = adverseReact;
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