package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrIcd10;
import com.zxit.model.TObject;

/**
 * ICD10
 *
 * @author Administrator
 */
public interface MisEmrIcd10Service {

    public MisEmrIcd10 findMisEmrIcd10ById(Integer id);

    public MisEmrIcd10 findMisEmrIcd10ByCode(String dCode);

    public String createHQL(MisEmrIcd10 misEmrIcd10);

    public int findCount(String hql);

    public List<MisEmrIcd10> findMisEmrIcd10ByHql(String hql);

    public List<MisEmrIcd10> findMisEmrIcd10ByHql(String hql, int startPos, int dataPerPage);

    public String createSelect(TObject t, List<MisEmrIcd10> list);


}
