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
import com.zxit.model.MisEmrSeTruma;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrSeTrumaService;
import com.zxit.share.Constants;

/**
 * 创伤检查控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrSeTruma.do")
public class MisEmrSeTrumaController {

    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrSeTrumaService misEmrSeTrumaService;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrSeTruma", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrSeTruma(
            MisEmrSeTruma misEmrSeTruma, HttpServletRequest request) {
        Map<String, String> m = new HashMap<String, String>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrSeTruma.getId());
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrSeTruma.setLastModifyTime(new Date());
        misEmrSeTruma.setCreateTime(new Date());
        misEmrSeTruma.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        misEmrSeTruma.toString();
        misEmrSeTrumaService.saveMisEmrSeTruma(misEmrSeTruma);
        return null;
    }


    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrSeTrumaById")
    public void findMisEmrSeTrumaById(String id, HttpServletRequest request) {
        MisEmrSeTruma misEmrSeTruma = misEmrSeTrumaService.findMisEmrSeTrumaById(id);
        request.setAttribute("misEmrSeTruma", misEmrSeTruma);
    }


}
