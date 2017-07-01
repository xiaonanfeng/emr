package com.zxit.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisEmrAe;
import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrNursingRecord;
import com.zxit.model.MisEmrPe;
import com.zxit.model.MisEmrPreaidVs;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrMarMedicine;
import com.zxit.model.VMisEmrOutdStaff;
import com.zxit.service.MisEmrAeService;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrMarService;
import com.zxit.service.MisEmrNursingRecordService;
import com.zxit.service.MisEmrPeService;
import com.zxit.service.MisEmrPreaidVsService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.SysSelectService;
import com.zxit.service.VMisEmrOutdStaffService;
import com.zxit.share.Constants;

@Controller
@RequestMapping("/misEmrNursingRecord.do")
public class MisEmrNursingRecordController {
    @Resource
    private MisEmrNursingRecordService misEmrNursingRecordService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;//基础信息
    @Resource
    private MisEmrPeService misEmrPeService;//体格检查
    @Resource
    private MisEmrMarService misEmrMarService;//药物检查
    @Resource
    private MisEmrPreaidVsService MisEmrPreaidVsService;//施救措施'
    @Resource
    private SysSelectService sysSelectService;//select构造器
    @Resource
    private SysCodeService sysCodeService;//基础代码服务
    @Resource
    private MisEmrAeService misEmrAeService;//辅助
    @Resource
    private VMisEmrOutdStaffService vMisEmrOutdStaffService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrNursingRecord", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrNursingRecord(MisEmrNursingRecord misEmrNursingRecord, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        misEmrNursingRecord.setLastModifyTime(new Date());
        misEmrNursingRecord.setCreateTime(new Date());
        misEmrNursingRecord.setModifyUserid(sysMemberInfo.getId());
        misEmrNursingRecord.setXzbm(sysMemberInfo.getXzbm());
        misEmrNursingRecordService.saveOrUpdate(misEmrNursingRecord);
        return null;
    }

    /**
     * 基础信息查询控制器
     * 药物不在这里初始化
     *
     * @param id      病历ID
     * @param print   打印
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrNursingRecordById")
    public String findMisEmrNursingRecordById(String emrId, String print, HttpServletRequest request) {
        //基础信息
        System.out.println("基础信息");
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);
        if (misEmrBasicinfo != null) {
            request.setAttribute("sex", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getSex(), Constants.sex));//性别
        }

        //体格检查
        System.out.println("体格检查");
        MisEmrPe misEmrPe = misEmrPeService.findMisEmrPeById(emrId);
        request.setAttribute("misEmrPe", misEmrPe);
        if (misEmrPe != null) {
            //神志mis
            String conscious = sysCodeService.findSysCodeByIdAndPid(misEmrPe.getConscious(), Constants.conscious).getName();
            request.setAttribute("conscious", conscious);
            //瞳孔
            String pupil = misEmrPeService.getEyeString(emrId);
            request.setAttribute("pupil", pupil);

        }

        //急救措施
        System.out.println("急救措施");
        MisEmrPreaidVs misEmrPreaidVs = MisEmrPreaidVsService.findMisEmrPreaidVsById(emrId);
        request.setAttribute("misEmrPreaidVs", misEmrPreaidVs);
        if (misEmrPreaidVs != null) {
            request.setAttribute("doctorSign", sysMemberInfoService.findSysMemberInfoById(misEmrPreaidVs.getDoctorSign()).getName());//接诊医生
        }


        //辅助
        System.out.println("辅助");
        MisEmrAe misEmrAE = misEmrAeService.findMisEmrAeById(emrId);
        request.setAttribute("misEmrAE", misEmrAE);

        /*************************************/
        TObject tObject = new TObject();
        List<SysCode> list = new ArrayList<SysCode>();
        String html = "";//页面html代码
        //护理-精神 305
        System.out.println("护理-精神 305");
        tObject.setSelectIdAndName("mentalstate");
        list = sysCodeService.findSysCodeByPid(Constants.MENTALSTAT);
        html = sysSelectService.CreateRadio(tObject, list);
        request.setAttribute("mentalstate", html);
        //护理-体位 306
        System.out.println("护理-体位 306");
        tObject.setSelectIdAndName("posture");
        list = sysCodeService.findSysCodeByPid(Constants.POSTURE);
        html = sysSelectService.CreateRadio(tObject, list);
        request.setAttribute("posture", html);
        //护理-口唇色泽 307
        System.out.println("护理-口唇色泽 307");
        tObject.setSelectIdAndName("cyanosis");
        list = sysCodeService.findSysCodeByPid(Constants.CYANOSIS);
        html = sysSelectService.CreateRadio(tObject, list);
        request.setAttribute("cyanosis", html);
        //护理-皮肤 308
        System.out.println("护理-皮肤 308");
        tObject.setSelectIdAndName("skin");
        list = sysCodeService.findSysCodeByPid(Constants.SKIN);
        html = sysSelectService.CreateRadio(tObject, list);
        request.setAttribute("skin", html);
        //护理措施 309
        System.out.println("护理措施 309");
        tObject.setSelectIdAndName("nursingCare");
        list = sysCodeService.findSysCodeByPid(Constants.NURSINGCARE);
        html = sysSelectService.CreateCheckBox(tObject, list);
        request.setAttribute("nursingCare", html);
        //护理效果评价 310
        System.out.println("护理效果评价 310");
        tObject.setSelectIdAndName("outcome");
        list = sysCodeService.findSysCodeByPid(Constants.OUTCOME);
        html = sysSelectService.CreateRadio(tObject, list);
        request.setAttribute("outcome", html);
        //随车护士
        System.out.println("随车护士");
        List<VMisEmrOutdStaff> colleList = vMisEmrOutdStaffService.findVMisEmrOutdStaffByEmrId(emrId);
        tObject.setSelectIdAndName("hsid");
        html = vMisEmrOutdStaffService.createColleSelect(tObject, colleList);
        request.setAttribute("hsid", html);

        //药物应用
        System.out.println("药物应用");
        VMisEmrMarMedicine vMisEmrMarMedicine = new VMisEmrMarMedicine();
        vMisEmrMarMedicine.setEmrId(emrId);//病历ID
        vMisEmrMarMedicine.setType(1);//现场。并没有什么卵用
        List<VMisEmrMarMedicine> senceDrugList = misEmrMarService.findMisEmrMar(vMisEmrMarMedicine);//现场用药
        request.setAttribute("senceDrugList", senceDrugList);

        MisEmrNursingRecord misEmrNursingRecord = misEmrNursingRecordService.findById(MisEmrNursingRecord.class, emrId);
        request.setAttribute("misEmrNursingRecord", misEmrNursingRecord);

        if (misEmrNursingRecord != null) {
            if (misEmrNursingRecord.getHsid() != null) {
                SysMemberInfo sysMemberInfo = sysMemberInfoService.findSysMemberInfoById(misEmrNursingRecord.getHsid());
                request.setAttribute("hsname", sysMemberInfo.getName());
            }
        }


        if ("1".equals(print)) {//参数是1转入打印页
            print(misEmrNursingRecord, misEmrBasicinfo, misEmrPe, misEmrPreaidVs, misEmrAE, request);
            return "/print/print_nursing";
        }
        return "/business/MIS_EMR_NURSING_RECORD";
    }

    /**
     * 打印方法
     *
     * @param misEmrNursingRecord
     * @param misEmrBasicinfo
     * @param misEmrPe
     * @param misEmrPreaidVs
     * @param misEmrAE
     */
    private void print(MisEmrNursingRecord misEmrNursingRecord,
                       MisEmrBasicinfo misEmrBasicinfo, MisEmrPe misEmrPe,
                       MisEmrPreaidVs misEmrPreaidVs, MisEmrAe misEmrAE, HttpServletRequest request) {


    }

    @SuppressWarnings("unused")
    private void createSelects(Integer typeId, String selectId, String changeMethod, HttpServletRequest request) {
        TObject t = new TObject(selectId, "", changeMethod);
        List<SysCode> list = sysCodeService.findSysCodeByPid(typeId);
        String select = sysSelectService.CreateSelect(t, list);
        request.setAttribute(selectId.toString(), select);
    }


}
