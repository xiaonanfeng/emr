package com.zxit.action;

import java.util.ArrayList;
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
import com.zxit.model.MisEmrMdfreq;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrMdfreqService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.SysSelectService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;
import com.zxit.tools.ServletParameter;


@Controller
@RequestMapping("/misEmrMdfreq.do")
public class MisEmrMdfreqController {

    @Resource
    private SysMemberInfoService sysMemberInfoService;
    @Resource
    private MisEmrMdfreqService misEmrMdfreqService;
    @Resource
    private SystemConfig systemConfig;
    @Resource
    private SysSelectService sysSelectService;//select构造器
    @Resource
    private SysCodeService sysCodeService;//基础代码服务
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;

    /**
     * 通过病历ID
     * 发起一个修改申请的动作
     * 并初始化修改申请页面
     *
     * @param emrId
     */
    @RequestMapping(params = "method=findMisEmrMdfReqByEmrId")
    public String findMisEmrMdfReqByEmrId(String emrId, HttpServletRequest request) {

        initEmrBasic(emrId, request);
        /**
         * 获取当前这个病历还未进行审核的申请
         * 作为页面表单初始化
         */
        MisEmrMdfreq misEmrMdfreq = misEmrMdfreqService.findByEmrIdAndRstIsZero(emrId);
        request.setAttribute("misEmrMdfreq", misEmrMdfreq);
        return "/business/MIS_EMR_MDFREQ";
    }


    /**
     * 发现一个修改申请
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrMdfReqById")
    public String findMisEmrMdfReqById(Long id, HttpServletRequest request) {
        /**
         * 修改信息初始化
         */
        MisEmrMdfreq misEmrMdfreq = misEmrMdfreqService.findById(MisEmrMdfreq.class, id);
        request.setAttribute("misEmrMdfreq", misEmrMdfreq);//初始化修改申请

        String emrId = misEmrMdfreq.getEmrId();
        initEmrBasic(emrId, request);

        return "/business/MIS_EMR_MDFREQ";
    }

    /**
     * 初始化病历基础信息部分
     *
     * @param ermId
     */
    public void initEmrBasic(String emrId, HttpServletRequest request) {
        /**
         * 后台验证这个病历的提交状态
         * 为了防止申请方页面没有刷新但是审核已经通过的情况
         */
        MisEmrBasicinfo misEmrBasicinfo = misEmrMdfreqService.findById(MisEmrBasicinfo.class, emrId);
        request.setAttribute("emrId", emrId);//初始化病历编号
        request.setAttribute("isCommited", misEmrBasicinfo.getIsCommitted());
        /**
         * 列举出这个病历下所有的修改信息
         */
        List<MisEmrMdfreq> list = misEmrMdfreqService.findMdfreqsByEmrId(emrId);
        request.setAttribute("list", list);

        createPubSelect(request);
    }

    /**
     * 公共select
     *
     * @param request
     */
    public void createPubSelect(HttpServletRequest request) {

        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);

        TObject t = new TObject();
        String html = "";//页面html代码
        /**
         * 填写人下拉框
         */
        String reqName = "";
        request.setAttribute("reqName", reqName);
        /**
         * 根据不同的人员类型
         * 找到不同的审批人员列表
         * 医生  type = 40
         * 分中心负责人=急救科医护  单位20人员类型100的人   人员类型40    所属科室 急救科
         * 急救科负责人=质管科医护
         * 分中心领导
         */
