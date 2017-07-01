package com.zxit.action;

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

import com.zxit.model.MisEmrReview;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrAmbul;
import com.zxit.service.MisEmrReviewService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VMisEmrAmbulService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;

/***
 * 病历审核入口
 * @author Administrator
 * -----saveOrUpdate
 *	1，根据不同的用户和其审核级别
 *	2，筛选出已经提交并且需要审核的病历
 *		2.1，或者推荐需要审核的病历。（暂定）
 *	3，审核者在主窗体进入列出需要打分的项目列表，open一个新窗口打开病历主页。
 *	4，在打分项上进行操作，并且保存。和病历形成多对一关系。
 *	5，
 */
@Controller
@RequestMapping("/misEmrReview.do")
public class MisEmrReviewController {

    @Resource
    private MisEmrReviewService misEmrReviewService;
    @Resource
    private VMisEmrAmbulService vMisEmrAmbulService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SystemConfig systemConfig;

    /**
     * 需要审核的病历查询控制器
     * 首先要通过评审条件控制器进行过滤
     * 评审条件控制器可设置
     *
     * @param vMisEmrAmbul
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findVMisEmrAmbul")
    public String findVMisEmrAmbul(VMisEmrAmbul vMisEmrAmbul,
                                   HttpServletRequest request) {
        String orgId = ((SysMemberInfo) request.getSession().getAttribute(
                Constants.USERNAME)).getSysOrgInfo().getOrgId();
        vMisEmrAmbul.setOrgId(orgId);
        String hql = "";
        hql = vMisEmrAmbulService.createHQL(vMisEmrAmbul);
        hql = hql + "  isCommitted = 1  ";//只看提交过的
        int dataPerPage = systemConfig.getMaxPerPage();// 最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        pager.Init(vMisEmrAmbulService.findCount(hql), request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        hql = hql + "  order by emrid desc";//排序
        List<VMisEmrAmbul> list = vMisEmrAmbulService.findVMisEmrAmbulPager(hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);
        request.setAttribute("vMisEmrAmbul", vMisEmrAmbul);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的
        // 生成单位下拉框
        TObject t = new TObject("szfz", "", "");
        List<SysOrgInfo> orgList = sysOrgInfoService.findSysOrgInfoFroSW();
        request.setAttribute("szfz",
                sysOrgInfoService.createSysOrgSelect(t, orgList));

        return "/business/list_MisEmrAmbulForRev";
    }


    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrReview", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrReview(MisEmrReview misEmrReview,
                                                HttpServletRequest request) {

        SysMemberInfo sysMemberInfo = ((SysMemberInfo) request.getSession()
                .getAttribute(Constants.USERNAME));
        misEmrReview.setRevUserid(sysMemberInfo.getId());
        misEmrReviewService.saveMisEmrReview(misEmrReview);
        return null;
    }

    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrReviewById")
    public void findMisEmrReviewById(String id, HttpServletRequest request) {

        String emrBaseId = "";// 病历ID
        MisEmrReview misEmrReview = misEmrReviewService.findMisEmrReviewById(emrBaseId);
        request.setAttribute("misEmrReview", misEmrReview);// 初始化病历审核对象
    }

    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrReviewList")
    public String findMisEmrReviewList(MisEmrReview misEmrReview,
                                       HttpServletRequest request) {
        int dataPerPage = systemConfig.getMaxPerPage();// 最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        String hql = misEmrReviewService.createHQL(misEmrReview);
        pager.Init(misEmrReviewService.findCount(hql), request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        List<MisEmrReview> list = misEmrReviewService.findMisEmrReviewByHql(
                hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);
        return "";
    }


}
