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
import com.zxit.model.MisEmrSeOb;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrSeObService;
import com.zxit.share.Constants;

/**
 * 产科检查控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrSeOb.do")
public class MisEmrSeObController {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrSeObService misEmrSeObService;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrSeOb", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrSeOb(
            MisEmrSeOb misEmrSeOb, HttpServletRequest request) {
        Map<String, String> m = new HashMap<String, String>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrSeOb.getId());
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrSeOb.setLastModifyTime(new Date());
        misEmrSeOb.setCreateTime(new Date());
        misEmrSeOb.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        misEmrSeOb.toString();
        misEmrSeObService.saveMisEmrSeOb(misEmrSeOb);
        return null;
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrSeObById")
    public void findMisEmrSeObById(String id, HttpServletRequest request) {
        MisEmrSeOb misEmrSeOb = misEmrSeObService.findMisEmrSeObById(id);
        request.setAttribute("misEmrSeOb", misEmrSeOb);
    }


}
