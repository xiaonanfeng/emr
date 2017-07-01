package com.zxit.action;

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;
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
 * 病历基础信息控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrBasicinfo.do")
public class MisEmrBasicinfoController {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private VAcceptAmbulOutdInfoService vAcceptAmbulOutdInfoService;
    @Resource
    private SysSelectService sysSelectService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private SysCodeTypeService sysCodeTypeService;
    @Resource
    private SystemConfig systemConfig;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrBasicinfo", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrBasicinfo(
            MisEmrBasicinfo misEmrBasicinfo, HttpServletRequest request) {

        Map<String, String> m = new HashMap<String, String>();
        SysMemberInfo sysMemberInfo = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME));
        String createuserid = sysMemberInfo.getId();
        //如果对象里面有用户ID并且ID和当前登录的用户还不一样
        if (misEmrBasicinfo.getCreateuserid() != null && !misEmrBasicinfo.getCreateuserid().equals(createuserid)) {
            m.put("msg", "您不能修改其他人的病历表单！");
            return m;
        }
        if (misEmrBasicinfo.getName() == null || "".equals(misEmrBasicinfo.getName())) {
            misEmrBasicinfo.setName("无名氏");
        }
        misEmrBasicinfo.setLastModifyTime(new Date());
        misEmrBasicinfo.setCreateTime(new Date());
        misEmrBasicinfo.setXzbm(sysMemberInfo.getXzbm());
        misEmrBasicinfo.setCreateuserid(createuserid);
        misEmrBasicinfoService.saveMisEmrBasicinfo(misEmrBasicinfo);
        return null;
    }

    /**
     * 病历提交方法
     *
     * @param id
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=commitMisEmrBasicinfo", method = RequestMethod.POST)
    public Map<String, String> commitMisEmrBasicinfo(String id, HttpServletRequest request) {
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(id);
        misEmrBasicinfoService.commitMisEmrBasicinfo(misEmrBasicinfo);
        return null;
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrBasicinfoById")
    public void findMisEmrBasicinfoById(String id, HttpServletRequest request) {

        String emrBaseId = "";// 病历ID
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService
                .findMisEmrBasicinfoById(emrBaseId);
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);// 初始化基础显示项
    }

    /**
     * 基础信息查询控制器
     *
     * @param misEmrBasicinfo
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrBasicinfoList")
    public String findMisEmrBasicinfoList(MisEmrBasicinfo misEmrBasicinfo, HttpServletRequest request) {
        int dataPerPage = systemConfig.getMaxPerPage();// 最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        String hql = misEmrBasicinfoService.createHQL(misEmrBasicinfo);
        pager.Init(misEmrBasicinfoService.findCount(hql), request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        List<MisEmrBasicinfo> list = misEmrBasicinfoService.findMisEmrBasicinfoByHql(hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);
        return "";
    }

    /**
     * 呼叫原因、疾病分类
     * 二级下拉菜单
     *
     * @param code
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findDiseaseType", method = RequestMethod.POST)
    public String findDiseaseType(Integer code, HttpServletRequest request) {
        //TODO WARNING这里是有问题的，而且肯定是一个大问题，关于syscodetype的设计
        Integer typeid = null;
        if (code != null) {
            typeid = code;
        }
        if (typeid != null) {
            String select = "";
            TObject t = new TObject("diseaseType", "", "");
            //TObject t = new TObject("diseaseType", "", "callSe(this)");
            //这里得到的只有code，需要从code里面找到SysCodeType的typeid
            List<SysCode> list = sysCodeService.findSysCodeByPid(typeid);
            select = sysSelectService.CreateSelect(t, list);
            return select;
        }
        return null;
    }


}
