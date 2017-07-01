package com.zxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrSeGyn;
import com.zxit.service.MisEmrSeGynService;

@Service("misEmrSeGynService")
public class MisEmrSeGynServiceImpl implements MisEmrSeGynService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public void saveMisEmrSeGyn(MisEmrSeGyn misEmrSeGyn) {
        aBaseDao.saveOrUpdate(misEmrSeGyn);
    }

    @Override
    public void delMisEmrSeGynById(String id) {
        aBaseDao.deleteById(MisEmrSeGyn.class, id);
    }

    @Override
    public MisEmrSeGyn findMisEmrSeGynById(String id) {
        MisEmrSeGyn misEmrSeGyn = aBaseDao.findById(MisEmrSeGyn.class, id);
        return misEmrSeGyn;
    }

}
