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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisAmEmMedicine;
import com.zxit.model.MisEmrBasicinfo;
import com.zxit.model.MisEmrMar;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.model.TObject;
import com.zxit.model.VMisEmrMarMedicine;
import com.zxit.service.MisAmEmMedicineService;
import com.zxit.service.MisEmrBasicinfoService;
import com.zxit.service.MisEmrMarService;
import com.zxit.service.SysCodeService;
import com.zxit.service.SysSelectService;
import com.zxit.share.Constants;
import com.zxit.tools.ServletParameter;
import com.zxit.tools.UtilTools;


@Controller
@RequestMapping("/misEmrMar.do")
public class MisEmrMarController {

    @Resource
    private MisEmrMarService misEmrMarService;
    @Resource
    private SysCodeService sysCodeService;
    @Resource
    private SysSelectService sysSelectService;
    @Resource
    private MisEmrBasicinfoService misEmrBasicinfoService;
    @Resource
    private MisAmEmMedicineService misAmEmMedicineService;

    /**
     * 保存一个药物应用对象
     */
    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED)
    @RequestMapping(params = "method=saveMisEmrMisEmrMar", method = RequestMethod.POST)
    public Map<String, String> saveMisEmrMisEmrMar(String jsonStr, String emrId, HttpServletRequest request) {
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        Integer xzbm = sysMemberInfo.getXzbm();
        /**
         * 转换misEmrMar用药对象
         */
        //System.out.println(jsonStr);
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        List<MisEmrMar> list = UtilTools.convertToList(jsonArray, MisEmrMar.class);
        for (MisEmrMar d : list) {
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
        misEmrMarService.saveMisEmrMarList(list);
        return null;
    }


    /**
     * 列举所有的用药情况
     *
     * @param request
     */
    @RequestMapping(params = "method=findMisEmrMarForInput")
    public String findMisEmrMarForInput(HttpServletRequest request) {
        List<MisAmEmMedicine> list = misAmEmMedicineService.findMisAmEmMedicineByHql(" from MisAmEmMedicine t order by t.name ");
        request.setAttribute("list", list);

        //创建给药方式选择项
        TObject t = new TObject();
        t.setOnChgMthd("changeDrip(this)");
        String select = sysSelectService.CreateSelect(t, sysCodeService.findSysCodeByPid(Constants.usage));
        request.setAttribute("usage", select);
        t.setOnChgMthd("");
        //创建用药单位
        select = sysSelectService.CreateSelect(t, sysCodeService.findSysCodeByPid(Constants.units));
        request.setAttribute("units", select);
        //创建用药频次
        select = sysSelectService.CreateSelect(t, sysCodeService.findSysCodeByPid(Constants.frequency));
        request.setAttribute("frequency", select);

        //最大用药批次
        Integer maxGrp = misEmrMarService.findMaxGrpInOneEmr(ServletParameter.getParameter(request, "emrId", ""));
        request.setAttribute("maxGrp", String.valueOf(Math.floor(maxGrp)));

        return "business/list_MisEmrMarForInput";
    }

    /**
     * 药物列表
     *
     * @param request
     * @return
     */
    @RequestMapping(params = "method=findMisEmrMar")
    public String findMisEmrMar(HttpServletRequest request) {
        String emrId = ServletParameter.getParameter(request, "emrId", "");
        Integer type = ServletParameter.getParameter(request, "type", 1);

        //是不是本人填写的药物判断
        MisEmrBasicinfo misEmrBasicinfo = misEmrBasicinfoService.findMisEmrBasicinfoById(emrId);
        if (misEmrBasicinfo != null) {
            String createuserid = misEmrBasicinfo.getCreateuserid();
            request.setAttribute("createuserid", createuserid);
            Integer isCommited = misEmrBasicinfo.getIsCommitted();
            request.setAttribute("isCommited", isCommited);
        }


        VMisEmrMarMedicine vMisEmrMarMedicine = new VMisEmrMarMedicine();
        vMisEmrMarMedicine.setEmrId(emrId);
        vMisEmrMarMedicine.setType(type);
        List<VMisEmrMarMedicine> list = misEmrMarService.findMisEmrMar(vMisEmrMarMedicine);
        request.setAttribute("list", list);
        return "/business/list_MisEmrMar";
    }


    @RequestMapping(params = "method=findUseage")
    public String findUseage(HttpServletRequest request) {
        List<SysCode> list = sysCodeService.findSysCodeByPid(Constants.usage);

        String test[] = request.getParameter("values").split(",");

        List<String> values = java.util.Arrays.asList(test);//转成list

        TObject t = new TObject();
        t.setSelectIdAndName("select");
        t.setInitStr(values);
        t.setObecjtName(Constants.sysCode);
        String select = sysSelectService.CreateSelect(t, list);
        request.setAttribute("select", select);
        return "chooser";
    }

    /**
     * 便利跟病历表单相关的附件
     */
    @ResponseBody
    @RequestMapping(params = "method=delMisEmrMarById")
    public String delMisEmrMarById(Integer id, HttpServletRequest request) {
        misEmrMarService.delMisEmrMarById(id);
        return null;
    }

}
