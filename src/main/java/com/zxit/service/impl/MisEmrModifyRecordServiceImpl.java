package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrModifyRecord;
import com.zxit.service.MisEmrModifyRecordService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.share.CreaterPK;

@Service("misEmrModifyRecordService")
public class MisEmrModifyRecordServiceImpl implements MisEmrModifyRecordService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SysMemberInfoService sysMemberInfoService;

    @Override
    public void saveMisEmrModifyRecord(List<MisEmrModifyRecord> list) {
        aBaseDao.save(list.toArray());
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrModifyRecord> findMisEmrModifyRecordByEmrId(String emrId) {
        String hql = " from MisEmrModifyRecord t where t.emrId = '" + emrId + "' order by t.modifyTime desc";
        List<MisEmrModifyRecord> list = aBaseDao.findByHQL(hql).list();
        try {
            for (MisEmrModifyRecord d : list) {
                d.setModifyUserid(sysMemberInfoService.findSysMemberInfoById(d.getModifyUserid()).getName());
                d.setModifyContent(CreaterPK.forCn(aBaseDao, d.getModifyTable().toUpperCase(), d.getModifyContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MisEmrModifyRecord findMisEmrModifyRecordById(String id) {
        return aBaseDao.findById(MisEmrModifyRecord.class, id);
    }

    @Override
    public void delMisEmrModifyRecordById(String id) {
        List<MisEmrModifyRecord> list = this.findMisEmrModifyRecordByEmrId(id);
        aBaseDao.delete(list.toArray());

    }

}
