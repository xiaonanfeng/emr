package com.zxit.service;

import java.util.List;

import com.zxit.model.TObject;
import com.zxit.model.VMisEmrOutdStaff;

public interface VMisEmrOutdStaffService extends ABaseService {

    public List<VMisEmrOutdStaff> findVMisEmrOutdStaffByEmrId(String emrId);

    public String createColleSelect(TObject t, List<VMisEmrOutdStaff> list);

    /**
     * 默认值为随车司机
     *
     * @param emrId
     * @return
     */
    public String findAutoColler(String emrId);

}
