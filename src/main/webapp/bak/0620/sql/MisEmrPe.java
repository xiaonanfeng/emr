package com.zxit.model;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;



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
	private Integer tTest;
	private Double t;
	private Integer pTest;
	private Integer p;
	private Integer rTest;
	private Integer r;
	private Integer bpL;
	private Integer bpH;
	private Integer bpTest;
	private Integer posture;
	private Integer conscious;
	private Integer skin;
	private Integer cyanosis;
	private Short hnEyeTestL;
	private Double hnEyeL;
	private Integer hnPlrL;
	private Short hnEyeTestR;
	private Double hnEyeR;
	private Integer hnPlrR;
	private Integer hnNeck;
	private String hnTender;
	private String hnOther;
	private String chestThorax;
	private Integer chestTender;
	private String chestOther;
	private Integer lungBsL;
	private Integer lungRL;
	private Integer lungBsR;
	private Integer lungRR;
	private String lungOther;
	private Integer hrtRate;
	private Integer hrtRhythm;
	private Integer hrtSound;
	private Integer hrtMurmur;
	private String hrtOther;
	private Integer abdAbd;
	private Integer abdWall;
	private String abdTender;
	private String abdRebt;
	private Integer abdLiver;
	private String abdLiverSize;
	private Integer abdSpleen;
	private String abdSplSize;
	private Integer abdBs;
	private String abdOther;
	
	private String limbMs;
	private String limbMf;
	private String limbEdema;
	
	private Integer limbMsTest;
	private Integer limbMfTest;
	private Integer limbEdemaTest;
	
	private Integer limbMsL;
	private Integer limbMsLue;
	private Integer limbMsLle;
	private Integer limbMsR;
	private Integer limbMsRue;
	private Integer limbMsRle;
	private Integer limbEdemaBle;
	private Integer limbEdemaLle;
	private Integer limbEdemaRle;
	private String limbOther;
	private Integer spine;
	private String spnOther;
	private Integer nrPr;
	private Integer nrBabinski;
	private Integer nrBabinskiR;
	
	private String peOther;
	
	private Integer nrMes;
	private String nrOther;
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
	public MisEmrPe(String id, Double t, Integer p, Integer r, Integer bpL,
			Integer bpH, Integer posture, Integer conscious, Integer skin,
			Integer cyanosis, Double hnEyeL, Integer hnPlrL, Double hnEyeR,
			Integer hnPlrR, Integer hnNeck, String hnTender, String hnOther,
			String chestThorax, Integer chestTender, String chestOther,
			Integer lungBsL, Integer lungRL, Integer lungBsR, Integer lungRR,
			String lungOther, Integer hrtRate, Integer hrtRhythm, Integer hrtSound,
			Integer hrtMurmur, String hrtOther, Integer abdAbd, Integer abdWall,
			String abdTender, String abdRebt, Integer abdLiver,
			String abdLiverSize, Integer abdSpleen, String abdSplSize,
			Integer abdBs, String abdOther, String limbMs, String limbMf,
			Integer limbMsL, Integer limbMsLue, Integer limbMsLle, Integer limbMsR,
			Integer limbMsRue, Integer limbMsRle, Integer limbEdemaBle,
			Integer limbEdemaLle, Integer limbEdemaRle, String limbOther,
			Integer spine, String spnOther, Integer nrPr, Integer nrBabinski,
			Integer nrMes, String nrOther, Date createTime, Date lastModifyTime,
			Integer xzbm) {
		this.id = id;
		this.t = t;
		this.p = p;
		this.r = r;
		this.bpL = bpL;
		this.bpH = bpH;
		this.posture = posture;
		this.conscious = conscious;
		this.skin = skin;
		this.cyanosis = cyanosis;
		this.hnEyeL = hnEyeL;
		this.hnPlrL = hnPlrL;
		this.hnEyeR = hnEyeR;
		this.hnPlrR = hnPlrR;
		this.hnNeck = hnNeck;
		this.hnTender = hnTender;
		this.hnOther = hnOther;
		this.chestThorax = chestThorax;
		this.chestTender = chestTender;
		this.chestOther = chestOther;
		this.lungBsL = lungBsL;
		this.lungRL = lungRL;
		this.lungBsR = lungBsR;
		this.lungRR = lungRR;
		this.lungOther = lungOther;
		this.hrtRate = hrtRate;
		this.hrtRhythm = hrtRhythm;
		this.hrtSound = hrtSound;
		this.hrtMurmur = hrtMurmur;
		this.hrtOther = hrtOther;
		this.abdAbd = abdAbd;
		this.abdWall = abdWall;
		this.abdTender = abdTender;
		this.abdRebt = abdRebt;
		this.abdLiver = abdLiver;
		this.abdLiverSize = abdLiverSize;
		this.abdSpleen = abdSpleen;
		this.abdSplSize = abdSplSize;
		this.abdBs = abdBs;
		this.abdOther = abdOther;
		this.limbMs = limbMs;
		this.limbMf = limbMf;
		this.limbMsL = limbMsL;
		this.limbMsLue = limbMsLue;
		this.limbMsLle = limbMsLle;
		this.limbMsR = limbMsR;
		this.limbMsRue = limbMsRue;
		this.limbMsRle = limbMsRle;
		this.limbEdemaBle = limbEdemaBle;
		this.limbEdemaLle = limbEdemaLle;
		this.limbEdemaRle = limbEdemaRle;
		this.limbOther = limbOther;
		this.spine = spine;
		this.spnOther = spnOther;
		this.nrPr = nrPr;
		this.nrBabinski = nrBabinski;
		this.nrMes = nrMes;
		this.nrOther = nrOther;
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

	@Column(name = "T", precision = 4, scale = 1)
	public Double getT() {
		return this.t;
	}

	public void setT(Double t) {
		this.t = t;
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
	public Short getHnEyeTestL() {
		return this.hnEyeTestL;
	}

	public void setHnEyeTestL(Short hnEyeTestL) {
		this.hnEyeTestL = hnEyeTestL;
	}
	
	@Column(name = "HN_EYE_L")
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
	public Short getHnEyeTestR() {
		return this.hnEyeTestR;
	}

	public void setHnEyeTestR(Short hnEyeTestR) {
		this.hnEyeTestR = hnEyeTestR;
	}

	@Column(name = "HN_EYE_R")
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

	@Column(name = "HN_NECK", precision = 4, scale = 0)
	public Integer getHnNeck() {
		return this.hnNeck;
	}

	public void setHnNeck(Integer hnNeck) {
		this.hnNeck = hnNeck;
	}

	@Column(name = "HN_TENDER", length = 32)
	public String getHnTender() {
		return this.hnTender;
	}

	public void setHnTender(String hnTender) {
		this.hnTender = hnTender;
	}

	@Column(name = "HN_OTHER", length = 128)
	public String getHnOther() {
		return this.hnOther;
	}

	public void setHnOther(String hnOther) {
		this.hnOther = hnOther;
	}

	@Column(name = "CHEST_THORAX", precision = 4, scale = 0)
	public String getChestThorax() {
		return this.chestThorax;
	}

	public void setChestThorax(String chestThorax) {
		this.chestThorax = chestThorax;
	}

	@Column(name = "CHEST_TENDER", precision = 4, scale = 0)
	public Integer getChestTender() {
		return this.chestTender;
	}

	public void setChestTender(Integer chestTender) {
		this.chestTender = chestTender;
	}

	@Column(name = "CHEST_OTHER", length = 128)
	public String getChestOther() {
		return this.chestOther;
	}

	public void setChestOther(String chestOther) {
		this.chestOther = chestOther;
	}

	@Column(name = "LUNG_BS_L", precision = 4, scale = 0)
	public Integer getLungBsL() {
		return this.lungBsL;
	}

	public void setLungBsL(Integer lungBsL) {
		this.lungBsL = lungBsL;
	}

	@Column(name = "LUNG_R_L", precision = 4, scale = 0)
	public Integer getLungRL() {
		return this.lungRL;
	}

	public void setLungRL(Integer lungRL) {
		this.lungRL = lungRL;
	}

	@Column(name = "LUNG_BS_R", precision = 4, scale = 0)
	public Integer getLungBsR() {
		return this.lungBsR;
	}

	public void setLungBsR(Integer lungBsR) {
		this.lungBsR = lungBsR;
	}

	@Column(name = "LUNG_R_R", precision = 4, scale = 0)
	public Integer getLungRR() {
		return this.lungRR;
	}

	public void setLungRR(Integer lungRR) {
		this.lungRR = lungRR;
	}

	@Column(name = "LUNG_OTHER", length = 128)
	public String getLungOther() {
		return this.lungOther;
	}

	public void setLungOther(String lungOther) {
		this.lungOther = lungOther;
	}

	@Column(name = "HRT_RATE", precision = 4, scale = 0)
	public Integer getHrtRate() {
		return this.hrtRate;
	}

	public void setHrtRate(Integer hrtRate) {
		this.hrtRate = hrtRate;
	}

	@Column(name = "HRT_RHYTHM", precision = 4, scale = 0)
	public Integer getHrtRhythm() {
		return this.hrtRhythm;
	}

	public void setHrtRhythm(Integer hrtRhythm) {
		this.hrtRhythm = hrtRhythm;
	}

	@Column(name = "HRT_SOUND", precision = 4, scale = 0)
	public Integer getHrtSound() {
		return this.hrtSound;
	}

	public void setHrtSound(Integer hrtSound) {
		this.hrtSound = hrtSound;
	}

	@Column(name = "HRT_MURMUR", precision = 4, scale = 0)
	public Integer getHrtMurmur() {
		return this.hrtMurmur;
	}

	public void setHrtMurmur(Integer hrtMurmur) {
		this.hrtMurmur = hrtMurmur;
	}

	@Column(name = "HRT_OTHER", length = 128)
	public String getHrtOther() {
		return this.hrtOther;
	}

	public void setHrtOther(String hrtOther) {
		this.hrtOther = hrtOther;
	}

	@Column(name = "ABD_ABD", precision = 4, scale = 0)
	public Integer getAbdAbd() {
		return this.abdAbd;
	}

	public void setAbdAbd(Integer abdAbd) {
		this.abdAbd = abdAbd;
	}

	@Column(name = "ABD_WALL", precision = 4, scale = 0)
	public Integer getAbdWall() {
		return this.abdWall;
	}

	public void setAbdWall(Integer abdWall) {
		this.abdWall = abdWall;
	}

	@Column(name = "ABD_TENDER")
	public String getAbdTender() {
		return this.abdTender;
	}

	public void setAbdTender(String abdTender) {
		this.abdTender = abdTender;
	}

	@Column(name = "ABD_REBT")
	public String getAbdRebt() {
		return this.abdRebt;
	}

	public void setAbdRebt(String abdRebt) {
		this.abdRebt = abdRebt;
	}

	@Column(name = "ABD_LIVER", precision = 4, scale = 0)
	public Integer getAbdLiver() {
		return this.abdLiver;
	}

	public void setAbdLiver(Integer abdLiver) {
		this.abdLiver = abdLiver;
	}

	@Column(name = "ABD_LIVER_SIZE", length = 32)
	public String getAbdLiverSize() {
		return this.abdLiverSize;
	}

	public void setAbdLiverSize(String abdLiverSize) {
		this.abdLiverSize = abdLiverSize;
	}

	@Column(name = "ABD_SPLEEN", precision = 4, scale = 0)
	public Integer getAbdSpleen() {
		return this.abdSpleen;
	}

	public void setAbdSpleen(Integer abdSpleen) {
		this.abdSpleen = abdSpleen;
	}

	@Column(name = "ABD_SPL_SIZE", length = 32)
	public String getAbdSplSize() {
		return this.abdSplSize;
	}

	public void setAbdSplSize(String abdSplSize) {
		this.abdSplSize = abdSplSize;
	}

	@Column(name = "ABD_BS", precision = 4, scale = 0)
	public Integer getAbdBs() {
		return this.abdBs;
	}

	public void setAbdBs(Integer abdBs) {
		this.abdBs = abdBs;
	}

	@Column(name = "ABD_OTHER", length = 128)
	public String getAbdOther() {
		return this.abdOther;
	}

	public void setAbdOther(String abdOther) {
		this.abdOther = abdOther;
	}

	@Column(name = "LIMB_MS")
	public String getLimbMs() {
		return this.limbMs;
	}

	public void setLimbMs(String limbMs) {
		this.limbMs = limbMs;
	}

	@Column(name = "LIMB_MF")
	public String getLimbMf() {
		return this.limbMf;
	}

	public void setLimbMf(String limbMf) {
		this.limbMf = limbMf;
	}
	
	@Column(name = "LIMB_EDEMA")
	public String getLimbEdema() {
		return limbEdema;
	}

	public void setLimbEdema(String limbEdema) {
		this.limbEdema = limbEdema;
	}

	@Column(name = "LIMB_MS_L", precision = 4, scale = 0)
	public Integer getLimbMsL() {
		return this.limbMsL;
	}

	public void setLimbMsL(Integer limbMsL) {
		this.limbMsL = limbMsL;
	}

	@Column(name = "LIMB_MS_LUE", precision = 4, scale = 0)
	public Integer getLimbMsLue() {
		return this.limbMsLue;
	}

	public void setLimbMsLue(Integer limbMsLue) {
		this.limbMsLue = limbMsLue;
	}

	@Column(name = "LIMB_MS_LLE", precision = 4, scale = 0)
	public Integer getLimbMsLle() {
		return this.limbMsLle;
	}

	public void setLimbMsLle(Integer limbMsLle) {
		this.limbMsLle = limbMsLle;
	}

	@Column(name = "LIMB_MS_R", precision = 4, scale = 0)
	public Integer getLimbMsR() {
		return this.limbMsR;
	}

	public void setLimbMsR(Integer limbMsR) {
		this.limbMsR = limbMsR;
	}

	@Column(name = "LIMB_MS_RUE", precision = 4, scale = 0)
	public Integer getLimbMsRue() {
		return this.limbMsRue;
	}

	public void setLimbMsRue(Integer limbMsRue) {
		this.limbMsRue = limbMsRue;
	}

	@Column(name = "LIMB_MS_RLE", precision = 4, scale = 0)
	public Integer getLimbMsRle() {
		return this.limbMsRle;
	}

	public void setLimbMsRle(Integer limbMsRle) {
		this.limbMsRle = limbMsRle;
	}

	@Column(name = "LIMB_EDEMA_BLE", precision = 4, scale = 0)
	public Integer getLimbEdemaBle() {
		return this.limbEdemaBle;
	}

	public void setLimbEdemaBle(Integer limbEdemaBle) {
		this.limbEdemaBle = limbEdemaBle;
	}

	@Column(name = "LIMB_EDEMA_LLE", precision = 4, scale = 0)
	public Integer getLimbEdemaLle() {
		return this.limbEdemaLle;
	}

	public void setLimbEdemaLle(Integer limbEdemaLle) {
		this.limbEdemaLle = limbEdemaLle;
	}

	@Column(name = "LIMB_EDEMA_RLE", precision = 4, scale = 0)
	public Integer getLimbEdemaRle() {
		return this.limbEdemaRle;
	}

	public void setLimbEdemaRle(Integer limbEdemaRle) {
		this.limbEdemaRle = limbEdemaRle;
	}

	@Column(name = "LIMB_OTHER", length = 128)
	public String getLimbOther() {
		return this.limbOther;
	}

	public void setLimbOther(String limbOther) {
		this.limbOther = limbOther;
	}

	@Column(name = "SPINE", precision = 4, scale = 0)
	public Integer getSpine() {
		return this.spine;
	}

	public void setSpine(Integer spine) {
		this.spine = spine;
	}

	@Column(name = "SPN_OTHER", length = 128)
	public String getSpnOther() {
		return this.spnOther;
	}

	public void setSpnOther(String spnOther) {
		this.spnOther = spnOther;
	}

	@Column(name = "NR_PR", precision = 4, scale = 0)
	public Integer getNrPr() {
		return this.nrPr;
	}

	public void setNrPr(Integer nrPr) {
		this.nrPr = nrPr;
	}

	@Column(name = "NR_BABINSKI", precision = 4, scale = 0)
	public Integer getNrBabinski() {
		return this.nrBabinski;
	}

	public void setNrBabinski(Integer nrBabinski) {
		this.nrBabinski = nrBabinski;
	}
	
	@Column(name = "NR_BABINSKI_R", precision = 4, scale = 0)
	public Integer getNrBabinskiR() {
		return this.nrBabinskiR;
	}

	public void setNrBabinskiR(Integer nrBabinskiR) {
		this.nrBabinskiR = nrBabinskiR;
	}
	

	@Column(name = "NR_MES", precision = 4, scale = 0)
	public Integer getNrMes() {
		return this.nrMes;
	}

	public void setNrMes(Integer nrMes) {
		this.nrMes = nrMes;
	}

	@Column(name = "NR_OTHER", length = 128)
	public String getNrOther() {
		return this.nrOther;
	}

	public void setNrOther(String nrOther) {
		this.nrOther = nrOther;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 7,unique=false)
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
	
	@Column(name = "T_TEST")
	public Integer gettTest() {
		return tTest;
	}

	public void settTest(Integer tTest) {
		this.tTest = tTest;
	}

	@Column(name = "P_TEST")
	public Integer getpTest() {
		return pTest;
	}

	public void setpTest(Integer pTest) {
		this.pTest = pTest;
	}

	@Column(name = "R_TEST")
	public Integer getrTest() {
		return rTest;
	}

	public void setrTest(Integer rTest) {
		this.rTest = rTest;
	}

	@Column(name = "LIMB_MS_TEST")
	public Integer getLimbMsTest() {
		return limbMsTest;
	}

	public void setLimbMsTest(Integer limbMsTest) {
		this.limbMsTest = limbMsTest;
	}

	@Column(name = "LIMB_MF_TEST")
	public Integer getLimbMfTest() {
		return limbMfTest;
	}

	public void setLimbMfTest(Integer limbMfTest) {
		this.limbMfTest = limbMfTest;
	}

	@Column(name = "LIMB_EDEMA_TEST")
	public Integer getLimbEdemaTest() {
		return limbEdemaTest;
	}

	public void setLimbEdemaTest(Integer limbEdemaTest) {
		this.limbEdemaTest = limbEdemaTest;
	}

	@Column(name="PE_OTHER")
	public String getPeOther() {
		return peOther;
	}

	public void setPeOther(String peOther) {
		this.peOther = peOther;
	}

	@Column(name = "BP_TEST")
	public Integer getBpTest() {
		return bpTest;
	}

	public void setBpTest(Integer bpTest) {
		this.bpTest = bpTest;
	}

	
	
	
	
	
	
}