package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrBasicinfo;

public interface MisEmrBasicinfoService {

    public void saveMisEmrBasicinfo(MisEmrBasicinfo misEmrBasicinfo);

    public String createHQL(MisEmrBasicinfo misEmrBasicinfo);

    public List<MisEmrBasicinfo> findMisEmrBasicinfoByHql(String hql, int startPos, int dataPerPage);

    public List<MisEmrBasicinfo> findMisEmrBasicinfoByLshAndCcxh(String lsh, Integer ccxh);

    public MisEmrBasicinfo findMisEmrBasicinfoById(String id);

    public void delMisEmrBasicinfoById(String id);

    public int findCount(String hql);

    public void commitMisEmrBasicinfo(MisEmrBasicinfo misEmrBasicinfo);


}
