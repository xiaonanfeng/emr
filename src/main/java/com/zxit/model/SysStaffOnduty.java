package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysStaffOnduty entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SYS_STAFF_ONDUTY")
public class SysStaffOnduty implements java.io.Serializable {

    // Fields

    private Integer id;
    private String gh;
    private String zbclid;
    private Date sbsj;
    private Date xbsj;
    private Integer flag;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public SysStaffOnduty() {
    }

    /**
     * minimal constructor
     */
    public SysStaffOnduty(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysStaffOnduty(Integer id, String gh, String zbclid, Date sbsj,
                          Date xbsj, Integer flag, Integer xzbm) {
        this.id = id;
        this.gh = gh;
        this.zbclid = zbclid;
        this.sbsj = sbsj;
        this.xbsj = xbsj;
        this.flag = flag;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "GH", length = 8)
    public String getGh() {
        return this.gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    @Column(name = "ZBCLID", length = 8)
    public String getZbclid() {
        return this.zbclid;
    }

    public void setZbclid(String zbclid) {
        this.zbclid = zbclid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SBSJ", length = 7)
    public Date getSbsj() {
        return this.sbsj;
    }

    public void setSbsj(Date sbsj) {
        this.sbsj = sbsj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "XBSJ", length = 7)
    public Date getXbsj() {
        return this.xbsj;
    }

    public void setXbsj(Date xbsj) {
        this.xbsj = xbsj;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

}