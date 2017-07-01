package com.zxit.service.impl;


import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.model.SysCode;
import com.zxit.model.TObject;
import com.zxit.service.SysSelectService;
import com.zxit.share.SystemConfig;

@Service("sysSelectService")
public class SysSelectServiceImpl implements SysSelectService {

    @Resource
    SystemConfig systemConfig;

    /**
     * 公共select构造服务
     */
    @Override
    public String CreateSelect(TObject t, List<SysCode> list) {
        Integer debugMode = systemConfig.getDebugMode();//debug模式
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("<select class='" + t.getStyle() + "' id='" + t.getSelectIdAndName() + "' name='" + t.getSelectIdAndName() + "' "
                + "onchange='" + t.getOnChgMthd() + "' >");
        sb.append("<option pvalue=\"\" value=\"\" >&nbsp;</option>");
        try {
            i = list.size();
            if (i == 0) {
                return "";
            }
            for (SysCode d : list) {
                if (debugMode == 0) {
                    sb.append("<option pvalue=\"" + d.getSysCodeType().getTypeid() + "\" value=\"" + d.getCode() + "\">" + d.getName() + "</option>");
                } else {
                    sb.append("<option pvalue=\"" + d.getSysCodeType().getTypeid() + "\" value=\"" + d.getCode() + "\">" + d.getName() + d.getCode() + "</option>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("</select>");
        return sb.toString();
    }

    @Override
    public String CreateRadio(TObject t, List<SysCode> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            i = list.size();
            if (i == 0) {
                return "";
            }
            for (SysCode d : list) {
                sb.append("<span>");
                sb.append(d.getName());
                sb.append("<input superBox='normal' type='radio' class='" + t.getStyle() + "'  "
                        + "id='" + d.getCode() + t.getSelectIdAndName() + "' name='" + t.getSelectIdAndName() + "' "
                        + "pvalue=\"" + d.getSysCodeType().getTypeid() + "\" value=\"" + d.getCode() + "\" "
                        + "onclick='" + t.getOnChgMthd() + "' />");
                sb.append("</span>");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public String CreateCheckBox(TObject t, List<SysCode> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            i = list.size();
            if (i == 0) {
                return "";
            }
            int flag = 0;
            for (SysCode d : list) {
                sb.append("<span>");
                sb.append(d.getName());
                sb.append("<input superBox='normal' type='checkbox'  style=\"height: 10px;width: 10px;\" "
                        + "id='" + d.getCode() + t.getSelectIdAndName() + "' name='" + t.getSelectIdAndName() + "' "
                        + "pvalue=\"" + d.getSysCodeType().getTypeid() + "\" value=\"" + d.getCode() + "\" "
                        + "onclick='" + t.getOnChgMthd() + "' />");
                ++flag;
                if (flag % 4 == 0) {
                    sb.append("<br/>");
                }
                sb.append("</span>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
