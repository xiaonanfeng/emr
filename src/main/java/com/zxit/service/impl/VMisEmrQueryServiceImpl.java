package com.zxit.service.impl;

import com.zxit.dao.ABaseDao;
import com.zxit.model.VMisEmrQuery;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.share.SystemConfig;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("vMisEmrQueryService")
public class VMisEmrQueryServiceImpl implements VMisEmrQueryService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SysAmbulInfoService sysAmbulInfoService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private MisEmrIcd10Service misEmrIcd10Service;
    @Resource
    private SystemConfig systemConfig;

    private Logger log = Logger.getLogger(VMisEmrQueryServiceImpl.class);


    @Override
    public List<VMisEmrQuery> findVMisEmrQueryPager(String hql, int startNum,
                                                    int pageTotal) {
        List<VMisEmrQuery> list = aBaseDao.findWithPager(VMisEmrQuery.class, hql, startNum, pageTotal);
        //呼救时刻、患者姓名、性别、年龄、疾病分类、病情、初步诊断、分站（只需显示站号）、救治结果、送往医院、医生

        for (VMisEmrQuery d : list) {
            try {
                if (d.getPrimDiag() != null) {
                    String temp_primDiag[] = d.getPrimDiag().split(",");
                    String temp_p = "";
                    for (int i = 0; i < temp_primDiag.length; i++) {
                        temp_p = temp_p + misEmrIcd10Service.findMisEmrIcd10ById(Integer.parseInt(temp_primDiag[i])).getDiseaseName() + "&nbsp;&nbsp;&nbsp;&nbsp;";
                    }
                    d.setText_primDiag(temp_p);//初步诊断是一个多项
                }
                d.setText_sex(sysCodeService.findSysCodeNameByIdAndPid(d.getSex(), Constants.sex));
                d.setText_diseaseType(sysCodeService.findSysCodeNameByIdAndPid(d.getDiseaseType(), d.getCause()));
                d.setText_condition(sysCodeService.findSysCodeNameByIdAndPid(d.getCondition(), Constants.condition));
                String text_szfz = sysOrgInfoService.findSysOrgInfoById(d.getSzfz()).getAlias();
                d.setText_szfz(text_szfz);
                d.setText_preEmcResult(sysCodeService.findSysCodeNameByIdAndPid(d.getPreEmcResult(), Constants.pre_emc_result));//救治结果
                String station = d.getSentTo();
                if (station != null) {
                    d.setText_sentTo(sysOrgInfoService.findSysOrgInfoById(d.getSentTo()).getName());
                } else if (d.getIsHospitalized() == 1) {
                    d.setText_sentTo("未送院");
                }
                d.setText_id(sysMemberInfoService.findSysMemberInfoById(d.getId()).getName());//医生ID
                d.setText_nurse(sysMemberInfoService.findSysMemberInfoById(d.getNurse()).getName());//护士
                d.setText_driver(sysMemberInfoService.findSysMemberInfoById(d.getDriver()).getName());//司机
            } catch (Exception e) {
                log.warn("流水号：" + d.getLsh() + "出车序号：" + d.getCcxh() + "的所在单位代码为空！");
                log.error("流水号：" + d.getLsh() + "出车序号" + d.getCcxh() + "的所在单位代码为空！");
            }
        }
        return list;
    }

    @Override
    public List<VMisEmrQuery> findVMisEmrQueryList(VMisEmrQuery vMisEmrQuery) {
        return null;
    }

    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }


    /**
     * 必要查询条件
     * 开始时刻、结束时刻、患者姓名、性别、病情、分站（只需显示站号）、救治结果、电话、送往地点、疾病分类、年龄段选择、提交
     */
    @Override
    public String createHQL(VMisEmrQuery VMisEmrQuery) {
        StringBuilder builder = new StringBuilder();
        builder.append(" from VMisEmrQuery t where ");
        if (VMisEmrQuery != null) {
            String timeBegin = VMisEmrQuery.getTimebegin();
            String timeOver = VMisEmrQuery.getTimeover();
            String orgId = VMisEmrQuery.getOrgId();
            String szfz = VMisEmrQuery.getSzfz();
            String ssjgdm = VMisEmrQuery.getSsjgdm();
            String ysid = VMisEmrQuery.getYsid();
            String id = VMisEmrQuery.getId();
            String name = VMisEmrQuery.getName();
            Integer sex = VMisEmrQuery.getSex();
            Integer condition = VMisEmrQuery.getCondition();
            Integer preEmcResult = VMisEmrQuery.getPreEmcResult();
            String phone = VMisEmrQuery.getPhone();
            String sendTo = VMisEmrQuery.getSentTo();
            Integer diseaseType = VMisEmrQuery.getDiseaseType();
            Integer dClassify = VMisEmrQuery.getdClassify();
            Integer stage = VMisEmrQuery.getStage();
            Integer isCommitted = VMisEmrQuery.getIsCommitted();
            String memberId = VMisEmrQuery.getMemberId();
            Integer orgType = VMisEmrQuery.getOrgType();
            String createUserId = VMisEmrQuery.getCreateuserid();
            String nurse = VMisEmrQuery.getNurse();
            String driver = VMisEmrQuery.getDriver();
            String clid = VMisEmrQuery.getClid();
            //时间
            if (timeBegin != null && timeBegin != "") {//开始时刻
                builder.append("  to_char(t.hjsj,'yyyy-mm-dd hh24:mi:ss') >= '" + timeBegin + "' and ");
            }
            if (timeOver != null && timeOver != "") {//结束时刻
                builder.append("  to_char(t.hjsj,'yyyy-mm-dd hh24:mi:ss') <= '" + timeOver + "'  and ");
            }
            //所属机构代码
            if (null != ssjgdm && ssjgdm.length() != 0) {
                builder.append("  t.ssjgdm = '" + ssjgdm + "' and ");
            }
            //所在分站
            if (null != szfz && szfz.length() != 0) {
                builder.append("  t.szfz = '" + szfz + "' and ");
            }
            //患者姓名
            if (null != name && name.length() != 0) {
                builder.append("  t.name like '%" + name + "%' and ");
            }
            //患者性别
            if (null != sex) {
                builder.append("  t.sex = '" + sex + "' and ");
            }
            //病情
            if (null != condition) {
                builder.append("  t.condition = '" + condition + "' and ");
            }
            //救治结果
            if (null != preEmcResult) {
                builder.append("  t.preEmcResult = '" + preEmcResult + "' and ");
            }
            //电话
            if (null != phone) {
                builder.append("  t.phone like '%" + phone + "%' and ");
            }
            //送往地点
            if (null != sendTo && sendTo.length() != 0) {
                builder.append("  t.sentTo = '" + sendTo + "' and ");
            }
            //疾病分类
            if (null != diseaseType) {
                builder.append("  t.diseaseType = '" + diseaseType + "' and ");
            }
            //疾病分类
            if (null != dClassify) {
                builder.append("  t.dClassify = '" + dClassify + "' and ");
            }
            //年龄段
            if (null != stage) {
                builder.append("  t.stage = '" + stage + "' and ");
            }
            //提交
            if (null != isCommitted) {
                builder.append("  t.isCommitted = " + isCommitted + " and ");
            }
            //护士
            if (null != nurse && nurse != "") {
                builder.append(" t.nurse = '" + nurse + "' and ");
            }
            //司机
            if (null != driver && driver != "") {
                builder.append(" t.driver = '" + driver + "' and ");
            }
            //医生ID
            if (null != ysid && ysid != "") {
                builder.append("  t.id = '" + ysid + "' and ");
            }
            //车辆编号
            if (null != clid && clid != "") {
                builder.append("  t.clid = '" + clid + "' and ");
            }
            //显示自己
            if (null != id && id != "") {
                builder.append("  (t.id = '" + id + "' or t.createuserid = '" + id + "') and ");
            }
            //数据级权限
            String sqlSuffixString = findOrgIdsFromSqlsuffix(memberId, orgId);
            /**
             * 如果显示自己被打勾或者单位类型是分站并且是强制私有模式
             */
            if (orgType == Constants.station && systemConfig.getShareMode() == 0) {//分站模式
                builder.append("  (t.id = '" + memberId + "' or t.createuserid = '" + memberId + "') and ");
            }
            if (sqlSuffixString.length() != 0) {
                builder.append(" t.szfz in " + sqlSuffixString + " and");
            }

        }
        return builder.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String findOrgIdsFromSqlsuffix(String memberId, String orgId) {
        String sql = " select org_id from mis_datascope_permission where objecttype=5 and objectid='" + memberId + "' " +
                " union " +
                " select org_id from mis_datascope_permission where objecttype=1 and objectid='" + orgId + "'";
        List<String> list = aBaseDao.findBySQL(sql).list();
        String string = "";
        if (list.size() != 0) {
            string = list.toString().replace("[", "(").replace("]", ")");
        }
        return string;
    }


    @Override
    public VMisEmrQuery findVMisEmrQueryById(String id) {
        return (VMisEmrQuery) aBaseDao.findById(VMisEmrQuery.class, id);
    }

    @Override
    public String findLshByEmrId(String emrId) {
        String lsh = "";
        VMisEmrQuery vMisEmrQuery = this.findVMisEmrQueryById(emrId);
        if (vMisEmrQuery != null) {
            lsh = vMisEmrQuery.getLsh();
        }
        return lsh;
    }

    @Override
    public Integer findCcxhByEmrId(String emrId) {
        Integer ccxh = null;
        VMisEmrQuery vMisEmrQuery = this.findVMisEmrQueryById(emrId);
        if (vMisEmrQuery != null) {
            ccxh = vMisEmrQuery.getCcxh();
        }
        return ccxh;
    }


}
