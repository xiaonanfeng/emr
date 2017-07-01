package com.zxit.service;

import com.zxit.model.MisEmrPreaidVs;

public interface MisEmrPreaidVsService {

    public void saveMisEmrPreaidVs(MisEmrPreaidVs misEmrPreaidVs);

    public void delMisEmrPreaidVsById(String id);

    public MisEmrPreaidVs findMisEmrPreaidVsById(String id);

}
