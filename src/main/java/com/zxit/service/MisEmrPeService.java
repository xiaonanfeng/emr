package com.zxit.service;

import com.zxit.model.MisEmrPe;

public interface MisEmrPeService {

    public void saveMisEmrPe(MisEmrPe misEmrPe);

    public void delMisEmrPeById(String id);

    public MisEmrPe findMisEmrPeById(String id);

    public String getEyeString(String emrId);
}
