package com.zxit.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysOrgInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_ORG_INFO")
public class SysOrgInfo implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String orgId;
    private String name;
    private String alias;
    private Integer type;
    private String ssjgdm;
    private Integer xzbm;
    private Integer ywddq;
    private Integer jgdj;
    private String dz;
    private String lxdh;
    private Integer sfzx;
    private Date createTime;
    private Date lastModifyTime;
    private Set<SysMemberInfo> sysMemberInfos = new HashSet<SysMemberInfo>(0);


    // Constructors

    @Override
    public String toString() {
        return "SysOrgInfo [orgId=" + orgId + ", name=" + name + ", type="
                + type + ", ssjgdm=" + ssjgdm + ", xzbm=" + xzbm + ", ywddq="
                + ywddq + ", jgdj=" + jgdj + ", dz=" + dz + ", lxdh=" + lxdh
                + ", sfzx=" + sfzx + ", createTime=" + createTime
                + ", lastModifyTime=" + lastModifyTime
                + ", sysMemberInfos=" + sysMemberInfos + "]";
    }

    /**
     * default constructor
     */
    public SysOrgInfo() {
    }

    /**
     * minimal constructor
     */
    public SysOrgInfo(String orgId) {
        this.orgId = orgId;
    }


    /**
     * full constructor
     */
    public SysOrgInfo(String orgId, String name, Integer type, String ssjgdm,
                      Integer xzbm, Integer ywddq, Integer jgdj, String dz, String lxdh,
                      Integer sfzx, Date createTime, Date lastModifyTime,
                      Set<SysMemberInfo> sysMemberInfos) {
        this.orgId = orgId;
        this.name = name;
        this.type = type;
        this.ssjgdm = ssjgdm;
        this.xzbm = xzbm;
        this.ywddq = ywddq;
        this.jgdj = jgdj;
        this.dz = dz;
        this.lxdh = lxdh;
        this.sfzx = sfzx;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.sysMemberInfos = sysMemberInfos;
    }

    // Property accessors
    @Id
    @Column(name = "ORG_ID", unique = true, nullable = false, length = 8)
    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "NAME", length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TYPE", precision = 4, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "SSJGDM", length = 8)
    public String getSsjgdm() {
        return this.ssjgdm;
    }

    public void setSsjgdm(String ssjgdm) {
        this.ssjgdm = ssjgdm;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

    @Column(name = "YWDDQ", precision = 1, scale = 0)
    public Integer getYwddq() {
        return this.ywddq;
    }

    public void setYwddq(Integer ywddq) {
        this.ywddq = ywddq;
    }

    @Column(name = "JGDJ", precision = 4, scale = 0)
    public Integer getJgdj() {
        return this.jgdj;
    }

    public void setJgdj(Integer jgdj) {
        this.jgdj = jgdj;
    }

    @Column(name = "DZ", length = 256)
    public String getDz() {
        return this.dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    @Column(name = "LXDH", length = 16)
    public String getLxdh() {
        return this.lxdh;
    }

    public void setLxdh(String lxdh) {
        this.lxdh = lxdh;
    }

    @Column(name = "SFZX", precision = 1, scale = 0)
    public Integer getSfzx() {
        return this.sfzx;
    }

    public void setSfzx(Integer sfzx) {
        this.sfzx = sfzx;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", length = 27, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFY_TIME", length = 27)
    public Date getLastModifyTime() {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Column(name = "ALIAS")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }


}