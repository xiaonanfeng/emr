package com.zxit.action;

import java.util.Date;
import java.util.HashMap;
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
import com.zxit.model.MisEmrSePed;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrSePedService;
import com.zxit.share.Constants;

/**
 * 产科检查控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrSePed.do")
public class MisEmrSePedController {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrSePedService misEmrSePedService;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrSePed", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrSePed(
            MisEmrSePed misEmrSePed, HttpServletRequest request) {
        Map<String, String> m = new HashMap<String, String>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrSePed.getId());
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrSePed.setLastModifyTime(new Date());
        misEmrSePed.setCreateTime(new Date());
        misEmrSePed.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        misEmrSePed.toString();
        misEmrSePedService.saveMisEmrSePed(misEmrSePed);
        return null;
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrSePedById")
    public void findMisEmrSePedById(String id, HttpServletRequest request) {
        MisEmrSePed misEmrSePed = misEmrSePedService.findMisEmrSePedById(id);
        request.setAttribute("misEmrSePed", misEmrSePed);
    }


}
