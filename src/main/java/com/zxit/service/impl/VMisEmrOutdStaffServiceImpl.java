package com.zxit.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.model.TObject;
import com.zxit.model.VMisEmrOutdStaff;
import com.zxit.service.VMisEmrOutdStaffService;

@Service("vMisEmrOutdStaffService")
public class VMisEmrOutdStaffServiceImpl extends ABaseServiceImpl implements VMisEmrOutdStaffService {

    @SuppressWarnings("unchecked")
    @Override
    public List<VMisEmrOutdStaff> findVMisEmrOutdStaffByEmrId(String emrId) {
        List<VMisEmrOutdStaff> list = this.findByHQL(" from VMisEmrOutdStaff t where t.id.emrId = '" + emrId + "'").list();
        return list;
    }

    @Override
    public String createColleSelect(TObject t, List<VMisEmrOutdStaff> list) {
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
            for (VMisEmrOutdStaff d : list) {
                sb.append("<option pvalue=\"" + d.getType() + "\" value=\"" + d.getId().getGh() + "\">" + d.getName() + "</option>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("</select>");
        return sb.toString();
    }

    @Override
    public String findAutoColler(String emrId) {
        String coller = "";
        Query query = this.findByHQL(" from VMisEmrOutdStaff t where t.id.emrId = '" + emrId + "' and t.type  = '30'");
        VMisEmrOutdStaff vMisEmrOutdStaff = (VMisEmrOutdStaff) query.uniqueResult();
        if (vMisEmrOutdStaff != null) {
            coller = vMisEmrOutdStaff.getId().getGh();
        }
        return coller;
    }

}
