package com.zxit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Service;


import com.zxit.dao.ABaseDao;
import com.zxit.model.SysCode;
import com.zxit.service.SysCodeService;

@Service("sysCodeService")
public class SysCodeServiceImpl implements SysCodeService {

    @Resource
    private ABaseDao aBaseDao;

    private Logger log = Logger.getLogger(SysCodeServiceImpl.class);

    @Override
    public SysCode findSysCodeById(Integer id) {
        SysCode sysCode = aBaseDao.findById(SysCode.class, id);
        return sysCode;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysCode> findSysCode(SysCode sysCode) {
        String hql = "from SysCode t where 1 = 1 ";
        if (sysCode.getSysCodeType().getTypeid() != null) {
            hql = hql + " and typeid = '" + sysCode.getSysCodeType().getTypeid() + "' ";
        }
        hql = hql + " order by t.sortId asc ";

        List<SysCode> list = aBaseDao.findByHQL(hql).list();
        return list;
    }


    @Override
    public SysCode findSysCodeByIdAndPid(Integer code, Integer pid) {
        SysCode sysCode = new SysCode();
        String hql = " from SysCode where ";
        try {
            sysCode.setName("");
            Query query = null;
            if (code != null && pid != null) {
                hql = hql + "  code = '" + code + "' and typeid = '" + pid + "'  ";
                query = aBaseDao.findByHQL(hql);
            }
            if (query != null) {
                sysCode = (SysCode) query.uniqueResult();
            }
        } catch (Exception e) {
            if (pid >= 255 && pid <= 260) {
                System.out.println(hql);
            }
            log.error(new Date() + this.getClass().getName() + ">>>>>>:pid=" + pid + "&code=" + code);
        }
        return sysCode;
    }

    @Override
    public String findSysCodeNameByIdAndPid(Integer code, Integer pid) {
        SysCode sysCode = findSysCodeByIdAndPid(code, pid);
        try {
            if (sysCode != null) {
                return sysCode.getName();
            } else {
                return "";
            }
        } catch (Exception e) {
            System.out.println("code=" + code + "pid=" + pid);
        }
        return "";
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<SysCode> findSysCodeByPid(Integer pid) {
        List<SysCode> list = aBaseDao.findByHQL(" from SysCode where  typeid = '" + pid + "' order by sortId asc ").list();
        return list;
    }


}
