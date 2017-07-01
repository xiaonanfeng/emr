package com.zxit.service.impl;

import com.zxit.dao.ABaseDao;
import com.zxit.model.*;
import com.zxit.service.SysAmbulInfoService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VAcceptAmbulOutdInfoService;
import com.zxit.share.Constants;
import com.zxit.share.SystemConfig;
import com.zxit.tools.UtilDate;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service("vAcceptAmbulOutdInfoService")
public class VAcceptAmbulOutdInfoServiceImpl implements VAcceptAmbulOutdInfoService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SysAmbulInfoService sysAmbulInfoService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;
    @Resource
    private SystemConfig systemConfig;

    private Logger log = Logger.getLogger(VAcceptAmbulOutdInfoServiceImpl.class);

    @Override
    public List<VAcceptAmbulOutdInfo> findVAcceptAmbulOutdInfoPager(String hql, int startNum, int pageTotal) {
        List<VAcceptAmbulOutdInfo> list = new ArrayList<VAcceptAmbulOutdInfo>();
        list = aBaseDao.findWithPager(VAcceptAmbulOutdInfo.class, hql, startNum, pageTotal);
        list = transVAccepts(list);
        return list;
    }

    @Override
    public List<VAcceptAmbulOutdInfo> findVAcceptAmbulOutdInfoPagerWithCollections(String hql, int startNum, int pageTotal, Map<String, Object> map) {
        List<VAcceptAmbulOutdInfo> list = new ArrayList<VAcceptAmbulOutdInfo>();
        list = aBaseDao.findWithPagerAndCollections(VAcceptAmbulOutdInfo.class, hql, map, startNum, pageTotal);
        list = transVAccepts(list);
        return list;
    }

    private List<VAcceptAmbulOutdInfo> transVAccepts(
            List<VAcceptAmbulOutdInfo> list) {
        try {
            for (VAcceptAmbulOutdInfo d : list) {
                String temp_id = d.getClid();//
                SysAmbulInfo temp_sysAmbulInfo = sysAmbulInfoService.findSysAmbulInfoById(temp_id);
                d.setClid(temp_sysAmbulInfo.getName());// 翻译车辆名称
                try {
                    temp_id = d.getSzfz();
                    SysOrgInfo sysOrgInfo = sysOrgInfoService.findSysOrgInfoById(temp_id);
                    if (temp_id != null && temp_id != "") {
                        d.setSzfz(sysOrgInfo.getName());// 翻译单位名
                    } else {
                        d.setSzfz("未知分站");// 翻译单位名
                    }
                } catch (Exception e) {
                    log.error("错误的对象" + d.toString());
                }
                String ysid = d.getYsid();
                SysMemberInfo sysMemberInfo = sysMemberInfoService.findSysMemberInfoById(ysid);
                if (sysMemberInfo != null) {
                    d.setYsid(sysMemberInfo.getName());
                } else {
                    d.setYsid("查无此人");
                }
            }
        } catch (Exception e) {
            log.error("VAcceptAmbulOutdInfo翻译失败！" + list.toString());
        }
        return list;
    }

    @Override
    public VAcceptAmbulOutdInfo findVAcceptAmbulOutdInfoById(VAcceptAmbulOutdInfoId id) {
        VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo = aBaseDao.findById(VAcceptAmbulOutdInfo.class, id);
        return vAcceptAmbulOutdInfo;
    }

    @Override
    public String createHQL(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(" from VAcceptAmbulOutdInfo t where ");
        if (vAcceptAmbulOutdInfo != null) {
            String timeBegin = vAcceptAmbulOutdInfo.getTimebegin();//时间开始
            String timeOver = vAcceptAmbulOutdInfo.getTimeover();//时间结束
            String jcdz = vAcceptAmbulOutdInfo.getJcdz();//接车地址
            String lxdh = vAcceptAmbulOutdInfo.getLxdh();//联系电话
            Integer hzrs = vAcceptAmbulOutdInfo.getHzrs();//获救人数
            Integer emrCounts = vAcceptAmbulOutdInfo.getEmrCounts();//产生病历数量
            Double overTimeLimit = vAcceptAmbulOutdInfo.getOverTimeLimit();//病历产生时限
            String memberId = vAcceptAmbulOutdInfo.getMemberId();//用户名
            //Integer orgType = vAcceptAmbulOutdInfo.getOrgType();//结构类型代码
            Integer showAll = vAcceptAmbulOutdInfo.getShowAll();//显示自己是否被打勾
            //如果开始时间和结束时间都是空
            if ((timeBegin == null && timeOver == null) || (timeBegin == "" && timeOver == "")) {
                //查询近一个月
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
                String defultBegin = UtilDate.formatDate(cal.getTime(), "yyyy-MM-dd hh:mm:ss");
                builder.append("  to_char(t.slsj,'yyyy-mm-dd hh24:mi:ss') >= '" + defultBegin + "' and ");
            } else {
                if (timeBegin != null && timeBegin != "") {// 时间开始不为空
                    builder.append("  to_char(t.slsj,'yyyy-mm-dd hh24:mi:ss') >= '" + timeBegin + "' and ");
                }
                if (timeOver != null && timeOver != "") {// 时间结束不为空
                    builder.append("  to_char(t.slsj,'yyyy-mm-dd hh24:mi:ss') <= '" + timeOver + "'  and ");
                }
            }
            //接车地址
            if (null != jcdz && jcdz.length() != 0) {
                builder.append("  t.jcdz like '%" + jcdz + "%' and ");
            }
            //联系电话
            if (null != lxdh && lxdh.length() != 0) {
                builder.append("  t.lxdh like '%" + lxdh + "%' and ");
            }

            //病历数量
            if (null != hzrs) {
                builder.append("  t.hzrs = '" + hzrs + "' and ");
            }
            //病历填写情况
            if (null != emrCounts) {
                if (emrCounts == 0) {//未填写
                    builder.append("  t.hzrs = '" + emrCounts + "' and ");
                } else {//已填写
                    builder.append("  t.hzrs != 0 and ");
                }
            }
            //填写超时检查
            if (null != overTimeLimit) {
                builder.append(" ROUND(TO_NUMBER(sysdate - t.slsj) * 24)6-1 >= '" + overTimeLimit + "' and ");
            }
            //显示自己被打勾
            if (showAll != null && showAll == 1) {//处于病历私有模式状态  或者  显示自己被打勾
                builder.append("  t.ysid = '" + memberId + "' and ");
            }

        }
        return builder.toString();
    }

    /**
     * 所有有关单位的数据级权限交给MIS
     */
    @Override
    public String createWebHQL(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo) {
        StringBuilder builder = new StringBuilder();
        //通用查询条件拼装
        String hql = createHQL(vAcceptAmbulOutdInfo);
        builder.append(hql);
        //SQL后缀，数据级权限
        if (vAcceptAmbulOutdInfo != null) {
            String memberId = vAcceptAmbulOutdInfo.getMemberId();
            String orgId = vAcceptAmbulOutdInfo.getOrgId();
            Integer orgType = vAcceptAmbulOutdInfo.getOrgType();//结构类型代码
            //所属分站
            String ssjgdm = vAcceptAmbulOutdInfo.getSsjgdm();//所属机构代码
            String szfz = vAcceptAmbulOutdInfo.getSzfz();//所在分站
            if (null != ssjgdm && ssjgdm.length() != 0) {
                builder.append("  t.ssjgdm = '" + ssjgdm + "' and ");
            }
            //所在分站
            if (null != szfz && szfz.length() != 0) {
                builder.append("  t.szfz = '" + szfz + "' and ");
            }
            String sqlSuffixString = findOrgIdsFromSqlsuffix(memberId, orgId);
            /**
             * 如果显示自己被打勾或者单位类型是分站并且是强制私有模式
             */
            if (orgType == Constants.station && systemConfig.getShareMode() == 0) {//分站模式
                builder.append("  t.ysid = '" + memberId + "' and ");
            }
            if (sqlSuffixString.length() != 0) {
                builder.append(" t.szfz in " + sqlSuffixString + " and");
            }
        }
        builder.append("  1 = 1 order by t.slsj desc ");
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
    public String createPadHQL(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo) {
        String hql = "";
        if (vAcceptAmbulOutdInfo != null) {
            String memberId = vAcceptAmbulOutdInfo.getMemberId();
            String clid = vAcceptAmbulOutdInfo.getClid();
            if (systemConfig.getShareMode() == 0) {//病历私有模式
                hql = createHQL(vAcceptAmbulOutdInfo) + " t.ysid = '" + memberId + "' and ";
            } else {//共享模式  车辆和出车信息是一个整体 适用于有pad值守的车辆
                hql = createHQL(vAcceptAmbulOutdInfo) + " t.clid = '" + clid + "' and ";
            }
        }
        hql = hql + "  1 = 1 order by t.slsj desc ";
        return hql;
    }


    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }


}
