package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysCode entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_CODE")
public class SysCode implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;
    private SysCodeType sysCodeType;
    private Integer code;
    private String name;
    private Integer flag;
    private String note;
    private Integer sortId;

    // Constructors

    /**
     * default constructor
     */
    public SysCode() {
    }

    /**
     * minimal constructor
     */
    public SysCode(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysCode(Integer id, SysCodeType sysCodeType, Integer code,
                   String name, Integer flag, String note) {
        this.id = id;
        this.sysCodeType = sysCodeType;
        this.code = code;
        this.name = name;
        this.flag = flag;
        this.note = note;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TYPEID")
    public SysCodeType getSysCodeType() {
        return this.sysCodeType;
    }

    public void setSysCodeType(SysCodeType sysCodeType) {
        this.sysCodeType = sysCodeType;
    }

    @Column(name = "CODE", precision = 4, scale = 0)
    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Column(name = "NAME", length = 64)
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

    @Column(name = "NOTE", length = 256)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "SORT_ID")
    public Integer getSortId() {
        return sortId;
    }


    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "SysCode [id=" + id + ", sysCodeType=" + sysCodeType + ", code="
                + code + ", name=" + name + ", flag=" + flag + ", note=" + note
                + ", sortId=" + sortId + "]";
    }


}