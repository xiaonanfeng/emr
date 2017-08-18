package com.zxit.share;

/**
 * 功能描述：系统中使用的常量
 * 创建日期：2008-12-04
 */
public final class Constants {
    /*************************系统常量*******************************/
    /**
     * 全局变量：session用户变量
     */
    public static final String USERNAME = "sysMemberInfo";
    /**
     * 车辆ID
     */
    public static final String ZBCLID = "zbclid";
    /**
     * 全局路径变量
     */
    public static final String PATH = "loginPath";
    /**
     *10	中心
     *20	分中心
     *30	急救站
     */
    /**
     * 中心
     */
    public static final Integer center = 10;
    /**
     * 分中心
     */
    public static final Integer scenter = 20;
    /**
     * 分站
     */
    public static final Integer station = 30;
    /**
     * 上传附件用
     */
    public static final String UPLOAD_PATH = "upload/";
    public static final String UPLOAD_SEVE_NAME = "uploadFileName";
    public static final int cache = 0;//文件缓存          0：不保存，用完就删      1：保存缓存文件
    /*************************Session和系统变量*******************************/

    //else 第二级选择器

    /*******************************系统需要的字典代码******************************/
    /**
     * 是否
     */
    public static final Integer yesOrNo = 200;
    /**
     * 有无
     */
    public static final Integer havOrNo = 201;
    /**
     * 检查情况
     */
    public static final Integer chkStat = 202;
    /**
     * 性别
     */
    public static final Integer sex = 28;
    /**
     * 年龄段
     */
    public static final Integer stage = 203;
    /**
     * 国籍
     */
    public static final Integer nation = 30;
    /**
     * 民族
     */
    public static final Integer ethnic = 31;
    /**
     * 病史提供人
     */
    public static final Integer hx_provider = 49;
    /**
     * 现场 环境
     */
    public static final Integer spot = 207;
    /**
     * 呼救原因
     */
    public static final Integer cause = 255;
    /**
     * 疾病类型
     */
    public static final Integer disease_type = 210;
    /**
     * 疾病分类
     */
    public static final Integer d_class = 274;
    /**
     * 院前救治结果
     */
    public static final Integer pre_emc_result = 212;
    /**
     * 病情等级
     */
    public static final Integer condition = 209;
    /**
     * 心脏病类型
     */
    public static final Integer heartIllness = 214;
    /**
     * 糖尿病类型
     */
    public static final Integer dmType = 249;
    /**
     * 体位
     */
    public static final Integer posture = 216;
    /**
     * 神智
     */
    public static final Integer conscious = 215;
    /**
     * 皮肤
     */
    public static final Integer skin = 217;
    /**
     * 眼部检查
     */
    public static final Integer eye = 202;
    /**
     * 对光反应
     */
    public static final Integer plr = 218;
    /**
     * 颈部检查
     */
    public static final Integer hnNeck = 250;
    /**
     * 胸廓
     */
    public static final Integer chestThorax = 219;
    /**
     * 呼吸音
     */
    public static final Integer lungBs = 220;
    /**
     * 啰音
     */
    public static final Integer lungR = 221;
    /**
     * 心率
     */
    public static final Integer hrtRhythm = 222;
    /**
     * 心音
     */
    public static final Integer hrtSound = 223;
    /**
     * 腹部检查
     */
    public static final Integer abdAbd = 224;
    /**
     * 腹壁检查
     */
    public static final Integer abdWall = 225;
    /**
     * 腹部压痛
     */
    public static final Integer abdTender = 226;
    /**
     * 肝脾脏
     */
    public static final Integer liverAndSpleen = 227;
    /**
     * 肠鸣音
     */
    public static final Integer abdBs = 228;
    /**
     * 脊柱检查
     */
    public static final Integer spine = 229;
    /**
     * 巴基斯和脑膜刺激
     */
    public static final Integer binskiAndBra = 230;
    /**
     * 婚姻状况
     */
    public static final Integer martialStatus = 231;
    /**
     * 宫缩
     */
    public static final Integer uterContrac = 232;
    /**
     * 胎膜
     */
    public static final Integer caul = 233;
    /**
     * 羊水
     */
    public static final Integer amnioticFluid = 234;
    /**
     * 先露 头还是屁股
     */
    public static final Integer present = 235;
    /**
     * PHI-呼吸
     */
    public static final Integer phiBr = 237;
    /**
     * PHI-神智
     */
    public static final Integer phiCons = 238;
    /**
     * PHI-收缩
     */
    public static final Integer phiSbp = 239;
    /**
     * PHI-脉率
     */
    public static final Integer phiPr = 240;
    /**
     * GCS-睁眼
     */
    public static final Integer dglsEr = 241;
    /**
     * GCS-语言
     */
    public static final Integer dglsVr = 242;
    /**
     * GCS-运动
     */
    public static final Integer dglsMr = 243;
    /**
     * 新生儿肤色
     */
    public static final Integer ped_skin = 244;
    /**
     * 心率
     */
    public static final Integer ped_hrt = 245;
    /**
     * 足底或鼻孔反应
     */
    public static final Integer ped_fn = 246;
    /**
     * 肌张力
     */
    public static final Integer ped_msl = 247;
    /**
     * 呼吸
     */
    public static final Integer ped_bre = 248;
    /**
     * 心电图印象
     */
    public static final Integer ecgDiag = 252;
    /**
     * 心电图交于人
     */
    public static final Integer ecgTo = 253;
    /**
     * 处理措施
     */
    public static final Integer sceneTreat = 254;
    /**
     * 病情初步诊断
     * 这个是ICD10
     */
    public static final Integer primDiag = 255;
    /**
     * 给药途径
     */
    public static final Integer usage = 271;
    /**
     * 用药单位
     */
    public static final Integer units = 282;
    /**
     * 用药频次
     */
    public static final Integer frequency = 283;
    /**
     * 既往史
     */
    public static final Integer pastHx = 272;
    /**
     * 医生code
     */
    public static final Integer doctorSign = 40;
    /**
     * 护士code
     */
    public static final Integer nurseSign = 50;
    /**
     * 司机code
     */
    public static final Integer driverSign = 30;

