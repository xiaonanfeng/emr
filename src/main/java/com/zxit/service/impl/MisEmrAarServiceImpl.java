package com.zxit.service.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import com.zxit.model.VMisEmrAar;
import com.zxit.service.MisEmrAarService;

@Service("MisEmrAarService")
public class MisEmrAarServiceImpl extends ABaseServiceImpl implements
        MisEmrAarService {


    @SuppressWarnings("unchecked")
    @Override
    public List<VMisEmrAar> findmisEmrAarInUse(String emrId) {
        List<VMisEmrAar> list = this.findByHQL(" from VMisEmrAar t where t.emrId = '" + emrId + "' order by t.grp").list();
        return list;
    }

    @Override
    public Integer findMaxGrpInOneAar(String emrid) {
        String sql = "select max(grp) from MIS_EMR_AAR t where t.emr_id = '" + emrid + "' ";
        SQLQuery sqlQuery = this.findBySQL(sql);
        Number max = (Number) sqlQuery.uniqueResult();
        if (max == null) {
            return 0;
        } else {
            return max.intValue();
        }
    }

}
