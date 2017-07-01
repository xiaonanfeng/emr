package com.zxit.service;

import com.zxit.model.MisEmrSeOb;

public interface MisEmrSeObService {

    public void saveMisEmrSeOb(MisEmrSeOb misEmrSeOb);

    public void delMisEmrSeObById(String id);

    public MisEmrSeOb findMisEmrSeObById(String id);

}
