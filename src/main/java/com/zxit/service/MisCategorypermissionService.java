package com.zxit.service;

import java.util.List;

import com.zxit.model.MisCategorypermission;
import com.zxit.model.SysMemberRole;

public interface MisCategorypermissionService extends ABaseService {
    /**
     * 通过sysmemberRole的roleCode找到目录分配
     *
     * @param objId
     * @return
     */
    public List<MisCategorypermission> findMisCategorypermissionByRoleCode(Integer roleCode);

    /**
     * 通过权限集合集合找到不同的菜单
     *
     * @param roleCodeList
     * @return
     */
    public List<MisCategorypermission> findMisCategorypermissionByRoleCode(List<String> roleCodeList);

    /**
     * 通过type,moudleId找到category的集合
     *
     * @param i
     * @return
     */
    public List<MisCategorypermission> findMisCategorypermissionByTypeAndMoudleId(Integer objecttype, Integer moduleid);

    /**
     * 为修改申请找到orgList查询权限
     *
     * @param roleCode
     * @param id
     * @return
     */
    //public List<String> findOrgListByRoleCodeAndType(Integer roleCode,Integer objecttype);
    public List<String> findOrgListByRoleCodeAndType(List<SysMemberRole> sysMemberRole, Integer objecttype);

}
