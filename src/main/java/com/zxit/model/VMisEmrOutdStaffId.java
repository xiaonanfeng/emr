package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VMisEmrOutdStaffId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class VMisEmrOutdStaffId implements java.io.Serializable {

    // Fields

    private String emrId;
    private String gh;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrOutdStaffId() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrOutdStaffId(String emrId) {
        this.emrId = emrId;
    }

    /**
     * full constructor
     */
    public VMisEmrOutdStaffId(String emrId, String gh) {
        this.emrId = emrId;
        this.gh = gh;
    }

    // Property accessors

    @Column(name = "EMR_ID", nullable = false, length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "GH", length = 8)
    public String getGh() {
        return this.gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof VMisEmrOutdStaffId))
            return false;
        VMisEmrOutdStaffId castOther = (VMisEmrOutdStaffId) other;

        return ((this.getEmrId() == castOther.getEmrId()) || (this.getEmrId() != null
                && castOther.getEmrId() != null && this.getEmrId().equals(
                castOther.getEmrId())))
                && ((this.getGh() == castOther.getGh()) || (this.getGh() != null
                && castOther.getGh() != null && this.getGh().equals(
                castOther.getGh())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getEmrId() == null ? 0 : this.getEmrId().hashCode());
        result = 37 * result + (getGh() == null ? 0 : this.getGh().hashCode());
        return result;
    }

}