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
 * SysMemberInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_MEMBER_INFO")
public class SysMemberInfo implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private SysOrgInfo sysOrgInfo;
    private String name;
    private String password;
    private Integer type;
    private Integer ssks;
    private Integer flag;
    private String phoneNum;
    private String textNum;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public SysMemberInfo() {
    }

    /**
     * minimal constructor
     */
    public SysMemberInfo(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysMemberInfo(String id, SysOrgInfo sysOrgInfo, String name,
                         String password, Integer type, Integer ssks, Integer flag,
                         String phoneNum, String textNum, Date createTime,
                         Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.sysOrgInfo = sysOrgInfo;
        this.name = name;
        this.password = password;
        this.type = type;
        this.ssks = ssks;
        this.flag = flag;
        this.phoneNum = phoneNum;
        this.textNum = textNum;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 8)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ORG_ID")
    public SysOrgInfo getSysOrgInfo() {
        return this.sysOrgInfo;
    }

    public void setSysOrgInfo(SysOrgInfo sysOrgInfo) {
        this.sysOrgInfo = sysOrgInfo;
    }

    @Column(name = "NAME", length = 32)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PASSWORD", length = 32)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "TYPE", precision = 4, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "SSKS")
    public Integer getSsks() {
        return this.ssks;
    }

    public void setSsks(Integer ssks) {
        this.ssks = ssks;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "PHONE_NUM", length = 16)
    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Column(name = "TEXT_NUM", length = 16)
    public String getTextNum() {
        return this.textNum;
    }

    public void setTextNum(String textNum) {
        this.textNum = textNum;
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

    @Override
    public String toString() {
        return "SysMemberInfo [id=" + id + ", sysOrgInfo=" + sysOrgInfo
                + ", name=" + name + ", password=" + password + ", type="
                + type + ", ssks=" + ssks + ", flag=" + flag + ", phoneNum="
                + phoneNum + ", textNum=" + textNum + ", createTime="
                + createTime + ", lastModifyTime=" + lastModifyTime + ", xzbm="
                + xzbm + "]";
    }


}