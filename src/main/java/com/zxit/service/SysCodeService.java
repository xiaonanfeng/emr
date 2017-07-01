package com.zxit.service;

import java.util.List;

import com.zxit.model.SysCode;


public interface SysCodeService {

    public SysCode findSysCodeById(Integer id);

    public SysCode findSysCodeByIdAndPid(Integer id, Integer pid);

    public String findSysCodeNameByIdAndPid(Integer id, Integer pid);

    public List<SysCode> findSysCode(SysCode sysCode);

    public List<SysCode> findSysCodeByPid(Integer pid);

}
