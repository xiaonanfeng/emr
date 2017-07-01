package com.zxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrSePed;
import com.zxit.service.MisEmrSePedService;

@Service("misEmrSePedService")
public class MisEmrSePedServiceImpl implements MisEmrSePedService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public void saveMisEmrSePed(MisEmrSePed misEmrSePed) {
        misEmrSePed.setApgar1(
                (misEmrSePed.getApgarAc1() == null ? 0 : misEmrSePed.getApgarAc1())
                        + (misEmrSePed.getApgarAp1() == null ? 0 : misEmrSePed.getApgarAp1())
                        + (misEmrSePed.getApgarG1() == null ? 0 : misEmrSePed.getApgarG1())
                        + (misEmrSePed.getApgarP1() == null ? 0 : misEmrSePed.getApgarP1())
                        + (misEmrSePed.getApgarR1() == null ? 0 : misEmrSePed.getApgarR1())
        );
        misEmrSePed.setApgar5(
                (misEmrSePed.getApgarAc5() == null ? 0 : misEmrSePed.getApgarAc5())
                        + (misEmrSePed.getApgarAp5() == null ? 0 : misEmrSePed.getApgarAp5())
                        + (misEmrSePed.getApgarG5() == null ? 0 : misEmrSePed.getApgarG5())
                        + (misEmrSePed.getApgarP5() == null ? 0 : misEmrSePed.getApgarP5())
                        + (misEmrSePed.getApgarR5() == null ? 0 : misEmrSePed.getApgarR5())
        );
        misEmrSePed.setApgar10(
                (misEmrSePed.getApgarAc10() == null ? 0 : misEmrSePed.getApgarAc10())
                        + (misEmrSePed.getApgarAp10() == null ? 0 : misEmrSePed.getApgarAp10())
                        + (misEmrSePed.getApgarG10() == null ? 0 : misEmrSePed.getApgarG10())
                        + (misEmrSePed.getApgarP10() == null ? 0 : misEmrSePed.getApgarP10())
                        + (misEmrSePed.getApgarR10() == null ? 0 : misEmrSePed.getApgarR10())
        );
        misEmrSePed.setApgar15(
                (misEmrSePed.getApgarAc15() == null ? 0 : misEmrSePed.getApgarAc15())
                        + (misEmrSePed.getApgarAp15() == null ? 0 : misEmrSePed.getApgarAp15())
                        + (misEmrSePed.getApgarG15() == null ? 0 : misEmrSePed.getApgarG15())
                        + (misEmrSePed.getApgarP15() == null ? 0 : misEmrSePed.getApgarP15())
                        + (misEmrSePed.getApgarR15() == null ? 0 : misEmrSePed.getApgarR15())
        );
        aBaseDao.saveOrUpdate(misEmrSePed);
    }

    @Override
    public void delMisEmrSePedById(String id) {
        aBaseDao.deleteById(MisEmrSePed.class, id);
    }

    @Override
    public MisEmrSePed findMisEmrSePedById(String id) {
        MisEmrSePed misEmrSePed = aBaseDao.findById(MisEmrSePed.class, id);
        return misEmrSePed;
    }

}
