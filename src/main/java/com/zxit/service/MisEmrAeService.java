package com.zxit.service;

import com.zxit.model.MisEmrAe;

public interface MisEmrAeService {

    public void saveMisEmrAe(MisEmrAe misEmrAe);

    public void delMisEmrAeById(String id);

    public MisEmrAe findMisEmrAeById(String id);

}
