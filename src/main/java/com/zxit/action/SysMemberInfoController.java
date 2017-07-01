package com.zxit.action;

import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.service.SysMemberInfoService;
import com.zxit.share.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/sysMemberInfo.do")
public class SysMemberInfoController {

    @Resource
    private SysMemberInfoService sysMemberInfoService;

    @ResponseBody
    @RequestMapping(params = "method=findMemberSelectByOrgId")
    public String findMemberSelectByOrgId(String orgId) {
        TObject tObject = new TObject();
        tObject.setStyle("select_short");//半个select
        List<SysMemberInfo> listMember;
        //医生select
        listMember = sysMemberInfoService.findSysMemberInfoByType(Constants.doctorSign, orgId);
        tObject.setSelectIdAndName("ysid");
        String docsList = sysMemberInfoService.createMemberInfoSelect(tObject, listMember)+"/";

        //护士select
        listMember = sysMemberInfoService.findSysMemberInfoByType(Constants.nurseSign, orgId);
        tObject.setSelectIdAndName("nurse");
        String nurseList = sysMemberInfoService.createMemberInfoSelect(tObject, listMember);
        nurseList = nurseList.length()==0?"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;":nurseList;
        nurseList = nurseList+"/";

        listMember = sysMemberInfoService.findSysMemberInfoByType(Constants.driverSign, orgId);
        tObject.setSelectIdAndName("driver");
        String driverList = sysMemberInfoService.createMemberInfoSelect(tObject, listMember);

        return docsList+nurseList+driverList;
    }

}
