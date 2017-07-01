package com.zxit.action;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisEmrQcSummary;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.service.MisEmrQcSummaryService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.tools.ServletParameter;
import com.zxit.tools.UtilTools;

@Controller
@RequestMapping("/misEmrQcSummary.do")
public class MisEmrQcSummaryController {

    @Resource
    private MisEmrQcSummaryService misEmrQcSummaryService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;
    @Resource
    private JdbcTemplate jdbcTemplate;

    private String percentFomateStr = "######0.000%";


    /**
     * 考核报表页面定位
     *
     * @param level
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findQcPage")
    public String findQcPage(Integer level, HttpServletRequest request) {
        Long id;
        String level_text = "";
        String org_text = "";
        String orgId = "";
        String id_temp = ServletParameter.getParameter(request, "id", "");
        String userName = "";
        //如果id没有值，则代表新增
        if (id_temp == null || "".equals(id_temp)) {
            id = misEmrQcSummaryService.findPK("SEQ_MIS_EMR_QC_SUMMARY");//序列产生主键
            SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
            orgId = sysMemberInfo.getSysOrgInfo().getOrgId();
            userName = sysMemberInfo.getName();
        } else {//查看、修改历史记录
            id = Long.valueOf(id_temp);
            MisEmrQcSummary misEmrQcSummary = misEmrQcSummaryService.findById(MisEmrQcSummary.class, id);
            request.setAttribute("misEmrQcSummary", misEmrQcSummary);
            level = misEmrQcSummary.getQcLevel();
            orgId = misEmrQcSummary.getOrgId();
            if (misEmrQcSummary.getEmrSum() != 0) {
                //抽样率
                String rateStr = UtilTools.getPercent(misEmrQcSummary.getSpotCheckSum(), misEmrQcSummary.getEmrSum(), percentFomateStr);
                request.setAttribute("rateStr", rateStr);
            }
            userName = sysMemberInfoService.findSysMemberInfoById(misEmrQcSummary.getSumUserid()).getName();
        }

        request.setAttribute("userName", userName);
        request.setAttribute("id", id);
        request.setAttribute("level", level);
        level_text = UtilTools.fmtNumToTxt(level) + "级";
        request.setAttribute("level_text", level_text);
        org_text = sysOrgInfoService.findSysOrgInfoById(orgId).getName();
        request.setAttribute("org_text", org_text);//单位名称
        String print = ServletParameter.getParameter(request, "print", "");
        if ("1".equals(print)) {
            return "/print/print_qc";
        }
        return "/business/MIS_EMR_QC";
        //return "/business/test";
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param timebegin 开始时间
     * @param timeover  结束时间
     * @param level     审核等级
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findQcCounts", method = RequestMethod.POST)
    public MisEmrQcSummary findQcCounts(String startTime, String endTime, Integer level, HttpServletRequest request) {

        String baseSql = misEmrQcSummaryService.findSumBtnTimes(startTime, endTime);//基本sql
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        String orgId = sysMemberInfo.getSysOrgInfo().getOrgId();

        MisEmrQcSummary misEmrQcSummary = new MisEmrQcSummary();//POJO
        misEmrQcSummary.setQcLevel(level);//评审等级

        String sqlOrg = baseSql + misEmrQcSummaryService.findEmrSum(orgId);//带单位ID筛选
        //病历总量
        Integer emrSum = misEmrQcSummaryService.findTotalBySQL(sqlOrg);
        misEmrQcSummary.setEmrSum(emrSum);
        //死亡
        Integer deathEmrSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findDeathEmrSum(sqlOrg));
        misEmrQcSummary.setDeathEmrSum(deathEmrSum);
        //病危
        Integer criticalEmrSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findCriticalEmrSum(sqlOrg));
        misEmrQcSummary.setCriticalEmrSum(criticalEmrSum);
        //病重
        Integer severeEmrSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findSevereEmrSum(sqlOrg));
        misEmrQcSummary.setSevereEmrSum(severeEmrSum);
        //病中
        Integer mediumErmSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findMediumErmSum(sqlOrg));
        misEmrQcSummary.setMediumErmSum(mediumErmSum);
        //病轻
        Integer lightEmrSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findLightEmrSum(sqlOrg));
        misEmrQcSummary.setLightEmrSum(lightEmrSum);

        //抽样总量
        Integer spotCheckSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findSpotCheckSum(sqlOrg, level));
        misEmrQcSummary.setSpotCheckSum(spotCheckSum);

        //抽样率
        double rate = 0;
        String rateStr = "";
        if (emrSum != 0) {
            rate = spotCheckSum * 1.0 / emrSum * 1.0;
            rateStr = UtilTools.getPercent(spotCheckSum, emrSum, percentFomateStr);//保留三位小数
        } else {
            rateStr = "0.000%";
        }
        DecimalFormat df = new DecimalFormat("#.000");
        misEmrQcSummary.setSpotCheckRate(Double.valueOf(df.format(rate)));
        misEmrQcSummary.setSpontCheckPercent(rateStr);
        //问题病历总量

        //TODO 病历评分等级写死了
        //甲A级
        Integer firstAGrade = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findGradeCount(sqlOrg, level, 97.00, 99.99));
        misEmrQcSummary.setFirstAGrade(firstAGrade);
        //甲B级
        Integer firstBGrade = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findGradeCount(sqlOrg, level, 94.00, 96.00));
        misEmrQcSummary.setFirstBGrade(firstBGrade);
        //甲C级
        Integer firstCGrade = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findGradeCount(sqlOrg, level, 90.00, 93.00));
        misEmrQcSummary.setFirstCGrade(firstCGrade);
        //乙级
        Integer secondGrade = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findGradeCount(sqlOrg, level, 80.00, 89.00));
        misEmrQcSummary.setSecondGrade(secondGrade);
        //丙级
        Integer thirdGrade = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findGradeCount(sqlOrg, level, 0.00, 80.00));
        misEmrQcSummary.setThirdGrade(thirdGrade);
        //问题病历数量
        Integer defectEmrSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findDefectEmrSum(sqlOrg, level));
        misEmrQcSummary.setDefectEmrSum(defectEmrSum);
        //满分病历数
        Integer fullCreditErmSum = misEmrQcSummaryService.findTotalBySQL(misEmrQcSummaryService.findFullCreditErmSum(sqlOrg, level));
        misEmrQcSummary.setFullCreditErmSum(fullCreditErmSum);


        return misEmrQcSummary;
    }

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrQcSummary", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrQcSummary(MisEmrQcSummary misEmrQcSummary, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        //Map<String, String> m = new HashMap<String, String>();
        misEmrQcSummary.setOrgId(sysMemberInfo.getSysOrgInfo().getOrgId());
        misEmrQcSummary.setSumUserid(sysMemberInfo.getId());
        misEmrQcSummary.setSumTime(new Date());
        misEmrQcSummary.setXzbm(sysMemberInfo.getXzbm());
        misEmrQcSummaryService.saveOrUpdate(misEmrQcSummary);
        return null;
    }


    @RequestMapping(params = "method=findMisEmrQcSummary")
    public String findMisEmrQcSummary(MisEmrQcSummary misEmrQcSummary, Integer level, String timebegin, String timeover, HttpServletRequest request) {
        // 生成单位下拉框
        TObject t = new TObject("orgId", "", "");
        List<SysOrgInfo> orgList = sysOrgInfoService.findSysOrgInfoFroSW();
        request.setAttribute("orgId", sysOrgInfoService.createSysOrgSelect(t, orgList));
        misEmrQcSummary.setQcLevel(level);
        String hql = misEmrQcSummaryService.findMisEmrQcSummaryByHql(misEmrQcSummary, timebegin, timeover);

        int dataPerPage = 10;//最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        Integer total = 0;
        total = misEmrQcSummaryService.findTotalByHQL(hql);
        pager.Init(total, request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        List<MisEmrQcSummary> list = misEmrQcSummaryService.findMisEmrQcSummaryWithPager(hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);

        return "/business/list_MisEmrQcSummary";
    }


    @RequestMapping(params = "method=findDefectEmr")
    public String findDefectEmr(String startTime, String endTime, Integer level, HttpServletRequest request) {
        String baseSql = misEmrQcSummaryService.findSumBtnTimes(startTime, endTime);//基本sql
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        String orgId = sysMemberInfo.getSysOrgInfo().getOrgId();

        MisEmrQcSummary misEmrQcSummary = new MisEmrQcSummary();//POJO
        misEmrQcSummary.setQcLevel(level);//评审等级

        String sqlOrg = baseSql + misEmrQcSummaryService.findEmrSum(orgId);//带单位ID筛选
        //问题病历总量665
        String sql = "select c.emr_id as id, c.name,d.doctor_sign from (" + misEmrQcSummaryService.findDefectEmrSum(sqlOrg, level) + ")c,mis_emr_preaid_vs d where c.emr_id = d.id";
        //存在问题的病历ID集合
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        request.setAttribute("sqlRowSet", sqlRowSet);
        while (sqlRowSet.next()) {
            System.out.println(sqlRowSet.getString("id"));
            System.out.println(sqlRowSet.getString("name"));
            System.out.println(sqlRowSet.getString("doctor_sign"));
        }


        //String exlList =
        //	"select * from call_info a,mis_emr_basicinfo b,mis_emr_pe c,mis_emr_ae d,mis_emr_preaid_vs ewhere a.lsh = b.lshand b.id = c.idand c.id = d.idand d.id = e.id";


        return "/exp/expdefectEmr";
    }

}
