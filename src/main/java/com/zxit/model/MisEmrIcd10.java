package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisEmrIcd10 entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_ICD10")
public class MisEmrIcd10 implements java.io.Serializable {

    // Fields

    private Integer id;
    private String diseaseCode;
    private String diseaseName;
    private String diseaseAlias;
    private Integer parentId;
    private String inputCode1;
    private String inputCode2;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrIcd10() {
    }

    /**
     * minimal constructor
     */
    public MisEmrIcd10(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrIcd10(Integer id, String diseaseCode, String diseaseName,
                       String diseaseAlias, Integer parentId, String inputCode1,
                       String inputCode2) {
        this.id = id;
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.diseaseAlias = diseaseAlias;
        this.parentId = parentId;
        this.inputCode1 = inputCode1;
        this.inputCode2 = inputCode2;
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

    @Column(name = "DISEASE_CODE", length = 8)
    public String getDiseaseCode() {
        return this.diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Column(name = "DISEASE_NAME", length = 64)
    public String getDiseaseName() {
        return this.diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Column(name = "DISEASE_ALIAS", length = 128)
    public String getDiseaseAlias() {
        return this.diseaseAlias;
    }

    public void setDiseaseAlias(String diseaseAlias) {
        this.diseaseAlias = diseaseAlias;
    }

    @Column(name = "PARENT_ID", precision = 8, scale = 0)
    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Column(name = "INPUT_CODE1", length = 100)
    public String getInputCode1() {
        return this.inputCode1;
    }

    public void setInputCode1(String inputCode1) {
        this.inputCode1 = inputCode1;
    }

    @Column(name = "INPUT_CODE2", length = 100)
    public String getInputCode2() {
        return this.inputCode2;
    }

    public void setInputCode2(String inputCode2) {
        this.inputCode2 = inputCode2;
    }

}