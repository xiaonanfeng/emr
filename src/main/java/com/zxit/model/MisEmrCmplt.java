package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MisEmrCmplt entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MIS_EMR_CMPLT")
public class MisEmrCmplt implements java.io.Serializable {

    // Fields
    private String id;
    private MisEmrCmpltTemplate misEmrCmpltTemplate;
    private String colname;
    private String colvalue;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrCmplt() {
    }

    /**
     * minimal constructor
     */
    public MisEmrCmplt(String id) {
        this.id = id;
    }

    /**
     * minimal constructor
     */
    public MisEmrCmplt(String id, MisEmrCmpltTemplate misEmrCmpltTemplate) {
        this.id = id;
        this.misEmrCmpltTemplate = misEmrCmpltTemplate;
    }

    /**
     * full constructor
     */
    public MisEmrCmplt(String id, MisEmrCmpltTemplate misEmrCmpltTemplate,
                       String colname, String colvalue) {
        this.id = id;
        this.misEmrCmpltTemplate = misEmrCmpltTemplate;
        this.colname = colname;
        this.colvalue = colvalue;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 16)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TMPL_ID", nullable = false)
    public MisEmrCmpltTemplate getMisEmrCmpltTemplate() {
        return this.misEmrCmpltTemplate;
    }

    public void setMisEmrCmpltTemplate(MisEmrCmpltTemplate misEmrCmpltTemplate) {
        this.misEmrCmpltTemplate = misEmrCmpltTemplate;
    }

    @Column(name = "COLNAME", length = 32)
    public String getColname() {
        return this.colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }

    @Column(name = "COLVALUE", length = 500)
    public String getColvalue() {
        return this.colvalue;
    }

    public void setColvalue(String colvalue) {
        this.colvalue = colvalue;
    }

}