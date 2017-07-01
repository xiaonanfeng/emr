package com.zxit.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zxit.model.VMisEmrCommit;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.VMisEmrCommitService;
import com.zxit.share.Constants;

@Component
public class VMisEmrCommitController {

	@Resource
	private VMisEmrCommitService vMisEmrCommitService;
	@Resource
	private MisEmrBasicinfoService misEmrBasicinfoService;
	
	@Scheduled(cron="0/10 * *  * * ? ")   //每30秒执行一次  
	public void commitEmr(){
		if(Constants.InterCommit == 1){
			List<VMisEmrCommit> list = vMisEmrCommitService.findEmr2Commit(Constants.commitTimeScope);
			for(VMisEmrCommit d:list){
				String sql = "update MIS_EMR_BASICINFO t set t.IS_COMMITTED = 1 where t.id = '"+d.getId()+"' ";
				vMisEmrCommitService.commitEmr(sql);
			}
		}else{
			
		}
	}
	
}
