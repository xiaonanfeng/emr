package com.zxit.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisCategorypermission;
import com.zxit.model.MisDatascopePermission;
import com.zxit.model.SysMemberRole;
import com.zxit.service.MisCategorypermissionService;
import com.zxit.tools.UtilTools;

@Service("misCategorypermissionService")
public class MisCategorypermissionServiceImpl extends ABaseServiceImpl implements MisCategorypermissionService {

    @Resource
    private ABaseDao aBaseDao;

    @SuppressWarnings("unchecked")
    @Override
    public List<MisCategorypermission> findMisCategorypermissionByRoleCode(Integer roleCode) {
        List<MisCategorypermission> list = aBaseDao.findByHQL(" from MisCategorypermission t where t.objectid = '" + roleCode + "'").list();
        return list;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MisCategorypermission> findMisCategorypermissionByRoleCode(List<String> roleCodeList) {
        @SuppressWarnings("rawtypes")
        HashSet h = new HashSet(roleCodeList);
        roleCodeList.clear();
        roleCodeList.addAll(h);
        String hql = " from MisCategorypermission t where t.objectid in (:roleCodeList)";
        Query query = this.findByHQL(hql);
        query.setParameterList("roleCodeList", roleCodeList);
        List<MisCategorypermission> list = query.list();
        return list;
    }

    @Override
    public List<MisCategorypermission> findMisCategorypermissionByTypeAndMoudleId(Integer objecttype, Integer moduleid) {
        String hql = " from MisCategorypermission t where t.objecttype = '" + objecttype + "' and t.moduleid = '" + moduleid + "'  ";
        List<MisCategorypermission> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

    @Override
    public List<String> findOrgListByRoleCodeAndType(List<SysMemberRole> sysMemberRole, Integer objecttype) {
        List<String> roleCodeList = new ArrayList<String>();
        for (SysMemberRole d : sysMemberRole) {
            //TODO 对象强转 类型错误
            roleCodeList.add(String.valueOf(d.getId().getRoleCode()));
        }
        String roleCode = UtilTools.findSqlInSuffix(roleCodeList);
        //TODO 原则改动，改动唯一值成为集合
        //String hql = " from MisDatascopePermission t where t.objecttype = '"+objecttype+"' and t.objectid = '"+roleCode+"'";
        String hql = " from MisDatascopePermission t where t.objecttype = '" + objecttype + "' and t.objectid in " + roleCode + " ";
        List<MisDatascopePermission> list = new ArrayList<MisDatascopePermission>();
        list = aBaseDao.findByHQL(hql).list();
        List<String> orgList = new ArrayList<String>();
        for (MisDatascopePermission d : list) {
            orgList.add(d.getOrgId());
        }
        return orgList;
    }


}
