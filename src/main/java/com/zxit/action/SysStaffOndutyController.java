package com.zxit.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxit.model.SysStaffOnduty;
import com.zxit.service.SysStaffOndutyService;


@Controller
@RequestMapping("/sysStaffOnduty.do")
public class SysStaffOndutyController {

    @Resource
    private SysStaffOndutyService sysStaffOndutyService;

    @RequestMapping(params = "method=findSysStaffOndutyByUnqIndex")
    public SysStaffOnduty findSysStaffOndutyByUnqIndex(String gh, Integer flag) {
        SysStaffOnduty sysStaffOnduty = sysStaffOndutyService.findSysStaffOndutyByUnqIndex(gh, flag);
        return sysStaffOnduty;
    }

}
