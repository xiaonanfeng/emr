package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrNotice;
import com.zxit.model.MisEmrNoticeItem;

public interface MisEmrNoticeService {

    public List<MisEmrNoticeItem> findMisEmrNoticeItem(String xzbm);

    public void saveMisEmrNotice(MisEmrNotice misEmrNotice);

    public MisEmrNotice findMisEmrNoticeById(String id);

    public void delMisEmrNoticeById(String id);

}
