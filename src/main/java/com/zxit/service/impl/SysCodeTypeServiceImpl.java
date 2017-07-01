package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.zxit.dao.ABaseDao;
import com.zxit.model.SysCodeType;
import com.zxit.service.SysCodeTypeService;

@Service("sysCodeTypeService")
public class SysCodeTypeServiceImpl implements SysCodeTypeService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public int findSysCodeTypeByName(String name) {
        String hql = "from SysCodeType where Name =  '" + name + "' ";
        SysCodeType sysCodeType = (SysCodeType) aBaseDao.findByHQL(hql).uniqueResult();
        return sysCodeType.getTypeid();
    }

    @Override
    public SysCodeType findSysCodeTypeById(Integer id) {
        SysCodeType sysCodeType = aBaseDao.findById(SysCodeType.class, id);
        return sysCodeType;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysCodeType> findSysCodeType(SysCodeType sysCodeType) {
        String hql = "from SysCodeType t where 1 = 1  ";
        if (sysCodeType.getTypeid() != null) {
            hql = hql + " and typeid = '" + sysCodeType.getTypeid() + "' or parentTypeid = '" + sysCodeType.getTypeid() + "' ";
        }
        hql = hql + " order by typeId asc";
        List<SysCodeType> list = aBaseDao.findByHQL(hql).list();
        return list;
    }


}
