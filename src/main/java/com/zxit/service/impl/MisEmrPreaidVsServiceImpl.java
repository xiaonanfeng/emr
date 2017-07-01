package com.zxit.service.impl;

import com.alibaba.fastjson.JSON;
import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrPreaidStat;
import com.zxit.model.MisEmrPreaidVs;
import com.zxit.service.MisEmrPreaidStatService;
import com.zxit.service.MisEmrPreaidVsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("misEmrPreaidVsService")
public class MisEmrPreaidVsServiceImpl implements MisEmrPreaidVsService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private MisEmrPreaidStatService misEmrPreaidStatService;

    @Override
    public void saveMisEmrPreaidVs(MisEmrPreaidVs misEmrPreaidVs) {
        aBaseDao.saveOrUpdate(misEmrPreaidVs);
    }

    @Override
    public void delMisEmrPreaidVsById(String id) {
        aBaseDao.deleteById(MisEmrPreaidVs.class, id);
    }

    @Override
    public MisEmrPreaidVs findMisEmrPreaidVsById(String id) {
        MisEmrPreaidVs misEmrPreaidVs = aBaseDao.findById(MisEmrPreaidVs.class, id);
        List<MisEmrPreaidStat> list = misEmrPreaidStatService.findByEmrId(id);
        misEmrPreaidVs.setPreaidVsStat(JSON.toJSONString(list));
        return misEmrPreaidVs;
    }

}
