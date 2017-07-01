package com.zxit.service;

import java.util.List;

import com.zxit.model.MisCategorypermission;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysMemberRole;

public interface SysMemberRoleService {

    public List<SysMemberRole> findSysMemberRoleByMemberId(String memberId);

    public List<SysMemberRole> findSysMemberRoleByMemberAndCatepermison(List<MisCategorypermission> misCateList, SysMemberInfo sysMemberInfo);

}
