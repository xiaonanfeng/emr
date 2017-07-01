package com.zxit.service;

import java.util.List;


import com.zxit.model.MisEmrModifyRecord;

public interface MisEmrModifyRecordService {

    public void saveMisEmrModifyRecord(List<MisEmrModifyRecord> list);

    public List<MisEmrModifyRecord> findMisEmrModifyRecordByEmrId(String emrId);

    public MisEmrModifyRecord findMisEmrModifyRecordById(String id);

    public void delMisEmrModifyRecordById(String id);


}
