package com.zxit.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrAmbul;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.SysSelectService;
import com.zxit.service.VMisEmrAmbulService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;

@Controller
@RequestMapping("/vMisEmrAmbul.do")
public class VMisEmrAmbulController {

    @Resource
    private VMisEmrAmbulService vMisEmrAmbulService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private SysSelectService sysSelectService;//select构造器
    @Resource
    private SystemConfig systemConfig;


    @RequestMapping(params = "method=findVMisEmrAmbul")
    public String findVMisEmrAmbul(VMisEmrAmbul vMisEmrAmbul,
                                   HttpServletRequest request) {
        /**
         * 当前登录用户的orgId
         */
        String orgId = ((SysMemberInfo) request.getSession().getAttribute(
                Constants.USERNAME)).getSysOrgInfo().getOrgId();
        vMisEmrAmbul.setOrgId(orgId);

        String hql = "";
        hql = vMisEmrAmbulService.createHQL(vMisEmrAmbul);
        int dataPerPage = systemConfig.getMaxPerPage();// 最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        hql = hql + "  1 = 1  ";//hql的尾巴
        System.out.println(hql);
        pager.Init(vMisEmrAmbulService.findCount(hql), request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        hql = hql + " order by emrid desc";//排序
        List<VMisEmrAmbul> list = vMisEmrAmbulService.findVMisEmrAmbulPager(
                hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);

        request.setAttribute("vMisEmrAmbul", vMisEmrAmbul);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的

        /**
         * 病历生成单位
         */
        TObject t = new TObject("szfz", "", "");
        List<SysCode> listCode = new ArrayList<SysCode>();
        List<SysOrgInfo> orgList = sysOrgInfoService.findSysOrgInfoFroSW();
        String orgSelect = sysOrgInfoService.createSysOrgSelect(t, orgList);
        request.setAttribute("szfz", orgSelect);
        /**
         * 送往分站
         */
        request.setAttribute("sendTo", orgSelect);

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
        t = new TObject("result", "", "");
        listCode = sysCodeService.findSysCodeByPid(Constants.pre_emc_result);
        request.setAttribute("result", sysSelectService.CreateSelect(t, listCode));
        /**
         * 呼叫原因、疾病分类
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

        return "/business/list_MisEmrAmbul";
    }

}
