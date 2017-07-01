package com.zxit.service;

import com.zxit.model.SysMemberInfo;


public interface LoginService {
    /**
     * 查找用户
     * 第三方登录
     *
     * @param id
     * @param password
     * @param system
     * @return
     */
    public SysMemberInfo login(String id, String password, String system);

    /**
     * 验证系统文件
     *
     * @param path
     * @return
     */
    public String checkFile(String path, String checker);

    /**
     * 验证用户类型
     *
     * @param sysMemberInfo
     * @return
     */
    public String checkUser(SysMemberInfo sysMemberInfo, Integer orgType);

    /**
     * 登出
     *
     * @param sysMemberInfo
     * @return
     */
    public int logout(SysMemberInfo sysMemberInfo);

}
