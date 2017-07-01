package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrCharges;

public interface MisEmrChargesService extends ABaseService {

    public List<MisEmrCharges> findMisEmrChargesListByEmrId(String emrId);


}
