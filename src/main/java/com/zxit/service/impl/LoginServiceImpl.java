package com.zxit.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.LoginService;
import com.zxit.share.Constants;
import com.zxit.share.MD5FileUtil;
import com.zxit.share.SystemConfig;
import com.zxit.tools.MD5;
import com.zxit.tools.UtilDate;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SystemConfig systemConfig;

    @Override
    public SysMemberInfo login(String id, String password, String system) {
        /**
         * 外部访问
         * 1:受理台
         * 3:MIS
         */
        if ("1".equals(system) || "3".equals(system)) {

        } else {
            MD5 md5 = new MD5();
            if (password != null) {
                password = md5.getMD5ofStr(password);
            }
        }
        String hql = "from SysMemberInfo where  flag = 0 and id = '" + id + "' and password = '" + password + "'";
        Query query = aBaseDao.findByHQL(hql);
        SysMemberInfo sysMemberInfo = (SysMemberInfo) query.uniqueResult();
        return sysMemberInfo;
    }

    @Override
    public int logout(SysMemberInfo sysMemberInfo) {
        return 0;
    }

    @Override
    public String checkUser(SysMemberInfo sysMemberInfo, Integer orgType) {
        String err2login = "";
        if (systemConfig.getOnlyDoctorLogin() == 1) {//如果系统限定只有医生才能登陆
            if (!sysMemberInfo.getType().equals(40)) {//如果用户类型不是40 代表医生
                //TODO 如果又不是中心的人也不是分中心的人员
                if (orgType != Constants.center || orgType != Constants.scenter) { //如果又不是中心的人也不是分中心的人员
                    System.out.println(UtilDate.get4yMdHms(new Date()) + sysMemberInfo.getId() + "非医生，无登录权限！");
                    err2login = systemConfig.getErrNotDoctor();//返回错误信息
                    return err2login;
                }
            }
        }
        return "success";
    }

    @Override
    public String checkFile(String path, String checker) {
        String err2login = "";
        try {
            File file = new File(path);
            if (file.exists()) {
                String check = MD5FileUtil.getFileMD5String(file);
                if (!check.equals(checker)) {
                    err2login = "请支持正版软件！";
                    return err2login;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * 成功！
         */
        return "success";
    }

}
