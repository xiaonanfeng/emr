package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisEmrMdfprvs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MIS_EMR_MDFPRVS")
public class MisEmrMdfprvs implements java.io.Serializable {

    // Fields

    private String id;
    private String memberId;
    private Integer objecttype;
    private String type;
    private Integer reviewlevel;
    private Integer flag;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrMdfprvs() {
    }

    /**
     * minimal constructor
     */
    public MisEmrMdfprvs(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrMdfprvs(String id, String memberId, Integer objecttype,
                         String type, Integer reviewlevel, Integer flag) {
        this.id = id;
        this.memberId = memberId;
        this.objecttype = objecttype;
        this.type = type;
        this.reviewlevel = reviewlevel;
        this.flag = flag;
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

    @Column(name = "OBJECTID", length = 20)
    public String getMemberid() {
        return this.memberId;
    }

    public void setMemberid(String memberId) {
        this.memberId = memberId;
    }

    @Column(name = "OBJECTTYPE", precision = 8, scale = 0)
    public Integer getObjecttype() {
        return this.objecttype;
    }

    public void setObjecttype(Integer objecttype) {
        this.objecttype = objecttype;
    }

    @Column(name = "TYPE", length = 20)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "REVIEWLEVEL", precision = 8, scale = 0)
    public Integer getReviewlevel() {
        return this.reviewlevel;
    }

    public void setReviewlevel(Integer reviewlevel) {
        this.reviewlevel = reviewlevel;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}