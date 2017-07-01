package com.zxit.action;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zxit.share.Constants;
import com.zxit.share.Pager;
import com.zxit.share.SystemConfig;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.SysOrgInfo;
import com.zxit.model.TObject;
import com.zxit.model.VAcceptAmbulOutdInfo;
import com.zxit.model.VAcceptAmbulOutdInfoId;
import com.zxit.service.SysOrgInfoService;
import com.zxit.service.VAcceptAmbulOutdInfoService;

@Controller
@RequestMapping("/vAcceptAmbulOutdInfo.do")
public class VAcceptAmbulOutdInfoController {

    @Resource
    private VAcceptAmbulOutdInfoService vAcceptAmbulOutdInfoService;
    @Resource
    private SysOrgInfoService sysOrgInfoService;
    @Resource
    private SystemConfig systemConfig;


    /**
     * 页面执行条件
     *
     * @param vAcceptAmbulOutdInfo
     * @param request
     */
    private void prepareHandler(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo, HttpServletRequest request) {
        request.setAttribute("vAcceptAmbulOutdInfo", vAcceptAmbulOutdInfo);// 这是一个查询对象，别弄混了。为了保留页面查询信息存在的
        //TODO WARNING如果车辆ID获取SZFZ为空，会导致这里分页出错。据说这里不会是空
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        //查询条件放入当前单位
        String orgId = sysMemberInfo.getSysOrgInfo().getOrgId(); // sysMemberInfo
        vAcceptAmbulOutdInfo.setOrgId(orgId);
        //放入个人ID
        vAcceptAmbulOutdInfo.setMemberId(sysMemberInfo.getId());
        //放入所在单位类型
        Integer orgType = null;
        orgType = sysMemberInfo.getSysOrgInfo().getType();
        vAcceptAmbulOutdInfo.setOrgType(orgType);
        //放入值班车辆ID
        String clid = (String) request.getSession().getAttribute("zbclid");
        vAcceptAmbulOutdInfo.setClid(clid);
        /**
         * 为分中心、分站创建汉字内容
         */
        String ssjgmc = "";
        if (orgType == Constants.scenter) {//		如果是分中心，则显示当前名称
            vAcceptAmbulOutdInfo.setSsjgdm(orgId);
            ssjgmc = sysOrgInfoService.findSysOrgInfoById(orgId).getName();
        }
        if (orgType == Constants.station) {//如果是分站，则显示所属单位名称
            String temp_id = sysOrgInfoService.findSysOrgInfoById(orgId).getSsjgdm();
            if (systemConfig.getShareMode() == 1) {
                vAcceptAmbulOutdInfo.setSsjgdm(temp_id);
            }
            ssjgmc = sysOrgInfoService.findSysOrgInfoById(temp_id).getName();
        }
        request.setAttribute("ssjgmc", ssjgmc);
        //为中心创建内容是中心+分中心的第一级下拉菜单
        TObject ssjgdm = new TObject("ssjgdm", "", "");
        List<SysOrgInfo> ssjgdmList = sysOrgInfoService.findScenter4Center();
        request.setAttribute("ssjgdm", sysOrgInfoService.createSysOrgSelect(ssjgdm, ssjgdmList));
    }

    /**
     * 警情查询控制器
     */
    @RequestMapping(params = "method=findVAcceptAmbulOutdInfo")
    public String findVAcceptAmbulOutdInfo(VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo, HttpServletRequest request) {
        this.prepareHandler(vAcceptAmbulOutdInfo, request);
        String path = (String) request.getSession().getAttribute(Constants.PATH);

        //声明HQL
        String hql = "";
        if ("web".equals(path)) {// web查询
            hql = vAcceptAmbulOutdInfoService.createWebHQL(vAcceptAmbulOutdInfo);
        } else {// pad查询
            hql = vAcceptAmbulOutdInfoService.createPadHQL(vAcceptAmbulOutdInfo);
        }
        int dataPerPage = systemConfig.getMaxPerPage();// 最大页码
        Pager pager = new Pager();// 对象声明
        pager.SetPerNum(dataPerPage);// 装载对象最大页面
        System.out.println(hql);
        pager.Init(vAcceptAmbulOutdInfoService.findCount(hql), request);// 总量，request对象
        String nva = pager.getStr();// 生成分页字符串
        List<VAcceptAmbulOutdInfo> list = null;
        list = vAcceptAmbulOutdInfoService.findVAcceptAmbulOutdInfoPager(hql, pager.getStartPos(), dataPerPage);
        request.setAttribute("list", list);
        request.setAttribute("nva", nva); // request到页面);


        return "/business/list_accept";// 转向一次出车的所有病历列表

    }

    /**
     * 根据第一级单位选择器
     * 生成第二级下拉菜单
     *
     * @param orgId
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=findSzfz4Scenter", method = RequestMethod.POST)
    public String findSzfz4Scenter(String orgId, HttpServletRequest request) {
        String select = "";
        //所在分站
        TObject szfz = new TObject("szfz", "", "");
        List<SysOrgInfo> orgList = sysOrgInfoService.findSzfz4Scenter(orgId);
        select = sysOrgInfoService.createSysOrgSelect(szfz, orgList);
        return select;
    }


    /**
     * 接处警、出车信息项
     */
    @RequestMapping(params = "method=findVAcceptAmbulOutdInfoById")
    public void findVAcceptAmbulOutdInfoById(String lsh, Integer ccxh, HttpServletRequest request) {
        VAcceptAmbulOutdInfoId vAcceptAmbulOutdInfoId = new VAcceptAmbulOutdInfoId(lsh, ccxh);//生成ID先
        VAcceptAmbulOutdInfo vAcceptAmbulOutdInfo = vAcceptAmbulOutdInfoService.findVAcceptAmbulOutdInfoById(vAcceptAmbulOutdInfoId);
        request.setAttribute("vAcceptAmbulOutdInfo", vAcceptAmbulOutdInfo);// 初始化现有数据项
    }


}
