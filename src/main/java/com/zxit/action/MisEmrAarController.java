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
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisAmEmArticles;
import com.zxit.model.MisEmrAar;
import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.VMisEmrAar;
import com.zxit.service.MisAmEmArticlesService;
import com.zxit.service.MisEmrAarService;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.share.Constants;
import com.zxit.tools.ServletParameter;
import com.zxit.tools.UtilTools;

@Controller
@RequestMapping("/misEmrAar.do")
public class MisEmrAarController {

    @Resource
    private MisAmEmArticlesService misAmEmArticlesService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisEmrAarService misEmrAarService;

    /**
     * 保存耗材应用
     *
     * @param jsonStr
     * @param emrId
     * @param request
     * @return
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisAmEmAar")
    public Map<String, String> saveMisAmEmAar(String jsonStr, String emrId, HttpServletRequest request) {

        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        Integer xzbm = sysMemberInfo.getXzbm();
        /**
         * 转换misEmrMar用药对象
         */
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        List<MisEmrAar> list = UtilTools.convertToList(jsonArray, MisEmrAar.class);
        for (MisEmrAar d : list) {
            d.setEmrId(emrId);
            d.setCreateTime(new Date());
            d.setLastModifyTime(new Date());
            d.setXzbm(xzbm);
        }
        Map<String, String> m = new HashMap<String, String>();
        MisEmrBasicinfo noBase = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        if (noBase == null) {
            m.put("err", "请您先填写相应的基础信息项！");
            return m;
        }
        misEmrAarService.save(list.toArray());
        return null;
    }

    /**
     * 列举耗材列表
     *
     * @param emrId
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findmisAmEmArticles")
    public String findmisAmEmArticles(HttpServletRequest request) {
        //最大批次
        Integer maxGrp = misEmrAarService.findMaxGrpInOneAar(ServletParameter.getParameter(request, "emrId", ""));
        request.setAttribute("maxGrp", String.valueOf(Math.floor(maxGrp)));

        List<MisAmEmArticles> list = misAmEmArticlesService.findAll(MisAmEmArticles.class);
        request.setAttribute("list", list);
        return "/business/list_MisAmEmArticlesForInput";
    }


    /**
     * 列举在用的耗材列表
     *
     * @param emrId
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findmisEmrAarInUse")
    public String findmisEmrAarInUse(String emrId, HttpServletRequest request) {
        //是不是本人填写的药物判断
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        if (misEmrBasicinfo != null) {
            String createuserid = misEmrBasicinfo.getCreateuserid();
            request.setAttribute("createuserid", createuserid);
            Integer isCommited = misEmrBasicinfo.getIsCommitted();
            request.setAttribute("isCommited", isCommited);
        }
        List<VMisEmrAar> list = misEmrAarService.findmisEmrAarInUse(emrId);

        request.setAttribute("list", list);
        return "/business/list_MisEmrAar";
    }

    /**
     * 删除耗材使用记录
     *
     * @param id
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(params = "method=delMisEmrAarById")
    public String delMisEmrAarById(Long id, HttpServletRequest request) {
        misEmrAarService.deleteById(MisEmrAar.class, id);
        return null;
    }


}