    /**
     * TODO 中心科长 这里是个固定值？
     */
    public static final Integer managerCenter = 80;
    /**
     * 收费类别
     */
    public static final Integer CHARGES = 301;
    /**
     * 收费差额原因
     */
    public static final Integer BALANCE = 302;
    /**
     * 护理-精神
     */
    public static final Integer MENTALSTAT = 305;
    /**
     * 护理-体位
     */
    public static final Integer POSTURE = 306;
    /**
     * 护理-口唇颜色
     */
    public static final Integer CYANOSIS = 307;
    /**
     * 护理-皮肤
     */
    public static final Integer SKIN = 308;
    /**
     * 护理-相关护理
     */
    public static final Integer NURSINGCARE = 309;
    /**
     * 护理-效果评价
     */
    public static final Integer OUTCOME = 310;
    /**
     * 病历修改原因
     */
    public static final Integer MDFREASON = 311;
    /**
     * 附件类型
     */
    public static final Integer relatedType = 312;
    /**
     * 收费类型
     */
    public static final Integer CHARGEKIND = 313;
    /**
     * 心电图导联
     */
    public static Integer ecgLead = 318;
    /**
     * 病人CPR复苏情况
     */
    public static Integer reason66 = 366;
    /**
     * 静脉输液失败原因
     */
    public static Integer reason58 = 367;
    /**
     * 肺插管失败原因
     */
    public static Integer reason67 = 368;
    /*****************************公共select反射对象:其实不用这么麻烦，这么写是为了可能用到反射**************************/
    /**
     * ICD10对象
     */
    public static final String icd10 = "com.zxit.model.MisEmrIcd10";
    public static final String sysCode = "com.zxit.model.SysCode";
    public static final String MisAmEmMedicine = "com.zxit.model.MisAmEmMedicine";
    public static final String SysMemberInfo = "com.zxit.model.SysMemberInfo";


}