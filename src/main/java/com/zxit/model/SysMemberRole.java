package com.zxit.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SysMemberRole entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SYS_MEMBER_ROLE")
public class SysMemberRole implements java.io.Serializable {

    // Fields

    private SysMemberRoleId id;
    private SysMemberInfo sysMemberInfo;

    // Constructors

    /**
     * default constructor
     */
    public SysMemberRole() {
    }

    /**
     * minimal constructor
     */
    public SysMemberRole(SysMemberRoleId id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysMemberRole(SysMemberRoleId id, SysMemberInfo sysMemberInfo) {
        this.id = id;
        this.sysMemberInfo = sysMemberInfo;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "memberId", column = @Column(name = "MEMBER_ID", length = 8)),
            @AttributeOverride(name = "type", column = @Column(name = "TYPE", precision = 4, scale = 0)),
            @AttributeOverride(name = "roleCode", column = @Column(name = "ROLE_CODE", precision = 4, scale = 0)),
            @AttributeOverride(name = "flag", column = @Column(name = "FLAG", precision = 1, scale = 0))})
    public SysMemberRoleId getId() {
        return this.id;
    }

    public void setId(SysMemberRoleId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", insertable = false, updatable = false)
    public SysMemberInfo getSysMemberInfo() {
        return this.sysMemberInfo;
    }

    public void setSysMemberInfo(SysMemberInfo sysMemberInfo) {
        this.sysMemberInfo = sysMemberInfo;
    }

}