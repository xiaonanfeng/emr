package com.zxit.service;

import com.zxit.model.MisEmrPreaidStat;

import java.util.List;

/**
 * 2017/06/29 20:53
 * by nanxiaofeng
 */
public interface MisEmrPreaidStatService extends ABaseService {


    void deleteByEmrId(String emrId);

    List<MisEmrPreaidStat> findByEmrId(String id);
}




