package com.zxit.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.SysLogs;
import com.zxit.service.SysLogsService;
import com.zxit.share.CreaterPK;

/**
 * 系统日志服务类
 *
 * @author Administrator
 */
@Service("sysLogsService")
public class SysLogsServiceImpl implements SysLogsService {

    @Resource
    private ABaseDao aBaseDao;


    @Override
    public void saveSysCode(SysLogs sysLogs) {
        sysLogs.setId(CreaterPK.CreateSqPk(aBaseDao, "SEQ_SYS_LOG"));
        aBaseDao.saveOrUpdate(sysLogs);
    }


}
