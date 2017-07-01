package com.zxit.service;

import java.util.List;

import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;


public interface SysOrgInfoService {
    /**
     * @return
     */
    public List<SysOrgInfo> findSysOrgInfo();

    /**
     * 送往分站
     *
     * @return
     */
    public List<SysOrgInfo> findSysOrgInfoFroSW();

    /**
     * 病历所属分站
     *
     * @return
     */
    public List<SysOrgInfo> findSysOrgInfoFroSZ();

    /**
     * 第一级查询中心、分站、中心直属单位
     */
    public List<SysOrgInfo> findScenter4Center();

    /**
     * 第二级单位列表
     */
    public List<SysOrgInfo> findSzfz4Scenter(String orgId);

    /**
     * @param t
     * @param list
     * @return
     */
    public String createSysOrgSelect(TObject t, List<SysOrgInfo> list);

    /**
     * @param id
     * @return
     */
    public SysOrgInfo findSysOrgInfoById(String id);

    /**
     * @param hql
     * @return
     */
    public List<SysOrgInfo> findOrgsByHql(String hql);

    /**
     * 找到中心单位代码
     *
     * @return
     */
    public String findCenter();
}
