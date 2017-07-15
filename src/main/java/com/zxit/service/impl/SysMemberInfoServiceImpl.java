package com.zxit.service.impl;

import com.zxit.dao.ABaseDao;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.service.SysMemberInfoService;
import com.zxit.share.SystemConfig;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("sysMemberInfoService")
public class SysMemberInfoServiceImpl implements SysMemberInfoService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SystemConfig systemConfig;

    private Logger log = Logger.getLogger("com.zxit.service.impl.SysMemberInfoServiceImpl");

    @Override
    public SysMemberInfo findSysMemberInfoById(String id) {
        SysMemberInfo sysMemberInfo = new SysMemberInfo();
        sysMemberInfo.setName("");
        try {
            if (id != null) {
                sysMemberInfo = aBaseDao.findById(SysMemberInfo.class, id);
            }
        } catch (Exception e) {
            log.debug(new Date() + this.getClass().getName() + ">>>>>>:id=" + id);
            e.printStackTrace();
        }
        return sysMemberInfo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysMemberInfo> findSysMemberInfoByType(Integer type, String orgId) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" from SysMemberInfo t where flag = '0' and ");
        if (type!=null){
            stringBuilder.append(" t.type = '" + type + "' and ");
        }
        if(orgId!=null&&orgId!=""){
            stringBuilder.append(" t.sysOrgInfo.orgId = '" + orgId + "' and ");
        }
        stringBuilder.append(" 1=1 ");
        String hql = stringBuilder.toString();
        List<SysMemberInfo> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SysMemberInfo> findMembersByArr(List<String> memberList) {
        List<SysMemberInfo> list = new ArrayList<SysMemberInfo>();
        String hql = "from SysMemberInfo t where  flag = '0'  and t.id in (:memberList)";
        Query query = aBaseDao.findByHQL(hql);
        list = query.setParameterList("memberList", memberList).list();
        return list;
    }


    @Override
    public String createMemberInfoSelect(TObject t, List<SysMemberInfo> list) {
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
            for (SysMemberInfo d : list) {
                sb.append("<option value=\"" + d.getId() + "\">" + d.getName() + "</option>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("</select>");
        return sb.toString();
    }


}
