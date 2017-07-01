package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SysMemberRoleId entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Embeddable
public class SysMemberRoleId implements java.io.Serializable {

    // Fields

    private String memberId;
    private Integer type;
    private Integer roleCode;
    private Integer flag;

    // Constructors

    /**
     * default constructor
     */
    public SysMemberRoleId() {
    }

    /**
     * full constructor
     */
    public SysMemberRoleId(String memberId, Integer type, Integer roleCode,
                           Integer flag) {
        this.memberId = memberId;
        this.type = type;
        this.roleCode = roleCode;
        this.flag = flag;
    }

    // Property accessors

    @Column(name = "MEMBER_ID", length = 8)
    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Column(name = "TYPE", precision = 4, scale = 0)
    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "ROLE_CODE", precision = 4, scale = 0)
    public Integer getRoleCode() {
        return this.roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof SysMemberRoleId))
            return false;
        SysMemberRoleId castOther = (SysMemberRoleId) other;

        return ((this.getMemberId() == castOther.getMemberId()) || (this
                .getMemberId() != null && castOther.getMemberId() != null && this
                .getMemberId().equals(castOther.getMemberId())))
                && ((this.getType() == castOther.getType()) || (this.getType() != null
                && castOther.getType() != null && this.getType()
                .equals(castOther.getType())))
                && ((this.getRoleCode() == castOther.getRoleCode()) || (this
                .getRoleCode() != null
                && castOther.getRoleCode() != null && this
                .getRoleCode().equals(castOther.getRoleCode())))
                && ((this.getFlag() == castOther.getFlag()) || (this.getFlag() != null
                && castOther.getFlag() != null && this.getFlag()
                .equals(castOther.getFlag())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result
                + (getMemberId() == null ? 0 : this.getMemberId().hashCode());
        result = 37 * result
                + (getType() == null ? 0 : this.getType().hashCode());
        result = 37 * result
                + (getRoleCode() == null ? 0 : this.getRoleCode().hashCode());
        result = 37 * result
                + (getFlag() == null ? 0 : this.getFlag().hashCode());
        return result;
    }

}