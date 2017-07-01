package com.zxit.service;

import java.util.List;

import com.zxit.model.VMisEmrAmbul;

public interface VMisEmrAmbulService {

    public List<VMisEmrAmbul> findVMisEmrAmbulPager(String hql, int startNum, int pageTotal);

    public List<VMisEmrAmbul> findVMisEmrAmbulList(VMisEmrAmbul vMisEmrAmbul);

    public int findCount(String hql);

    public String createHQL(VMisEmrAmbul vMisEmrAmbul);

    public VMisEmrAmbul findVMisEmrAmbulById(String id);

}
