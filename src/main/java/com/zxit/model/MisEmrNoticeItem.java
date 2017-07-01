package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MisEmrNoticeItem entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_NOTICE_ITEM")
public class MisEmrNoticeItem implements java.io.Serializable {

    // Fields

    private Integer itemId;
    private String display;
    private Short sortId;
    private Integer xzbm;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrNoticeItem() {
    }

    /**
     * minimal constructor
     */
    public MisEmrNoticeItem(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * full constructor
     */
    public MisEmrNoticeItem(Integer itemId, String display, Short sortId,
                            Integer xzbm) {
        this.itemId = itemId;
        this.display = display;
        this.sortId = sortId;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ITEM_ID", unique = true, nullable = false, precision = 8, scale = 0)
    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Column(name = "DISPLAY", length = 500)
    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Column(name = "SORT_ID", precision = 4, scale = 0)
    public Short getSortId() {
        return this.sortId;
    }

    public void setSortId(Short sortId) {
        this.sortId = sortId;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

}