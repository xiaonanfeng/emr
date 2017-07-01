package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrCmplt;
import com.zxit.model.MisEmrCmpltTemplate;

public interface MisEmrCmpltService {

    /**
     * 查询病历模板
     *
     * @return
     */
    public List<MisEmrCmplt> findMisEmrCmplt(Integer id);

    /**
     * 找到最小的公用病历模板
     *
     * @return
     */
    public Integer findMinIdFromMisEmrCmpltTempate();

    /**
     * 查询病历模板
     *
     * @param misEmrCmpltTemplate
     * @return
     */
    public List<MisEmrCmpltTemplate> findMisEmrCmpltTemplateByHql(MisEmrCmpltTemplate misEmrCmpltTemplate);

}
