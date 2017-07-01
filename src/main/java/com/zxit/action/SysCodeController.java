package com.zxit.action;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxit.model.SysCode;
import com.zxit.service.SysCodeService;

/**
 * 编码类型
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/sysCode.do")
public class SysCodeController {

    @Resource
    private SysCodeService sysCodeService;

    /**
     * 获得一个信息系统对象
     */
    @RequestMapping(params = "method=findSysCodeById")
    public String findSysCodeById(Integer id, HttpServletRequest request) {
        SysCode sysCode = sysCodeService.findSysCodeById(id);
        request.setAttribute("obj", sysCode);
        return "business/SysCode/save";
    }


}
