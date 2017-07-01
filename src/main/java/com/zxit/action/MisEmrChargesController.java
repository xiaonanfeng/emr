package com.zxit.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrChargeItems;
import com.zxit.model.MisEmrCharges;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrOutdStaff;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrChargeItemsService;
import com.zxit.service.MisEmrChargesService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysSelectService;
import com.zxit.service.VMisEmrOutdStaffService;
import com.zxit.share.Constants;
import com.zxit.share.CreaterPK;

@Controller
@RequestMapping("/misEmrCharges.do")
public class MisEmrChargesController {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrChargesService misEmrChargesService;
    @Resource
    private MisEmrChargeItemsService misEmrChargeItemsService;
    @Resource
    private SysSelectService sysSelectService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private VMisEmrOutdStaffService vMisEmrOutdStaffService;

    /**
     * 病历ID集合查询控制器
     * 收费流水
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrChargesListByEmrId")
    public String findMisEmrChargesListByEmrId(String emrId, HttpServletRequest request) {
        //生成收费单ID
        String id = CreaterPK.CreatePK();
        request.setAttribute("id", id);
        //基础信息
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);

        //收费类别  从syscode里面初始化
        TObject t = new TObject();
        t.setSelectIdAndName("type");//id和name
        List<SysCode> listCharges = sysCodeService.findSysCodeByPid(Constants.CHARGES);
        String type = sysSelectService.CreateSelect(t, listCharges);
        request.setAttribute("type", type);


        //欠费原因
        List<SysCode> reasonList = sysCodeService.findSysCodeByPid(Constants.BALANCE);
        t.setSelectIdAndName("reasoncode");
        String reasoncode = sysSelectService.CreateSelect(t, reasonList);
        request.setAttribute("reasoncode", reasoncode);

        //随车收费人集合
        List<VMisEmrOutdStaff> colleList = vMisEmrOutdStaffService.findVMisEmrOutdStaffByEmrId(emrId);
        t.setSelectIdAndName("collectorId");
        String collectorId = vMisEmrOutdStaffService.createColleSelect(t, colleList);
        request.setAttribute("collectorId", collectorId);

        //现有的收费记录
        List<MisEmrCharges> list = misEmrChargesService.findMisEmrChargesListByEmrId(emrId);
        request.setAttribute("list", list);// 初始化基础显示项
        if (list.size() != 0) {
            //已经存在的收费人
            String collId = list.get(0).getCollectorId();
            request.setAttribute("exitMan", collId);
        }

        return "/business/list_MisEmrCharges_table";
    }

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrCharges", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrCharges(
            MisEmrCharges misEmrCharges, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME));
        misEmrCharges.setLastModifyTime(new Date());
        misEmrCharges.setCreateTime(new Date());
        misEmrCharges.setCreateUserid(sysMemberInfo.getId());
        misEmrCharges.setModifyUserid(sysMemberInfo.getId());
        misEmrCharges.setXzbm(sysMemberInfo.getXzbm());
        misEmrChargesService.saveOrUpdate(misEmrCharges);
        return null;
    }


    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=delMisEmrChargesById", method = RequestMethod.POST)
    public Map<String, String> delMisEmrChargesById(String id, HttpServletRequest request) {
        //Map<String,String> map = new HashMap<String, String>();
        misEmrChargesService.deleteById(MisEmrCharges.class, id);
        return null;
    }


    /**
     * 第二级下拉菜单选择器
     *
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisEmrChargesItems", method = RequestMethod.POST)
    public String findMisEmrChargesItems(String code) {
        if ("".equals(code) || null == code || "null".equals(code)) {
            code = "0";
        }
        TObject t = new TObject();
        t.setSelectIdAndName("itemcode");//id和name
        List<MisEmrChargeItems> list = misEmrChargeItemsService.findMisEmrChargeItems(code);
        String itemcode = misEmrChargeItemsService.createChargeSelect(t, list);
        return itemcode;
    }

    /**
     * ID查询控制器
     *
     * @param id
     * @param request
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisEmrChargesById")
    public MisEmrCharges findMisEmrChargesById(String id, HttpServletRequest request) {
        MisEmrCharges misEmrCharges = misEmrChargesService.findById(MisEmrCharges.class, id);
        request.setAttribute("misEmrCharges", misEmrCharges);// 初始化基础显示项
        return misEmrCharges;
    }


}
