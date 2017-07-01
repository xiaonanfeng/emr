package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * MisEmrQcSummary entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_QC_SUMMARY")
public class MisEmrQcSummary implements java.io.Serializable {

    // Fields

    private Long id;
    private Integer qcLevel;
    private String orgId;
    private String org_text;

    private String emrMonth;
    private String sumUserid;
    private String sumUser_text;

    private Date sumTime;
    private Date startTime;
    private Date endTime;
    private Integer emrSum;//	病历总数
    private Integer deathEmrSum;//	死亡病历数
    private Integer criticalEmrSum;//	病危病历数
    private Integer severeEmrSum;//	病情重病历数
    private Integer mediumErmSum;//病情中病历数
    private Integer lightEmrSum;//病情轻病历数

    private Integer spotCheckSum;//	抽查总数
    private Double spotCheckRate;//	抽查率

    private String spontCheckPercent;//抽样率显示字符串

    private Integer defectEmrSum;//	问题病历总数	？？？
    private Integer fullCreditErmSum;//满分病例数

    private Integer firstAGrade;//	甲A级病历数
    private Integer firstBGrade;    //	甲B级病历数
    private Integer firstCGrade;//	甲C级病历数
    private Integer secondGrade;//	乙级病历数
    private Integer thirdGrade;//	丙级病历数
    private String defectSummary;
    private String defectReason;
    private String improvement;
    private String responsible;
    private String followUp;
    private String fuUser;
    private Date fuTime;
    private Integer xzbm;

    private String timebegin;
    private String timeover;


    // Constructors

    /**
     * default constructor
     */
    public MisEmrQcSummary() {
    }

    /**
     * minimal constructor
     */
    public MisEmrQcSummary(Long id, Integer qcLevel) {
        this.id = id;
        this.qcLevel = qcLevel;
    }

    /**
     * full constructor
     */
    public MisEmrQcSummary(Long id, Integer qcLevel, String orgId, String emrMonth,
                           String sumUserid, Date sumTime, Date startTime, Date endTime,
                           Integer emrSum, Integer deathEmrSum, Integer criticalEmrSum,
                           Integer severeEmrSum, Integer spotCheckSum, Double spotCheckRate,
                           Integer defectEmrSum, Integer firstAGrade, Integer firstBGrade,
                           Integer firstCGrade, Integer secondGrade, Integer thirdGrade,
                           String defectSummary, String defectReason, String improvement,
                           String responsible, String followUp, String fuUser, Date fuTime,
                           Integer xzbm) {
        this.id = id;
        this.qcLevel = qcLevel;
        this.orgId = orgId;
        this.emrMonth = emrMonth;
        this.sumUserid = sumUserid;
        this.sumTime = sumTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.emrSum = emrSum;
        this.deathEmrSum = deathEmrSum;
        this.criticalEmrSum = criticalEmrSum;
        this.severeEmrSum = severeEmrSum;
        this.spotCheckSum = spotCheckSum;
        this.spotCheckRate = spotCheckRate;
        this.defectEmrSum = defectEmrSum;
        this.firstAGrade = firstAGrade;
        this.firstBGrade = firstBGrade;
        this.firstCGrade = firstCGrade;
        this.secondGrade = secondGrade;
        this.thirdGrade = thirdGrade;
        this.defectSummary = defectSummary;
        this.defectReason = defectReason;
        this.improvement = improvement;
        this.responsible = responsible;
        this.followUp = followUp;
        this.fuUser = fuUser;
        this.fuTime = fuTime;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "QC_LEVEL", nullable = false, precision = 4, scale = 0)
    public Integer getQcLevel() {
        return this.qcLevel;
    }

    public void setQcLevel(Integer qcLevel) {
        this.qcLevel = qcLevel;
    }

    @Column(name = "ORG_ID", length = 16)
    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Column(name = "EMR_MONTH")
    public String getEmrMonth() {
        return this.emrMonth;
    }

    public void setEmrMonth(String emrMonth) {
        this.emrMonth = emrMonth;
    }

