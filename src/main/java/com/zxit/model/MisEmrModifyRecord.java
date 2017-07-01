package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * MisEmrModifyRecord entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_MODIFY_RECORD")
public class MisEmrModifyRecord implements java.io.Serializable {

    // Fields

    private Long id;
    private String emrId;
    private String modifyUserid;
    private Date modifyTime;
    private String modifyTable;
    private String modifyContent;
    private String before;
    private String after;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrModifyRecord() {
    }

    /**
     * minimal constructor
     */
    public MisEmrModifyRecord(Long id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrModifyRecord(Long id, String emrId, String modifyUserid,
                              Date modifyTime, String modifyTable, String modifyContent,
                              String before, String after) {
        this.id = id;
        this.emrId = emrId;
        this.modifyUserid = modifyUserid;
        this.modifyTime = modifyTime;
        this.modifyTable = modifyTable;
        this.modifyContent = modifyContent;
        this.before = before;
        this.after = after;
    }

    // Property accessors

    /**
     * 利用序做主键
     *
     * @return
     */
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    @SequenceGenerator(name = "SEQ_MIS_EMR_MODIFY_RECORD", sequenceName = "SEQ_MIS_EMR_MODIFY_RECORD", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_MODIFY_RECORD", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "MODIFY_USERID", length = 20)
    public String getModifyUserid() {
        return this.modifyUserid;
    }

    public void setModifyUserid(String modifyUserid) {
        this.modifyUserid = modifyUserid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_TIME", length = 7)
    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Column(name = "MODIFY_TABLE", length = 320)
    public String getModifyTable() {
        return this.modifyTable;
    }

    public void setModifyTable(String modifyTable) {
        this.modifyTable = modifyTable;
    }

    @Column(name = "MODIFY_CONTENT", length = 320)
    public String getModifyContent() {
        return this.modifyContent;
    }

    public void setModifyContent(String modifyContent) {
        this.modifyContent = modifyContent;
    }

    @Column(name = "BEFORE", length = 200)
    public String getBefore() {
        return this.before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    @Column(name = "AFTER", length = 200)
    public String getAfter() {
        return this.after;
    }

    public void setAfter(String after) {
        this.after = after;
    }


}