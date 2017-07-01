package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.model.MisEmrChargeItems;
import com.zxit.model.MisEmrCharges;
import com.zxit.service.MisEmrChargeItemsService;
import com.zxit.service.MisEmrChargesService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysMemberInfoService;
import com.zxit.share.Constants;

@Service("misEmrChargesService")
public class MisEmrChargesServiceImpl extends ABaseServiceImpl implements MisEmrChargesService {

    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private MisEmrChargeItemsService misEmrChargeItemsService;
    @Resource
    private SysMemberInfoService sysMemberInfoService;

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrCharges> findMisEmrChargesListByEmrId(String emrId) {
        List<MisEmrCharges> list = this.findByHQL(" from MisEmrCharges t where t.emrId = '" + emrId + "' order by t.id desc").list();
        for (MisEmrCharges d : list) {
            d.setType_text(sysCodeService.findSysCodeNameByIdAndPid(d.getType(), Constants.CHARGES));//收费类型
            if (d.getItemcode() != null) {
                d.setItemcode(misEmrChargeItemsService.findById(MisEmrChargeItems.class, d.getItemcode()).getItemname());//收费项目
            }
            d.setReason_text(sysCodeService.findSysCodeNameByIdAndPid(d.getReasoncode(), Constants.BALANCE));//收费差原因
            d.setCollectorText(sysMemberInfoService.findSysMemberInfoById(d.getCollectorId()).getName());
        }
        return list;
    }


}
