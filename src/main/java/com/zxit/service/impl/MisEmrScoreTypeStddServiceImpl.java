package com.zxit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrMdfreq;
import com.zxit.model.MisEmrScoreConfig;
import com.zxit.model.MisEmrScoreRecord;
import com.zxit.model.MisEmrScoreTotal;
import com.zxit.model.VMisEmrScoreType;
import com.zxit.model.VMisEmrScoreTypeStdd;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrMdfreqService;
import com.zxit.service.MisEmrScoreTypeStddService;

@SuppressWarnings("unchecked")
@Service("misEmrScoreTypeStddService")
public class MisEmrScoreTypeStddServiceImpl extends ABaseServiceImpl implements MisEmrScoreTypeStddService {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrMdfreqService misEmrMdfreqService;


    @Override
    public List<VMisEmrScoreTypeStdd> findVMisEmrScoreTypeStddByFlag() {
        String hql = " from VMisEmrScoreTypeStdd t where t.flag = '0' order by t.id";
        List<VMisEmrScoreTypeStdd> list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public List<VMisEmrScoreType> findVMisEmrScoreTypeByFlag() {
        String hql = " from VMisEmrScoreType t where t.flag = '0' order by t.typeid";
        List<VMisEmrScoreType> list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public List<VMisEmrScoreTypeStdd> findVMisEmrScoreTypeStddByTypeid(Integer typeid) {
        String hql = " from VMisEmrScoreTypeStdd t where t.flag = '0' and t.typeid= '" + typeid + "' order by t.id";
        List<VMisEmrScoreTypeStdd> list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public String findMisEmrQuality(Double total) {
        List<MisEmrScoreConfig> list = this.findAll(MisEmrScoreConfig.class);
        for (MisEmrScoreConfig d : list) {
            if (total >= d.getStartvalue() && total <= d.getEndvalue()) {
                return d.getScorename();
            }
        }
        return "病历评定错误";
    }

    @Override
    public void saveOrUpdateMisEmrScoreTotal(MisEmrScoreTotal misEmrScoreTotal) {
        //报表扣分信息
        String hql = "from MisEmrScoreTotal t where t.emrId = '" + misEmrScoreTotal.getEmrId() + "' and t.scoreLevel = '" + misEmrScoreTotal.getScoreLevel() + "' ";
        Query query = this.findByHQL(hql);
        MisEmrScoreTotal misEmrScoreTotal_temp = (MisEmrScoreTotal) query.uniqueResult();
        if (misEmrScoreTotal_temp == null) {//如果是空则保存新对象
            this.saveOrUpdate(misEmrScoreTotal);
        } else {//如果不是空则更新现有对象
            misEmrScoreTotal_temp.setEmrId(misEmrScoreTotal.getEmrId());
            misEmrScoreTotal_temp.setScoreLevel(misEmrScoreTotal.getScoreLevel());
            misEmrScoreTotal_temp.setTotalScore(misEmrScoreTotal.getTotalScore());
            misEmrScoreTotal_temp.setCreateUserid(misEmrScoreTotal.getCreateUserid());
            misEmrScoreTotal_temp.setXzbm(misEmrScoreTotal.getXzbm());
            misEmrScoreTotal_temp.setCreateTime(misEmrScoreTotal.getCreateTime());
            misEmrScoreTotal_temp.setLastModifyTime(misEmrScoreTotal.getLastModifyTime());
            this.saveOrUpdate(misEmrScoreTotal_temp);
        }

    }

    @Override
    public void saveOrUpdateMisEmrScoreRecord(MisEmrScoreRecord misEmrScoreRecord) {
        //报表扣分信息
        String hql = "from MisEmrScoreRecord t where t.emrId = '" + misEmrScoreRecord.getEmrId() + "' and t.scoreLevel = '" + misEmrScoreRecord.getScoreLevel() + "' and t.itemid = '" + misEmrScoreRecord.getItemid() + "'";
        Query query = this.findByHQL(hql);
        MisEmrScoreRecord misEmrScoreRecord_temp = (MisEmrScoreRecord) query.uniqueResult();
        if (misEmrScoreRecord_temp == null) {//如果是空则保存新对象
            this.saveOrUpdate(misEmrScoreRecord);
        } else {//如果不是空则更新现有对象
            misEmrScoreRecord_temp.setEmrId(misEmrScoreRecord.getEmrId());
            misEmrScoreRecord_temp.setScoreLevel(misEmrScoreRecord.getScoreLevel());
            misEmrScoreRecord_temp.setItemid(misEmrScoreRecord.getItemid());
            misEmrScoreRecord_temp.setTime(1);
            misEmrScoreRecord_temp.setScore(misEmrScoreRecord.getScore());
            misEmrScoreRecord_temp.setCreateTime(new Date());
            misEmrScoreRecord_temp.setRemark(misEmrScoreRecord.getRemark());
            this.saveOrUpdate(misEmrScoreRecord_temp);
        }
    }

    public List<MisEmrScoreTotal> findMisEmrScoreRecordTotalByEmrId(String emrId, Integer level) {
        String hql = "from MisEmrScoreTotal t  where t.emrId = '" + emrId + "' ";
        if (level != null) {
            hql = hql + "and scoreLevel = '" + level + "' ";
        }
        hql = hql + "  order by t.scoreLevel";
        List<MisEmrScoreTotal> list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public List<MisEmrScoreRecord> findNormalMisEmrScoreRecords(String emrId) {
        String hql = "from MisEmrScoreRecord t where t.emrId = '" + emrId + "' order by t.id  desc ";
        List<MisEmrScoreRecord> list = this.findByHQL(hql).list();
        return list;
    }


    @Override
    public List<MisEmrScoreRecord> findMisEmrScoreRecordByObj(MisEmrScoreRecord misEmrScoreRecord) {
        String hql = "from MisEmrScoreRecord t where t.emrId = '" + misEmrScoreRecord.getEmrId() + "' and t.scoreLevel = '" + misEmrScoreRecord.getScoreLevel() + "' ";
        List<MisEmrScoreRecord> list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public void delEmrScoreRecordByItemid(MisEmrScoreRecord misEmrScoreRecord) {
        String hql = "from MisEmrScoreRecord t where t.itemid = '" + misEmrScoreRecord.getItemid() + "' and t.emrId = '" + misEmrScoreRecord.getEmrId() + "' and t.scoreLevel = '" + misEmrScoreRecord.getScoreLevel() + "' ";
        //TODO BUG3
        MisEmrScoreRecord misEmrScoreRecord_temp = (MisEmrScoreRecord) this.findByHQL(hql).uniqueResult();
        this.deleteById(MisEmrScoreRecord.class, misEmrScoreRecord_temp.getId());
    }

    @Override
    public boolean findIfEmrCanPrev(String id) {
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(id);
        //提交状态
        Integer isComtd = 1;//已经提交
        if (misEmrBasicinfo != null) {
            isComtd = misEmrBasicinfo.getIsCommitted();
        }

        //修改申请状态
        Integer reqResult = 1;//不包含未审核的修改申请
        List<MisEmrMdfreq> list = misEmrMdfreqService.findMdfreqsByEmrId(id);//病历修改申请列表
        //查询是否有未读数据
        for (MisEmrMdfreq d : list) {
            if (d.getReqResult() == 0) {
                reqResult = 0;
            }
        }

        //是否存在已有的评分记录
        //Integer sorceRec = 0;
        //List<MisEmrScoreRecord> list2 = this.findNormalMisEmrScoreRecords(id);
        //sorceRec = list2.size();

        if (isComtd == 1 && reqResult == 1) {
            return true;
        }

        return false;
    }


}
