package com.zxit.service;

import java.util.List;

import com.zxit.model.VMisEmrAar;

public interface MisEmrAarService extends ABaseService {

    public List<VMisEmrAar> findmisEmrAarInUse(String emrId);

    public Integer findMaxGrpInOneAar(String emrid);

}
