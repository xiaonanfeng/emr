package com.zxit.service.impl;

import com.zxit.model.MisEmrPreaidStat;
import com.zxit.service.MisEmrPreaidStatService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2017/06/29 20:53
 * by nanxiaofeng
 */
@Service("misEmrPreaidStatService")
public class MisEmrPreaidStatServiceImpl extends ABaseServiceImpl implements MisEmrPreaidStatService {


    @Override
    public void deleteByEmrId(String emrId) {
        List<MisEmrPreaidStat> list = findByEmrId(emrId);
        this.delete(list.toArray());
    }

    @Override
    public List<MisEmrPreaidStat> findByEmrId(String emrId) {
        String hql = " from MisEmrPreaidStat t where t.emrId = '"+emrId+"'";
        List<MisEmrPreaidStat> list = this.findByHQL(hql).list();
        return list;
    }

}


