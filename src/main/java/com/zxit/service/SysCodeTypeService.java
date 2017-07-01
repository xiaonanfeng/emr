package com.zxit.service;

import java.util.List;

import com.zxit.model.SysCodeType;


public interface SysCodeTypeService {

    public int findSysCodeTypeByName(String name);

    public SysCodeType findSysCodeTypeById(Integer id);

    public List<SysCodeType> findSysCodeType(SysCodeType sysCodeType);

}
