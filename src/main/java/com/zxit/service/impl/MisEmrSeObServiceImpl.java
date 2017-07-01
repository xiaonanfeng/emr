package com.zxit.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrSeOb;
import com.zxit.service.MisEmrSeObService;

@Service("misEmrSeObService")
public class MisEmrSeObServiceImpl implements MisEmrSeObService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public void saveMisEmrSeOb(MisEmrSeOb misEmrSeOb) {
        aBaseDao.saveOrUpdate(misEmrSeOb);
    }

    @Override
    public void delMisEmrSeObById(String id) {
        aBaseDao.deleteById(MisEmrSeOb.class, id);
    }

    @Override
    public MisEmrSeOb findMisEmrSeObById(String id) {
        MisEmrSeOb misEmrSeOb = aBaseDao.findById(MisEmrSeOb.class, id);
        return misEmrSeOb;
    }


}
