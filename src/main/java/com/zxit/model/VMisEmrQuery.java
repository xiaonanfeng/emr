package com.zxit.model;

import javax.persistence.*;
import java.util.Date;

/**
 * VMisEmrQuery entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_QUERY")
public class VMisEmrQuery implements java.io.Serializable {

    // Fields
    private String emrid;
    private Date hjsj;
    private String name;
    private String phone;
    private Integer sex;
    private Integer age;
    private Integer stage;
    private Integer cause;
    private Integer diseaseType;
    private Integer dClassify;
    private Integer condition;
    private Integer isHospitalized;
    private String primDiag;
    private String primDiagR;
    private String lsh;
    private Integer ccxh;
    private Date ccsj;
    private String szfz;
    private String ssjgdm;
    private Integer preEmcResult;
    private String sentTo;// 送往
    private String createuserid;
    private String id;// 医生ID
    private Integer isCommitted;
    private String nurse;//护士
    private String driver;//司机

    private String text_sex;
    private String text_age;
    private String text_stage;
    private String text_diseaseType;
    private String text_condition;
    private String text_primDiag;
    private String text_szfz;
    private String text_preEmcResult;
    private String text_sentTo;
    private String text_id;
    private String text_nurse;
    private String text_driver;

    private String memberId;
    private String orgId;
    private Integer orgType;
    private String timebegin;
    private String timeover;
    private Integer exist;

    private String ysid;
    private String clid;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrQuery() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrQuery(String emrid, Date hjsj) {
        this.emrid = emrid;
        this.hjsj = hjsj;
    }

    /**
     * full constructor
     */
    public VMisEmrQuery(String emrid, Date hjsj, String name, Integer sex,
                        Integer age, Integer stage, Integer diseaseType, Integer condition,
                        String primDiag, String szfz, Integer preEmcResult, String sentTo,
                        String id, Integer isCommitted) {
        this.emrid = emrid;
        this.hjsj = hjsj;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.stage = stage;
        this.diseaseType = diseaseType;
        this.condition = condition;
        this.primDiag = primDiag;
        this.szfz = szfz;
        this.preEmcResult = preEmcResult;
        this.sentTo = sentTo;
        this.id = id;
        this.isCommitted = isCommitted;
    }

    // Property accessors
    @Id
    @Column(name = "EMRID", nullable = false, length = 20)
    public String getEmrid() {
        return this.emrid;
    }

    public void setEmrid(String emrid) {
        this.emrid = emrid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HJSJ", nullable = false, length = 7)
    public Date getHjsj() {
        return this.hjsj;
    }

    public void setHjsj(Date hjsj) {
        this.hjsj = hjsj;
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

    @Column(name = "CAUSE")
    public Integer getCause() {
        return cause;
    }

    public void setCause(Integer cause) {
        this.cause = cause;
    }

    @Column(name = "DISEASE_TYPE", precision = 4, scale = 0)
    public Integer getDiseaseType() {
        return this.diseaseType;
    }

    public void setDiseaseType(Integer diseaseType) {
        this.diseaseType = diseaseType;
    }

    @Column(name = "D_CLASSIFY")
    public Integer getdClassify() {
        return dClassify;
    }

    public void setdClassify(Integer dClassify) {
        this.dClassify = dClassify;
    }

    @Column(name = "CONDITION", precision = 4, scale = 0)
    public Integer getCondition() {
        return this.condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    @Column(name = "IS_HOSPITALIZED", precision = 1, scale = 0)
    public Integer getIsHospitalized() {
        return isHospitalized;
    }

    public void setIsHospitalized(Integer isHospitalized) {
        this.isHospitalized = isHospitalized;
    }

    @Column(name = "PRIM_DIAG", length = 256)
    public String getPrimDiag() {
        return this.primDiag;
    }

    public void setPrimDiag(String primDiag) {
        this.primDiag = primDiag;
    }

    @Column(name = "SZFZ", length = 16)
    public String getSzfz() {
        return this.szfz;
    }

    public void setSzfz(String szfz) {
        this.szfz = szfz;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CCSJ", nullable = false, length = 7)
    public Date getCcsj() {
        return ccsj;
    }

    public void setCcsj(Date ccsj) {
        this.ccsj = ccsj;
    }

    @Column(name = "PRE_EMC_RESULT", precision = 4, scale = 0)
    public Integer getPreEmcResult() {
        return this.preEmcResult;
    }

    public void setPreEmcResult(Integer preEmcResult) {
        this.preEmcResult = preEmcResult;
    }

    @Column(name = "SENT_TO", length = 20)
    public String getSentTo() {
        return this.sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
    }

    @Column(name = "SSJGDM", length = 20)
    public String getSsjgdm() {
        return ssjgdm;
    }

    public void setSsjgdm(String ssjgdm) {
        this.ssjgdm = ssjgdm;
    }

    @Column(name = "ID", length = 8)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NURSE", length = 8)
    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    @Column(name = "DRIVER", length = 8)
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Column(name = "CREATEUSERID", length = 8, updatable = false)
    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    @Column(name = "IS_COMMITTED", precision = 1, scale = 0)
    public Integer getIsCommitted() {
        return this.isCommitted;
    }

    public void setIsCommitted(Integer isCommitted) {
        this.isCommitted = isCommitted;
    }

    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "LSH")
    public String getLsh() {
        return lsh;
    }

    public void setLsh(String lsh) {
        this.lsh = lsh;
    }

    @Column(name = "CCXH")
    public Integer getCcxh() {
        return ccxh;
    }

    public void setCcxh(Integer ccxh) {
        this.ccxh = ccxh;
    }

    @Column(name = "CLID")
    public String getClid() {
        return clid;
    }

    public void setClid(String clid) {
        this.clid = clid;
    }

    @Transient
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Transient
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    @Transient
    public String getText_sex() {
        return text_sex;
    }

    public void setText_sex(String text_sex) {
        this.text_sex = text_sex;
    }

    @Transient
    public String getText_age() {
        return text_age;
    }

    public void setText_age(String text_age) {
        this.text_age = text_age;
    }

    @Transient
    public String getText_stage() {
        return text_stage;
    }

    public void setText_stage(String text_stage) {
        this.text_stage = text_stage;
    }

    @Transient
    public String getText_diseaseType() {
        return text_diseaseType;
    }

    public void setText_diseaseType(String text_diseaseType) {
        this.text_diseaseType = text_diseaseType;
    }

    @Transient
    public String getText_condition() {
        return text_condition;
    }

    public void setText_condition(String text_condition) {
        this.text_condition = text_condition;
    }

    @Transient
    public String getText_primDiag() {
        return text_primDiag;
    }

    public void setText_primDiag(String text_primDiag) {
        this.text_primDiag = text_primDiag;
    }

    @Transient
    public String getText_szfz() {
        return text_szfz;
    }

    public void setText_szfz(String text_szfz) {
        this.text_szfz = text_szfz;
    }

    @Transient
    public String getText_preEmcResult() {
        return text_preEmcResult;
    }

    public void setText_preEmcResult(String text_preEmcResult) {
        this.text_preEmcResult = text_preEmcResult;
    }

    @Transient
    public String getText_sentTo() {
        return text_sentTo;
    }

    public void setText_sentTo(String text_sentTo) {
        this.text_sentTo = text_sentTo;
    }

    @Transient
    public String getText_id() {
        return text_id;
    }

    public void setText_id(String text_id) {
        this.text_id = text_id;
    }

    @Column(name = "PRIM_DIAG_R", length = 64)
    public String getPrimDiagR() {
        return this.primDiagR;
    }

    public void setPrimDiagR(String primDiagR) {
        this.primDiagR = primDiagR;
    }

    @Transient
    public Integer getExist() {
        return exist;
    }

    public void setExist(Integer exist) {
        this.exist = exist;
    }

    @Transient
    public String getText_nurse() {
        return text_nurse;
    }

    public void setText_nurse(String text_nurse) {
        this.text_nurse = text_nurse;
    }

    @Transient
    public String getText_driver() {
        return text_driver;
    }

    public void setText_driver(String text_driver) {
        this.text_driver = text_driver;
    }

    @Override
    public String toString() {
        return "VMisEmrQuery [emrid=" + emrid + ", hjsj=" + hjsj + ", name="
                + name + ", phone=" + phone + ", sex=" + sex + ", age=" + age
                + ", stage=" + stage + ", diseaseType=" + diseaseType
                + ", condition=" + condition + ", primDiag=" + primDiag
                + ", lsh=" + lsh + ", ccxh=" + ccxh + ", szfz=" + szfz
                + ", preEmcResult=" + preEmcResult + ", sentTo=" + sentTo
                + ", id=" + id + ", isCommitted=" + isCommitted + ", text_sex="
                + text_sex + ", text_age=" + text_age + ", text_stage="
                + text_stage + ", text_diseaseType=" + text_diseaseType
                + ", text_condition=" + text_condition + ", text_primDiag="
                + text_primDiag + ", text_szfz=" + text_szfz
                + ", text_preEmcResult=" + text_preEmcResult + ", text_sentTo="
                + text_sentTo + ", text_id=" + text_id + ", orgId=" + orgId
                + ", timebegin=" + timebegin + ", timeover=" + timeover + "]";
    }

    @Transient
    public String getYsid() {
        return ysid;
    }

    public void setYsid(String ysid) {
        this.ysid = ysid;
    }

    @Transient
    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }


}