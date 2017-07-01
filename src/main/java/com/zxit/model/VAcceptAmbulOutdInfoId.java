package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VAcceptAmbulOutdInfoId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class VAcceptAmbulOutdInfoId implements java.io.Serializable {

    // Fields

    private String lsh;
    private Integer ccxh;

    // Constructors

    /**
     * default constructor
     */
    public VAcceptAmbulOutdInfoId() {
    }

    /**
     * full constructor
     */
    public VAcceptAmbulOutdInfoId(String lsh, Integer ccxh) {
        this.lsh = lsh;
        this.ccxh = ccxh;
    }

    // Property accessors


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

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof VAcceptAmbulOutdInfoId))
            return false;
        VAcceptAmbulOutdInfoId castOther = (VAcceptAmbulOutdInfoId) other;

        return ((this.getLsh() == castOther.getLsh()) || (this.getLsh() != null
                && castOther.getLsh() != null && this.getLsh().equals(
                castOther.getLsh())))
                && ((this.getCcxh() == castOther.getCcxh()) || (this.getCcxh() != null
                && castOther.getCcxh() != null && this.getCcxh()
                .equals(castOther.getCcxh())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getLsh() == null ? 0 : this.getLsh().hashCode());
        result = 37 * result
                + (getCcxh() == null ? 0 : this.getCcxh().hashCode());
        return result;
    }

}