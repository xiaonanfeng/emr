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
import com.zxit.model.MisEmrSeGyn;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrSeGynService;
import com.zxit.share.Constants;

/**
 * 妇科检查控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrSeGyn.do")
public class MisEmrSeGynController {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrSeGynService misEmrSeGynService;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrSeGyn", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrSeGyn(
            MisEmrSeGyn misEmrSeGyn, HttpServletRequest request) {
        Map<String, String> m = new HashMap<String, String>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrSeGyn.getId());
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrSeGyn.setLastModifyTime(new Date());
        misEmrSeGyn.setCreateTime(new Date());
        misEmrSeGyn.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        misEmrSeGyn.toString();
        misEmrSeGynService.saveMisEmrSeGyn(misEmrSeGyn);
        return null;
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrSeGynById")
    public void findMisEmrSeGynById(String id, HttpServletRequest request) {
        MisEmrSeGyn misEmrSeGyn = misEmrSeGynService.findMisEmrSeGynById(id);
        request.setAttribute("misEmrSeGyn", misEmrSeGyn);
    }


}
