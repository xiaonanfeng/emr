package com.zxit.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisCategorypermission;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysMemberRole;
import com.zxit.service.SysMemberRoleService;

@Service("sysMemberRoleService")
public class SysMemberRoleServiceImpl implements SysMemberRoleService {

    @Resource
    private ABaseDao aBaseDao;

    @SuppressWarnings("unchecked")
    @Override
    public List<SysMemberRole> findSysMemberRoleByMemberId(String memberId) {
        //TODO 病历系统代码继承于MIS = 3
        String hql = " from SysMemberRole t where t.id.type = '3' and t.id.memberId = '" + memberId + "' and t.id.flag = '0'";
        List<SysMemberRole> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

    @Override
    public List<SysMemberRole> findSysMemberRoleByMemberAndCatepermison(List<MisCategorypermission> misCateList, SysMemberInfo sysMemberInfo) {
        //TODO 数据类型不匹配，memberRole是Integer，catepermison是String
        List<Integer> roleCodeList = new ArrayList<Integer>();
        for (MisCategorypermission d : misCateList) {
            roleCodeList.add(Integer.parseInt(d.getObjectid()));
        }
        String hql = " from SysMemberRole t where t.sysMemberInfo.id = '" + sysMemberInfo.getId() + "' and t.id.roleCode in (:roleCodeList)";
        Query query = aBaseDao.findByHQL(hql);
        query.setParameterList("roleCodeList", roleCodeList);
        List<SysMemberRole> sysMemberRole = query.list();
        return sysMemberRole;
    }

}
