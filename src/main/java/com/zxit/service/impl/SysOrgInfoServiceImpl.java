package com.zxit.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.service.SysOrgInfoService;
import com.zxit.share.SystemConfig;

@Service("sysOrgInfoService")
public class SysOrgInfoServiceImpl implements SysOrgInfoService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    SystemConfig systemConfig;

    private Logger log = Logger.getLogger(SysOrgInfoServiceImpl.class);


    @SuppressWarnings("unchecked")
    @Override//送往在用
    public List<SysOrgInfo> findSysOrgInfo() {
        List<SysOrgInfo> list = aBaseDao.findByHQL(" from SysOrgInfo t where t.sfzx = '1' and  t.type in (" + systemConfig.getExitSentTo() + ")  order by t.orgId*1").list();
        return list;
    }


    /**
     * 送往
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<SysOrgInfo> findSysOrgInfoFroSW() {
        List<SysOrgInfo> list = aBaseDao.findByHQL(" from SysOrgInfo t where t.sfzx = '1' and  t.type in (" + systemConfig.getExitSentTo() + ")  order by t.orgId*1").list();
        return list;
    }

    /**
     * 所在
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<SysOrgInfo> findSysOrgInfoFroSZ() {
        List<SysOrgInfo> list = aBaseDao.findByHQL(" from SysOrgInfo t where t.sfzx = '1' and t.type = '" + systemConfig.getExitSzfz() + "' order by t.orgId*1").list();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String findCenter() {
        String centerOrg = null;
        SysOrgInfo sysOrgInfo = new SysOrgInfo();
        String hql = " from SysOrgInfo t where t.sfzx = '1' and t.type = '10' order by t.type,t.orgId*1";
        //TODO 如果数据是合法的话，这是一个多余判断
        List<SysOrgInfo> list = aBaseDao.findByHQL(hql).list();
        if (list.size() > 1) {
            sysOrgInfo = list.get(0);
        } else {
            sysOrgInfo = (SysOrgInfo) aBaseDao.findByHQL(hql).uniqueResult();
        }
        if (sysOrgInfo != null) {
            centerOrg = sysOrgInfo.getOrgId();
        }
        return centerOrg;
    }


    /**
     * 宁波作为中心用户时选择
     * 第一次初始化20，以及10下的30是
     *
     * @return
     */
    @Override
    public List<SysOrgInfo> findScenter4Center() {
        //TODO 宁波要求的修改，不知道是否符合郑州
        String hql = " from SysOrgInfo t where t.sfzx = '1' and  (t.type = '40' or t.type = '20' or t.type = '10') "
                + " order by t.type,t.orgId*1";
        List<SysOrgInfo> list = this.findOrgsByHql(hql);
        return list;
    }

    /**
     * 分中心选择后
     * 根据分中心选择的单位id例举所属分站
     *
     * @param orgId
     * @param i
     * @return
     */
    @Override
    public List<SysOrgInfo> findSzfz4Scenter(String orgId) {
        String hql = " from SysOrgInfo t where t.sfzx = '1' and  t.ssjgdm = '" + orgId + "' order by t.type,t.orgId*1";
        List<SysOrgInfo> list = this.findOrgsByHql(hql);
        return list;
    }


    @Override
    public SysOrgInfo findSysOrgInfoById(String id) {
        SysOrgInfo sysOrgInfo = new SysOrgInfo();
        sysOrgInfo.setName("");
        try {
            if (id != null) {
                sysOrgInfo = aBaseDao.findById(SysOrgInfo.class, id);
            }
        } catch (Exception e) {
            log.debug(new Date() + this.getClass().getName() + ">>>>>>:id=" + id);
            e.printStackTrace();
        }
        return sysOrgInfo;
    }

    @Override
    public String createSysOrgSelect(TObject t, List<SysOrgInfo> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("<select class='" + t.getStyle() + "' id='" + t.getSelectIdAndName() + "' name='" + t.getSelectIdAndName()
                + "' onchange='" + t.getOnChgMthd() + "'>");
        sb.append("<option pvalue=\"\" value=\"\" >&nbsp;</option>");
        try {
            i = list.size();
            if (i == 0) {
                return "";
            }
            for (SysOrgInfo d : list) {
                sb.append("<option value=\"" + d.getOrgId() + "\">" + d.getName() + ":" + d.getOrgId()
                        + "</option>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("</select>");
        return sb.toString();
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<SysOrgInfo> findOrgsByHql(String hql) {
        List<SysOrgInfo> list = aBaseDao.findByHQL(hql).list();
        return list;
    }


}
