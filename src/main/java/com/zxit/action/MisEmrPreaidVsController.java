package com.zxit.action;

import com.alibaba.fastjson.JSON;
import com.zxit.model.*;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.share.CreaterPK;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 施救措施控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrPreaidVs.do")
public class MisEmrPreaidVsController {

    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private SysSelectMultiService sysSelectMultiService;
    @Resource
    private MisEmrPreaidVsService misEmrPreaidVsService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrIcd10Service misEmrIcd10Service;
    @Resource
    private MisAmEmMedicineService misAmEmMedicineService;
    @Resource
    private MisEmrPreaidStatService misEmrPreaidStatService;

    /**
     * 保存一个施救措施对象
     * 和救治成功率对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrPreaidVs", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrPreaidVs(MisEmrPreaidVs misEmrPreaidVs,String stat, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        Integer xzbm = sysMemberInfo.getXzbm();
        String emrId = misEmrPreaidVs.getId();
        Map<String, String> m = new HashMap<>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        Date lastModifyTime = new Date();
        Date createTime = new Date();
        misEmrPreaidVs.setLastModifyTime(lastModifyTime);
        misEmrPreaidVs.setCreateTime(createTime);
        misEmrPreaidVs.setXzbm(xzbm);
        misEmrPreaidVsService.saveMisEmrPreaidVs(misEmrPreaidVs);
        misEmrPreaidStatService.deleteByEmrId(emrId);
        List<MisEmrPreaidStat> objList = JSON.parseArray(stat,MisEmrPreaidStat.class);
        for(MisEmrPreaidStat d:objList){
            d.setId(CreaterPK.CreatePK());
            d.setLastModifyTime(lastModifyTime);
            d.setCreateTime(createTime);
            d.setModifyUserid(sysMemberInfo.getId());
            d.setXzbm(xzbm);
            if(!(d.getPatientStat()==null&&d.getPreaidSucceed()==null&&d.getReason()==null)){
                misEmrPreaidStatService.saveOrUpdate(d);
            }
        }
        return null;
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrPreaidVsById")
    public void findMisEmrPreaidVsById(String id, HttpServletRequest request) {
        MisEmrPreaidVs misEmrPreaidVs = misEmrPreaidVsService.findMisEmrPreaidVsById(id);
        request.setAttribute("misEmrPreaidVs", misEmrPreaidVs);
    }


    /**
     * 施救措施
     * 创建多选组件
     *
     * @return
     */
    @RequestMapping(params = "method=findSceneTreatlects")
    public String findSceneTreatlects(HttpServletRequest request) {
        List<SysCode> list = sysCodeService.findSysCodeByPid(Constants.sceneTreat);
        List<String> values = java.util.Arrays.asList(request.getParameter("values").split(","));//转成list
        TObject t = new TObject();
        t.setSelectIdAndName("select");
        t.setInitStr(values);
        t.setObecjtName(Constants.sysCode);
        String select = sysSelectMultiService.createMultiSelect(t, list);
        request.setAttribute("select", select);
        return "chooser";
    }


    /**
     * 用药
     * 创建多选组件
     */
    @RequestMapping(params = "method=findSceneDrugSelects")
    public String findSceneDrugSelects(MisAmEmMedicine misAmEmMedicine, HttpServletRequest request) {
        String hql = misAmEmMedicineService.createHQL(misAmEmMedicine);
        List<MisAmEmMedicine> list = misAmEmMedicineService.findMisAmEmMedicineByHql(hql);

        //List<String> values =  java.util.Arrays.asList(request.getParameter("values").split(","));//转成list

        TObject t = new TObject();
        t.setSelectIdAndName("select");
        //t.setInitStr( values );
        t.setObecjtName(Constants.MisAmEmMedicine);
        String select = sysSelectMultiService.createMultiSelect(t, list);
        request.setAttribute("select", select);
        return "chooser";
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

        List<String> values = java.util.Arrays.asList(request.getParameter("values").split(","));//转成list
        TObject t = new TObject();
        t.setSelectIdAndName("select");
        t.setInitStr(values);
        t.setObecjtName(Constants.icd10);
        String select = sysSelectMultiService.createMultiSelect(t, list);
        request.setAttribute("select", select);
        return "chooser";
    }


    /**
     * 异步返回处理情况的 汉字
     *
     * @param str
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisEmrPreaidVsSceneTreatText", method = RequestMethod.GET)
    public String findMisEmrPreaidVsSceneTreatText(String str) {
        String returnStr = "";
        if (str != null) {
            if (str.length() != 0) {
                String[] temp = str.split(",");
                for (int i = 0; i < temp.length; i++) {
                    String codeName = sysCodeService.findSysCodeByIdAndPid(Integer.parseInt(temp[i]), Constants.sceneTreat).getName();
                    returnStr += codeName + "        ";
                }
            }
        }
        return returnStr;
    }


    /**
     * 异步返回药品使用情况的 汉字
     *
     * @param str
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findDrugText", method = RequestMethod.GET)
    public String findDrugText(String str) {
        String returnStr = "";
        if (str != null) {
            if (str.length() != 0) {
                String[] temp = str.split(",");
                for (int i = 0; i < temp.length; i++) {
                    String drugName = misAmEmMedicineService.findMisAmEmMedicineById(Integer.parseInt(temp[i])).getName();
                    returnStr += drugName + "        ";
                }
            }
        }
        return returnStr;
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
