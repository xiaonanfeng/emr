package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * MisFiles entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_FILES")
public class MisFiles implements java.io.Serializable {

    // Fields

    private String id;
    private String name;
    private String type;
    private String alias;
    private Double filesize;
    private String path;
    private Integer partId;
    private Date uploadTime;
    private String uploadUserid;
    private String ralatedId;
    private Integer flag;
    private Date lastModifyTime;
    private Integer xzbm;
    private Integer relatedType;

    private String relatedTypeStr;

    // Constructors

    /**
     * default constructor
     */
    public MisFiles() {
    }

    /**
     * minimal constructor
     */
    public MisFiles(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisFiles(String id, String name, String type, String alias,
                    Double filesize, String path, Integer partId, Date uploadTime,
                    String uploadUserid, String ralatedId, Integer flag,
                    Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.alias = alias;
        this.filesize = filesize;
        this.path = path;
        this.partId = partId;
        this.uploadTime = uploadTime;
        this.uploadUserid = uploadUserid;
        this.ralatedId = ralatedId;
        this.flag = flag;
        this.lastModifyTime = lastModifyTime;
        this.xzbm = xzbm;
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

    @Column(name = "NAME", length = 64)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TYPE", length = 20)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "ALIAS", length = 64)
    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Transient
    //@Column(name = "SIZE", precision = 10, scale = 3)
    public Double getFilesize() {
        return this.filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }

    @Column(name = "PATH", length = 100)
    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Column(name = "PART_ID", precision = 4, scale = 0)
    public Integer getPartId() {
        return this.partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPLOAD_TIME", length = 7)
    public Date getUploadTime() {
        return this.uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Column(name = "UPLOAD_USERID", length = 8)
    public String getUploadUserid() {
        return this.uploadUserid;
    }

    public void setUploadUserid(String uploadUserid) {
        this.uploadUserid = uploadUserid;
    }

    @Column(name = "RALATED_ID", length = 20)
    public String getRalatedId() {
        return this.ralatedId;
    }

    public void setRalatedId(String ralatedId) {
        this.ralatedId = ralatedId;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_MODIFY_TIME", length = 7)
    public Date getLastModifyTime() {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

    @Column(name = "RELATED_TYPE")
    public Integer getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(Integer relatedType) {
        this.relatedType = relatedType;
    }

    @Transient
    public String getRelatedTypeStr() {
        return relatedTypeStr;
    }

    public void setRelatedTypeStr(String relatedTypeStr) {
        this.relatedTypeStr = relatedTypeStr;
    }


}