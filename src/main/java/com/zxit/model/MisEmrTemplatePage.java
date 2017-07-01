package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_EMR_TEMPLATE_PAGE")
public class MisEmrTemplatePage implements java.io.Serializable {

    // Fields

    private String id;
    private Integer flag;
    private String pagename;
    private String htmlid;
    private String csskey;
    private String cssvalue;

    // Constructors

    /**
     * default constructor
     */
    public MisEmrTemplatePage() {
    }

    /**
     * minimal constructor
     */
    public MisEmrTemplatePage(String id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisEmrTemplatePage(String id, Integer flag, String pagename,
                              String htmlid, String csskey, String cssvalue) {
        this.id = id;
        this.flag = flag;
        this.pagename = pagename;
        this.htmlid = htmlid;
        this.csskey = csskey;
        this.cssvalue = cssvalue;
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

    @Column(name = "FLAG", precision = 22, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "PAGENAME", length = 20)
    public String getPagename() {
        return this.pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }

    @Column(name = "HTMLID", length = 20)
    public String getHtmlid() {
        return this.htmlid;
    }

    public void setHtmlid(String htmlid) {
        this.htmlid = htmlid;
    }

    @Column(name = "CSSKEY", length = 20)
    public String getCsskey() {
        return this.csskey;
    }

    public void setCsskey(String csskey) {
        this.csskey = csskey;
    }

    @Column(name = "CSSVALUE", length = 20)
    public String getCssvalue() {
        return this.cssvalue;
    }

    public void setCssvalue(String cssvalue) {
        this.cssvalue = cssvalue;
    }

}