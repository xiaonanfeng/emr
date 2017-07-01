package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysAmbulInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_AMBUL_INFO")
public class SysAmbulInfo implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String clid;
    private SysOrgInfo sysOrgInfo;
    private String cph;
    private String name;
    private Integer flag;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public SysAmbulInfo() {
    }

    /**
     * minimal constructor
     */
    public SysAmbulInfo(String clid) {
        this.clid = clid;
    }

    /**
     * full constructor
     */
    public SysAmbulInfo(String clid, SysOrgInfo sysOrgInfo, String cph,
                        String name, Integer flag, Date createTime, Date lastModifyTime,
                        Integer xzbm) {
        this.clid = clid;
        this.sysOrgInfo = sysOrgInfo;
        this.cph = cph;
        this.name = name;
        this.flag = flag;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "CLID", unique = true, nullable = false, length = 8)
    public String getClid() {
        return this.clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORG_ID")
    public SysOrgInfo getSysOrgInfo() {
        return this.sysOrgInfo;
    }

    public void setSysOrgInfo(SysOrgInfo sysOrgInfo) {
        this.sysOrgInfo = sysOrgInfo;
    }

    @Column(name = "CPH", length = 16)
    public String getCph() {
        return this.cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    @Column(name = "NAME", length = 32)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 7, updatable = false)
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

}