package com.zxit.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrAe;
import com.zxit.service.MisEmrAeService;

@Service("misEmrAeService")
public class MisEmrAeServiceImpl implements MisEmrAeService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public void saveMisEmrAe(MisEmrAe misEmrAe) {
        aBaseDao.saveOrUpdate(misEmrAe);
    }

    @Override
    public void delMisEmrAeById(String id) {
        aBaseDao.deleteById(MisEmrAe.class, id);
    }

    @Override
    public MisEmrAe findMisEmrAeById(String id) {
        MisEmrAe misEmrAe = aBaseDao.findById(MisEmrAe.class, id);
        return misEmrAe;
    }

}
