package com.zxit.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VMisEmrOutdStaff entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_OUTD_STAFF")
public class VMisEmrOutdStaff implements java.io.Serializable {

    // Fields

    private VMisEmrOutdStaffId id;
    private String name;
    private Integer type;
    private String typename;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrOutdStaff() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrOutdStaff(VMisEmrOutdStaffId id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public VMisEmrOutdStaff(VMisEmrOutdStaffId id, String name, Integer type,
                            String typename) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.typename = typename;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "emrId", column = @Column(name = "EMR_ID", nullable = false, length = 20)),
            @AttributeOverride(name = "gh", column = @Column(name = "GH", length = 8))})
    public VMisEmrOutdStaffId getId() {
        return this.id;
    }

    public void setId(VMisEmrOutdStaffId id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 32)
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

    @Column(name = "TYPENAME", length = 64)
    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }


}