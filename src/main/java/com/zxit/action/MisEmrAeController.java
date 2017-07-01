package com.zxit.action;

import java.util.Date;
import java.util.HashMap;
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
import com.zxit.model.MisEmrAe;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrAeService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysSelectMultiService;
import com.zxit.service.SysSelectService;
import com.zxit.share.Constants;

/**
 * 体格检查控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misEmrAe.do")
public class MisEmrAeController {

    @Resource
    private SysSelectService sysSelectService;
    @Resource
    private MisEmrAeService misEmrAeService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private SysSelectMultiService sysSelectMultiService;

    /**
     * 保存一个对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrAe", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrAe(
            MisEmrAe misEmrAe, HttpServletRequest request) {
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(misEmrAe.getId());
        Map<String, String> m = new HashMap<String, String>();
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrAe.setLastModifyTime(new Date());
        misEmrAe.setCreateTime(new Date());
        misEmrAe.setXzbm(((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getXzbm());
        //misEmrAe.toString();
        misEmrAeService.saveMisEmrAe(misEmrAe);
        return null;
    }

    /**
     * 基础信息查询控制器
     *
     * @param id
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrAeById")
    public void findMisEmrAeById(String id, HttpServletRequest request) {
        MisEmrAe misEmrAe = misEmrAeService.findMisEmrAeById(id);
        request.setAttribute("misEmrAe", misEmrAe);
    }


    /**
     * 创建多选组件
     *
     * @return
     */
    @RequestMapping(params = "method=findMultiSelects")
    public String findMultiSelects(HttpServletRequest request) {
        List<SysCode> list = sysCodeService.findSysCodeByPid(Constants.ecgDiag);

        List<String> values = java.util.Arrays.asList(request.getParameter("values").split(","));//转成list
        TObject t = new TObject();
        t.setSelectIdAndName("select");
        t.setInitStr(values);
        t.setObecjtName(Constants.sysCode);
        String select = sysSelectMultiService.createMultiSelect(t, list);
        request.setAttribute("select", select);
        return "chooser";
    }


    /**
     * 异步返回病情的 汉字
     *
     * @param str
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=findMisEmrAeInnerDiag", method = RequestMethod.GET)
    public String findMisEmrAeInnerDiag(String str) {
        String returnStr = "";
        if (str != null) {
            if (str.length() != 0) {
                String[] temp = str.split(",");
                for (int i = 0; i < temp.length; i++) {
                    String codeName = sysCodeService.findSysCodeByIdAndPid(Integer.parseInt(temp[i]), Constants.ecgDiag).getName();
                    returnStr += codeName + "        ";
                }
            }
        }
        return returnStr;
    }

}
