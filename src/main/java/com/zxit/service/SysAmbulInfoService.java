package com.zxit.service;

import java.util.List;

import com.zxit.model.SysAmbulInfo;

public interface SysAmbulInfoService {

    public SysAmbulInfo findSysAmbulInfoById(String id);

    public int findCount(String hql);

    public List<SysAmbulInfo> findSysAmbulInfoPager(String hql, int startPos, int dataPerPage);

    public String createHQL(SysAmbulInfo sysAmbulInfo);

    public List<SysAmbulInfo> findSysAmbulInfo(String hql);


}
