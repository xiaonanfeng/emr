package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisCategorypermission entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_CATEGORYPERMISSION")
public class MisCategorypermission implements java.io.Serializable {

    // Fields

    private String modulepermissionid;
    private Integer objecttype;
    private String objectid;
    private Integer moduleid;

    // Constructors

    /**
     * default constructor
     */
    public MisCategorypermission() {
    }

    /**
     * minimal constructor
     */
    public MisCategorypermission(String modulepermissionid) {
        this.modulepermissionid = modulepermissionid;
    }

    /**
     * full constructor
     */
    public MisCategorypermission(String modulepermissionid,
                                 Integer objecttype, String objectid, Integer moduleid) {
        this.modulepermissionid = modulepermissionid;
        this.objecttype = objecttype;
        this.objectid = objectid;
        this.moduleid = moduleid;
    }

    // Property accessors
    @Id
    @Column(name = "MODULEPERMISSIONID", nullable = false, length = 50)
    public String getModulepermissionid() {
        return this.modulepermissionid;
    }

    public void setModulepermissionid(String modulepermissionid) {
        this.modulepermissionid = modulepermissionid;
    }

    @Column(name = "OBJECTTYPE", precision = 22, scale = 0)
    public Integer getObjecttype() {
        return this.objecttype;
    }

    public void setObjecttype(Integer objecttype) {
        this.objecttype = objecttype;
    }

    @Column(name = "OBJECTID", length = 8)
    public String getObjectid() {
        return this.objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    @Column(name = "MODULEID", precision = 22, scale = 0)
    public Integer getModuleid() {
        return this.moduleid;
    }

    public void setModuleid(Integer moduleid) {
        this.moduleid = moduleid;
    }

}