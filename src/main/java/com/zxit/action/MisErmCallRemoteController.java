package com.zxit.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisErmCallRemoteService;
import com.zxit.share.Constants;
import com.zxit.wbss.obj.GW_RequestOpenConf;

/**
 * webss远程医疗急救调用
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/misErmCallRemote.do")
public class MisErmCallRemoteController {
    @Resource
    private MisErmCallRemoteService misErmCallRemoteService;

    @ResponseBody
    @RequestMapping(params = "method=sendMsg")
    public Map<String, String> sendMsg(GW_RequestOpenConf gw_RequestOpenConf, HttpServletRequest request) {
        Map<String, String> m = new HashMap<String, String>();
        //获得发起请求的id
        String reqUserId = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getId();
        gw_RequestOpenConf.setREQ_USERID(reqUserId);
        System.out.println(gw_RequestOpenConf.toString());
        String result = misErmCallRemoteService.callRemote(gw_RequestOpenConf);
        m.put("result", result);
        System.out.println(m);
        return m;
    }

}
