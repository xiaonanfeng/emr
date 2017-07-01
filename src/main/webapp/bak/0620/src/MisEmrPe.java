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
 * MIS_电子病历_体格检查
 */
@SuppressWarnings("serial")
@Entity
@DynamicUpdate(value=true)
@Table(name = "MIS_EMR_PE")
public class MisEmrPe implements java.io.Serializable {
	// Fields

		private String id;
		private Integer TTest;
		private Double t;
		private Integer PTest;
		private Integer p;
		private Integer RTest;
		private Integer r;
		private Integer bpTest;
		private Integer bpL;
		private Integer bpH;
		private Integer posture;
		private Integer conscious;
		private Integer skin;
		private Integer cyanosis;
		private Integer hnEyeTestL;
		private Double hnEyeL;
		private Integer hnPlrL;
		private Integer hnEyeTestR;
		private Double hnEyeR;
		private Integer hnPlrR;
		private String headNeck;
		private String chest;
		private String lung;
		private String heart;
		private String abdomen;
		private String limb;
		private String spine;
		private String nerveReflex;
		private String peOthers;
		private Date createTime;
		private Date lastModifyTime;
		private Integer xzbm;

		// Constructors

		/** default constructor */
		public MisEmrPe() {
		}

		/** minimal constructor */
		public MisEmrPe(String id, Date createTime) {
			this.id = id;
			this.createTime = createTime;
		}

