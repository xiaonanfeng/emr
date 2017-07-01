package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * MisEmrNotice entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_NOTICE")
@DynamicUpdate(value = true)
public class MisEmrNotice implements java.io.Serializable {

    // Fields

    private String id;
    private String rlt;
    private String atte;
    private String spker;
    private Date noticetime;
    private Date arvtime;
    private String notice;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private String item1;
    private String item2;
    private String item3;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrNotice() {
    }

    /**
     * minimal constructor
     */
    public MisEmrNotice(String id, Date createTime) {
        this.id = id;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrNotice(String id, String rlt, String atte, String spker,
                        Date noticetime, String notice, Date createTime,
                        Date lastModifyTime, Integer xzbm, String item1, String item2,
                        String item3) {
        this.id = id;
        this.rlt = rlt;
        this.atte = atte;
        this.spker = spker;
        this.noticetime = noticetime;
        this.notice = notice;
        this.createTime = createTime;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 20)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "RLT", length = 20)
    public String getRlt() {
        return this.rlt;
    }

    public void setRlt(String rlt) {
        this.rlt = rlt;
    }

    @Column(name = "ATTE", length = 20)
    public String getAtte() {
        return this.atte;
    }

    public void setAtte(String atte) {
        this.atte = atte;
    }

    @Column(name = "SPKER", length = 20)
    public String getSpker() {
        return this.spker;
    }

    public void setSpker(String spker) {
        this.spker = spker;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "NOTICETIME")
    public Date getNoticetime() {
        return this.noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ARVTIME")
    public Date getArvtime() {
        return arvtime;
    }

    public void setArvtime(Date arvtime) {
        this.arvtime = arvtime;
    }


    @Column(name = "NOTICE", length = 100)
    public String getNotice() {
        return this.notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false, length = 7, updatable = false)
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

    @Column(name = "ITEM1", length = 50)
    public String getItem1() {
        return this.item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    @Column(name = "ITEM2", length = 50)
    public String getItem2() {
        return this.item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    @Column(name = "ITEM3", length = 50)
    public String getItem3() {
        return this.item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }


}