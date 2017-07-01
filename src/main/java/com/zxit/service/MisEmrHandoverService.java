package com.zxit.service;

import com.zxit.model.MisEmrHandover;

public interface MisEmrHandoverService {

    public void saveMisEmrHandover(MisEmrHandover misEmrHandover);

    public void delMisEmrHandoverById(String id);

    public MisEmrHandover findMisEmrHandoverById(String id);

}
