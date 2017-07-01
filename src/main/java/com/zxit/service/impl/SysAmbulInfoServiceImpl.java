package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.SysAmbulInfo;
import com.zxit.service.SysAmbulInfoService;

@Service("sysAmbulInfoService")
public class SysAmbulInfoServiceImpl implements SysAmbulInfoService {

    @Resource
    private ABaseDao aBaseDao;


    @Override
    public SysAmbulInfo findSysAmbulInfoById(String id) {
        SysAmbulInfo sysAmbulInfo = new SysAmbulInfo();
        sysAmbulInfo = aBaseDao.findById(SysAmbulInfo.class, id);
        return sysAmbulInfo;
    }

    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }

    @Override
    public List<SysAmbulInfo> findSysAmbulInfoPager(String hql, int startPos,
                                                    int dataPerPage) {
        List<SysAmbulInfo> list = aBaseDao.findWithPager(SysAmbulInfo.class, hql, startPos, dataPerPage);
        return list;
    }

    @Override
    public String createHQL(SysAmbulInfo sysAmbulInfo) {
        String hql = "from SysAmbulInfo t where";
        if (sysAmbulInfo != null) {
            if (null != sysAmbulInfo.getSysOrgInfo()) {
                hql = hql + "  t.sysOrgInfo.orgId = '" + sysAmbulInfo.getSysOrgInfo().getOrgId() + "' and ";
            }
            if (null != sysAmbulInfo.getClid()) {
                hql = hql + "  t.type = '" + sysAmbulInfo.getClid() + "' and ";
            }
            if (null != sysAmbulInfo.getName() && sysAmbulInfo.getName().length() > 0) {
                hql = hql + "  t.name like '%" + sysAmbulInfo.getName() + "%' and ";
            }
        }
        hql = hql + " 1 = 1 order by clid asc ";
        return hql;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysAmbulInfo> findSysAmbulInfo(String hql) {
        List<SysAmbulInfo> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

}
