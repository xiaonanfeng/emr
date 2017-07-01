package com.zxit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrReview;
import com.zxit.service.MisEmrReviewService;


@Service("misEmrReviewService")
public class MisEmrReviewServiceImpl implements MisEmrReviewService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public void saveMisEmrReview(MisEmrReview misEmrReview) {
        if (null == misEmrReview.getRevTime()) {
            misEmrReview.setRevTime(new Date());
        }
        aBaseDao.saveOrUpdate(misEmrReview);

    }

    @Override
    public String createHQL(MisEmrReview misEmrReview) {
        String hql = " from MisEmrReview where ";


        hql = hql + " 1 = 1 order by id desc";
        return hql;
    }

    @Override
    public List<MisEmrReview> findMisEmrReviewByHql(String hql, int startPos,
                                                    int dataPerPage) {
        List<MisEmrReview> list = aBaseDao.findWithPager(MisEmrReview.class, hql, startPos, dataPerPage);
        return list;
    }

    @Override
    public MisEmrReview findMisEmrReviewById(String id) {
        MisEmrReview misEmrReview = aBaseDao.findById(MisEmrReview.class, id);
        return misEmrReview;
    }

    @Override
    public void delMisEmrReviewById(String id) {

    }

    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }

}
