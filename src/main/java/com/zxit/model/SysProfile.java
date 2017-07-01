package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysProfile entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SYS_PROFILE")
public class SysProfile implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private String value;

    // Constructors

    /**
     * default constructor
     */
    public SysProfile() {
    }

    /**
     * minimal constructor
     */
    public SysProfile(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysProfile(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
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

    @Column(name = "VALUE", length = 64)
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}