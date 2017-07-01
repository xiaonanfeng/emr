package com.zxit.model;

import javax.persistence.*;
import java.util.Date;

/**
 * VAcceptAmbulOutdInfo entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_ACCEPT_AMBUL_OUTD_INFO")
public class VAcceptAmbulOutdInfo implements java.io.Serializable {

    // Fields

    private VAcceptAmbulOutdInfoId id;
    private String jcdz;
    private String swyy;
    private String ddyid;
    private Date slsj;
    private String lxdh;
    private String hzxm;
    private Integer hzxb;
    private Integer nl;
    private String clid;
    private String szfz;
    private Date pcsj;
    private Date ccsj;
    private Date ddxcsj;
    private Date ddbrsbsj;
    private Date scsj;
    private Date swsj;
    private Date wcsj;
    private Date fzsj;
    private Integer tsqk;
    private Integer hzrs;
    private String ysid;
    private String bz;

    private String orgId;
    private Integer orgType;
    private String ssjgdm;

    private String timebegin;
    private String timeover;
    private Integer emrCounts;
    private Double overTimeLimit;
    private Integer showAll;// 显示自己？全部
    private String memberId;// 个人工号

    private String nurse;
    private String doctor;
    private String driver;


    // Constructors

    /**
     * default constructor
     */
    public VAcceptAmbulOutdInfo() {
    }

    /**
     * minimal constructor
     */
    public VAcceptAmbulOutdInfo(VAcceptAmbulOutdInfoId id, String ddyid,
                                Date slsj, String clid) {
        this.id = id;
        this.ddyid = ddyid;
        this.slsj = slsj;
        this.clid = clid;
    }

    /**
     * full constructor
     */
    public VAcceptAmbulOutdInfo(VAcceptAmbulOutdInfoId id, String jcdz,
                                String swyy, String ddyid, Date slsj, String lxdh, String hzxm,
                                Integer hzxb, Integer nl, String clid, String szfz, Date pcsj,
                                Date ccsj, Date ddxcsj, Date scsj, Date swsj, Date wcsj, Date fzsj,
                                Integer tsqk, Integer hzrs, String timebegin, String timeover) {
        this.id = id;
        this.jcdz = jcdz;
        this.swyy = swyy;
        this.ddyid = ddyid;
        this.slsj = slsj;
        this.lxdh = lxdh;
        this.hzxm = hzxm;
        this.hzxb = hzxb;
        this.nl = nl;
        this.clid = clid;
        this.szfz = szfz;
        this.pcsj = pcsj;
        this.ccsj = ccsj;
        this.ddxcsj = ddxcsj;
        this.scsj = scsj;
        this.swsj = swsj;
        this.wcsj = wcsj;
        this.fzsj = fzsj;
        this.tsqk = tsqk;
        this.hzrs = hzrs;
        this.timebegin = timebegin;
        this.timeover = timeover;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "lsh", column = @Column(name = "LSH", nullable = false, length = 20)),
            @AttributeOverride(name = "ccxh", column = @Column(name = "CCXH", nullable = false, precision = 4, scale = 0))})
    public VAcceptAmbulOutdInfoId getId() {
        return this.id;
    }

    public void setId(VAcceptAmbulOutdInfoId id) {
        this.id = id;
    }

    @Column(name = "JCDZ", length = 256)
    public String getJcdz() {
        return this.jcdz;
    }

    public void setJcdz(String jcdz) {
        this.jcdz = jcdz;
    }

    @Column(name = "SWYY", length = 16)
    public String getSwyy() {
        return this.swyy;
    }

    public void setSwyy(String swyy) {
        this.swyy = swyy;
    }

    @Column(name = "DDYID", nullable = false, length = 8)
    public String getDdyid() {
        return this.ddyid;
    }

    public void setDdyid(String ddyid) {
        this.ddyid = ddyid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SLSJ", nullable = false, length = 7)
    public Date getSlsj() {
        return this.slsj;
    }

    public void setSlsj(Date slsj) {
        this.slsj = slsj;
    }

    @Column(name = "LXDH", length = 16)
    public String getLxdh() {
        return this.lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Column(name = "HZXM", length = 64)
    public String getHzxm() {
        return this.hzxm;
    }

    public void setHzxm(String hzxm) {
        this.hzxm = hzxm;
    }

    @Column(name = "HZXB", precision = 4, scale = 0)
    public Integer getHzxb() {
        return this.hzxb;
    }

    public void setHzxb(Integer hzxb) {
        this.hzxb = hzxb;
    }

    @Column(name = "NL", precision = 4, scale = 0)
    public Integer getNl() {
        return this.nl;
    }

    public void setNl(Integer nl) {
        this.nl = nl;
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

    @Column(name = "SSJGDM", length = 16)
    public String getSsjgdm() {
        return ssjgdm;
    }

    public void setSsjgdm(String ssjgdm) {
        this.ssjgdm = ssjgdm;
    }

    @Column(name = "BZ", length = 256)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCSJ", length = 7)
    public Date getPcsj() {
        return this.pcsj;
    }

    public void setPcsj(Date pcsj) {
        this.pcsj = pcsj;
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
    @Column(name = "DBRSBSJ", length = 7)
    public Date getDdbrsbsj() {
        return ddbrsbsj;
    }

    public void setDdbrsbsj(Date ddbrsbsj) {
        this.ddbrsbsj = ddbrsbsj;
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FZSJ", length = 7)
    public Date getFzsj() {
        return this.fzsj;
    }

    public void setFzsj(Date fzsj) {
        this.fzsj = fzsj;
    }

    @Column(name = "TSQK", precision = 4, scale = 0)
    public Integer getTsqk() {
        return this.tsqk;
    }

    public void setTsqk(Integer tsqk) {
        this.tsqk = tsqk;
    }

    @Column(name = "HZRS", precision = 4, scale = 0)
    public Integer getHzrs() {
        return hzrs;
    }

    public void setHzrs(Integer hzrs) {
        this.hzrs = hzrs;
    }

    @Column(name = "YSID")
    public String getYsid() {
        return ysid;
    }

    public void setYsid(String ysid) {
        this.ysid = ysid;
    }

    @Column(name = "NURSE")
    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    @Column(name = "DOCTOR")
    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Column(name = "DRIVER")
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
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

    @Transient
    public Integer getEmrCounts() {
        return emrCounts;
    }

    public void setEmrCounts(Integer emrCounts) {
        this.emrCounts = emrCounts;
    }

    @Transient
    public Double getOverTimeLimit() {
        return overTimeLimit;
    }

    public void setOverTimeLimit(Double overTimeLimit) {
        this.overTimeLimit = overTimeLimit;
    }

    @Transient
    public Integer getShowAll() {
        return showAll;
    }

    public void setShowAll(Integer showAll) {
        this.showAll = showAll;
    }

    @Transient
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Transient
    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }


    @Override
    public String toString() {
        return "VAcceptAmbulOutdInfo [id=" + id + ", jcdz=" + jcdz + ", swyy="
                + swyy + ", ddyid=" + ddyid + ", slsj=" + slsj + ", lxdh="
                + lxdh + ", hzxm=" + hzxm + ", hzxb=" + hzxb + ", nl=" + nl
                + ", clid=" + clid + ", szfz=" + szfz + ", pcsj=" + pcsj
                + ", ccsj=" + ccsj + ", ddxcsj=" + ddxcsj + ", scsj=" + scsj
                + ", swsj=" + swsj + ", wcsj=" + wcsj + ", fzsj=" + fzsj
                + ", tsqk=" + tsqk + ", hzrs=" + hzrs + ", orgId=" + orgId
                + ", timebegin=" + timebegin + ", timeover=" + timeover + "]";
    }

}