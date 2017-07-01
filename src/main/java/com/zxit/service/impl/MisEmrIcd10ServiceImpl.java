package com.zxit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrIcd10;
import com.zxit.model.TObject;
import com.zxit.service.MisEmrIcd10Service;
import com.zxit.service.SysSelectMultiService;

@Service("misEmrIcd10Service")
public class MisEmrIcd10ServiceImpl implements MisEmrIcd10Service {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SysSelectMultiService sysSelectMultiService;

    private Logger log = Logger.getLogger("com.zxit.service.impl.MisEmrIcd10ServiceImpl");

    @Override
    public MisEmrIcd10 findMisEmrIcd10ById(Integer id) {
        MisEmrIcd10 misEmrIcd10 = new MisEmrIcd10();
        misEmrIcd10.setDiseaseName("");
        try {
            if (id != null) {
                misEmrIcd10 = aBaseDao.findById(MisEmrIcd10.class, id);
            }
        } catch (Exception e) {
            log.debug(new Date() + this.getClass().getName() + ">>>>>>:" + id);
            e.printStackTrace();
        }
        return misEmrIcd10;
    }

    @Override
    public MisEmrIcd10 findMisEmrIcd10ByCode(String dCode) {
        String hql = " from MisEmrIcd10 t where t.diseaseCode = '" + dCode + "' ";
        return (MisEmrIcd10) aBaseDao.findByHQL(hql).uniqueResult();
    }

    @Override
    public String createHQL(MisEmrIcd10 misEmrIcd10) {
        String hql = " from MisEmrIcd10 t where  ";
        if (misEmrIcd10.getInputCode1() != null && !"".equals(misEmrIcd10.getInputCode1())) {
            hql = hql + " t.inputCode1 like '%" + misEmrIcd10.getInputCode1() + "%' "
                    + "or t.inputCode1 like '%" + misEmrIcd10.getInputCode1().toUpperCase() + "%' ";
        } else {
            hql = hql + "  1 = 1";
        }
        return hql;
    }

    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }

    @Override
    public List<MisEmrIcd10> findMisEmrIcd10ByHql(String hql, int startPos, int dataPerPage) {
        List<MisEmrIcd10> list = aBaseDao.findWithPager(MisEmrIcd10.class, hql, startPos, dataPerPage);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrIcd10> findMisEmrIcd10ByHql(String hql) {
        List<MisEmrIcd10> list = aBaseDao.findByHQL(hql).setMaxResults(1500).list();
        return list;
    }

    @Override
    public String createSelect(TObject t, List<MisEmrIcd10> list) {
        String select = sysSelectMultiService.createMultiSelect(t, list);
        return select;
    }

}
