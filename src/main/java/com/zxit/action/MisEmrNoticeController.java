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
import com.zxit.model.MisEmrNotice;
import com.zxit.model.MisEmrNoticeItem;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.VMisEmrQuery;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrNoticeService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VMisEmrQueryService;
import com.zxit.share.Constants;
import com.zxit.share.SystemConfig;

@Controller
@RequestMapping("/misEmrNotice.do")
public class MisEmrNoticeController {

    @Resource
    private SystemConfig systemConfig;
    @Resource
    private MisEmrNoticeService misEmrNoticeService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private SysCodeService sysCodeService;//基础代码服务
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private VMisEmrQueryService vMisEmrQueryService;

    /**
     * 初始化需要显示的告知内容
     * 初始化需要显示的病例基础信息
     *
     * @param id      病人ID
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findMisEmrNoticeItemAndContext")
    public String findMisEmrNoticeItemAndContext(String id, String print, HttpServletRequest request) {
        /**
         * 获取需要显示的病例告知列表
         */
        List<MisEmrNoticeItem> list = misEmrNoticeService.findMisEmrNoticeItem(systemConfig.getXzbm());
        request.setAttribute("list", list);

        /**
         * 获取病例基础信息
         */
        VMisEmrQuery vMisEmrQuery = vMisEmrQueryService.findVMisEmrQueryById(id);
        if (vMisEmrQuery != null) {
            request.setAttribute("szfz", sysOrgInfoService.findSysOrgInfoById(vMisEmrQuery.getSzfz()).getName());//出诊急救站
            request.setAttribute("sentTo", sysOrgInfoService.findSysOrgInfoById(vMisEmrQuery.getSentTo()).getName());
        }

        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(id);
        request.setAttribute("misEmrBasicinfo", misEmrBasicinfo);
        if (misEmrBasicinfo != null) {
            request.setAttribute("name", misEmrBasicinfo.getName());//姓名
            request.setAttribute("sex", sysCodeService.findSysCodeNameByIdAndPid(misEmrBasicinfo.getSex(), Constants.sex));//性别
        }
        /**
         * 初始化病情告知内容
         */
        MisEmrNotice misEmrNotice = misEmrNoticeService.findMisEmrNoticeById(id);
        request.setAttribute("misEmrNotice", misEmrNotice);
        if (print != null && print.equals("1")) {
            return "/print/print_notice";
        }
        return "/business/MIS_EMR_NOTICE";
    }


    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrNotice", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrNotice(MisEmrNotice misEmrNotice, HttpServletRequest request) {
        misEmrNotice.setLastModifyTime(new Date());
        misEmrNotice.setCreateTime(new Date());
        misEmrNotice.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        misEmrNoticeService.saveMisEmrNotice(misEmrNotice);
        return null;
    }

    //00958


}
