package com.zxit.service.impl;

import com.zxit.model.*;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.tools.UtilDate;
import com.zxit.tools.UtilTools;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("misEmrMdfreqService")
public class MisEmrMdfreqServiceImpl extends ABaseServiceImpl implements MisEmrMdfreqService {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private MisCategorypermissionService misCategorypermissionService;
    @Resource
    private SysMemberRoleService sysMemberRoleService;

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrMdfreq> findReqByHql(String timebegin, String timeover, String recMember) {
        String hql = " from MisEmrMdfreq t where t.recMember = '" + recMember + "' and ";
        if (timebegin != null && timebegin != "") {//开始时刻
            hql = hql + "  to_char(t.createTime,'yyyy-mm-dd hh24:mi:ss') >= '" + timebegin + "' and ";
        }
        if (timeover != null && timeover != "") {//结束时刻
            hql = hql + "  to_char(t.createTime,'yyyy-mm-dd hh24:mi:ss') <= '" + timeover + "'  and ";
        }
        hql = hql + "  1 = 1  ";//hql的尾巴
        hql = hql + " order by createTime desc";//排序
        List<MisEmrMdfreq> list = this.findByHQL(hql).list();
        list = changeValues(list);
        return list;
    }

    @Override
    public List<MisEmrMdfreq> findRecByHql(String reqMember) {
        String hql = " from MisEmrMdfreq t where t.reqResult != '0' and t.reqMember = '" + reqMember + "' order by t.createTime desc";
        @SuppressWarnings("unchecked")
        List<MisEmrMdfreq> list = this.findByHQL(hql).list();
        list = changeValues(list);
        return list;
    }


    /**
     * 翻译
     *
     * @param list
     * @return
     */
    public List<MisEmrMdfreq> changeValues(List<MisEmrMdfreq> list) {
        for (MisEmrMdfreq d : list) {
            d.setMdfReason_text(sysCodeService.findSysCodeByIdAndPid(d.getMdfReason(), Constants.MDFREASON).getName());
            MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(d.getEmrId());
            //基础信息
            if (misEmrBasicinfo != null) {
                d.setName(misEmrBasicinfo.getName());
                d.setChiefComplaint(misEmrBasicinfo.getChiefComplaint());
            }
            //发起人
            SysMemberInfo sysMemberInfo = sysMemberInfoService.findSysMemberInfoById(d.getReqMember());
            if (misEmrBasicinfo != null) {
                d.setReqMember(sysMemberInfo.getName());
            }
            //审批人
            sysMemberInfo = sysMemberInfoService.findSysMemberInfoById(d.getRecMember());
            if (misEmrBasicinfo != null) {
                d.setRecMember(sysMemberInfo.getName());
            }
        }
        return list;
    }


    @Override
    public void saveReqRec(MisEmrMdfreq misEmrMdfreq) {
        this.saveOrUpdate(misEmrMdfreq);
        if (misEmrMdfreq.getReqResult() == 1) {//如果同意
            MisEmrBasicinfo misEmrBasicinfo = this.findById(MisEmrBasicinfo.class, misEmrMdfreq.getEmrId());
            misEmrBasicinfo.setIsCommitted(0);//更改为未提交状态
            this.saveOrUpdate(misEmrBasicinfo);
        }
    }

