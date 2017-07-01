package com.zxit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SysCodeType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_CODE_TYPE")
public class SysCodeType implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer typeid;
    private String name;
    private Integer parentTypeid;
    private Integer flag;
    private String note;
    private Set<SysCode> sysCodes = new HashSet<SysCode>(0);

    // Constructors

    /**
     * default constructor
     */
    public SysCodeType() {
    }

    /**
     * minimal constructor
     */
    public SysCodeType(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * full constructor
     */
    public SysCodeType(Integer typeid, String name, Integer parentTypeid,
                       Integer flag, String note, Set<SysCode> sysCodes) {
        this.typeid = typeid;
        this.name = name;
        this.parentTypeid = parentTypeid;
        this.flag = flag;
        this.note = note;
        this.sysCodes = sysCodes;
    }

    // Property accessors
    @Id
    @Column(name = "TYPEID", unique = true, nullable = false)
    public Integer getTypeid() {
        return this.typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(name = "NAME", length = 16)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PARENT_TYPEID")
    public Integer getParentTypeid() {
        return this.parentTypeid;
    }

    public void setParentTypeid(Integer parentTypeid) {
        this.parentTypeid = parentTypeid;
    }

    @Column(name = "FLAG", precision = 1)
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sysCodeType")
    public Set<SysCode> getSysCodes() {
        return this.sysCodes;
    }

    public void setSysCodes(Set<SysCode> sysCodes) {
        this.sysCodes = sysCodes;
    }

}