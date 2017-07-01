package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysLogs entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SYS_LOGS")
public class SysLogs implements java.io.Serializable {

    // Fields

    private String id;
    private Date logdate;
    private String message;
    private String note;
    private String type;

    // Constructors

    /**
     * default constructor
     */
    public SysLogs() {
    }

    /**
     * minimal constructor
     */
    public SysLogs(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public SysLogs(String id, Date logdate, String note, String type) {
        this.id = id;
        this.logdate = logdate;
        this.note = note;
        this.type = type;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 25)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOGDATE", length = 7)
    public Date getLogdate() {
        return this.logdate;
    }

    public void setLogdate(Date logdate) {
        this.logdate = logdate;
    }

    @Column(name = "NOTE", length = 2000)
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Column(name = "TYPE", length = 20)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "MESSAGE")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}