    @Override
    public void delMisEmrMdfreqs() {

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<VMisEmrMdfreq> findEmrMdfRq2Rec(Integer timeScope) {
        String hql = " from VMisEmrMdfreq t where t.reqResult =0 and  t.timescope >= " + timeScope + " ";
        List<VMisEmrMdfreq> list = this.findByHQL(hql).list();
        System.out.println(UtilDate.get4yMdHms(new Date()) + "：发现" + list.size() + "条病例修改申请已过期！");
        for (VMisEmrMdfreq d : list) {
            //自动更新为驳回并且申请人的阅读标志为0
            String sql = "update MIS_EMR_MDFREQ t set t.req_Result = 2 ,t.rec_remark = '申请过期，自动驳回！', t.red = '0' where t.id = '" + d.getId() + "' ";
            this.findBySQL(sql).executeUpdate();
        }
        return list;
    }

    @Override
    public MisEmrMdfreq findByEmrIdAndRstIsZero(String emrId) {
        String hql = " from MisEmrMdfreq t where t.emrId = '" + emrId + "' and t.reqResult = '0' ";
        MisEmrMdfreq misEmrMdfreq = (MisEmrMdfreq) this.findByHQL(hql).uniqueResult();
        return misEmrMdfreq;
    }


    @Override
    public boolean findPrvdEmrByEmrId(String emrId, Date now) {
        boolean b = true;
        String sql = " select max(comtagain) as maxdate  from MIS_EMR_MDFREQ t where t.emr_Id = '" + emrId + "' and t.req_Result = '1'   ";
        Date d = (Date) this.findBySQL(sql).uniqueResult();
        //如果没有这条数据，代表该病历没有提起过修改申请
        //如果审核未通过
        //如果这个申请数据意外没了
        //这个地方都会是NULL
        if (d == null) {
            return true;//告诉提交拦截器，可以提交了
        }
        //当这个修改时限存在时，数据库中审核通过的病历记录的最后提交期限  和现在相比    是否  已经过时。
        b = d.before(now);
        return b;
    }

    @Override
    public Integer findMisEmrMdfReqCount(Integer stat, String memberId) {
        String hql = " from MisEmrMdfreq t where   ";
        if (stat == 0) {//审批
            hql = hql + " t.recMember = '" + memberId + "' and t.reqResult = '0' ";
        } else {//审批结果  发送人发现没有读的审批结果
            hql = hql + " t.reqMember = '" + memberId + "' and t.red = '0' and t.reqResult != '0' ";
        }
        System.out.println(hql);
        Integer count = this.findTotalByHQL(hql);
        return count;
    }

    @Override
    public List<MisEmrMdfreq> findMdfreqsByEmrId(String emrId) {
        String hql = " from MisEmrMdfreq t where t.emrId = '" + emrId + "'  order by t.createTime desc";
        @SuppressWarnings("unchecked")
        List<MisEmrMdfreq> list = this.findByHQL(hql).list();
        list = changeValues(list);
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrMdfreq> findRecNotRed(String timebegin, String timeover, String id) {
        String hql = " from MisEmrMdfreq t where   ";
        hql = hql + " t.reqMember = '" + id + "' and ";

        if (timebegin != null && timebegin != "") {//开始时刻
            hql = hql + "  to_char(t.createTime,'yyyy-mm-dd hh24:mi:ss') >= '" + timebegin + "' and ";
        }
        if (timeover != null && timeover != "") {//结束时刻
            hql = hql + "  to_char(t.createTime,'yyyy-mm-dd hh24:mi:ss') <= '" + timeover + "'  and ";
        }
        hql = hql + "  1 = 1  ";//hql的尾巴
        hql = hql + " order by t.red asc";//排序

        List<MisEmrMdfreq> list = this.findByHQL(hql).list();
        list = changeValues(list);
        return list;
    }

    @Override
    public void checkMisEmrMdfReqById(Long id) {
        if (id != null) {
            MisEmrMdfreq misEmrMdfreq = this.findById(MisEmrMdfreq.class, id);
            if (misEmrMdfreq != null) {
                misEmrMdfreq.setRed(1);
                this.saveOrUpdate(misEmrMdfreq);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysMemberInfo> findMisEmrMdfprvsListByHql(SysMemberInfo sysMemberInfo) {
        Integer xzbm = sysMemberInfo.getXzbm();//行政编码
        Integer memberType = sysMemberInfo.getType();//获得人员类型
        Integer ssks = sysMemberInfo.getSsks();//获得所属科室
        SysOrgInfo sysOrgInfo = sysMemberInfo.getSysOrgInfo();
        String orgId = sysOrgInfo.getOrgId();//获得组织机构ID
        String ssjgdm = sysOrgInfo.getSsjgdm();//所属机构代码
        Integer orgType = sysOrgInfo.getType();//机构类型
        List<SysMemberInfo> list = new ArrayList<SysMemberInfo>();
        String hql = "";
        if (xzbm == 330201) {//宁波
            /**
             * 普通医生的申请递交原则： 如果用户的type=40 and orgType==30，
             * 找到医生的orgid，然后根据这个orgid找到相应的ssjgdm，
             * 同时找到机构的类型=20and人员类型=100的人员列表
             */
            if (memberType == 40 && orgType == 30) {//医生 向  分中心负责人  提交修改申请
                hql = " from SysMemberInfo t "
                        + "where t.sysOrgInfo.ssjgdm = '" + ssjgdm + "' "
                        + "and t.sysOrgInfo.type = 20 and t.type = 100 ";
            }
            /**
             * 分中心负责人和急救科医护是一个等级，但是急救科医护不具有审核权，分中心负责人具有审核权
             * 急救科医护人员+分中心负责人  向  急救科负责人 提交病历修改申请
             * 急救科负责人：orgType=中心&&type=100&&
             */
            //分中心负责人						//急救科医护//TODO type是一个变量
            if ((orgType == 20 && memberType == 100) || (orgType == 10 && memberType == 40)) {
                hql = " from SysMemberInfo t "
                        + "where t.sysOrgInfo.type = '" + 10 + "' "
                        + "and t.type = '?' and t.ssks = '?' ";
            }

        } else {
            hql = "from MisEmrMdfprvs t where t.flag = 0 ";
        }
        list = this.findByHQL(hql).list();
        return list;
    }

    @Override
    public Integer findCount(String hql) {
        return this.findTotalByHQL(hql);
    }

    @Override
    public List<MisEmrMdfreq> findMisEmrMdfreqWithPager(String hql, int startNum, int pageTotal) {
        List<MisEmrMdfreq> list = this.findWithPager(MisEmrMdfreq.class, hql, startNum, pageTotal);
        for (MisEmrMdfreq d : list) {
            String name = sysMemberInfoService.findSysMemberInfoById(d.getReqMember()).getName();
            d.setReqMember(name);
            d.setMdfReason_text(sysCodeService.findSysCodeByIdAndPid(d.getMdfReason(), Constants.MDFREASON).getName());
        }
        return list;
    }

    @Override
    public String createQueryHql(String timeBegin, String timeOver, String reqResult, SysMemberInfo sysMemberInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(" from MisEmrMdfreq t where ");
        //时间
        if (timeBegin != null && timeBegin != "") {//开始时刻
            builder.append("  to_char(t.createTime,'yyyy-mm-dd hh24:mi:ss') >= '" + timeBegin + "' and ");
        }
        if (timeOver != null && timeOver != "") {//结束时刻
            builder.append("  to_char(t.createTime,'yyyy-mm-dd hh24:mi:ss') <= '" + timeOver + "'  and ");
        }
        if (reqResult != null && reqResult != "") {
            builder.append("  reqResult = '" + reqResult + "'  and ");
        }
        if (!sysMemberInfo.getId().equals("1000")) {
            //第一步找具病历审核权的角色id，这个可能是多个，点击病历审核按钮的时候 moduleid是知道的
            List<MisCategorypermission> misionList = misCategorypermissionService.findMisCategorypermissionByTypeAndMoudleId(2, 2013);
            //第二步当前登录人具有审核病历权限的角色id，这个应该是一个确定的(TOOD 集合)
            List<SysMemberRole> sysMemberRole = sysMemberRoleService.findSysMemberRoleByMemberAndCatepermison(misionList, sysMemberInfo);
            //第三步
            List<String> orgList = misCategorypermissionService.findOrgListByRoleCodeAndType(sysMemberRole, 2);
            //第四步 找到MisEmrMdfreq 集合分页
            String sqlInSuffix = UtilTools.findSqlInSuffix(orgList);
            if (sqlInSuffix != null && sqlInSuffix != "") {//开始时刻
                builder.append(" t.orgId in " + sqlInSuffix + " and ");
            }
        }
        return builder.toString();
    }


}
