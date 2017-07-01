package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VMisEmrScoreType entity. @author MyEclipse Persistence Tools
 * TODO 必须实现自定义排序
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "V_MIS_EMR_SCORE_TYPE")

public class VMisEmrScoreType implements java.io.Serializable, Comparable<VMisEmrScoreType> {

    // Fields

    private Integer typeid;
    private String typename;
    private Integer maxscore;
    private String remark;
    private Integer flag;
    private Integer xzbm;
    private Integer rowspan;

    // Constructors

    /**
     * default constructor
     */
    public VMisEmrScoreType() {
    }

    /**
     * minimal constructor
     */
    public VMisEmrScoreType(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * full constructor
     */
    public VMisEmrScoreType(Integer typeid, String typename, Integer maxscore,
                            String remark, Integer flag, Integer xzbm) {
        this.typeid = typeid;
        this.typename = typename;
        this.maxscore = maxscore;
        this.remark = remark;
        this.flag = flag;
        this.xzbm = xzbm;
    }

    // Property accessors
    @Id
    @Column(name = "TYPEID", nullable = false, precision = 8, scale = 0)
    public Integer getTypeid() {
        return this.typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    @Column(name = "TYPENAME", length = 128)
    public String getTypename() {
        return this.typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Column(name = "MAXSCORE", precision = 4, scale = 0)
    public Integer getMaxscore() {
        return this.maxscore;
    }

    public void setMaxscore(Integer maxscore) {
        this.maxscore = maxscore;
    }

    @Column(name = "REMARK", length = 2000)
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "XZBM", precision = 8, scale = 0)
    public Integer getXzbm() {
        return this.xzbm;
    }

    public void setXzbm(Integer xzbm) {
        this.xzbm = xzbm;
    }


    @Column(name = "ROWSPAN", precision = 22, scale = 0)
    public Integer getRowspan() {
        return rowspan;
    }

    public void setRowspan(Integer rowspan) {
        this.rowspan = rowspan;
    }

    @Override
    public int compareTo(VMisEmrScoreType o) {
        //根据姓名排序
        int num = new Integer(this.typeid).compareTo(new Integer(o.typeid));
        if (num == 0)
            return this.typeid.compareTo(o.typeid);
        return num;
    }

}