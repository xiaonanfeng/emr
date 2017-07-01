package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrMar;
import com.zxit.model.VMisEmrMarMedicine;

public interface MisEmrMarService {

    /**
     * 全部用药情况
     *
     * @param emrId
     * @return
     */
    public List<VMisEmrMarMedicine> findMisEmrMar(VMisEmrMarMedicine vMisEmrMarMedicine);

    public MisEmrMar findMisEmrMarById(Integer id);

    public void delMieEmrMarByEmrId(String id);

    public void saveMisEmrMarList(List<MisEmrMar> list);

    public void saveMisEmrMar(MisEmrMar misEmrMar);

    public void delMisEmrMarById(Integer id);

    /**
     * 找到一个病历中用药的当前最大批次
     *
     * @param parameter
     * @return
     */
    public int findMaxGrpInOneEmr(String emrid);
}
