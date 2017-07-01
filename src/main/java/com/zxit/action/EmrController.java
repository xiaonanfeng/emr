package com.zxit.action;


import com.zxit.model.*;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.share.CreaterPK;
import com.zxit.share.SystemConfig;
import com.zxit.tools.UtilTools;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emr.do")
public class EmrController {

    @Resource
    private SysSelectService sysSelectService;//select构造器
    @Resource
    private SysCodeService sysCodeService;//基础代码服务
    @Resource
    private SysMemberInfoService sysMemberInfoService;//人员服务
    @Resource
    private VAcceptAmbulOutdInfoService vAcceptAmbulOutdInfoService;//接警信息服务
    @Resource
    private SysOrgInfoService sysOrgInfoService;//联网医疗机构代码
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;//基础信息服务
    @Resource
    private MisEmrPeService misEmrPeService;//体格检查
    @Resource
    private MisEmrSeGynService misEmrSeGynService;//专项_妇科
    @Resource
    private MisEmrSeObService misEmrSeObService;//专项_产科
    @Resource
    private MisEmrSePedService misEmrSePedService;//专项_儿科
    @Resource
    private MisEmrSeTrumaService misEmrSeTrumaService;//专项_创伤科
    @Resource
    private MisEmrAeService misEmrAeService;//辅助检查
    @Resource
    private MisEmrPreaidVsService misEmrPreaidVsService;//急救措施
    @Resource
    private MisFileService misFileService;//附件
    @Resource
    private MisEmrMarService misEmrMarService;
    @Resource
    private MisEmrCmpltService misEmrCmpltService;//体格检查部分默认值
    @Resource
    private MisEmrModifyRecordService misEmrModifyRecordService;//修改记录
    @Resource
    private MisEmrHandoverService misEmrHandoverService;
    @Resource
    private MisEmrNoticeService misEmrNoticeService;
    @Resource
    private MisEmrChargesTableService misEmrChargesTableService;
    @Resource
    private MisEmrChargesNoteService misEmrChargesNoteService;
    @Resource
    private SystemConfig systemConfig;
    @Resource
    private VMisEmrQueryService vMisEmrQueryService;


    @RequestMapping(params = "method=initEmrByEmrId")
    public String initEmrByEmrId(String id, HttpServletRequest request) {
        String lsh = vMisEmrQueryService.findLshByEmrId(id);
        Integer ccxh = vMisEmrQueryService.findCcxhByEmrId(id);
        return initEmr(null, id, lsh, ccxh, request);
    }


