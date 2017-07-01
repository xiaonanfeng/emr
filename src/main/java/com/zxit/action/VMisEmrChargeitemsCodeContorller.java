package com.zxit.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisEmrChargesNote;
import com.zxit.service.MisEmrChargesNoteService;
import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrChargesTable;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrChargeitemsCode;
import com.zxit.model.VMisEmrOutdStaff;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysSelectService;
import com.zxit.service.VMisEmrChargeitemsCodeService;
import com.zxit.service.MisEmrChargesTableService;
import com.zxit.service.VMisEmrOutdStaffService;
import com.zxit.share.Constants;
import com.zxit.tools.UtilTools;

@Controller
@RequestMapping("/vMisEmrChargeitemsCode.do")
public class VMisEmrChargeitemsCodeContorller {

    @Resource
    private VMisEmrChargeitemsCodeService vMisEmrChargeitemsCodeService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private SysSelectService sysSelectService;
    @Resource
    private VMisEmrOutdStaffService vMisEmrOutdStaffService;
    @Resource
    private MisEmrChargesTableService misEmrChargesTableService;
    @Resource
    private MisEmrChargesNoteService misEmrChargesNoteService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;


    @RequestMapping(params = "method=findVMisEmrChargeitemsCode")
    public String findVMisEmrChargeitemsCode(String emrId, HttpServletRequest request) {
        /**
         * 病历基本信息
         */
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);
        /***
         * 初始化欠费原因，随车人员下拉框
         */
        TObject t = new TObject();
        //欠费原因
        List<SysCode> reasonList = sysCodeService.findSysCodeByPid(Constants.BALANCE);
        t.setSelectIdAndName("reasoncode");
        String reasoncode = sysSelectService.CreateSelect(t, reasonList);
        request.setAttribute("reasoncode", reasoncode);
        /**
         * 收费类型
         */
        List<SysCode> chargeKindList = sysCodeService.findSysCodeByPid(Constants.CHARGEKIND);
        t.setSelectIdAndName("chargeKind");
        String chargekind = sysSelectService.CreateSelect(t, chargeKindList);
        request.setAttribute("chargeKind", chargekind);

        System.out.println("欠费原因……");
        //随车收费人集合
        List<VMisEmrOutdStaff> colleList = vMisEmrOutdStaffService.findVMisEmrOutdStaffByEmrId(emrId);
        t.setSelectIdAndName("collectorId");
        String collectorId = vMisEmrOutdStaffService.createColleSelect(t, colleList);
        request.setAttribute("collectorId", collectorId);
        System.out.println("随车收费人集合……");

        //随车默认值：如果没有收费人就默认司机
        String coller = vMisEmrOutdStaffService.findAutoColler(emrId);
        request.setAttribute("coller", coller);
        System.out.println("随车默认值……");
        /**
         * 收费明细基础数据
         */
        List<VMisEmrChargeitemsCode> list = vMisEmrChargeitemsCodeService.findAll(VMisEmrChargeitemsCode.class);
        request.setAttribute("list", list);
        System.out.println("收费明细基础数据……");
        /**
         * 收费情况
         */
        MisEmrChargesTable misEmrChargesTable = misEmrChargesTableService.findById(MisEmrChargesTable.class, emrId);
        request.setAttribute("misEmrChargesTable", misEmrChargesTable);
        System.out.println("收费情况……");
        /**
         * 收费明细业务数据
         */
        List<MisEmrChargesNote> misEmrChargesNoteList = misEmrChargesNoteService.findMisEmrChargesNoteByEmrId(emrId);
        request.setAttribute("misEmrChargesNoteList", misEmrChargesNoteList);
        System.out.println("收费明细业务数据……");

        return "/business/list_MisEmrCharges_TABLE";
    }


    /**
     * 存储
     *
     * @param misEmrChargesTable    主表对象
     * @param misEmrChargesNoteJson 从表JSON字符串
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrChargesTable", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrChargesTable(
            MisEmrChargesTable misEmrChargesTable, String misEmrChargesNoteJson, HttpServletRequest request) {
        @SuppressWarnings("unused")
        Map<String, String> map = new HashMap<String, String>();
        /**
         *保存收费主表
         */
        SysMemberInfo sysMemberInfo = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME));
        misEmrChargesTable.setLastModifyTime(new Date());
        misEmrChargesTable.setCreateTime(new Date());
        misEmrChargesTable.setCreateUserid(sysMemberInfo.getId());
        misEmrChargesTable.setModifyUserid(sysMemberInfo.getId());
        misEmrChargesTable.setXzbm(sysMemberInfo.getXzbm());
        misEmrChargesTableService.saveOrUpdate(misEmrChargesTable);
        /**
         * 保存从表
         */
        JSONArray jsonArray = JSONArray.fromObject(misEmrChargesNoteJson);
        List<MisEmrChargesNote> misEmrChargesNoteList = UtilTools.convertToList(jsonArray, MisEmrChargesNote.class);
        for (MisEmrChargesNote d : misEmrChargesNoteList) {
            //TODO 这个地方有BUG，如果主键过长会写不进去  主键=病历ID+收费type+收费itemcode
            misEmrChargesNoteService.saveOrUpdate(d);
        }

        return null;
    }


}
