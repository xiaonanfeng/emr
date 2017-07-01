package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * VMisEmrAmbul entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_AMBUL")
public class VMisEmrAmbul implements java.io.Serializable {

    // Fields

    private String emrid;
    private String lsh;
    private Integer ccxh;
    private String clid;
    private String szfz;
    private Date ccsj;
    private Date ddxcsj;
    private Date scsj;
    private Date swsj;
    private Date wcsj;
    private String name;
    private Integer sex;
    private String chiefComplaint;
    private String lxr;
    private String lxdh;
    private Integer isCommitted;
    private Integer xgcs;
    private String createuserid;
    private Date createtime;
    private Date lastmodifytime;

    private String orgId;
    private String timebegin;
    private String timeover;


    // Constructors

    /**
     * default constructor
     */
    public VMisEmrAmbul() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrAmbul(String emrid, String lsh, Integer ccxh, String clid) {
        this.emrid = emrid;
        this.lsh = lsh;
        this.ccxh = ccxh;
        this.clid = clid;
    }

    /**
     * full constructor
     */
    public VMisEmrAmbul(String emrid, String lsh, Integer ccxh, String clid,
                        String szfz, Date ccsj, Date ddxcsj, Date scsj, Date swsj,
                        Date wcsj, String lxr, String lxdh) {
        this.emrid = emrid;
        this.lsh = lsh;
        this.ccxh = ccxh;
        this.clid = clid;
        this.szfz = szfz;
        this.ccsj = ccsj;
        this.ddxcsj = ddxcsj;
        this.scsj = scsj;
        this.swsj = swsj;
        this.wcsj = wcsj;
        this.lxr = lxr;
        this.lxdh = lxdh;
    }

    // Property accessors
    @Id
    @Column(name = "EMRID", nullable = false, length = 20)
    public String getEmrid() {
        return this.emrid;
    }

    public void setEmrid(String emrid) {
        this.emrid = emrid;
    }

    @Column(name = "LSH", nullable = false, length = 20)
    public String getLsh() {
        return this.lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    @Column(name = "CCXH", nullable = false, precision = 4, scale = 0)
    public Integer getCcxh() {
        return this.ccxh;
    }

    public void setCcxh(Integer ccxh) {
        this.ccxh = ccxh;
    }

    @Column(name = "CLID", nullable = false, length = 8)
    public String getClid() {
        return this.clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    @Column(name = "SZFZ", length = 16)
    public String getSzfz() {
        return this.szfz;
    }

    public void setSzfz(String szfz) {
        this.szfz = szfz;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CCSJ", length = 7)
    public Date getCcsj() {
        return this.ccsj;
    }

    public void setCcsj(Date ccsj) {
        this.ccsj = ccsj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DDXCSJ", length = 7)
    public Date getDdxcsj() {
        return this.ddxcsj;
    }

    public void setDdxcsj(Date ddxcsj) {
        this.ddxcsj = ddxcsj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCSJ", length = 7)
    public Date getScsj() {
        return this.scsj;
    }

    public void setScsj(Date scsj) {
        this.scsj = scsj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SWSJ", length = 7)
    public Date getSwsj() {
        return this.swsj;
    }

    public void setSwsj(Date swsj) {
        this.swsj = swsj;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "WCSJ", length = 7)
    public Date getWcsj() {
        return this.wcsj;
    }

    public void setWcsj(Date wcsj) {
        this.wcsj = wcsj;
    }

    @Column(name = "LXR", length = 64)
    public String getLxr() {
        return this.lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    @Column(name = "NAME", length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "LXDH", length = 16)
    public String getLxdh() {
        return this.lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Column(name = "IS_COMMITTED")
    public Integer getIsCommitted() {
        return isCommitted;
    }

    public void setIsCommitted(Integer isCommitted) {
        this.isCommitted = isCommitted;
    }

    @Transient
    public String getTimebegin() {
        return timebegin;
    }

    public void setTimebegin(String timebegin) {
        this.timebegin = timebegin;
    }

    @Transient
    public String getTimeover() {
        return timeover;
    }

    public void setTimeover(String timeover) {
        this.timeover = timeover;
    }

    @Transient
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "XGCS", length = 200)
    public Integer getXgcs() {
        return xgcs;
    }

    public void setXgcs(Integer xgcs) {
        this.xgcs = xgcs;
    }

    @Column(name = "CREATEUSERID", updatable = false)
    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 16, updatable = false)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFY_TIME", length = 16)
    public Date getLastmodifytime() {
        return lastmodifytime;
    }

    public void setLastmodifytime(Date lastmodifytime) {
        this.lastmodifytime = lastmodifytime;
    }

    @Column(name = "SEX")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Transient


    @Column(name = "CHIEF_COMPLAINT", length = 40)
    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }


}