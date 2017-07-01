package com.zxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.VMisEmrHandover;
import com.zxit.service.VMisEmrHandoverService;

@Service("vMisEmrHandoverService")
public class VMisEmrHandoverServiceImpl implements VMisEmrHandoverService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public VMisEmrHandover findVMisEmrHandover(String id) {
        VMisEmrHandover vMisEmrHandover = aBaseDao.findById(VMisEmrHandover.class, id);
        return vMisEmrHandover;
    }

}
