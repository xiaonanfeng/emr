package com.zxit.service;

import java.util.Date;
import java.util.List;

import com.zxit.model.MisEmrMdfreq;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.VMisEmrMdfreq;

public interface MisEmrMdfreqService extends ABaseService {
    /**
     * 中心管理人员根据审核人的ID找到需要审核的修改申请
     *
     * @return
     */
    public List<MisEmrMdfreq> findReqByHql(String timebegin, String timeover, String recMember);

    /**
     * 根据发起人找到审批结果
     *
     * @param reqMember
     * @return
     */
    public List<MisEmrMdfreq> findRecByHql(String reqMember);

    /**
     * 审核操作，同意还是不驳回
     *
     * @param id
     * @param emr_id
     */
    public void saveReqRec(MisEmrMdfreq misEmrMdfreq);

    /**
     * 删除已经过期的修改申请
     */
    public void delMisEmrMdfreqs();

    /**
     * 自动驳回过期申请
     *
     * @param timeScope
     * @return
     */
    public List<VMisEmrMdfreq> findEmrMdfRq2Rec(Integer timeScope);

    /**
     * 通过病历找到该病历下未审核的修改申请
     * 审核标记为0，即为当时的申请状态
     *
     * @param emrId
     * @return
     */
    public MisEmrMdfreq findByEmrIdAndRstIsZero(String emrId);

    /**
     * 发现所有需要审批的修改申请
     *
     * @param string
     * @return
     */
    public Integer findMisEmrMdfReqCount(Integer stat, String memberId);

    /**
     * 已经审核并通过过的病历需要手动提交
     */
    public boolean findPrvdEmrByEmrId(String emrId, Date now);

    /**
     * 发现一个病历单号下所有的申请历史
     *
     * @param emrId
     * @return
     */
    public List<MisEmrMdfreq> findMdfreqsByEmrId(String emrId);

    /**
     * 申请方发现还有读取的回复结果
     *
     * @param id
     * @return
     */
    public List<MisEmrMdfreq> findRecNotRed(String timebegin, String timeover, String id);

    /**
     * 申请方确认签收审批方的反馈信息
     *
     * @param id
     * @return
     */
    public void checkMisEmrMdfReqById(Long id);

    /**
     * 根据当前的人员类型找到具有审核权限的人员
     * 医生<分中心负责人=急救科医护<急救科负责人=质管科医护<分中心领导
     * <p>
     * 医生  type = 40
     * <p>
     * 分中心负责人     orgType=2&&type=100
     * 急救科医护          type=40&&ssks=120
     * <p>
     * 急救科负责人
     * 质管科医护
     * <p>
     * 分中心领导
     *
     * @param sysMemberInfo
     * @return
     */
    public List<SysMemberInfo> findMisEmrMdfprvsListByHql(SysMemberInfo sysMemberInfo);

    /**
     * 查询到的数据总量
     *
     * @param hql
     * @return
     */
    public Integer findCount(String hql);

    /**
     * 分页查询
     *
     * @return
     */
    public List<MisEmrMdfreq> findMisEmrMdfreqWithPager(String hql, int startNum, int pageTota);

    /**
     * 查询业务
     *
     * @param timebegin
     * @param timeover
     * @param sysMemberInfo
     * @return
     */
    public String createQueryHql(String timebegin, String timeover, String reqResult, SysMemberInfo sysMemberInfo);


}
