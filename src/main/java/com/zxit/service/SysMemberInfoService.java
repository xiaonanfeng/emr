package com.zxit.service;


import java.util.List;

import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;

/**
 * 人员信息
 *
 * @author Administrator
 */
public interface SysMemberInfoService {

    public SysMemberInfo findSysMemberInfoById(String id);

    public List<SysMemberInfo> findSysMemberInfoByType(Integer type, String orgId);

    public String createMemberInfoSelect(TObject t, List<SysMemberInfo> listNurse);

    /**
     * 医生
     * 分中心负责人=急救科医护
     * 急救科负责人=质管科医护
     * 分中心领导
     *
     * @param memberList
     * @return
     */
    public List<SysMemberInfo> findMembersByArr(List<String> memberList);

}
