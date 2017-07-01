package com.zxit.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.MisEmrCmpltTemplate;
import com.zxit.service.MisEmrCmpltService;

@Controller
@RequestMapping("/misEmrCmplt.do")
public class MisEmrCmpltController {

    @Resource
    private HttpServletRequest request;
    @Resource
    private MisEmrCmpltService misEmrCmpltService;

    @ResponseBody
    @RequestMapping(params = "method=findMisEmrCmplt")
    public String findMisEmrCmplt(MisEmrCmpltTemplate misEmrCmpltTemplate) {
        List<MisEmrCmpltTemplate> list = misEmrCmpltService.findMisEmrCmpltTemplateByHql(misEmrCmpltTemplate);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);//防止实体类对象死循环
        String misEmrCmpltTemplateStr = JSONArray.fromObject(list, jsonConfig).toString();
        return misEmrCmpltTemplateStr;
    }

}
