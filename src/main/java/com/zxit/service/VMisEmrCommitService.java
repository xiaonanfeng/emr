package com.zxit.service;

import java.util.List;

import com.zxit.model.VMisEmrCommit;

public interface VMisEmrCommitService {

    public void commitEmr(String emrId);

    public List<VMisEmrCommit> findEmr2Commit(Integer commitTimeScope);

}
