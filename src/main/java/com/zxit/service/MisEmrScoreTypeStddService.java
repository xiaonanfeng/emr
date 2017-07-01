package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrScoreRecord;
import com.zxit.model.MisEmrScoreTotal;
import com.zxit.model.VMisEmrScoreType;
import com.zxit.model.VMisEmrScoreTypeStdd;

public interface MisEmrScoreTypeStddService extends ABaseService {

    /**
     * 审核类型
     * 大类
     *
     * @return
     */
    public List<VMisEmrScoreType> findVMisEmrScoreTypeByFlag();

    /**
     * 根据大类项目ID
     * 找到审核项目细则
     *
     * @param typeid
     * @return
     */
    public List<VMisEmrScoreTypeStdd> findVMisEmrScoreTypeStddByTypeid(Integer typeid);

    /**
     * 审核细则
     * 小类
     *
     * @return
     */
    public List<VMisEmrScoreTypeStdd> findVMisEmrScoreTypeStddByFlag();

    /**
     * 病历质量评定
     *
     * @param total
     * @return
     */
    public String findMisEmrQuality(Double total);

    /**
     * 保存审核记录
     *
     * @param misEmrScoreTotal
     */
    public void saveOrUpdateMisEmrScoreTotal(MisEmrScoreTotal misEmrScoreTotal);

    /**
     * 保存扣分信息
     *
     * @param emrId
     * @param level
     * @param itemid
     */
    public void saveOrUpdateMisEmrScoreRecord(MisEmrScoreRecord misEmrScoreRecord);

    /**
     * 找到同级下的病历审核记录
     *
     * @param misEmrScoreRecord
     */
    public List<MisEmrScoreRecord> findMisEmrScoreRecordByObj(MisEmrScoreRecord misEmrScoreRecord);

    /**
     * 找到病历相关审核记录
     *
     * @param emrId
     */
    public List<MisEmrScoreTotal> findMisEmrScoreRecordTotalByEmrId(String emrId, Integer level);

    /**
     * 找到病历相关扣分项
     *
     * @param emrId
     * @return
     */
    public List<MisEmrScoreRecord> findNormalMisEmrScoreRecords(String emrId);

    /**
     * 根据itemId删除记录
     *
     * @param itemid
     */
    public void delEmrScoreRecordByItemid(MisEmrScoreRecord misEmrScoreRecord);

    /**
     * 已经提交&&并且修改申请里没有未处理的数据
     * 或者已经有审核记录
     *
     * @param id
     * @return
     */
    public boolean findIfEmrCanPrev(String id);


}
