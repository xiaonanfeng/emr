package com.zxit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MisEmrCmpltTemplate entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MIS_EMR_CMPLT_TEMPLATE")
public class MisEmrCmpltTemplate implements java.io.Serializable {

    // Fields
    private Integer id;
    private String name;
    private Integer tmplType;
    private String createUserid;
    private Date createTime;
    private String modifyUserid;
    private Date lastModifyTime;
    private Integer xzbm;
    private Set<MisEmrCmplt> misEmrCmplts = new HashSet<MisEmrCmplt>(0);

    /**
     * default constructor
     */
    public MisEmrCmpltTemplate() {
    }

    /**
     * minimal constructor
     */
    public MisEmrCmpltTemplate(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrCmpltTemplate(Integer id, String name, Integer tmplType,
                               String createUserid, Date createTime, String modifyUserid,
                               Date lastModifyTime, Integer xzbm, Set<MisEmrCmplt> misEmrCmplts) {
        this.id = id;
        this.name = name;
        this.tmplType = tmplType;
        this.createUserid = createUserid;
        this.createTime = createTime;
        this.modifyUserid = modifyUserid;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
        this.misEmrCmplts = misEmrCmplts;
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

    @Column(name = "NAME", length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TMPL_TYPE", precision = 4, scale = 0)
    public Integer getTmplType() {
        return this.tmplType;
    }

    public void setTmplType(Integer tmplType) {
        this.tmplType = tmplType;
    }

    @Column(name = "CREATE_USERID", length = 8, updatable = false)
    public String getCreateUserid() {
        return this.createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Column(name = "MODIFY_USERID", length = 8)
    public String getModifyUserid() {
        return this.modifyUserid;
    }

    public void setModifyUserid(String modifyUserid) {
        this.modifyUserid = modifyUserid;
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "misEmrCmpltTemplate")
    public Set<MisEmrCmplt> getMisEmrCmplts() {
        return this.misEmrCmplts;
    }

    public void setMisEmrCmplts(Set<MisEmrCmplt> misEmrCmplts) {
        this.misEmrCmplts = misEmrCmplts;
    }

}