    /**
     * 初始化病历
     *
     * @param id   患者id
     * @param lsh  流水号
     * @param ccxh 出车序号
     */
    @RequestMapping(params = "method=initEmr")
    public String initEmr(String print, String id, String lsh, Integer ccxh, HttpServletRequest request) {
        VAcceptAmbulOutdInfoId vAcceptAmbulOutdInfoId = new VAcceptAmbulOutdInfoId(lsh, ccxh);//生成ID先
        //初始化基本接处警信息
        VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo = vAcceptAmbulOutdInfoService.findVAcceptAmbulOutdInfoById(vAcceptAmbulOutdInfoId);
        request.setAttribute("vAcceptAmbulOutdInfo", vAcceptAmbulOutdInfo);

        //查询有没有id，如果有 就初始化，没有就到病历表单填写去
        MisEmrBasicinfo misEmrBasicinfo = new MisEmrBasicinfo();//基本信息
        MisEmrPe misEmrPe = new MisEmrPe();//体格检查
        MisEmrSeGyn misEmrSeGyn = new MisEmrSeGyn();//妇科
        MisEmrSeOb misEmrSeOb = new MisEmrSeOb();//产科
        MisEmrSePed misEmrSePed = new MisEmrSePed();//儿科
        MisEmrSeTruma misEmrSeTruma = new MisEmrSeTruma();//创伤
        MisEmrAe misEmrAe = new MisEmrAe();//辅助
        MisEmrPreaidVs misEmrPreaidVs = new MisEmrPreaidVs();//施救措施

        if (id == null || id.length() == 0 || id == "" || "".equals(id)) {
            id = CreaterPK.CreatePK();//创造一个id
            misEmrBasicinfo.setId(id);
            /**用来判断是新增还是更改**/
            request.setAttribute("modify", false);
            //呼叫普通填写模板ID
            //String misEmrCmpltListStr = findMisErmCmpltById(1);
            //request.setAttribute("misEmrCmpltList",misEmrCmpltListStr);//交给前台eval
        } else {//如果有id直接初始化病历对象
            request.setAttribute("modify", true);
            misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(id);
            //初始化体格检查
            misEmrPe = misEmrPeService.findMisEmrPeById(id);
            request.setAttribute("misEmrPe", misEmrPe);
            //初始化妇科
            misEmrSeGyn = misEmrSeGynService.findMisEmrSeGynById(id);
            request.setAttribute("misEmrSeGyn", misEmrSeGyn);
            //初始化产科
            misEmrSeOb = misEmrSeObService.findMisEmrSeObById(id);
            request.setAttribute("misEmrSeOb", misEmrSeOb);
            //初始化儿科
            misEmrSePed = misEmrSePedService.findMisEmrSePedById(id);
            request.setAttribute("misEmrSePed", misEmrSePed);
            //初始化创伤科
            misEmrSeTruma = misEmrSeTrumaService.findMisEmrSeTrumaById(id);
            request.setAttribute("misEmrSeTruma", misEmrSeTruma);
            //辅助检查
            misEmrAe = misEmrAeService.findMisEmrAeById(id);
            request.setAttribute("misEmrAe", misEmrAe);
            //急救措施
            misEmrPreaidVs = misEmrPreaidVsService.findMisEmrPreaidVsById(id);
            request.setAttribute("misEmrPreaidVs", misEmrPreaidVs);

            //附件个数
            int fileSize = misFileService.findMisFilesByEmrId(id).size();
            request.setAttribute("fileSize", fileSize);
            //修改次数
            int modSize = misEmrModifyRecordService.findMisEmrModifyRecordByEmrId(id).size();
            request.setAttribute("modSize", modSize);
        }
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);
        //下面开始本系统最恶心的地方了，也就是郑州最恶心的地方，
        intiAllSelects(request);
        /**
         * 打印
         */
        if ("1".equals(print)) {//参数是1转入打印页
            print(id, vAcceptAmbulOutdInfo, misEmrBasicinfo, misEmrPe, misEmrSeGyn, misEmrSeOb, misEmrSePed, misEmrSeTruma, misEmrAe, misEmrPreaidVs, request);
            String page = "/print/" + systemConfig.getPrintPage();
            return page;//根据配置找到不同的打印页面
        } else {
            /**
             * 特殊的select
             */
            /**
             * 送往医院代码
             */
            List<SysOrgInfo> list = sysOrgInfoService.findSysOrgInfoFroSW();
            TObject t = new TObject("sentTo", "", "");
            request.setAttribute("sentTo", sysOrgInfoService.createSysOrgSelect(t, list));
            String orgId = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getSysOrgInfo().getOrgId();
            List<SysMemberInfo> listMember = new ArrayList<SysMemberInfo>();
            /**
             * 医生下拉框
             */
            listMember = sysMemberInfoService.findSysMemberInfoByType(Constants.doctorSign, orgId);
            t = new TObject("doctorSign", "", "");
            request.setAttribute("doctorSign", sysMemberInfoService.createMemberInfoSelect(t, listMember));
            /**
             *护士下拉框
             */
            List<SysMemberInfo> listNurse = sysMemberInfoService.findSysMemberInfoByType(Constants.nurseSign, orgId);
            t = new TObject("nurseSign", "", "");
            request.setAttribute("nurseSign", sysMemberInfoService.createMemberInfoSelect(t, listNurse));

        }
        return "/business/index";
    }


    @ResponseBody
    @RequestMapping(params = "method=findMisErmCmpltById")
    public String findMisErmCmpltById(Integer templateId) {
        //病历默认值
        List<MisEmrCmplt> misEmrCmpltList = misEmrCmpltService.findMisEmrCmplt(templateId);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);//防止实体类对象死循环
        String misEmrCmpltListStr = JSONArray.fromObject(misEmrCmpltList, jsonConfig).toString();
        return misEmrCmpltListStr;
    }

    /**
     * 打印方法
     *
     * @param vAcceptAmbulOutdInfo
     * @param misEmrBasicinfo
     * @param misEmrPe
     * @param misEmrSeGyn
     * @param misEmrSeOb
     * @param misEmrSePed
     * @param misEmrSeTruma
     * @param misEmrAe
     * @param misEmrPreaidVs
     * @param request
     */
    private void print(String id, VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo, MisEmrBasicinfo misEmrBasicinfo, MisEmrPe misEmrPe,
                       MisEmrSeGyn misEmrSeGyn, MisEmrSeOb misEmrSeOb,
                       MisEmrSePed misEmrSePed, MisEmrSeTruma misEmrSeTruma,
                       MisEmrAe misEmrAe, MisEmrPreaidVs misEmrPreaidVs,
                       HttpServletRequest request) {
        List<MisFiles> list = misFileService.findMisFilesByEmrId(id);//心电图文件列表
        //缓存文件
        misFileService.cacheFiles(list);
        request.setAttribute("list", list);//文件列表
        //出车基本信息
        if (vAcceptAmbulOutdInfo != null) {
            request.setAttribute("orgId", vAcceptAmbulOutdInfo.getSzfz());
            request.setAttribute("hosName", sysOrgInfoService.findSysOrgInfoById(vAcceptAmbulOutdInfo.getSzfz()).getName());//医院名
        }
        if (misEmrBasicinfo != null) {
            request.setAttribute("emrCode", misEmrBasicinfo.getEmrCode());
            request.setAttribute("sex", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getSex(), Constants.sex));//性别
            request.setAttribute("ethnic", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getEthnic(), Constants.ethnic));//民族
            request.setAttribute("nation", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getNation(), Constants.nation));//g国籍
            request.setAttribute("stage", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getStage(), Constants.stage));//年龄段
            request.setAttribute("hxProvider", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getHxProvider(), Constants.hx_provider));//并使提供人

            request.setAttribute("cause", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getCause(), Constants.cause));//呼救原因
            request.setAttribute("diseaseType", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getDiseaseType(), misEmrBasicinfo.getCause()));//疾病类型

            request.setAttribute("condition", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getCondition(), Constants.condition));//病情
            request.setAttribute("spot", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getSpot(), Constants.spot));//现场环境
            request.setAttribute("sentTo", sysOrgInfoService.findSysOrgInfoById(misEmrBasicinfo.getSentTo()).getName());//送达地点
            request.setAttribute("preEmcResult", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getPreEmcResult(), Constants.pre_emc_result));//院前急救结果
            request.setAttribute("pastHx", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getPastHx(), Constants.pastHx));//既往史
            request.setAttribute("drugAllergy", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getDrugAllergy(), Constants.havOrNo));//有无药敏
        }
        if (misEmrPe != null) {
            request.setAttribute("posture", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getPosture(), Constants.posture));//体位
            request.setAttribute("conscious", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getConscious(), Constants.conscious));//神志
            request.setAttribute("tTest", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.gettTest(), Constants.chkStat));//T
            request.setAttribute("pTest", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getpTest(), Constants.chkStat));//P
            request.setAttribute("rTest", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getrTest(), Constants.chkStat));//R
            request.setAttribute("bpTest", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getBpTest(), Constants.chkStat));//BP
            request.setAttribute("skin", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getSkin(), Constants.skin));//皮肤
            request.setAttribute("cyanosis", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getCyanosis(), Constants.havOrNo));//口唇浅紫
            request.setAttribute("hnEyeTestL", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getHnEyeTestL(), Constants.chkStat));//左瞳孔是否检查
            request.setAttribute("hnEyeTestR", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getHnEyeTestR(), Constants.chkStat));//右瞳孔是否检查
            request.setAttribute("hnPlrL", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getHnPlrL(), Constants.plr));//对光反射
            request.setAttribute("hnPlrR", sysCodeService.findSysCodeNameByIdAndPid(misEmrPe.getHnPlrR(), Constants.plr));
        }
        if (misEmrAe != null) {
            request.setAttribute("rbgTest", sysCodeService.findSysCodeNameByIdAndPid(misEmrAe.getRbgTest(), Constants.chkStat));//快速血糖检测
            request.setAttribute("bosTest", sysCodeService.findSysCodeNameByIdAndPid(misEmrAe.getBosTest(), Constants.chkStat));//血氧饱和度
            request.setAttribute("ecg", sysCodeService.findSysCodeNameByIdAndPid(misEmrAe.getEcg(), Constants.chkStat));//心电图
            request.setAttribute("ecgMonitor",sysCodeService.findSysCodeNameByIdAndPid(misEmrAe.getEcgMonitor(), Constants.chkStat));//心电监护
        }
        if (misEmrPreaidVs != null) {
            request.setAttribute("doctorSign", sysMemberInfoService.findSysMemberInfoById(misEmrPreaidVs.getDoctorSign()).getName());//医生 签名
            request.setAttribute("nurseSign", sysMemberInfoService.findSysMemberInfoById(misEmrPreaidVs.getNurseSign()).getName());//护士 签名
        }
        //产科
        if (misEmrSeOb != null) {
            request.setAttribute("bloodSee", sysCodeService.findSysCodeNameByIdAndPid(misEmrSeOb.getBloodSee(), Constants.yesOrNo));//是否见红
            request.setAttribute("uterContrac", sysCodeService.findSysCodeNameByIdAndPid(misEmrSeOb.getUterContrac(), Constants.havOrNo));    //有宫缩？
            request.setAttribute("caul", sysCodeService.findSysCodeNameByIdAndPid(misEmrSeOb.getCaul(), Constants.caul));    //胎膜
            request.setAttribute("amnioticFluid", sysCodeService.findSysCodeNameByIdAndPid(misEmrSeOb.getAmnioticFluid(), Constants.amnioticFluid));//羊水
            request.setAttribute("present", sysCodeService.findSysCodeNameByIdAndPid(misEmrSeOb.getPresent(), Constants.present));//显露哪

        }
        //药物应用
        VMisEmrMarMedicine vMisEmrMarMedicine = new VMisEmrMarMedicine();
        vMisEmrMarMedicine.setEmrId(id);//病历ID
        vMisEmrMarMedicine.setType(1);//现场。并没有什么卵用
        List<VMisEmrMarMedicine> senceDrugList = misEmrMarService.findMisEmrMar(vMisEmrMarMedicine);//现场用药
        request.setAttribute("senceDrugList", senceDrugList);
    }

    /**
     * 初始化所有select
     */
    private void intiAllSelects(HttpServletRequest request) {
        /**
         * 基础信息项
         */
        createSelects(Constants.sex, "sex", "", request);//性别    //calMan:如果选择男性，则隐藏妇科、产科。
        createSelects(Constants.stage, "stage", "", request);//年龄段   //calPed：如果大于某个年龄段，则隐藏儿科。
        createSelects(Constants.condition, "condition", "", request);//病情等级  calTruma 是否隐藏创伤。

        createSelects(Constants.ethnic, "ethnic", "", request);//民族
        createSelects(Constants.nation, "nation", "", request);//国籍
        createSelects(Constants.hx_provider, "hxProvider", "", request);//病史提供人
        createSelects(Constants.spot, "spot", "", request);//现场环境
        createSelects(Constants.cause, "cause", "", request);//呼救原因
        createSelects(Constants.d_class, "dClassify", "", request);//疾病分类

        createSelects(Constants.pre_emc_result, "preEmcResult", "", request);//院前救治结果

        createSelects(Constants.pastHx, "pastHx", "", request);//有无病史

        createSelects(Constants.havOrNo, "hbp", "", request);//有无高血压病史
        createSelects(Constants.havOrNo, "heartCondition", "", request);//有无心脏病病史
        createSelects(Constants.heartIllness, "heartIllness", "", request);//心脏病类型
        createSelects(Constants.havOrNo, "diabetes", "", request);//有无糖尿病
        createSelects(Constants.dmType, "dmType", "", request);//糖尿病类型
        createSelects(Constants.havOrNo, "drugAllergy", "", request);//有无药物过敏
        createSelects(Constants.relatedType, "relatedType", "", request);//附件类型


        /**
         * 体格检查
         */
        createSelects(Constants.chkStat, "tTest", "", request);//T检查情况
        createSelects(Constants.chkStat, "pTest", "", request);//P
        createSelects(Constants.chkStat, "rTest", "", request);//R
        createSelects(Constants.chkStat, "bpTest", "", request);//BP
        createSelects(Constants.conscious, "conscious", "", request);//神智
        createSelects(Constants.posture, "posture", "", request);//体位
        createSelects(Constants.skin, "skin", "", request);//皮肤
        createSelects(Constants.havOrNo, "cyanosis", "", request);//口唇浅紫

        createSelects(Constants.chkStat, "hnEyeTestL", "", request);//左眼检查情况
        createSelects(Constants.plr, "hnPlrL", "", request);//对光反射 左

        createSelects(Constants.chkStat, "hnEyeTestR", "", request);//右眼检查情况
        createSelects(Constants.plr, "hnPlrR", "", request);//对光反射 右
        //createSelects(Constants.eye,"hnEyeL","",request);//眼部检查 左
        //createSelects(Constants.eye,"hnEyeR","",request);//眼部检查 左

        createSelects(Constants.hnNeck, "hnNeck", "", request);//头颈部
        createSelects(Constants.chestThorax, "chestThorax", "", request);//胸廓
        createSelects(Constants.havOrNo, "chestTender", "", request);//胸廓
        createSelects(Constants.lungBs, "lungBsL", "", request);//呼吸音 左
        createSelects(Constants.lungBs, "lungBsR", "", request);//呼吸音 右
        createSelects(Constants.lungR, "lungRL", "", request);//啰音 左
        createSelects(Constants.lungR, "lungRR", "", request);//啰音 右
        createSelects(Constants.hrtRhythm, "hrtRhythm", "", request);//心律
        createSelects(Constants.hrtSound, "hrtSound", "", request);//心音
        createSelects(Constants.havOrNo, "hrtMurmur", "", request);//杂音：有无
        createSelects(Constants.abdAbd, "abdAbd", "", request);//腹部
        createSelects(Constants.havOrNo, "abdTender", "", request);//腹部压痛  有无
        createSelects(Constants.abdWall, "abdWall", "", request);//腹壁
        createSelects(Constants.havOrNo, "abdRebt", "", request);//腹 反跳痛
        createSelects(Constants.liverAndSpleen, "abdLiver", "", request);//肝脏
        createSelects(Constants.liverAndSpleen, "abdSpleen", "", request);//脾脏
        createSelects(Constants.abdBs, "abdBs", "", request);//肠鸣音
        createSelects(Constants.condition, "limbEdemaBle", "", request);//四肢_双下肢水肿
        createSelects(Constants.condition, "limbEdemaLle", "", request);//四肢_左下肢水肿
        createSelects(Constants.condition, "limbEdemaRle", "", request);//四肢_右下肢水肿
        createSelects(Constants.spine, "spine", "", request);//脊柱检查
        createSelects(Constants.havOrNo, "nrPr", "", request);//生理反射
        createSelects(Constants.binskiAndBra, "nrMes", "", request);//神经反射_脑膜刺激征
        createSelects(Constants.binskiAndBra, "nrBabinski", "", request);//神经反射_巴彬斯基征   left
        createSelects(Constants.binskiAndBra, "nrBabinskiR", "", request);//神经反射_巴彬斯基征 right

        createSelects(Constants.chkStat, "limbMsTest", "", request);//肌力检查情况
        createSelects(Constants.chkStat, "limbMfTest", "", request);//肌张力
        createSelects(Constants.chkStat, "limbEdemaTest", "", request);//水肿
        /**
         * 妇科
         */
        createSelects(Constants.martialStatus, "martialStatus", "", request);//婚姻状况
        createSelects(Constants.havOrNo, "sexLife", "", request);//你懂的生活
        /**
         * 产科
         */
        createSelects(Constants.uterContrac, "uterContrac", "", request);//宫缩
        createSelects(Constants.caul, "caul", "", request);//胎膜
        createSelects(Constants.amnioticFluid, "amnioticFluid", "", request);//羊水
        createSelects(Constants.present, "present", "", request);//显露
        createSelects(Constants.yesOrNo, "bloodSee", "", request);//见红
        /**
         * 创伤
         */
        createSelects(Constants.phiBr, "phiBr", "valPhi()", request);///、院前指数_呼吸
        createSelects(Constants.phiCons, "phiCons", "valPhi()", request);//院前指数_神志
        createSelects(Constants.phiSbp, "phiSbp", "valPhi()", request);//院前指数_收缩压
        createSelects(Constants.phiPr, "phiPr", "valPhi()", request);//院前指数_脉率

        createSelects(Constants.dglsEr, "dglsEr", "valGcs()", request);//道格拉斯评分_睁眼反应
        createSelects(Constants.dglsVr, "dglsVr", "valGcs()", request);//道格拉斯评分_语言反应
        createSelects(Constants.dglsMr, "dglsMr", "valGcs()", request);//道格拉斯评分_运动反应
        /**
         * 儿科
         */
        //1分钟
        createSelects(Constants.ped_skin, "apgarAp1", "", request);//肤色 1分钟
        createSelects(Constants.ped_hrt, "apgarP1", "", request); //心律1分钟
        createSelects(Constants.ped_fn, "apgarG1", "", request); //足底和鼻孔刺激 1分
        createSelects(Constants.ped_msl, "apgarAc1", "", request); //肌张力 1分
        createSelects(Constants.ped_bre, "apgarR1", "", request); ////呼吸 1分钟
        //5分钟
        createSelects(Constants.ped_skin, "apgarAp5", "", request);
        createSelects(Constants.ped_hrt, "apgarP5", "", request);
        createSelects(Constants.ped_fn, "apgarG5", "", request);
        createSelects(Constants.ped_msl, "apgarAc5", "", request);
        createSelects(Constants.ped_bre, "apgarR5", "", request);
        //10分钟
        createSelects(Constants.ped_skin, "apgarAp10", "", request);
        createSelects(Constants.ped_hrt, "apgarP10", "", request);
        createSelects(Constants.ped_fn, "apgarG10", "", request);
        createSelects(Constants.ped_msl, "apgarAc10", "", request);
        createSelects(Constants.ped_bre, "apgarR10", "", request);
        //15分钟
        createSelects(Constants.ped_skin, "apgarAp15", "", request);
        createSelects(Constants.ped_hrt, "apgarP15", "", request);
        createSelects(Constants.ped_fn, "apgarG15", "", request);
        createSelects(Constants.ped_msl, "apgarAc15", "", request);
        createSelects(Constants.ped_bre, "apgarR15", "", request);
        /**
         * 辅助检查
         */
        createSelects(Constants.chkStat, "rbgTest", "", request);//RBG检查情况
        createSelects(Constants.chkStat, "bosTest", "", request);//血氧饱和度检查情况
        createSelects(Constants.chkStat, "ecg", "showUpload(this)", request);//心电图检查情况：检查情况
        createSelects(Constants.chkStat, "ecgMonitor", "", request);//i心电监护情况
        createSelects(Constants.ecgTo, "ecgTo", "", request);//心电图交于人 252
        createSelects(Constants.ecgLead, "ecgLead", "", request);//心电图导联
        /**
         * 施救措施
         */
        createSelects(Constants.reason58, "reason58", "", request);//静脉输液失败原因
        createSelects(Constants.reason66, "reason66", "", request);//病人CPR复苏情况
        createSelects(Constants.reason67, "reason67", "", request);//肺插管失败原因
    }

    /**
     * select构造器
     *
     * @param typeId       代码类型
     * @param selectId     select的ID
     * @param changeMethod 改变方法
     */
    private void createSelects(Integer typeId, String selectId, String changeMethod, HttpServletRequest request) {
        TObject t = new TObject(selectId, "", changeMethod);
        List<SysCode> list = sysCodeService.findSysCodeByPid(typeId);
        String select = sysSelectService.CreateSelect(t, list);
        request.setAttribute(selectId.toString(), select);
    }


    @ResponseBody
    @RequestMapping(params = "method=findEmrsByLshAndCcxh")
    public String findEmrsByLshAndCcxh(String lsh, Integer ccxh, HttpServletRequest request) {
        String emrUrls = "";
        List<MisEmrBasicinfo> list = misEmrBasicinfoService.findMisEmrBasicinfoByLshAndCcxh(lsh, ccxh);
        //生成病历列表
        if (list.size() != 0) {
            emrUrls = "<table width='100%' border='1' class='table_list'>";
            emrUrls = emrUrls + "<tr class='table_list_first'>";
            emrUrls = emrUrls + "<th>姓名</th><th>性别</th><th>呼救原因</th><th>待/主诉</th><th>提交状态</th><th>编号</th></tr>";
            for (MisEmrBasicinfo d : list) {
                String name = (d.getName() == null || d.getName().equals("null")) ? "" : d.getName();
                String localCommitStat = d.getIsCommitted() == 1 ? "<font color='green'>已提交</font>" : "未提交";
                emrUrls = emrUrls
                        + "<tr>"
                        + "<td>" + name + "</td>"
                        + "<td>" + sysCodeService.findSysCodeByIdAndPid(d.getSex(), Constants.sex).getName() + "</td>"
                        + "<td>" + sysCodeService.findSysCodeByIdAndPid(d.getCause(), Constants.cause).getName() + "</td>"
                        + "<td>" + UtilTools.KillNull(d.getChiefComplaint(), "") + "</td>"
                        + "<td>" + localCommitStat + "</td>"
                        + "<td><a  biaozhi ='" + d.getId() + "'  tab_title='" + d.getName() + "' href=\"javascript:void(0)\" openMode=\"tabMenu\" "
                        + "link_url=\"emr.do?method=initEmr" + "&ccxh=" + d.getCcxh() + "&lsh=" + d.getLsh() + "&id=" + d.getId() + "\"   >" + d.getId() + "</a></td>"
                        + "</tr>";
            }
            emrUrls = emrUrls + " </table> ";
        }
        return emrUrls;
    }

    /**
     * 删除
     *
     * @param id
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=delEmrsById", method = RequestMethod.POST)
    public String delEmrsById(String id, HttpServletRequest request) {
        if (id != null && !id.equals("null")) {
            misEmrBasicinfoService.delMisEmrBasicinfoById(id);//基础信息
            misEmrPeService.delMisEmrPeById(id);//体格

            misEmrAeService.delMisEmrAeById(id);//辅助
            misEmrHandoverService.delMisEmrHandoverById(id);//交接记录
            misEmrMarService.delMieEmrMarByEmrId(id);//用药
            misEmrModifyRecordService.delMisEmrModifyRecordById(id);//修改记录
            misEmrNoticeService.delMisEmrNoticeById(id);//告知书
            misEmrPreaidVsService.delMisEmrPreaidVsById(id);//辅助

            misEmrSeGynService.delMisEmrSeGynById(id);//妇科
            misEmrSeObService.delMisEmrSeObById(id);//产科
            misEmrSePedService.delMisEmrSePedById(id);//儿科
            misEmrSeTrumaService.delMisEmrSeTrumaById(id);//PHI GCS
            //文件
            List<MisFiles> list = misFileService.findMisFilesByEmrId(id);
            misFileService.delMisFiles(list);
            //收费信息
            misEmrChargesTableService.deleteById(MisEmrChargesTable.class, id);
            List<MisEmrChargesNote> listChargesNote = misEmrChargesNoteService.findMisEmrChargesNoteByEmrId(id);
            misEmrChargesNoteService.delete(listChargesNote.toArray());
        }
        return "";
    }

}
