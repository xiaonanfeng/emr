package com.zxit.action;

import javax.annotation.Resource;

import com.zxit.service.MisEmrMdfreqService;

/**
 * 自动驳回修改申请控制器
 *
 * @author Administrator
 *         autoRec;// 是否自动审核
 *         recTimeScope;// 查询需要自动审核的病例修改申请时间跨度（小时）
 */
public class VMisEmrMdfReqController {

    @Resource
    private MisEmrMdfreqService misEmrMdfreqService;

    private Integer autoRec;// 是否自动审核
    private Integer recTimeScope;// 查询需要自动审核的病例修改申请时间跨度（小时）

    public Integer getAutoRec() {
        return autoRec;
    }

    public void setAutoRec(Integer autoRec) {
        this.autoRec = autoRec;
    }

    public Integer getRecTimeScope() {
        return recTimeScope;
    }

    public void setRecTimeScope(Integer recTimeScope) {
        this.recTimeScope = recTimeScope;
    }

    /**
     * 自动驳回方法
     */
    public void recEmrMdfReq() {
        if (autoRec == 1) {
            misEmrMdfreqService.findEmrMdfRq2Rec(recTimeScope);
        }
    }

}
