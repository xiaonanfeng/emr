package com.zxit.service.impl;

import com.zxit.dao.ABaseDao;
import com.zxit.model.VMisEmrAmbul;
import com.zxit.service.*;
import com.zxit.share.Constants;
import com.zxit.share.SystemConfig;
import com.zxit.tools.UtilDate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Service("vMisEmrAmbulService")
public class VMisEmrAmbulServiceImpl implements VMisEmrAmbulService {

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
    private SystemConfig systemConfig;

    @Override
    public List<VMisEmrAmbul> findVMisEmrAmbulList(VMisEmrAmbul vMisEmrAmbul) {
        return null;
    }

    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }

    @Override
    public String createHQL(VMisEmrAmbul vMisEmrAmbul) {
        String hql = " from VMisEmrAmbul t where ";
        //如果开始时间和结束时间都是空
        if ((vMisEmrAmbul.getTimebegin() == null && vMisEmrAmbul.getTimeover() == null)
                || (vMisEmrAmbul.getTimebegin() == "" && vMisEmrAmbul.getTimeover() == "")) {
            //查询近一个月
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1);
            String defultBegin = UtilDate.formatDate(cal.getTime(), "yyyy-MM-dd hh:mm:ss");
            hql = hql + "  to_char(t.ccsj,'yyyy-mm-dd hh24:mi:ss') >= '" + defultBegin + "' and ";
        } else {
            if (vMisEmrAmbul.getTimebegin() != null && vMisEmrAmbul.getTimebegin() != "") {// 时间开始不为空
                hql = hql + "  to_char(t.ccsj,'yyyy-mm-dd hh24:mi:ss') >= '" + vMisEmrAmbul.getTimebegin() + "' and ";
            }
            if (vMisEmrAmbul.getTimeover() != null && vMisEmrAmbul.getTimeover() != "") {// 时间结束不为空
                hql = hql + "  to_char(t.ccsj,'yyyy-mm-dd hh24:mi:ss') <= '" + vMisEmrAmbul.getTimeover() + "'  and ";
            }
        }

        if (vMisEmrAmbul != null) {
            if (!vMisEmrAmbul.getOrgId().equals(Constants.center)) {//如果是中心人员就查询所有的
                //如果不是中心单位的值班员，就查询该用户的
                if (null != vMisEmrAmbul.getOrgId() && vMisEmrAmbul.getOrgId().length() != 0) {
                    hql = hql + "  t.szfz = '" + vMisEmrAmbul.getOrgId() + "' and ";
                }
            } else {//如果是中心人员并且有单位的查询条件的
                if (null != vMisEmrAmbul.getSzfz() && vMisEmrAmbul.getSzfz().length() != 0) {
                    hql = hql + "  t.szfz = '" + vMisEmrAmbul.getSzfz() + "' and ";
                }
            }
            if (null != vMisEmrAmbul.getName() && vMisEmrAmbul.getName().length() != 0) {
                hql = hql + "  t.name like '%" + vMisEmrAmbul.getName() + "%' and ";
            }
            if (null != vMisEmrAmbul.getLxr() && vMisEmrAmbul.getLxr().length() != 0) {
                hql = hql + "  t.lxr like '%" + vMisEmrAmbul.getLxr() + "%' and ";
            }
            if (null != vMisEmrAmbul.getLxdh() && vMisEmrAmbul.getLxdh().length() != 0) {
                hql = hql + "  t.lxdh like '%" + vMisEmrAmbul.getLxdh() + "%' and ";
            }
            if (null != vMisEmrAmbul.getIsCommitted()) {
                hql = hql + "  t.isCommitted = " + vMisEmrAmbul.getIsCommitted() + " and ";
            }
        }
        return hql;
    }

    @Override
    public VMisEmrAmbul findVMisEmrAmbulById(String id) {
        return (VMisEmrAmbul) aBaseDao.findById(VMisEmrAmbul.class, id);
    }

    @Override
    public List<VMisEmrAmbul> findVMisEmrAmbulPager(String hql, int startNum,
                                                    int pageTotal) {
        List<VMisEmrAmbul> list = aBaseDao.findWithPager(VMisEmrAmbul.class, hql, startNum, pageTotal);
        for (VMisEmrAmbul d : list) {
            d.setClid(sysAmbulInfoService.findSysAmbulInfoById(d.getClid()).getName());//车辆名
            d.setSzfz(sysOrgInfoService.findSysOrgInfoById(d.getSzfz()).getName());
            d.setCreateuserid(sysMemberInfoService.findSysMemberInfoById(d.getCreateuserid()).getName());
        }
        return list;
    }

}
