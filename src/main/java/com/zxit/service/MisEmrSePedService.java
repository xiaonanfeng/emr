package com.zxit.service;

import com.zxit.model.MisEmrSePed;

public interface MisEmrSePedService {

    public void saveMisEmrSePed(MisEmrSePed misEmrSePed);

    public void delMisEmrSePedById(String id);

    public MisEmrSePed findMisEmrSePedById(String id);

}
