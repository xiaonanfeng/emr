package com.zxit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * MisCategory entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MIS_CATEGORY")
public class MisCategory implements java.io.Serializable {

    // Fields

    private Integer id;
    private String name;
    private Integer parentId;
    private String url;
    private String img;
    private String title;
    private String content;
    private Integer partId;
    private Integer sortId;
    private Integer flag;
    private Integer urlOpentype;
    private String openMode;


    // Constructors

    /**
     * default constructor
     */
    public MisCategory() {
    }

    /**
     * minimal constructor
     */
    public MisCategory(Integer id) {
        this.id = id;
    }

    /**
     * full constructor
     */
    public MisCategory(Integer id, String name, String url, String img,
                       String title, String content, Integer partId, Integer sortId,
                       Integer flag, Integer urlOpentype) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.img = img;
        this.title = title;
        this.content = content;
        this.partId = partId;
        this.sortId = sortId;
        this.flag = flag;
        this.urlOpentype = urlOpentype;
    }

    // Property accessors
    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 8, scale = 0)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "NAME", length = 32)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "PARENTID")
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    @Column(name = "URL", length = 100)
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "IMG", length = 100)
    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "TITLE", length = 64)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "CONTENT", length = 32)
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(name = "PART_ID", precision = 4, scale = 0)
    public Integer getPartId() {
        return this.partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    @Column(name = "SORT_ID", precision = 4, scale = 0)
    public Integer getSortId() {
        return this.sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    @Column(name = "FLAG", precision = 1, scale = 0)
    public Integer getFlag() {
        return this.flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Column(name = "URL_OPENTYPE", precision = 4, scale = 0)
    public Integer getUrlOpentype() {
        return this.urlOpentype;
    }

    public void setUrlOpentype(Integer urlOpentype) {
        this.urlOpentype = urlOpentype;
    }

    @Transient
    public String getOpenMode() {
        if (this.urlOpentype == 1) {
            openMode = "tabMenu";
        }
        if (this.urlOpentype == 2) {
            openMode = "newWin";
        }
        return openMode;
    }

    public void setOpenMode(String openMode) {
        this.openMode = openMode;
    }


}