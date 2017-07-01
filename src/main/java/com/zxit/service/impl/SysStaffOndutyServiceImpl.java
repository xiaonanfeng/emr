package com.zxit.service.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.SysStaffOnduty;
import com.zxit.service.SysStaffOndutyService;

@Service("sysStaffOndutyService")
public class SysStaffOndutyServiceImpl implements SysStaffOndutyService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public SysStaffOnduty findSysStaffOndutyByUnqIndex(String gh, Integer flag) {
        //String hql = " from SysStaffOnduty t where t.gh = '"+gh+"' and flag = 0";
        String hql = " from SysStaffOnduty t where t.id = (select max(id) as id from SysStaffOnduty where gh = '" + gh + "' and flag = 0)";
        Query query = aBaseDao.findByHQL(hql);
        //TODO 重复数据的校验问题（熊超）
        SysStaffOnduty sysStaffOnduty = (SysStaffOnduty) query.uniqueResult();
        return sysStaffOnduty;
    }

}
