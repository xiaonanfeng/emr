package com.zxit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * VMisEmrHandover entity. @author MyEclipse Persistence Tools
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "V_MIS_EMR_HANDOVER")
public class VMisEmrHandover implements java.io.Serializable {
    // Fields
    private String id;
    private String sentTo;
    private String name;
    private Integer sex;
    private Integer age;
    private Integer condition;
    private String chiefComplaint;
    private Integer p;
    private Integer r;
    private Integer bpL;
    private Integer bpH;
    private Integer conscious;
    private String primDiag;
    private String sceneTreat;
    private String szfz;
    private Date hoTime;
    private String hoDoctor;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrHandover() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrHandover(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public VMisEmrHandover(String id, String sentTo, String name, Integer sex,
                           Integer age, Integer condition, String chiefComplaint, Integer p,
                           Integer r, Integer bpL, Integer bpH, String primDiag, String sceneTreat,
                           String szfz, Date hoTime, String hoDoctor) {
        this.id = id;
        this.sentTo = sentTo;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.condition = condition;
        this.chiefComplaint = chiefComplaint;
        this.p = p;
        this.r = r;
        this.bpL = bpL;
        this.bpH = bpH;
        this.primDiag = primDiag;
        this.sceneTreat = sceneTreat;
        this.szfz = szfz;
        this.hoTime = hoTime;
        this.hoDoctor = hoDoctor;
    }

    // Property accessors
    @Id
    @Column(name = "ID", nullable = false, length = 20)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "SENT_TO", length = 20)
    public String getSentTo() {
        return this.sentTo;
    }

    public void setSentTo(String sentTo) {
        this.sentTo = sentTo;
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

    @Column(name = "CONDITION", precision = 4, scale = 0)
    public Integer getCondition() {
        return this.condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    @Column(name = "CHIEF_COMPLAINT", length = 40)
    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    @Column(name = "P", precision = 4, scale = 0)
    public Integer getP() {
        return this.p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    @Column(name = "R", precision = 4, scale = 0)
    public Integer getR() {
        return this.r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    @Column(name = "BP_L", precision = 4, scale = 0)
    public Integer getBpL() {
        return this.bpL;
    }

    public void setBpL(Integer bpL) {
        this.bpL = bpL;
    }

    @Column(name = "BP_H", precision = 4, scale = 0)
    public Integer getBpH() {
        return this.bpH;
    }

    public void setBpH(Integer bpH) {
        this.bpH = bpH;
    }

    @Column(name = "PRIM_DIAG", length = 64)
    public String getPrimDiag() {
        return this.primDiag;
    }

    public void setPrimDiag(String primDiag) {
        this.primDiag = primDiag;
    }

    @Column(name = "SCENE_TREAT", length = 32)
    public String getSceneTreat() {
        return this.sceneTreat;
    }

    public void setSceneTreat(String sceneTreat) {
        this.sceneTreat = sceneTreat;
    }

    @Column(name = "SZFZ", length = 16)
    public String getSzfz() {
        return this.szfz;
    }

    public void setSzfz(String szfz) {
        this.szfz = szfz;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HO_TIME", length = 7)
    public Date getHoTime() {
        return this.hoTime;
    }

    public void setHoTime(Date hoTime) {
        this.hoTime = hoTime;
    }

    @Column(name = "HO_DOCTOR", length = 64)
    public String getHoDoctor() {
        return this.hoDoctor;
    }

    public void setHoDoctor(String hoDoctor) {
        this.hoDoctor = hoDoctor;
    }

    @Column(name = "CONSCIOUS", length = 64)
    public Integer getConscious() {
        return conscious;
    }

    public void setConscious(Integer conscious) {
        this.conscious = conscious;
    }


}