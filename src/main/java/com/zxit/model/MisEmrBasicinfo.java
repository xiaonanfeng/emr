package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;


/**
 * 基础信息
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value = true)
@Table(name = "MIS_EMR_BASICINFO")
public class MisEmrBasicinfo implements java.io.Serializable {

    // Fields

    private String id;
    private String lsh;
    private Integer ccxh;
    private String name;
    private Integer sex;
    private Integer age;
    private Integer stage;
    private Integer nation;
    private String phone;
    private String address;
    private Integer ethnic;
    private Integer spot;
    private String sentTo;
    private Integer cause;
    private Integer condition;
    private Integer diseaseType;
    private Integer preEmcResult;
    private String idCard;
    private String chiefComplaint;
    private Integer hxProvider;
    private String presentHx;
    private Integer pastHx;
    private Integer heartCondition;
    private Integer heartIllness;
    private Integer heartHx;
    private String heartTherapy;
    private Integer hbp;
    private Integer hbpHx;
    private Integer bpH;
    private Integer bpL;
    private String hbpTherapy;
    private Integer diabetes;
    private Integer dmType;
    private Integer dmHx;
    private String dmTherapy;
    private String otherHx;
    private Integer drugAllergy;
    private String drugName;
    private Integer isCommitted;
    private Date createTime;
    private Date lastModifyTime;
    private Integer xzbm;
    private String createuserid;
    private String contact;
    private Integer isHosptial;
    private Integer dClassify;
    private String emrCode;

    private String sendToOther;


    // Constructors

    /**
     * default constructor
     */
    public MisEmrBasicinfo() {
    }

    /**
     * minimal constructor
     */
    public MisEmrBasicinfo(String id, String lsh, Integer ccxh, Date createTime) {
        this.id = id;
        this.lsh = lsh;
        this.ccxh = ccxh;
        this.createTime = createTime;
    }

    /**
     * full constructor
     */
    public MisEmrBasicinfo(String id, String lsh, Integer ccxh, String name,
                           Integer sex, Integer age, Integer stage, Integer nation, Integer ethnic,
                           Integer spot, String sentTo, Integer cause, Integer condition,
                           Integer diseaseType, Integer preEmcResult, String idCard,
                           String chiefComplaint, Integer hxProvider, String presentHx,
                           Integer pastHx, Integer heartCondition, Integer heartIllness,
                           Integer heartHx, String heartTherapy, Integer hbp, Integer hbpHx,
                           Integer bpH, Integer bpL, String hbpTherapy, Integer diabetes,
                           Integer dmType, Integer dmHx, String dmTherapy, String otherHx,
                           Integer drugAllergy, String drugName, Date createTime,
                           Date lastModifyTime, Integer xzbm) {
        this.id = id;
        this.lsh = lsh;
        this.ccxh = ccxh;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.stage = stage;
        this.nation = nation;
        this.ethnic = ethnic;
        this.spot = spot;
        this.sentTo = sentTo;
        this.cause = cause;
        this.condition = condition;
        this.diseaseType = diseaseType;
        this.preEmcResult = preEmcResult;
        this.idCard = idCard;
        this.chiefComplaint = chiefComplaint;
        this.hxProvider = hxProvider;
        this.presentHx = presentHx;
        this.pastHx = pastHx;
        this.heartCondition = heartCondition;
        this.heartIllness = heartIllness;
        this.heartHx = heartHx;
        this.heartTherapy = heartTherapy;
        this.hbp = hbp;
        this.hbpHx = hbpHx;
        this.bpH = bpH;
        this.bpL = bpL;
        this.hbpTherapy = hbpTherapy;
        this.diabetes = diabetes;
        this.dmType = dmType;
        this.dmHx = dmHx;
        this.dmTherapy = dmTherapy;
        this.otherHx = otherHx;
        this.drugAllergy = drugAllergy;
        this.drugName = drugName;
        this.createTime = createTime;
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

    @Column(name = "LSH", nullable = false, length = 20)
    public String getLsh() {
        return this.lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    @Column(name = "CCXH", nullable = false, precision = 4, scale = 0)
    public Integer getCcxh() {
        return this.ccxh;
    }

    public void setCcxh(Integer ccxh) {
        this.ccxh = ccxh;
    }

    @Column(name = "NAME", length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "SEX", precision = 4, scale = 0)
    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "AGE", precision = 8, scale = 0)
    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(name = "STAGE", precision = 4, scale = 0)
    public Integer getStage() {
        return this.stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    @Column(name = "NATION", precision = 4, scale = 0)
    public Integer getNation() {
        return this.nation;
    }

    public void setNation(Integer nation) {
        this.nation = nation;
    }

    @Column(name = "ETHNIC", precision = 4, scale = 0)
    public Integer getEthnic() {
        return this.ethnic;
    }

    public void setEthnic(Integer ethnic) {
        this.ethnic = ethnic;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "SPOT", precision = 4, scale = 0)
    public Integer getSpot() {
        return this.spot;
    }

    public void setSpot(Integer spot) {
        this.spot = spot;
    }

    @Column(name = "SENT_TO", length = 20)
    public String getSentTo() {
        return this.sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    @Column(name = "CAUSE", precision = 4, scale = 0)
    public Integer getCause() {
        return this.cause;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    @Column(name = "CONDITION", precision = 4, scale = 0)
    public Integer getCondition() {
        return this.condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    @Column(name = "DISEASE_TYPE", precision = 4, scale = 0)
    public Integer getDiseaseType() {
        return this.diseaseType;
    }

    public void setDiseaseType(Integer diseaseType) {
        this.diseaseType = diseaseType;
    }

    @Column(name = "PRE_EMC_RESULT", precision = 4, scale = 0)
    public Integer getPreEmcResult() {
        return this.preEmcResult;
    }

    public void setPreEmcResult(Integer preEmcResult) {
        this.preEmcResult = preEmcResult;
    }

    @Column(name = "ID_CARD")
    public String getIdCard() {
        return this.idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Column(name = "CHIEF_COMPLAINT", length = 80)
    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    @Column(name = "HX_PROVIDER", precision = 4, scale = 0)
    public Integer getHxProvider() {
        return this.hxProvider;
    }

    public void setHxProvider(Integer hxProvider) {
        this.hxProvider = hxProvider;
    }

    @Column(name = "PRESENT_HX", length = 64)
    public String getPresentHx() {
        return this.presentHx;
    }

    public void setPresentHx(String presentHx) {
        this.presentHx = presentHx;
    }

    @Column(name = "PAST_HX", precision = 4, scale = 0)
    public Integer getPastHx() {
        return this.pastHx;
    }

    public void setPastHx(Integer pastHx) {
        this.pastHx = pastHx;
    }

    @Column(name = "HEART_CONDITION", precision = 4, scale = 0)
    public Integer getHeartCondition() {
        return this.heartCondition;
    }

    public void setHeartCondition(Integer heartCondition) {
        this.heartCondition = heartCondition;
    }

    @Column(name = "HEART_ILLNESS", precision = 4, scale = 0)
    public Integer getHeartIllness() {
        return this.heartIllness;
    }

    public void setHeartIllness(Integer heartIllness) {
        this.heartIllness = heartIllness;
    }

    @Column(name = "HEART_HX", precision = 4, scale = 0)
    public Integer getHeartHx() {
        return this.heartHx;
    }

    public void setHeartHx(Integer heartHx) {
        this.heartHx = heartHx;
    }

    @Column(name = "HEART_THERAPY", length = 64)
    public String getHeartTherapy() {
        return this.heartTherapy;
    }

    public void setHeartTherapy(String heartTherapy) {
        this.heartTherapy = heartTherapy;
    }

    @Column(name = "HBP", precision = 4, scale = 0)
    public Integer getHbp() {
        return this.hbp;
    }

    public void setHbp(Integer hbp) {
        this.hbp = hbp;
    }

    @Column(name = "HBP_HX", precision = 4, scale = 0)
    public Integer getHbpHx() {
        return this.hbpHx;
    }

    public void setHbpHx(Integer hbpHx) {
        this.hbpHx = hbpHx;
    }

    @Column(name = "BP_H", precision = 4, scale = 0)
    public Integer getBpH() {
        return this.bpH;
    }

    public void setBpH(Integer bpH) {
        this.bpH = bpH;
    }

    @Column(name = "BP_L", precision = 4, scale = 0)
    public Integer getBpL() {
        return this.bpL;
    }

    public void setBpL(Integer bpL) {
        this.bpL = bpL;
    }

    @Column(name = "HBP_THERAPY", length = 64)
    public String getHbpTherapy() {
        return this.hbpTherapy;
    }

    public void setHbpTherapy(String hbpTherapy) {
        this.hbpTherapy = hbpTherapy;
    }

    @Column(name = "DIABETES", precision = 4, scale = 0)
    public Integer getDiabetes() {
        return this.diabetes;
    }

    public void setDiabetes(Integer diabetes) {
        this.diabetes = diabetes;
    }

    @Column(name = "DM_TYPE", precision = 4, scale = 0)
    public Integer getDmType() {
        return this.dmType;
    }

    public void setDmType(Integer dmType) {
        this.dmType = dmType;
    }

    @Column(name = "DM_HX", precision = 4, scale = 0)
    public Integer getDmHx() {
        return this.dmHx;
    }

    public void setDmHx(Integer dmHx) {
        this.dmHx = dmHx;
    }

    @Column(name = "DM_THERAPY", length = 64)
    public String getDmTherapy() {
        return this.dmTherapy;
    }

    public void setDmTherapy(String dmTherapy) {
        this.dmTherapy = dmTherapy;
    }

    @Column(name = "OTHER_HX", length = 64)
    public String getOtherHx() {
        return this.otherHx;
    }

    public void setOtherHx(String otherHx) {
        this.otherHx = otherHx;
    }

    @Column(name = "DRUG_ALLERGY", precision = 4, scale = 0)
    public Integer getDrugAllergy() {
        return this.drugAllergy;
    }

    public void setDrugAllergy(Integer drugAllergy) {
        this.drugAllergy = drugAllergy;
    }

    @Column(name = "DRUG_NAME", length = 64)
    public String getDrugName() {
        return this.drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Column(name = "IS_COMMITTED")
    public Integer getIsCommitted() {
        return isCommitted;
    }

    public void setIsCommitted(Integer isCommitted) {
        this.isCommitted = isCommitted;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME", nullable = false, length = 7, updatable = false)
    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Column(name = "CREATEUSERID", length = 8, updatable = false)
    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    @Column(name = "CONTACT")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "IS_HOSPITALIZED")
    public Integer getIsHosptial() {
        return isHosptial;
    }

    public void setIsHosptial(Integer isHosptial) {
        this.isHosptial = isHosptial;
    }

    @Column(name = "D_CLASSIFY")
    public Integer getdClassify() {
        return dClassify;
    }

    public void setdClassify(Integer dClassify) {
        this.dClassify = dClassify;
    }

    @Column(name = "EMR_CODE")
    public String getEmrCode() {
        return emrCode;
    }

    public void setEmrCode(String emrCode) {
        this.emrCode = emrCode;
    }

    @Column(name = "SEND_TO_OTHER")
    public String getSendToOther() {
        return sendToOther;
    }

    public void setSendToOther(String sendToOther) {
        this.sendToOther = sendToOther;
    }


}