package com.zxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrSeTruma;
import com.zxit.service.MisEmrSeTrumaService;

@Service("misEmrSeTrumaService")
public class MisEmrSeTrumaServiceImpl implements MisEmrSeTrumaService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public void saveMisEmrSeTruma(MisEmrSeTruma misEmrSeTruma) {

        misEmrSeTruma.setPhiTotal(
                (misEmrSeTruma.getPhiBr() == null ? 0 : misEmrSeTruma.getPhiBr())
                        + (misEmrSeTruma.getPhiCons() == null ? 0 : misEmrSeTruma.getPhiCons())
                        + (misEmrSeTruma.getPhiSbp() == null ? 0 : misEmrSeTruma.getPhiSbp())
                        + (misEmrSeTruma.getPhiPr() == null ? 0 : misEmrSeTruma.getPhiPr())
        );


        misEmrSeTruma.setDglsTotal(
                (misEmrSeTruma.getDglsEr() == null ? 0 : misEmrSeTruma.getDglsEr())
                        + (misEmrSeTruma.getDglsMr() == null ? 0 : misEmrSeTruma.getDglsMr())
                        + (misEmrSeTruma.getDglsVr() == null ? 0 : misEmrSeTruma.getDglsVr())
        );


        aBaseDao.saveOrUpdate(misEmrSeTruma);
    }

    @Override
    public void delMisEmrSeTrumaById(String id) {
        aBaseDao.deleteById(MisEmrSeTruma.class, id);
    }

    @Override
    public MisEmrSeTruma findMisEmrSeTrumaById(String id) {
        MisEmrSeTruma misEmrSeTruma = aBaseDao.findById(MisEmrSeTruma.class, id);
        return misEmrSeTruma;
    }

}
