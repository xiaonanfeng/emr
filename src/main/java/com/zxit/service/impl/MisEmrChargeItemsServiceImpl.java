package com.zxit.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.zxit.model.MisEmrChargeItems;
import com.zxit.model.TObject;
import com.zxit.service.MisEmrChargeItemsService;

@Service("misEmrChargeItemsService")
public class MisEmrChargeItemsServiceImpl extends ABaseServiceImpl implements MisEmrChargeItemsService {

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrChargeItems> findMisEmrChargeItems(String code) {
        List<MisEmrChargeItems> list = this.findByHQL(" from MisEmrChargeItems t where t.flag = '0' and type = '" + code + "' order by t.sortId asc").list();
        return list;
    }

    @Override
    public String createChargeSelect(TObject t, List<MisEmrChargeItems> list) {
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
            for (MisEmrChargeItems d : list) {
                sb.append("<option pvalue=\"" + d.getStandards() + "\" value=\"" + d.getItemcode() + "\">" + d.getItemname() + "</option>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("</select>");
        return sb.toString();
    }

}
