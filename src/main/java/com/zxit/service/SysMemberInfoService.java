package com.zxit.service;


import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;

import java.util.List;

/**
 * 人员信息
 *
 * @author Administrator
 */
public interface SysMemberInfoService {

    SysMemberInfo findSysMemberInfoById(String id);

    List<SysMemberInfo> findSysMemberInfoByType(Integer type, String orgId);

    String createMemberInfoSelect(TObject t, List<SysMemberInfo> listNurse);

    /**
     * 医生
     * 分中心负责人=急救科医护
     * 急救科负责人=质管科医护
     * 分中心领导
     *
     * @param memberList
     * @return
     */
    List<SysMemberInfo> findMembersByArr(List<String> memberList);

}