    @Column(name = "SUM_USERID", length = 16)
    public String getSumUserid() {
        return this.sumUserid;
    }

    public void setSumUserid(String sumUserid) {
        this.sumUserid = sumUserid;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SUM_TIME", length = 7)
    public Date getSumTime() {
        return this.sumTime;
    }

    public void setSumTime(Date sumTime) {
        this.sumTime = sumTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_TIME", length = 7)
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME", length = 7)
    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Column(name = "EMR_SUM", precision = 8, scale = 0)
    public Integer getEmrSum() {
        return this.emrSum;
    }

    public void setEmrSum(Integer emrSum) {
        this.emrSum = emrSum;
    }

    @Column(name = "DEATH_EMR_SUM", precision = 8, scale = 0)
    public Integer getDeathEmrSum() {
        return this.deathEmrSum;
    }

    public void setDeathEmrSum(Integer deathEmrSum) {
        this.deathEmrSum = deathEmrSum;
    }

    @Column(name = "CRITICAL_EMR_SUM", precision = 8, scale = 0)
    public Integer getCriticalEmrSum() {
        return this.criticalEmrSum;
    }

    public void setCriticalEmrSum(Integer criticalEmrSum) {
        this.criticalEmrSum = criticalEmrSum;
    }

    @Column(name = "SEVERE_EMR_SUM", precision = 8, scale = 0)
    public Integer getSevereEmrSum() {
        return this.severeEmrSum;
    }

    public void setSevereEmrSum(Integer severeEmrSum) {
        this.severeEmrSum = severeEmrSum;
    }

    @Column(name = "SPOT_CHECK_SUM", precision = 8, scale = 0)
    public Integer getSpotCheckSum() {
        return this.spotCheckSum;
    }

    public void setSpotCheckSum(Integer spotCheckSum) {
        this.spotCheckSum = spotCheckSum;
    }

    @Column(name = "SPOT_CHECK_RATE", precision = 6, scale = 4)
    public Double getSpotCheckRate() {
        return this.spotCheckRate;
    }

    public void setSpotCheckRate(Double spotCheckRate) {
        this.spotCheckRate = spotCheckRate;
    }

    @Column(name = "DEFECT_EMR_SUM", precision = 8, scale = 0)
    public Integer getDefectEmrSum() {
        return this.defectEmrSum;
    }

    public void setDefectEmrSum(Integer defectEmrSum) {
        this.defectEmrSum = defectEmrSum;
    }

    @Column(name = "FIRST_A_GRADE", precision = 8, scale = 0)
    public Integer getFirstAGrade() {
        return this.firstAGrade;
    }

    public void setFirstAGrade(Integer firstAGrade) {
        this.firstAGrade = firstAGrade;
    }

    @Column(name = "FIRST_B_GRADE", precision = 8, scale = 0)
    public Integer getFirstBGrade() {
        return this.firstBGrade;
    }

    public void setFirstBGrade(Integer firstBGrade) {
        this.firstBGrade = firstBGrade;
    }

    @Column(name = "FIRST_C_GRADE", precision = 8, scale = 0)
    public Integer getFirstCGrade() {
        return this.firstCGrade;
    }

    public void setFirstCGrade(Integer firstCGrade) {
        this.firstCGrade = firstCGrade;
    }

    @Column(name = "SECOND_GRADE", precision = 8, scale = 0)
    public Integer getSecondGrade() {
        return this.secondGrade;
    }

    public void setSecondGrade(Integer secondGrade) {
        this.secondGrade = secondGrade;
    }

    @Column(name = "THIRD_GRADE", precision = 8, scale = 0)
    public Integer getThirdGrade() {
        return this.thirdGrade;
    }

    @Column(name = "MEDIUM_EMR_SUM", precision = 8, scale = 0)
    public Integer getMediumErmSum() {
        return mediumErmSum;
    }

    public void setMediumErmSum(Integer mediumErmSum) {
        this.mediumErmSum = mediumErmSum;
    }

    @Column(name = "LIGHT_EMR_SUM", precision = 8, scale = 0)
    public Integer getLightEmrSum() {
        return lightEmrSum;
    }

    public void setLightEmrSum(Integer lightEmrSum) {
        this.lightEmrSum = lightEmrSum;
    }

    @Column(name = "FULLCREDIT_EMR_SUM", precision = 8, scale = 0)
    public Integer getFullCreditErmSum() {
        return fullCreditErmSum;
    }

    public void setFullCreditErmSum(Integer fullCreditErmSum) {
        this.fullCreditErmSum = fullCreditErmSum;
    }

    public void setThirdGrade(Integer thirdGrade) {
        this.thirdGrade = thirdGrade;
    }

    @Column(name = "DEFECT_SUMMARY", length = 1000)
    public String getDefectSummary() {
        return this.defectSummary;
    }

    public void setDefectSummary(String defectSummary) {
        this.defectSummary = defectSummary;
    }

    @Column(name = "DEFECT_REASON", length = 1000)
    public String getDefectReason() {
        return this.defectReason;
    }

    public void setDefectReason(String defectReason) {
        this.defectReason = defectReason;
    }

    @Column(name = "IMPROVEMENT", length = 1000)
    public String getImprovement() {
        return this.improvement;
    }

    public void setImprovement(String improvement) {
        this.improvement = improvement;
    }

    @Column(name = "RESPONSIBLE", length = 8)
    public String getResponsible() {
        return this.responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    @Column(name = "FOLLOW_UP", length = 1000)
    public String getFollowUp() {
        return this.followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    @Column(name = "FU_USER", length = 8)
    public String getFuUser() {
        return this.fuUser;
    }

    public void setFuUser(String fuUser) {
        this.fuUser = fuUser;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FU_TIME", length = 7)
    public Date getFuTime() {
        return this.fuTime;
    }

    public void setFuTime(Date fuTime) {
        this.fuTime = fuTime;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }

    @Transient
    public String getSpontCheckPercent() {
        return spontCheckPercent;
    }

    public void setSpontCheckPercent(String spontCheckPercent) {
        this.spontCheckPercent = spontCheckPercent;
    }

    @Override
    public String toString() {
        return "MisEmrQcSummary [id=" + id + ", qcLevel=" + qcLevel
                + ", orgId=" + orgId + ", emrMonth=" + emrMonth
                + ", sumUserid=" + sumUserid + ", sumTime=" + sumTime
                + ", startTime=" + startTime + ", endTime=" + endTime
                + ", emrSum=" + emrSum + ", deathEmrSum=" + deathEmrSum
                + ", criticalEmrSum=" + criticalEmrSum + ", severeEmrSum="
                + severeEmrSum + ", spotCheckSum=" + spotCheckSum
                + ", spotCheckRate=" + spotCheckRate + ", spontCheckPercent="
                + spontCheckPercent + ", defectEmrSum=" + defectEmrSum
                + ", firstAGrade=" + firstAGrade + ", firstBGrade="
                + firstBGrade + ", firstCGrade=" + firstCGrade
                + ", secondGrade=" + secondGrade + ", thirdGrade=" + thirdGrade
                + ", defectSummary=" + defectSummary + ", defectReason="
                + defectReason + ", improvement=" + improvement
                + ", responsible=" + responsible + ", followUp=" + followUp
                + ", fuUser=" + fuUser + ", fuTime=" + fuTime + ", xzbm="
                + xzbm + "]";
    }


    @Transient
    public String getOrg_text() {
        return org_text;
    }

    public void setOrg_text(String org_text) {
        this.org_text = org_text;
    }

    @Transient
    public String getSumUser_text() {
        return sumUser_text;
    }

    public void setSumUser_text(String sumUser_text) {
        this.sumUser_text = sumUser_text;
    }

    @Transient
    public String getTimebegin() {
        return timebegin;
    }

    public void setTimebegin(String timebegin) {
        this.timebegin = timebegin;
    }

    @Transient
    public String getTimeover() {
        return timeover;
    }

    public void setTimeover(String timeover) {
        this.timeover = timeover;
    }

}