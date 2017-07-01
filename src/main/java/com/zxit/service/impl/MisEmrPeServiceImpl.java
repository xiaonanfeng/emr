package com.zxit.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrPe;
import com.zxit.service.MisEmrPeService;
import com.zxit.service.SysCodeService;
import com.zxit.share.Constants;

@Service("misEmrPeService")
public class MisEmrPeServiceImpl implements MisEmrPeService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SysCodeService sysCodeService;

    @Override
    public void saveMisEmrPe(MisEmrPe misEmrPe) {
        aBaseDao.saveOrUpdate(misEmrPe);
    }

    @Override
    public void delMisEmrPeById(String id) {
        aBaseDao.deleteById(MisEmrPe.class, id);
    }

    @Override
    public MisEmrPe findMisEmrPeById(String id) {
        MisEmrPe misEmrPe = aBaseDao.findById(MisEmrPe.class, id);
        return misEmrPe;
    }

    @Override
    public String getEyeString(String emrId) {
        MisEmrPe misEmrPe = findMisEmrPeById(emrId);
        String pl = "左侧：";
        if (misEmrPe.getHnEyeL() == null && misEmrPe.getHnPlrL() == null) {
            pl = sysCodeService.findSysCodeByIdAndPid(misEmrPe.getHnEyeTestL(), Constants.chkStat).getName();
        } else {
            if (misEmrPe.getHnEyeL() != null) {
                pl = pl + misEmrPe.getHnEyeL() + "mm；";
            }
            if (misEmrPe.getHnPlrL() != null) {
                pl = pl + "对光反射" + sysCodeService.findSysCodeByIdAndPid(misEmrPe.getHnPlrL(), Constants.plr).getName() + "。";
            }
        }

        String pr = "右侧：";
        if (misEmrPe.getHnEyeR() == null && misEmrPe.getHnPlrR() == null) {
            pr = sysCodeService.findSysCodeByIdAndPid(misEmrPe.getHnEyeTestR(), Constants.chkStat).getName();
        } else {
            if (misEmrPe.getHnEyeR() != null) {
                pr = pr + misEmrPe.getHnEyeR() + "mm；";
            }
            if (misEmrPe.getHnPlrL() != null) {
                pr = pr + "对光反射" + sysCodeService.findSysCodeByIdAndPid(misEmrPe.getHnPlrR(), Constants.plr).getName() + "。";
            }
        }
        String pupil = pl + pr;
        return pupil;
    }


}
