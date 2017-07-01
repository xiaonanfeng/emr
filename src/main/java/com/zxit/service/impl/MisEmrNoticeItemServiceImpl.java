package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrNotice;
import com.zxit.model.MisEmrNoticeItem;
import com.zxit.service.MisEmrNoticeService;

@Service("misEmrNoticeService")
public class MisEmrNoticeItemServiceImpl implements MisEmrNoticeService {

    @Resource
    private ABaseDao aBaseDao;

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrNoticeItem> findMisEmrNoticeItem(String xzmb) {
        List<MisEmrNoticeItem> list = aBaseDao.findByHQL(" from MisEmrNoticeItem  where xzbm = " + xzmb + " order by sortId").list();
        return list;
    }

    @Override
    public void saveMisEmrNotice(MisEmrNotice misEmrNotice) {
        aBaseDao.saveOrUpdate(misEmrNotice);

    }

    @Override
    public MisEmrNotice findMisEmrNoticeById(String id) {
        MisEmrNotice misEmrNotice = aBaseDao.findById(MisEmrNotice.class, id);
        return misEmrNotice;
    }

    @Override
    public void delMisEmrNoticeById(String id) {
        aBaseDao.deleteById(MisEmrNotice.class, id);
    }

}
