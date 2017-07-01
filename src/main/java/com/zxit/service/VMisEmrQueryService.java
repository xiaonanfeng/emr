package com.zxit.service;

import java.util.List;

import com.zxit.model.VMisEmrQuery;

public interface VMisEmrQueryService {

    public List<VMisEmrQuery> findVMisEmrQueryPager(String hql, int startNum, int pageTotal);

    public List<VMisEmrQuery> findVMisEmrQueryList(VMisEmrQuery vMisEmrQuery);

    public int findCount(String hql);

    public String createHQL(VMisEmrQuery VMisEmrQuery);

    public VMisEmrQuery findVMisEmrQueryById(String id);

    public String findOrgIdsFromSqlsuffix(String memberId, String orgId);

    public String findLshByEmrId(String emrId);

    public Integer findCcxhByEmrId(String emrId);

}
