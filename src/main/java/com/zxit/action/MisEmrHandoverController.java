package com.zxit.action;

import java.util.Date;
import java.util.HashMap;
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

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrHandover;
import com.zxit.model.MisEmrIcd10;
import com.zxit.model.MisEmrPreaidVs;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrAmbul;
import com.zxit.model.VMisEmrQuery;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrHandoverService;
import com.zxit.service.MisEmrIcd10Service;
import com.zxit.service.MisEmrPreaidVsService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.SysSelectService;
import com.zxit.service.VMisEmrAmbulService;
import com.zxit.service.VMisEmrHandoverService;
import com.zxit.service.VMisEmrQueryService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;

/**
 * 体格检查控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrHandover.do")
public class MisEmrHandoverController {

    @Resource
    private MisEmrHandoverService misEmrHandoverService;
    @Resource
    private VMisEmrHandoverService vMisEmrHandoverService;
    @Resource
    private VMisEmrAmbulService vMisEmrAmbulService;
    @Resource
    private VMisEmrQueryService vMisEmrQueryService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysSelectService sysSelectService;//select构造器
    @Resource
    private SysCodeService sysCodeService;//基础代码服务
    @Resource
    private MisEmrIcd10Service misEmrIcd10Service;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;
    @Resource
    private MisEmrPreaidVsService misEmrPreaidVsService;
    @Resource
    private SystemConfig systemConfig;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrHandover", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrHandover(MisEmrHandover misEmrHandover, HttpServletRequest request) {
        Map<String, String> m = new HashMap<String, String>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrHandover.getId());
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrHandover.setLastModifyTime(new Date());
        misEmrHandover.setCreateTime(new Date());
        misEmrHandover.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        misEmrHandoverService.saveMisEmrHandover(misEmrHandover);
        return null;
    }


    @RequestMapping(params = "method=findVMisEmrAmbul")
    public String findVMisEmrAmbul(VMisEmrAmbul vMisEmrAmbul,
                                   HttpServletRequest request) {
        String orgId = ((SysMemberInfo) request.getSession().getAttribute(
                Constants.USERNAME)).getSysOrgInfo().getOrgId();
        vMisEmrAmbul.setOrgId(orgId);
        String hql = "";
        hql = vMisEmrAmbulService.createHQL(vMisEmrAmbul);
        int dataPerPage = systemConfig.getMaxPerPage();// 最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        hql = hql + "  1 = 1  ";//hql的尾巴
        pager.Init(vMisEmrAmbulService.findCount(hql), request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        hql = hql + " order by emrid desc";//排序
        List<VMisEmrAmbul> list = vMisEmrAmbulService.findVMisEmrAmbulPager(
                hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);
        request.setAttribute("vMisEmrAmbul", vMisEmrAmbul);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的
        // 生成单位下拉框
        TObject t = new TObject("szfz", "", "");
        List<SysOrgInfo> orgList = sysOrgInfoService.findSysOrgInfoFroSW();
        request.setAttribute("szfz", sysOrgInfoService.createSysOrgSelect(t, orgList));


        return "/business/list_MisEmrAmbulForHandover";
    }

    @RequestMapping(params = "method=findMisEmrHandoverById")
    public String findMisEmrHandoverById(String print, String id, HttpServletRequest request) {

        VMisEmrQuery vMisEmrQuery = vMisEmrQueryService.findVMisEmrQueryById(id);
        if (vMisEmrQuery != null) {
            request.setAttribute("szfz", sysOrgInfoService.findSysOrgInfoById(vMisEmrQuery.getSzfz()).getName());//出诊急救站
        }

        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(id);
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);
        if (misEmrBasicinfo != null) {
            request.setAttribute("sentTo", sysOrgInfoService.findSysOrgInfoById(misEmrBasicinfo.getSentTo()).getName());
            request.setAttribute("name", misEmrBasicinfo.getName());//姓名
            request.setAttribute("sex", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getSex(), Constants.sex));//性别
            request.setAttribute("condition", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getCondition(), Constants.condition));//病情
            request.setAttribute("chiefComplaint", misEmrBasicinfo.getChiefComplaint());//主诉
        }

        MisEmrPreaidVs misEmrPreaidVs = misEmrPreaidVsService.findMisEmrPreaidVsById(id);
        if (misEmrPreaidVs != null) {
            request.setAttribute("doctor", sysMemberInfoService.findSysMemberInfoById(misEmrPreaidVs.getDoctorSign()).getName());//接诊医生
        }
        createSelects(Constants.conscious, "hoConscious", "", request);//神智

        MisEmrHandover misEmrHandover = misEmrHandoverService.findMisEmrHandoverById(id);
        request.setAttribute("misEmrHandover", misEmrHandover);

        if (print != null && print.equals("1")) {
            if (misEmrHandover != null) {//**
                request.setAttribute("hoConscious", sysCodeService.findSysCodeByIdAndPid(misEmrHandover.getHoConscious(), Constants.conscious).getName());
            }
            return "/print/print_handover";
        }
        return "/business/MIS_EMR_HANDOVER";
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


    /**
     * 创建疾病类型ICD10多选组件
     *
     * @return
     */
    @RequestMapping(params = "method=findPrimDiag")
    public String findPrimDiag(MisEmrIcd10 misEmrIcd10, HttpServletRequest request) {
        String hql = misEmrIcd10Service.createHQL(misEmrIcd10);//创造查询HQL
        List<MisEmrIcd10> list = misEmrIcd10Service.findMisEmrIcd10ByHql(hql);
        TObject t = new TObject();
        t.setSelectIdAndName("select");
        String select = misEmrIcd10Service.createSelect(t, list);
        request.setAttribute("select", select);
        return "multi-handover";
    }


    /**
     * 异步返回 疾病类型ICD10汉字
     *
     * @param str
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findPrimDiagText", method = RequestMethod.GET)
    public String findPrimDiagText(String str) {
        String returnStr = "";
        if (str != null) {
            if (str.length() != 0) {
                String[] temp = str.split(",");
                for (int i = 0; i < temp.length; i++) {
                    String diseaseName = misEmrIcd10Service.findMisEmrIcd10ById(Integer.parseInt(temp[i])).getDiseaseName();
                    returnStr += diseaseName + "        ";
                }
            }
        }
        return returnStr;
    }


}
