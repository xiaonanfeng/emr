package com.zxit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxit.model.SysCode;
import com.zxit.model.SysCodeType;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysCodeTypeService;

/**
 * 编码类型
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/sysCodeType.do")
public class SysCodeTypeController {

    @Resource
    private SysCodeTypeService sysCodeTypeService;
    @Resource
    private SysCodeService sysCodeService;


    /**
     * 获得一个信息系统对象
     */
    @RequestMapping(params = "method=findSysCodeTypeById")
    public String findSysCodeTypeById(Integer id, HttpServletRequest request) {
        SysCodeType sysCodeType = sysCodeTypeService.findSysCodeTypeById(id);
        request.setAttribute("obj", sysCodeType);
        return "business/SysCodeType/save";
    }

    /**
     * @param name系统名称
     * @param request
     * @return
     */

    @RequestMapping(params = "method=findSysCodeType")
    public String findSysCodeType(SysCodeType sysCodeType, HttpServletRequest request) {
        List<SysCodeType> list = sysCodeTypeService.findSysCodeType(sysCodeType);
        request.setAttribute("list", list);
        /**
         * dtree构造方法
         * d.add(id, pid, name, url, title, target, icon, iconOpen, open);
         */
        return "business/SysCode/list";
    }

    /**
     * 通过id和父id找到
     * syscodetype
     * syscode
     *
     * @param id
     * @param pid
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findCodeTypeOrCodeByIdAndPid")
    public String findCodeTypeOrCodeByIdAndPid(Integer id, Integer pid, HttpServletRequest request) {
        //"000".substring(0, 100);
        request.setAttribute("id", id);
        request.setAttribute("pid", pid);

        /****获得codelist*****/
        SysCode sysCode = new SysCode();
        SysCodeType sysCodeType = new SysCodeType();
        sysCodeType.setTypeid(id);
        sysCode.setSysCodeType(sysCodeType);
        List<SysCode> codeList = sysCodeService.findSysCode(sysCode);//找到自己的集合先
        request.setAttribute("codeList", codeList);

        /****获得typelist*****/
        SysCodeType sysCodeType2 = new SysCodeType();
        sysCodeType2.setTypeid(id);
        List<SysCodeType> typeList = sysCodeTypeService.findSysCodeType(sysCodeType2);
        request.setAttribute("typeList", typeList);
        return "business/SysCode/save";
    }


}
