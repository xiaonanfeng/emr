package com.zxit.service;

import java.util.List;
import java.util.Map;

import com.zxit.model.VAcceptAmbulOutdInfo;
import com.zxit.model.VAcceptAmbulOutdInfoId;

/**
 * 接处警基础信息
 *
 * @author Administrator
 */
public interface VAcceptAmbulOutdInfoService {
    /**
     * 带翻页查询
     *
     * @param hql
     * @param startNum
     * @param pageTotal
     * @return
     */
    public List<VAcceptAmbulOutdInfo> findVAcceptAmbulOutdInfoPager(String hql, int startNum, int pageTotal);

    /**
     * 带ID查询
     *
     * @param id
     * @return
     */
    public VAcceptAmbulOutdInfo findVAcceptAmbulOutdInfoById(VAcceptAmbulOutdInfoId id);

    /**
     * HQL创造器
     *
     * @param vAcceptAmbulOutdInfo
     * @return
     */
    public String createHQL(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo);

    /**
     * 总量
     *
     * @param hql
     * @return
     */
    public int findCount(String hql);

    /**
     * web HQL
     *
     * @param vAcceptAmbulOutdInfo
     * @return
     */
    public String createPadHQL(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo);

    /**
     * pad HQL
     *
     * @param vAcceptAmbulOutdInfo
     * @param systemConfig
     * @return
     */
    public String createWebHQL(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo);

    /**
     * @param hql
     * @param startNum
     * @param pageTotal
     * @param map
     * @return
     */
    public List<VAcceptAmbulOutdInfo> findVAcceptAmbulOutdInfoPagerWithCollections(
            String hql, int startNum, int pageTotal, Map<String, Object> map);


    /**
     * Sql集合后缀
     * 用户数据级权限
     *
     * @param memberId
     * @param orgId
     * @return
     */
    public String findOrgIdsFromSqlsuffix(String memberId, String orgId);


}
