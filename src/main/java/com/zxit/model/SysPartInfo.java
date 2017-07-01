package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SysPartInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SYS_PART_INFO")
public class SysPartInfo implements java.io.Serializable {

    // Fields

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    // Constructors

    /**
     * default constructor
     */
    public SysPartInfo() {
    }

    /**
     * minimal constructor
     */
    public SysPartInfo(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysPartInfo(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Column(name = "NAME", length = 256)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}