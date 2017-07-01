package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.VAcceptAmbulOutdInfo;
import com.zxit.model.VAcceptAmbulOutdInfoId;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VAcceptAmbulOutdInfoService;
import com.zxit.service.VMisEmrQueryService;
import com.zxit.share.SystemConfig;
import com.zxit.tools.UtilDate;

/**
 * @author Administrator
 * @version 1.1
 *          20160828
 *          说明：实现了BaseService基础服务类,至此服务类不再实际注入Dao层相关内容。
 */
@Service("misEmrBasicinfoService")
public class MisEmrBasicinfoServiceImpl extends ABaseServiceImpl implements MisEmrBasicinfoService {

    @Resource
    private SystemConfig systemConfig;
    @Resource
    private VMisEmrQueryService vMisEmrQueryService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private VAcceptAmbulOutdInfoService vAcceptAmbulOutdInfoService;

    private Logger m_log = Logger.getLogger("com.zxit.service.impl.MisEmrBasicinfoServiceImpl");

    @Override
    public void saveMisEmrBasicinfo(MisEmrBasicinfo misEmrBasicinfo) {
        String emrCode = createEmrCode(misEmrBasicinfo);
        misEmrBasicinfo.setEmrCode(emrCode);//生成病历外部编号
        this.saveOrUpdate(misEmrBasicinfo);
    }

    @Override
    public MisEmrBasicinfo findMisEmrBasicinfoById(String id) {
        MisEmrBasicinfo misEmrBasicinfo = this.findById(MisEmrBasicinfo.class, id);
        return misEmrBasicinfo;
    }

    @Override
    public void delMisEmrBasicinfoById(String id) {
        this.deleteById(MisEmrBasicinfo.class, id);
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrBasicinfo> findMisEmrBasicinfoByLshAndCcxh(String lsh, Integer ccxh) {
        List<MisEmrBasicinfo> list = this.findByHQL(" from MisEmrBasicinfo t where t.lsh = '" + lsh + "' and t.ccxh = '" + ccxh + "' ").list();
        return list;
    }

    @Override
    public String createHQL(MisEmrBasicinfo misEmrBasicinfo) {
        String hql = " from MisEmrBasicinfo where ";
//		if(){
//			
//		}
        hql = hql + " 1 = 1 order by id desc";
        return hql;
    }

    @Override
    public List<MisEmrBasicinfo> findMisEmrBasicinfoByHql(String hql, int startPos, int dataPerPage) {
        List<MisEmrBasicinfo> list = this.findWithPager(MisEmrBasicinfo.class, hql, startPos, dataPerPage);
        return list;
    }

    @Override
    public int findCount(String hql) {
        return this.findTotalByHQL(hql);
    }

    @Override
    public void commitMisEmrBasicinfo(MisEmrBasicinfo misEmrBasicinfo) {
        misEmrBasicinfo.setIsCommitted(1);
        this.saveOrUpdate(misEmrBasicinfo);
    }


    /**
     * 外部病历编号生成规则
     *
     * @param vMisEmrQuery
     * @param misEmrBasicinfo
     * @return
     */
    private String createEmrCode(MisEmrBasicinfo misEmrBasicinfo) {
        String emrCode = "";

        try {
            VAcceptAmbulOutdInfoId id = new VAcceptAmbulOutdInfoId(misEmrBasicinfo.getLsh(), misEmrBasicinfo.getCcxh());
            VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo = vAcceptAmbulOutdInfoService.findVAcceptAmbulOutdInfoById(id);
            if (systemConfig.getEmrCode().equals("1")) {//郑州现用
                if (vAcceptAmbulOutdInfo != null) {
                    SysOrgInfo sysOrgInfo = sysOrgInfoService.findSysOrgInfoById(vAcceptAmbulOutdInfo.getSzfz());
                    String str1 = sysOrgInfo.getAlias();//站点名
                    String str2 = UtilDate.get4yMd(vAcceptAmbulOutdInfo.getCcsj()).replaceAll("-", "");
                    String emrId = misEmrBasicinfo.getId();
                    String str3 = emrId.substring(emrId.length() - 6, emrId.length());
                    emrCode = str1 + "-" + str2 + str3;
                }
            }

            if (systemConfig.getEmrCode().equals("2")) {//宁波现用
                String ccsj = UtilDate.get4yMd(vAcceptAmbulOutdInfo.getCcsj()).replaceAll("-", "");//出车时间
                String emrId = misEmrBasicinfo.getId();
                String randomNum = emrId.substring(emrId.length() - 5, emrId.length());//病历的后五位
                emrCode = ccsj + randomNum;
            }

        } catch (Exception e) {
            m_log.error("外部病历编号生成错误" + e.getMessage());
        }
        return emrCode;
    }


}
