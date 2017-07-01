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
 * MisEmrReview entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_REVIEW")
public class MisEmrReview implements java.io.Serializable {

    // Fields

    private Integer id;
    private String emrId;
    private String revUserid;
    private Date revTime;
    private String revResult;
    private String item1;
    private String item2;
    private String item3;
    private String item4;
    private String item5;
    private String item6;
    private String item7;
    private String item8;
    private String item9;
    private String item10;
    private String item11;
    private String item12;
    private String item13;
    private String item14;
    private String item15;
    private String item16;
    private String item17;
    private String item18;
    private String item19;
    private String item20;
    private String item21;
    private String item22;
    private String item23;
    private String item24;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrReview() {
    }

    /**
     * minimal constructor
     */
    public MisEmrReview(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrReview(Integer id, String emrId, String revUserid, Date revTime,
                        String revResult, String item1, String item2, String item3,
                        String item4, String item5, String item6, String item7,
                        String item8, String item9, String item10, String item11,
                        String item12, String item13, String item14, String item15,
                        String item16, String item17, String item18, String item19,
                        String item20, String item21, String item22, String item23,
                        String item24) {
        this.id = id;
        this.emrId = emrId;
        this.revUserid = revUserid;
        this.revTime = revTime;
        this.revResult = revResult;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
        this.item7 = item7;
        this.item8 = item8;
        this.item9 = item9;
        this.item10 = item10;
        this.item11 = item11;
        this.item12 = item12;
        this.item13 = item13;
        this.item14 = item14;
        this.item15 = item15;
        this.item16 = item16;
        this.item17 = item17;
        this.item18 = item18;
        this.item19 = item19;
        this.item20 = item20;
        this.item21 = item21;
        this.item22 = item22;
        this.item23 = item23;
        this.item24 = item24;
    }

    // Property accessors
    @Id
    @SequenceGenerator(name = "SEQ_MIS_EMR_REVIEW", sequenceName = "SEQ_MIS_EMR_REVIEW", allocationSize = 1)
    @GeneratedValue(generator = "SEQ_MIS_EMR_REVIEW", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true, nullable = false, precision = 10, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "EMR_ID", length = 20)
    public String getEmrId() {
        return this.emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Column(name = "REV_USERID", length = 8)
    public String getRevUserid() {
        return this.revUserid;
    }

    public void setRevUserid(String revUserid) {
        this.revUserid = revUserid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "REV_TIME", length = 7)
    public Date getRevTime() {
        return this.revTime;
    }

    public void setRevTime(Date revTime) {
        this.revTime = revTime;
    }

    @Column(name = "REV_RESULT", length = 200)
    public String getRevResult() {
        return this.revResult;
    }

    public void setRevResult(String revResult) {
        this.revResult = revResult;
    }

    @Column(name = "ITEM1", length = 64)
    public String getItem1() {
        return this.item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    @Column(name = "ITEM2", length = 64)
    public String getItem2() {
        return this.item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    @Column(name = "ITEM3", length = 64)
    public String getItem3() {
        return this.item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    @Column(name = "ITEM4", length = 64)
    public String getItem4() {
        return this.item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    @Column(name = "ITEM5", length = 64)
    public String getItem5() {
        return this.item5;
    }

    public void setItem5(String item5) {
        this.item5 = item5;
    }

    @Column(name = "ITEM6", length = 64)
    public String getItem6() {
        return this.item6;
    }

    public void setItem6(String item6) {
        this.item6 = item6;
    }

    @Column(name = "ITEM7", length = 64)
    public String getItem7() {
        return this.item7;
    }

    public void setItem7(String item7) {
        this.item7 = item7;
    }

    @Column(name = "ITEM8", length = 64)
    public String getItem8() {
        return this.item8;
    }

    public void setItem8(String item8) {
        this.item8 = item8;
    }

    @Column(name = "ITEM9", length = 64)
    public String getItem9() {
        return this.item9;
    }

    public void setItem9(String item9) {
        this.item9 = item9;
    }

    @Column(name = "ITEM10", length = 64)
    public String getItem10() {
        return this.item10;
    }

    public void setItem10(String item10) {
        this.item10 = item10;
    }

    @Column(name = "ITEM11", length = 64)
    public String getItem11() {
        return this.item11;
    }

    public void setItem11(String item11) {
        this.item11 = item11;
    }

    @Column(name = "ITEM12", length = 64)
    public String getItem12() {
        return this.item12;
    }

    public void setItem12(String item12) {
        this.item12 = item12;
    }

    @Column(name = "ITEM13", length = 64)
    public String getItem13() {
        return this.item13;
    }

    public void setItem13(String item13) {
        this.item13 = item13;
    }

    @Column(name = "ITEM14", length = 64)
    public String getItem14() {
        return this.item14;
    }

    public void setItem14(String item14) {
        this.item14 = item14;
    }

    @Column(name = "ITEM15", length = 64)
    public String getItem15() {
        return this.item15;
    }

    public void setItem15(String item15) {
        this.item15 = item15;
    }

    @Column(name = "ITEM16", length = 64)
    public String getItem16() {
        return this.item16;
    }

    public void setItem16(String item16) {
        this.item16 = item16;
    }

    @Column(name = "ITEM17", length = 64)
    public String getItem17() {
        return this.item17;
    }

    public void setItem17(String item17) {
        this.item17 = item17;
    }

    @Column(name = "ITEM18", length = 64)
    public String getItem18() {
        return this.item18;
    }

    public void setItem18(String item18) {
        this.item18 = item18;
    }

    @Column(name = "ITEM19", length = 64)
    public String getItem19() {
        return this.item19;
    }

    public void setItem19(String item19) {
        this.item19 = item19;
    }

    @Column(name = "ITEM20", length = 64)
    public String getItem20() {
        return this.item20;
    }

    public void setItem20(String item20) {
        this.item20 = item20;
    }

    @Column(name = "ITEM21", length = 64)
    public String getItem21() {
        return this.item21;
    }

    public void setItem21(String item21) {
        this.item21 = item21;
    }

    @Column(name = "ITEM22", length = 64)
    public String getItem22() {
        return this.item22;
    }

    public void setItem22(String item22) {
        this.item22 = item22;
    }

    @Column(name = "ITEM23", length = 64)
    public String getItem23() {
        return this.item23;
    }

    public void setItem23(String item23) {
        this.item23 = item23;
    }

    @Column(name = "ITEM24", length = 64)
    public String getItem24() {
        return this.item24;
    }

    public void setItem24(String item24) {
        this.item24 = item24;
    }

}