		/** full constructor */
		public MisEmrPe(String id, Integer TTest, Double t, Integer PTest, Integer p,
				Integer RTest, Integer r, Integer bpTest, Integer bpL, Integer bpH,
				Integer posture, Integer conscious, Integer skin, Integer cyanosis,
				Integer hnEyeTestL, Double hnEyeL, Integer hnPlrL, Integer hnEyeTestR,
				Double hnEyeR, Integer hnPlrR, String headNeck, String chest,
				String lung, String heart, String abdomen, String limb,
				String spine, String nerveReflex, String peOthers, Date createTime,
				Date lastModifyTime, Integer xzbm) {
			this.id = id;
			this.TTest = TTest;
			this.t = t;
			this.PTest = PTest;
			this.p = p;
			this.RTest = RTest;
			this.r = r;
			this.bpTest = bpTest;
			this.bpL = bpL;
			this.bpH = bpH;
			this.posture = posture;
			this.conscious = conscious;
			this.skin = skin;
			this.cyanosis = cyanosis;
			this.hnEyeTestL = hnEyeTestL;
			this.hnEyeL = hnEyeL;
			this.hnPlrL = hnPlrL;
			this.hnEyeTestR = hnEyeTestR;
			this.hnEyeR = hnEyeR;
			this.hnPlrR = hnPlrR;
			this.headNeck = headNeck;
			this.chest = chest;
			this.lung = lung;
			this.heart = heart;
			this.abdomen = abdomen;
			this.limb = limb;
			this.spine = spine;
			this.nerveReflex = nerveReflex;
			this.peOthers = peOthers;
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

		@Column(name = "T_TEST", precision = 4, scale = 0)
		public Integer getTTest() {
			return this.TTest;
		}

		public void setTTest(Integer TTest) {
			this.TTest = TTest;
		}

		@Column(name = "T", precision = 4, scale = 1)
		public Double getT() {
			return this.t;
		}

		public void setT(Double t) {
			this.t = t;
		}

		@Column(name = "P_TEST", precision = 4, scale = 0)
		public Integer getPTest() {
			return this.PTest;
		}

		public void setPTest(Integer PTest) {
			this.PTest = PTest;
		}

		@Column(name = "P", precision = 4, scale = 0)
		public Integer getP() {
			return this.p;
		}

		public void setP(Integer p) {
			this.p = p;
		}

		@Column(name = "R_TEST", precision = 4, scale = 0)
		public Integer getRTest() {
			return this.RTest;
		}

		public void setRTest(Integer RTest) {
			this.RTest = RTest;
		}

		@Column(name = "R", precision = 4, scale = 0)
		public Integer getR() {
			return this.r;
		}

		public void setR(Integer r) {
			this.r = r;
		}

		@Column(name = "BP_TEST", precision = 4, scale = 0)
		public Integer getBpTest() {
			return this.bpTest;
		}

		public void setBpTest(Integer bpTest) {
			this.bpTest = bpTest;
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

		@Column(name = "POSTURE", precision = 4, scale = 0)
		public Integer getPosture() {
			return this.posture;
		}

		public void setPosture(Integer posture) {
			this.posture = posture;
		}

		@Column(name = "CONSCIOUS", precision = 4, scale = 0)
		public Integer getConscious() {
			return this.conscious;
		}

		public void setConscious(Integer conscious) {
			this.conscious = conscious;
		}

		@Column(name = "SKIN", precision = 4, scale = 0)
		public Integer getSkin() {
			return this.skin;
		}

		public void setSkin(Integer skin) {
			this.skin = skin;
		}

		@Column(name = "CYANOSIS", precision = 4, scale = 0)
		public Integer getCyanosis() {
			return this.cyanosis;
		}

		public void setCyanosis(Integer cyanosis) {
			this.cyanosis = cyanosis;
		}

		@Column(name = "HN_EYE_TEST_L", precision = 4, scale = 0)
		public Integer getHnEyeTestL() {
			return this.hnEyeTestL;
		}

		public void setHnEyeTestL(Integer hnEyeTestL) {
			this.hnEyeTestL = hnEyeTestL;
		}

		@Column(name = "HN_EYE_L", precision = 5, scale = 1)
		public Double getHnEyeL() {
			return this.hnEyeL;
		}

		public void setHnEyeL(Double hnEyeL) {
			this.hnEyeL = hnEyeL;
		}

		@Column(name = "HN_PLR_L", precision = 4, scale = 0)
		public Integer getHnPlrL() {
			return this.hnPlrL;
		}

		public void setHnPlrL(Integer hnPlrL) {
			this.hnPlrL = hnPlrL;
		}

		@Column(name = "HN_EYE_TEST_R", precision = 4, scale = 0)
		public Integer getHnEyeTestR() {
			return this.hnEyeTestR;
		}

		public void setHnEyeTestR(Integer hnEyeTestR) {
			this.hnEyeTestR = hnEyeTestR;
		}

		@Column(name = "HN_EYE_R", precision = 5, scale = 1)
		public Double getHnEyeR() {
			return this.hnEyeR;
		}

		public void setHnEyeR(Double hnEyeR) {
			this.hnEyeR = hnEyeR;
		}

		@Column(name = "HN_PLR_R", precision = 4, scale = 0)
		public Integer getHnPlrR() {
			return this.hnPlrR;
		}

		public void setHnPlrR(Integer hnPlrR) {
			this.hnPlrR = hnPlrR;
		}

		@Column(name = "HEAD_NECK", length = 512)
		public String getHeadNeck() {
			return this.headNeck;
		}

		public void setHeadNeck(String headNeck) {
			this.headNeck = headNeck;
		}

		@Column(name = "CHEST", length = 512)
		public String getChest() {
			return this.chest;
		}

		public void setChest(String chest) {
			this.chest = chest;
		}

		@Column(name = "LUNG", length = 512)
		public String getLung() {
			return this.lung;
		}

		public void setLung(String lung) {
			this.lung = lung;
		}

		@Column(name = "HEART", length = 512)
		public String getHeart() {
			return this.heart;
		}

		public void setHeart(String heart) {
			this.heart = heart;
		}

		@Column(name = "ABDOMEN", length = 512)
		public String getAbdomen() {
			return this.abdomen;
		}

		public void setAbdomen(String abdomen) {
			this.abdomen = abdomen;
		}

		@Column(name = "LIMB", length = 512)
		public String getLimb() {
			return this.limb;
		}

		public void setLimb(String limb) {
			this.limb = limb;
		}

		@Column(name = "SPINE", length = 512)
		public String getSpine() {
			return this.spine;
		}

		public void setSpine(String spine) {
			this.spine = spine;
		}

		@Column(name = "NERVE_REFLEX", length = 512)
		public String getNerveReflex() {
			return this.nerveReflex;
		}

		public void setNerveReflex(String nerveReflex) {
			this.nerveReflex = nerveReflex;
		}

		@Column(name = "PE_OTHERS", length = 512)
		public String getPeOthers() {
			return this.peOthers;
		}

		public void setPeOthers(String peOthers) {
			this.peOthers = peOthers;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "CREATE_TIME", nullable = false, length = 7)
		public Date getCreateTime() {
			return this.createTime;
		}

		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}

		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "LAST_MODIFY_TIME", length = 7,updatable = false)
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
	
}