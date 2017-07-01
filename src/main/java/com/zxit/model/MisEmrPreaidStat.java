package com.zxit.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 2017/06/29 10:58
 * by nanxiaofeng
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_PREAID_STAT")
public class MisEmrPreaidStat implements java.io.Serializable{

    private String id;
    private String emrId;
    private Integer preaidCode;
    private Integer patientStat;
    private Integer preaidSucceed;
    private Integer reason;
    private Date createTime;
    private String modifyUserid;
    private Date lastModifyTime;
    private Integer xzbm;

    @Id
    @Column(name = "ID", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EMR_ID", nullable = false, length = 20)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "PREAID_CODE", nullable = true, precision = 0)
    public Integer getPreaidCode() {
        return preaidCode;
    }

    public void setPreaidCode(Integer preaidCode) {
        this.preaidCode = preaidCode;
    }

    @Basic
    @Column(name = "PATIENT_STAT", nullable = true, precision = 0)
    public Integer getPatientStat() {
        return patientStat;
    }

    public void setPatientStat(Integer patientStat) {
        this.patientStat = patientStat;
    }

    @Basic
    @Column(name = "PREAID_SUCCEED", nullable = true, precision = 0)
    public Integer getPreaidSucceed() {
        return preaidSucceed;
    }

    public void setPreaidSucceed(Integer preaidSucceed) {
        this.preaidSucceed = preaidSucceed;
    }

    @Basic
    @Column(name = "REASON", nullable = true, precision = 0)
    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }


    @Basic
    @Column(name = "CREATE_TIME", nullable = false,updatable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "MODIFY_USERID", nullable = true, length = 8)
    public String getModifyUserid() {
        return modifyUserid;
    }

    public void setModifyUserid(String modifyUserid) {
        this.modifyUserid = modifyUserid;
    }

    @Basic
    @Column(name = "LAST_MODIFY_TIME", nullable = true)
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Basic
    @Column(name = "XZBM", nullable = true, precision = 0)
    public Integer getXzbm() {
        return xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MisEmrPreaidStat that = (MisEmrPreaidStat) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (preaidCode != null ? !preaidCode.equals(that.preaidCode) : that.preaidCode != null) return false;
        if (patientStat != null ? !patientStat.equals(that.patientStat) : that.patientStat != null) return false;
        if (preaidSucceed != null ? !preaidSucceed.equals(that.preaidSucceed) : that.preaidSucceed != null)
            return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (modifyUserid != null ? !modifyUserid.equals(that.modifyUserid) : that.modifyUserid != null) return false;
        if (lastModifyTime != null ? !lastModifyTime.equals(that.lastModifyTime) : that.lastModifyTime != null)
            return false;
        if (xzbm != null ? !xzbm.equals(that.xzbm) : that.xzbm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (preaidCode != null ? preaidCode.hashCode() : 0);
        result = 31 * result + (patientStat != null ? patientStat.hashCode() : 0);
        result = 31 * result + (preaidSucceed != null ? preaidSucceed.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (modifyUserid != null ? modifyUserid.hashCode() : 0);
        result = 31 * result + (lastModifyTime != null ? lastModifyTime.hashCode() : 0);
        result = 31 * result + (xzbm != null ? xzbm.hashCode() : 0);
        return result;
    }
}