//		List<SysMemberInfo> idList = misEmrMdfreqService.findMisEmrMdfprvsListByHql(sysMemberInfo);
//		t.setSelectIdAndName("recMember");
//		html = sysMemberInfoService.createMemberInfoSelect(t, idList);
//		request.setAttribute("recMember",html);
        /**
         * 找到修改原因
         */
        List<SysCode> listCodes = sysCodeService.findSysCodeByPid(Constants.MDFREASON);
        t.setSelectIdAndName("mdfReason");
        html = sysSelectService.CreateSelect(t, listCodes);
        request.setAttribute("mdfReason", html);

    }

    /**
     * 发现一个需要 修改申请
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrMdfPrevById")
    public String findMisEmrMdfPrevById(Long id, HttpServletRequest request) {
        MisEmrMdfreq misEmrMdfreq = misEmrMdfreqService.findById(MisEmrMdfreq.class, id);
        request.setAttribute("misEmrMdfreq", misEmrMdfreq);//初始化修改申请
        return "/business/MIS_EMR_MDFREQ_PRV";
    }

    /**
     * 保存修改申请
     * 保存申请审批
     *
     * @param misEmrMdfreq
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrMdfReq", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrMdfReq(MisEmrMdfreq misEmrMdfreq, HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        /**
         * 申请提交时，只允许 一个病历  一次未审核申请
         */
        MisEmrMdfreq temp = misEmrMdfreqService.findByEmrIdAndRstIsZero(misEmrMdfreq.getEmrId());
        if (temp != null && misEmrMdfreq.getReqResult() == null) {
            map.put("err", "申请已存在且未审核！");
            return map;
        }

        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        String orgId = sysMemberInfo.getSysOrgInfo().getOrgId();
        misEmrMdfreq.setOrgId(orgId);//
        //如果是填写人
        if (!sysMemberInfo.getSysOrgInfo().getOrgId().equals(Constants.center)) {
            misEmrMdfreq.setReqMember(sysMemberInfo.getId());
            misEmrMdfreq.setCreateTime(new Date());
            misEmrMdfreqService.saveOrUpdate(misEmrMdfreq);
        } else {
            temp.setReqResult(misEmrMdfreq.getReqResult());
            temp.setRecRemark(misEmrMdfreq.getRecRemark());
            temp.setComtagain(misEmrMdfreq.getComtagain());
            temp.setRed(0);//告诉申请人这个信息没有读
            misEmrMdfreqService.saveReqRec(temp);
        }
        return null;
    }


    /**
     * 发现所有修改申请总量
     * 用于页面消息提示
     *
     * @param stat 0中心   1分站
     * @param id
     * @return
     */
    @RequestMapping(params = "method=findMisEmrMdfs")
    public String findMisEmrMdfs(Integer stat, HttpServletRequest request) {

        String timebegin = ServletParameter.getParameter(request, "timebegin", "");
        String timeover = ServletParameter.getParameter(request, "timeover", "");
        String reqResult = ServletParameter.getParameter(request, "reqResult", "");


        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        List<MisEmrMdfreq> list = new ArrayList<MisEmrMdfreq>();
        if (stat == 0) {//带审批消息
            return findMdfReqs4Prev(timebegin, timeover, reqResult, sysMemberInfo, request);
        } else {//已审批为阅读消息
            list = misEmrMdfreqService.findRecNotRed(timebegin, timeover, sysMemberInfo.getId());
        }
        request.setAttribute("list", list);
        return "/business/list_MIS_EMR_MDFREQ";
    }

    /**
     * 发现所有修改申请总量
     * 用于页面消息提示
     *
     * @param stat 0中心   1分站
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisEmrMdfReqCount")
    public Integer findMisEmrMdfReqCount(Integer stat, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        Integer count = 0;
        if (sysMemberInfo != null) {
            count = misEmrMdfreqService.findMisEmrMdfReqCount(stat, sysMemberInfo.getId());
        } else {//防止用户登录过期的情况
            return 0;
        }
        return count;
    }

    /**
     * 申请方签收确认反馈信息
     *
     * @param stat
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=checkMisEmrMdfReqById")
    public void checkMisEmrMdfReqById(Long id, HttpServletRequest request) {
        misEmrMdfreqService.checkMisEmrMdfReqById(id);
    }

    /**
     * --第一步找具病历审核权的角色id，这个可能是多个，点击病历审核按钮的时候 moduleid是知道的
     * select role_code from mis_categorypermission where objecttype=2 and moduleid=2013
     * --第二步当前登录人具有审核病历权限的角色id，这个应该是一个确定的，此处应该获取的是30
     * select role_code from sys_member_role where role_code in(第一步找到的rolecode) and member_id='当前登录人id'
     * --第三步
     * select * from mis_datascope_permission where objecttype=2 and objectid=30 and ;
     * --第四步
     * select * from 申请表 where org_id in(第二步获取的orgid);
     */
    @RequestMapping(params = "method=findMdfReqs4Prev")
    public String findMdfReqs4Prev(String timebegin, String timeover, String reqResult, SysMemberInfo sysMemberInfo, HttpServletRequest request) {
        request.setAttribute("timebegin", timebegin);
        request.setAttribute("timeover", timeover);
        request.setAttribute("reqResult", reqResult);

        String memberId = sysMemberInfo.getId();
        String hql = "";
        hql = misEmrMdfreqService.createQueryHql(timebegin, timeover, reqResult, sysMemberInfo);
        hql = hql + " 1 = 1  ";
        int dataPerPage = systemConfig.getMaxPerPage();//最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        Integer total = 0;
        total = misEmrMdfreqService.findCount(hql);
        pager.Init(total, request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        hql = hql + "  order by t.createTime  desc";
        System.out.println("MisEmrMdfreq:" + memberId + ":" + hql);
        List<MisEmrMdfreq> list = misEmrMdfreqService.findMisEmrMdfreqWithPager(hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);
        return "/business/list_MIS_EMR_MDFREQ_PRV";
    }


    /**
     * 保存申请审批
     *
     * @param misEmrMdfreq
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrMdfPrev", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrMdfPrev(MisEmrMdfreq misEmrMdfreq, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        Long id = misEmrMdfreq.getId();
        MisEmrMdfreq temp = misEmrMdfreqService.findById(MisEmrMdfreq.class, id);
        if (temp != null) {
            temp.setReqResult(misEmrMdfreq.getReqResult());
            temp.setComtagain(misEmrMdfreq.getComtagain());
            String recMember = sysMemberInfo.getId();
            temp.setRecMember(recMember);
            temp.setRecRemark(misEmrMdfreq.getRecRemark());
            temp.setRed(0);
            misEmrMdfreqService.saveOrUpdate(temp);
            if (misEmrMdfreq.getReqResult() == 1) {//如果同意
                MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrMdfreq.getEmrId());
                misEmrBasicinfo.setIsCommitted(0);//更改为未提交状态
                misEmrBasicinfoService.saveMisEmrBasicinfo(misEmrBasicinfo);
            }
        }
        return null;
    }


}
