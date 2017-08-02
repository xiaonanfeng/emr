package com.zxit.action;

import com.zxit.model.*;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;
import com.zxit.tools.ServletParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/misEmrQuery.do")
public class VMisEmrQueryController {

    @Resource
    private VMisEmrQueryService vMisEmrQueryService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private SysSelectService sysSelectService;//select构造器
    @Resource
    private SystemConfig systemConfig;
    @Resource
    private SysSelectMultiService sysSelectMultiService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;


    /**
     * 页面执行条件
     *
     * @param vMisEmrQuery
     * @param request
     */
    private void prepareHandler(VMisEmrQuery vMisEmrQuery, HttpServletRequest request) {
        request.setAttribute("vMisEmrQuery", vMisEmrQuery);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的
        /**
         * 所属机构
         */
        TObject t = new TObject("ssjgdm", "", "");
        List<SysCode> listCode = new ArrayList<SysCode>();
        List<SysOrgInfo> orgList = sysOrgInfoService.findScenter4Center();
        String orgSelect = sysOrgInfoService.createSysOrgSelect(t, orgList);
        request.setAttribute("ssjgdm", orgSelect);
        /**
         * 送往分站
         */
        t = new TObject("sentTo", "", "");
        orgList = sysOrgInfoService.findSysOrgInfoFroSW();
        orgSelect = sysOrgInfoService.createSysOrgSelect(t, orgList);
        request.setAttribute("sentTo", orgSelect);

        /**
         * 患者性别选择项
         */
        t = new TObject("sex", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.sex);
        request.setAttribute("sex", sysSelectService.CreateSelect(t, listCode));
        /**
         * 病情
         */
        t = new TObject("condition", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.condition);
        request.setAttribute("condition", sysSelectService.CreateSelect(t, listCode));
        /**
         * 救治结果
         */
        t = new TObject("preEmcResult", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.pre_emc_result);
        request.setAttribute("preEmcResult", sysSelectService.CreateSelect(t, listCode));
        /**
         * 呼叫原因
         */
        t = new TObject("cause", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.cause);
        request.setAttribute("cause", sysSelectService.CreateSelect(t, listCode));
        /**
         * 年龄段
         */
        t = new TObject("stage", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.stage);
        request.setAttribute("stage", sysSelectService.CreateSelect(t, listCode));
        /**
         * 疾病分类
         */
        t = new TObject("dClassify", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.d_class);
        request.setAttribute("dClassify", sysSelectService.CreateSelect(t, listCode));
    }

    /**
     * 病历信息列表查询总控制器
     *
     * @param vMisEmrQuery
     * @param actionButton 功能模块控制
     * @param level        病历评审等级
     * @param request
     * @return
     */
    @RequestMapping(params = "method=queryEmrs")
    public String findVMisEmrQuery(VMisEmrQuery vMisEmrQuery, Integer actionButton, Integer level, HttpServletRequest request) {
        this.prepareHandler(vMisEmrQuery, request);//执行页面
        request.setAttribute("actionButton", actionButton);//确定页面显示<a>的连接指向
        /**
         * 当前登录用户的orgId
         */
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        String orgId = sysMemberInfo.getSysOrgInfo().getOrgId();
        vMisEmrQuery.setOrgId(orgId);//(orgId);
        String memberId = sysMemberInfo.getId();
        vMisEmrQuery.setMemberId(memberId);
        //放入所在单位类型
        Integer orgType = null;
        orgType = sysMemberInfo.getSysOrgInfo().getType();
        vMisEmrQuery.setOrgType(orgType);
        //开始查询
        String hql = "";
        hql = vMisEmrQueryService.createHQL(vMisEmrQuery);
        hql = hql + "  1 = 1  ";//hql的尾巴

        int dataPerPage = systemConfig.getMaxPerPage();//最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        Integer total = 0;
        total = vMisEmrQueryService.findCount(hql);
        pager.Init(total, request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        hql = hql + " order by hjsj desc";//排序

        System.out.println("VMisEmrQuery:" + memberId + ":" + hql);

        List<VMisEmrQuery> list = vMisEmrQueryService.findVMisEmrQueryPager(hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);

        return "/business/list_MisEmrQuery";
    }


    @RequestMapping(params = "method=findDoctors")
    public String findDoctors(HttpServletRequest request) {
        String orgId = ServletParameter.getParameter(request,"orgId","");
        List<SysMemberInfo> list = sysMemberInfoService.findSysMemberInfoByType(Constants.doctorSign,orgId);
        List<String> values = java.util.Arrays.asList(request.getParameter("values").split(","));//转成list
        TObject t = new TObject();
        t.setSelectIdAndName("select");
        t.setInitStr(values);
        t.setObecjtName(Constants.SysMemberInfo);
        String select = sysSelectMultiService.createMultiSelect(t, list);
        request.setAttribute("select", select);
        return "chooser";
    }



}
