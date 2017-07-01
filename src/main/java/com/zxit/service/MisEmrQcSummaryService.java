package com.zxit.service;

import java.util.List;


import com.zxit.model.MisEmrQcSummary;

public interface MisEmrQcSummaryService extends ABaseService {


    /**
     * 根据时间端查询病历的基础SQL
     *
     * @param orgId
     * @return
     */
    public String findSumBtnTimes(String timebegin, String timeover);

    /**
     * 病历总数
     *
     * @return
     */
    public String findEmrSum(String orgId);

    /**
     * 死亡病历数
     *
     * @return
     */
    public String findDeathEmrSum(String base);

    /**
     * 病危病历数
     *
     * @return
     */
    public String findCriticalEmrSum(String base);

    /**
     * 病情重病历数
     *
     * @return
     */
    public String findSevereEmrSum(String base);

    /**
     * 病情中病例数
     */
    public String findMediumErmSum(String base);

    /**
     * 病情轻病数
     */
    public String findLightEmrSum(String base);

    /**
     * 抽查总数
     *
     * @return
     */
    public String findSpotCheckSum(String base, Integer level);

    /**
     * 问题病历总数
     *
     * @return
     */
    public String findDefectEmrSum(String base, Integer level);

    /**
     * 满分病历数
     */
    public String findFullCreditErmSum(String base, Integer level);

    /**
     * 病历评定等级统计
     *
     * @return
     */
    public String findGradeCount(String base, Integer level, Double startvalue, Double endvalue);

    /**
     * 甲A级病历数
     *
     * @return
     */
    public String findFirstAGrade(String base, Integer level);

    /**
     * 甲B级病历数
     *
     * @return
     */
    public String findFirstBGrade();

    /**
     * 甲C级病历数
     *
     * @return
     */
    public String findFirstCGrade();

    /**
     * 乙级病历数
     *
     * @return
     */
    public String findSecondGrade();

    /**
     * 丙级病历数
     *
     * @return
     */
    public String findThirdGrade();

    /**
     * 查询SQL
     *
     * @param misEmrQcSummary
     * @param timebegin
     * @param timeover
     * @return
     */
    public String findMisEmrQcSummaryByHql(MisEmrQcSummary misEmrQcSummary, String timebegin, String timeover);

    /**
     * 查询检索方法
     *
     * @param misEmrQcSummary
     * @return
     */
    public List<MisEmrQcSummary> findMisEmrQcSummaryWithPager(String hql,
                                                              int startPos, int dataPerPage);

}
