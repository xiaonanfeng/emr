package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisDatascopePermission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MIS_DATASCOPE_PERMISSION")
public class MisDatascopePermission implements java.io.Serializable {
    // Fields

    private Integer id;
    private Integer objecttype;
    private String objectid;
    private String orgId;
    private Integer flag;

    // Constructors

    /**
     * default constructor
     */
    public MisDatascopePermission() {
    }

    /**
     * minimal constructor
     */
    public MisDatascopePermission(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisDatascopePermission(Integer id, Integer objecttype,
                                  String objectid, String orgId, Integer flag) {
        this.id = id;
        this.objecttype = objecttype;
        this.objectid = objectid;
        this.orgId = orgId;
        this.flag = flag;
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

    @Column(name = "OBJECTTYPE", precision = 8, scale = 0)
    public Integer getObjecttype() {
        return this.objecttype;
    }

    public void setObjecttype(Integer objecttype) {
        this.objecttype = objecttype;
    }

    @Column(name = "OBJECTID", length = 20)
    public String getObjectid() {
        return this.objectid;
    }

    public void setObjectid(String objectid) {
        this.objectid = objectid;
    }

    @Column(name = "ORG_ID", length = 20)
    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}