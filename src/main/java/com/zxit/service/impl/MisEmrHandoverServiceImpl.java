package com.zxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrHandover;
import com.zxit.service.MisEmrHandoverService;
import com.zxit.service.VMisEmrHandoverService;

@Service("misEmrHandoverService")
public class MisEmrHandoverServiceImpl implements MisEmrHandoverService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private VMisEmrHandoverService vMisEmrHandoverService;

    @Override
    public void saveMisEmrHandover(MisEmrHandover misEmrHandover) {
        aBaseDao.saveOrUpdate(misEmrHandover);
    }

    @Override
    public void delMisEmrHandoverById(String id) {
        aBaseDao.deleteById(MisEmrHandover.class, id);
    }

    @Override
    public MisEmrHandover findMisEmrHandoverById(String id) {
        MisEmrHandover misEmrHandover = aBaseDao.findById(MisEmrHandover.class, id);//返回值
        return misEmrHandover;
    }


}
