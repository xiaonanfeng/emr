package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrReview;


public interface MisEmrReviewService {

    public void saveMisEmrReview(MisEmrReview misEmrReview);

    public String createHQL(MisEmrReview misEmrReview);

    public List<MisEmrReview> findMisEmrReviewByHql(String hql, int startPos, int dataPerPage);

    public MisEmrReview findMisEmrReviewById(String id);

    public void delMisEmrReviewById(String id);

    public int findCount(String hql);

}
