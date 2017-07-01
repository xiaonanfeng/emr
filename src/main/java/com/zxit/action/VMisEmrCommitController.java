package com.zxit.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.zxit.model.VMisEmrCommit;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrMdfreqService;
import com.zxit.service.VMisEmrCommitService;
import com.zxit.tools.UtilDate;

public class VMisEmrCommitController {

    @Resource
    private VMisEmrCommitService vMisEmrCommitService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrMdfreqService misEmrMdfreqService;

    private Integer autoCommit;//是否自动提交
    private Integer commitTimeScope;//查询需要提交的病例时间跨度（小时）

    public Integer getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Integer autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Integer getCommitTimeScope() {
        return commitTimeScope;
    }

    public void setCommitTimeScope(Integer commitTimeScope) {
        this.commitTimeScope = commitTimeScope;
    }

    public void commitEmr() {
        //TODO 这里有个BUG，如果填完就提交的话，很麻烦。我还没想好怎么做。
        if (autoCommit == 1) {//如果打开自动提交，
            List<VMisEmrCommit> list = vMisEmrCommitService.findEmr2Commit(commitTimeScope);
            System.out.println(UtilDate.get4yMdHms(new Date()) + "：发现" + list.size() + "条病例以超过提交时限！");
            for (VMisEmrCommit d : list) {
                //且该病历在审核记录中没有信息 或者 已经审核通过并且超过再提交时限
                if (misEmrMdfreqService.findPrvdEmrByEmrId(d.getId(), new Date())) {
                    vMisEmrCommitService.commitEmr(d.getId());
                }
            }
        } else {
            System.out.println("自动提交未开启");
        }

    }

}
