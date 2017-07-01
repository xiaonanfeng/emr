package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.VMisEmrCommit;
import com.zxit.service.VMisEmrCommitService;

@Service("vMisEmrCommitService")
public class VMisEmrCommitServiceImpl implements VMisEmrCommitService {

    @Resource
    private ABaseDao aBaseDao;

    @SuppressWarnings("unchecked")
    @Override
    public List<VMisEmrCommit> findEmr2Commit(Integer commitTimeScope) {
        String hql = " from VMisEmrCommit t where t.isCommitted =0 and  t.committimescope >= " + commitTimeScope + " ";
        List<VMisEmrCommit> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

    //TODO WARNNING需求违反开发原则
    @Override
    public void commitEmr(String emrId) {
        String sql = "update MIS_EMR_BASICINFO t set t.IS_COMMITTED = 1 where t.id = '" + emrId + "' ";
        SQLQuery sqlQuery = aBaseDao.findBySQL(sql);
        System.out.println("自动提交" + sql);
        sqlQuery.executeUpdate();
    }


}
