package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrCmplt;
import com.zxit.model.MisEmrCmpltTemplate;
import com.zxit.service.MisEmrCmpltService;

@SuppressWarnings("unchecked")
@Service("misEmrCmpltService")
public class MisEmrCmpltServiceImpl implements MisEmrCmpltService {

    @Resource
    private ABaseDao aBaseDao;


    @Override
    public List<MisEmrCmplt> findMisEmrCmplt(Integer id) {
        //ID查询
        if (id == null) {
            id = findMinIdFromMisEmrCmpltTempate();
        }
        String hql = "from MisEmrCmplt t where t.misEmrCmpltTemplate.id = '" + id + "' ";
        List<MisEmrCmplt> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

    @Override
    public Integer findMinIdFromMisEmrCmpltTempate() {
        Integer id = 0;
        String hql = "select min(id) from MisEmrCmpltTemplate t where t.tmplType = '0'";
        id = (Integer) aBaseDao.findByHQL(hql).uniqueResult();
        return id;
    }

    @Override
    public List<MisEmrCmpltTemplate> findMisEmrCmpltTemplateByHql(MisEmrCmpltTemplate misEmrCmpltTemplate) {
        String hql = " from MisEmrCmpltTemplate t where 1 = 1";
        if (misEmrCmpltTemplate.getName() != "" && misEmrCmpltTemplate.getName() != null) {
            hql = hql + " and t.name like '%" + misEmrCmpltTemplate.getName() + "%' ";
        }
        if (misEmrCmpltTemplate.getTmplType() != null) {
            hql = hql + " and t.tmplType = '" + misEmrCmpltTemplate.getTmplType() + "' ";
        }
        List<MisEmrCmpltTemplate> list = aBaseDao.findByHQL(hql).list();
        return list;
    }


}
