package com.zxit.service;

import com.zxit.model.MisEmrSeGyn;

public interface MisEmrSeGynService {

    public void saveMisEmrSeGyn(MisEmrSeGyn misEmrSeGyn);

    public void delMisEmrSeGynById(String id);

    public MisEmrSeGyn findMisEmrSeGynById(String id);

}
