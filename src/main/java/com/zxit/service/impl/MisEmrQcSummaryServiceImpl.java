package com.zxit.service.impl;

import com.zxit.model.MisEmrQcSummary;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrQcSummaryService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.SysOrgInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("misEmrQcSummary")
public class MisEmrQcSummaryServiceImpl extends ABaseServiceImpl implements
        MisEmrQcSummaryService {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;

    /**
     * 创建救治情况的枚举类型
     * 0	危重
     * 1	重
     * 2	中
     * 3	轻
     * 4	救前死亡
     * 5	不详
     * 6	无特殊
     */
    public enum Condition {

        CriticalEmrSum(0), SevereEmrSum(1), MediumErmSum(2), LightEmrSum(3), DeathEmrSum(4);

        // 定义私有变量
        private Integer code;

        // 构造函数，枚举类型只能为私有
        private Condition(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

    }
//

    @Override
    public String findSumBtnTimes(String timebegin, String timeover) {
        String sql = " select a.* from V_MIS_EMR_QUERY a "
                + "where to_char(a.hjsj,'yyyy-mm-dd hh') <= '" + timeover + "' "
                + "and to_char(a.hjsj,'yyyy-mm-dd hh') >= '" + timebegin + "' ";
        return sql;
    }

    @Override
    public String findEmrSum(String orgId) {
        String sql = "and szfz = '" + orgId + "' ";
        return sql;
    }

    @Override
    public String findDeathEmrSum(String base) {
        String sql = base + " and condition = '" + Condition.DeathEmrSum.getCode() + "' ";
        return sql;
    }

    @Override
    public String findCriticalEmrSum(String base) {
        String sql = base + " and condition = '" + Condition.CriticalEmrSum.getCode() + "' ";
        return sql;
    }

    @Override
    public String findSevereEmrSum(String base) {
        String sql = base + " and condition = '" + Condition.SevereEmrSum.getCode() + "' ";
        return sql;
    }

    @Override
    public String findMediumErmSum(String base) {
        String sql = base + " and condition = '" + Condition.MediumErmSum.getCode() + "' ";
        return sql;
    }

    @Override
    public String findLightEmrSum(String base) {
        String sql = base + " and condition = '" + Condition.LightEmrSum.getCode() + "' ";
        return sql;
    }

    @Override
    public String findSpotCheckSum(String base, Integer level) {
        String sql = base + " and a.EMRID in (select emr_id as EMRID from MIS_EMR_SCORE_TOTAL where score_level = '" + level + "')";
        return sql;
    }

    @Override
    public String findDefectEmrSum(String base, Integer level) {
        String sql = "select * from (" + base + ") t1,"
                + "MIS_EMR_SCORE_TOTAL t2 "
                + "where t2.total_score != " + 100 + " "
                + "and t1.emrid = t2.emr_id "
                + "and t2.score_level = '" + level + "' ";
        return sql;
    }

    @Override
    public String findGradeCount(String base, Integer level, Double startvalue, Double endvalue) {
        String sql = "select * from (" + base + ") t1,"
                + "MIS_EMR_SCORE_TOTAL t2 "
                + "where t2.total_score >= " + startvalue + " "
                + "and t2.total_score <= " + endvalue + " "
                + "and t1.emrid = t2.emr_id "
                + "and t2.score_level = '" + level + "' ";

        return sql;
    }

    @Override
    public String findFirstAGrade(String base, Integer level) {
        String sql = "select * from (" + base + ") t1,"
                + "MIS_EMR_SCORE_TOTAL t2 "
                + "where t2.total_score >= " + 97.00 + " "
                + "and t2.total_score < " + 100.00 + " "
                + "and t1.emrid = t2.emr_id "
                + "and t2.score_level = '" + level + "' ";

        return sql;
    }

    @Override
    public String findFullCreditErmSum(String base, Integer level) {
        String sql = "select * from (" + base + ") t1,"
                + "MIS_EMR_SCORE_TOTAL t2 "
                + "where t2.total_score = " + 100 + " "
                + "and t1.emrid = t2.emr_id "
                + "and t2.score_level = '" + level + "' ";
        return sql;
    }

    @Override
    public String findFirstBGrade() {

        return null;
    }

    @Override
    public String findFirstCGrade() {

        return null;
    }

    @Override
    public String findSecondGrade() {

        return null;
    }

    @Override
    public String findThirdGrade() {

        return null;
    }

    @Override
    public String findMisEmrQcSummaryByHql(
            MisEmrQcSummary misEmrQcSummary, String timebegin, String timeover) {
        String hql = "from MisEmrQcSummary t where ";

        if (timebegin != null && !"".equals(timebegin)) {//开始时刻
            hql = hql + " to_char(t.sumTime,'yyyy-mm-dd hh24:mi:ss')  >= '" + timebegin + "' and ";
        }
        if (timeover != null && !"".equals(timeover)) {//结束时刻
            hql = hql + " to_char(t.sumTime,'yyyy-mm-dd hh24:mi:ss')  <= '" + timeover + "'  and ";
        }
        if (misEmrQcSummary.getEmrMonth() != null && !"".equals(misEmrQcSummary.getEmrMonth())) {
            hql = hql + "  emrMonth = '" + misEmrQcSummary.getEmrMonth() + "'  and ";
        }
        if (misEmrQcSummary.getOrgId() != null && !"".equals(misEmrQcSummary.getOrgId())) {
            hql = hql + "  orgId = '" + misEmrQcSummary.getOrgId() + "'  and ";
        }
        if (misEmrQcSummary.getOrgId() != null && !"".equals(misEmrQcSummary.getOrgId())) {
            hql = hql + "  orgId = '" + misEmrQcSummary.getOrgId() + "'  and ";
        }
        if (misEmrQcSummary.getQcLevel() != null) {
            hql = hql + "  qcLevel = '" + misEmrQcSummary.getQcLevel() + "'  and ";
        }
        if (misEmrQcSummary.getSumUserid() != null && !"".equals(misEmrQcSummary.getSumUserid())) {
            hql = hql + " sumUserid = '" + misEmrQcSummary.getSumUserid() + "'";
        }

        hql = hql + "  1 = 1  order by t.id desc";//hql的尾巴

        return hql;
    }


    @Override
    public List<MisEmrQcSummary> findMisEmrQcSummaryWithPager(String hql,
                                                              int startPos, int dataPerPage) {
        List<MisEmrQcSummary> list = this.findWithPager(MisEmrQcSummary.class, hql, startPos, dataPerPage);

        for (MisEmrQcSummary d : list) {
            d.setOrg_text(sysOrgInfoService.findSysOrgInfoById(d.getOrgId()).getAlias());
            d.setSumUser_text(sysMemberInfoService.findSysMemberInfoById(d.getSumUserid()).getName());
        }
        return list;
    }


}
