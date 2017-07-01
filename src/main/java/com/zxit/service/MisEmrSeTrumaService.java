package com.zxit.service;

import com.zxit.model.MisEmrSeTruma;

public interface MisEmrSeTrumaService {
    public void saveMisEmrSeTruma(MisEmrSeTruma misEmrSeTruma);

    public void delMisEmrSeTrumaById(String id);

    public MisEmrSeTruma findMisEmrSeTrumaById(String id);
}
