package com.zxit.service.impl;

import com.zxit.model.*;
import com.zxit.service.SysSelectMultiService;
import com.zxit.share.Constants;
import com.zxit.tools.Cn2Spell;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysSelectMultiService")
public class SysSelectMultiServiceImpl implements SysSelectMultiService {
    @Override
    public <T> String createMultiSelect(TObject tObject, List<T> list) {

        StringBuilder sb = new StringBuilder();
        sb.append("<select superSelect='normal' class='" + tObject.getStyle() + "' " + "id='"
                + tObject.getSelectIdAndName() + "' " + "name='"
                + tObject.getSelectIdAndName() + "' " + "onchange='"
                + tObject.getOnChgMthd() + "' ");
        sb.append("  multiple='multiple' ");
        sb.append(">");
        int i = list.size();
        if (i == 0)
            return "";
        for (T d : list) {
            try {
                // 如果是ICD10
                if (tObject.getObecjtName().equals(Constants.icd10)) {
                    MisEmrIcd10 misEmrIcd10 = (MisEmrIcd10) d;
                    sb.append("<option pvalue='" + misEmrIcd10.getId()
                            + "'  ptext = '" + misEmrIcd10.getDiseaseName()
                            + "' value='" + misEmrIcd10.getId() + "' ");
                    if (tObject.getInitStr().contains(
                            misEmrIcd10.getId().toString())) {
                        sb.append(" selected >");
                    } else {
                        sb.append(" >");
                    }
                    sb.append(misEmrIcd10.getDiseaseName()
                            + misEmrIcd10.getInputCode1() + "</option>");
                }

                // 如果是药物
                if (tObject.getObecjtName().equals(Constants.MisAmEmMedicine)) {
                    MisAmEmMedicine misAmEmMedicine = (MisAmEmMedicine) d;
                    sb.append("<option pvalue='"
                            + misAmEmMedicine.getId()
                            + "'  ptext = '"
                            + misAmEmMedicine.getName()
                            + Cn2Spell.converterToFirstSpell(
                            misAmEmMedicine.getName().replace("：", "")
                                    .replace("（", "").replace("）", "")
                                    .replace("—", "").replace("％", ""))
                            .toUpperCase() + "（"
                            + misAmEmMedicine.getSpecs() + "）" + "' value='"
                            + misAmEmMedicine.getId() + "' ");
                    sb.append(" >");
                    // }
                    try {
                        sb.append(misAmEmMedicine.getName()
                                + Cn2Spell.converterToFirstSpell(
                                misAmEmMedicine.getName()
                                        .replace("：", "")
                                        .replace("（", "")
                                        .replace("）", "")
                                        .replace("—", "")
                                        .replace("％", ""))
                                .toUpperCase() + "（"
                                + misAmEmMedicine.getSpecs() + "）"
                                + "</option>");
                    } catch (Exception e) {
                        System.out.println(misAmEmMedicine.getName());
                    }
                }
                //如果是人员
                if (tObject.getObecjtName().equals(Constants.SysMemberInfo)) {
                    SysMemberInfo sysMemberInfo = (SysMemberInfo) d;
                    sb.append("<option pvalue='" + sysMemberInfo.getId() + "' "
                            + "ptext = '" + sysMemberInfo.getName() + Cn2Spell.converterToFirstSpell(sysMemberInfo.getName().replace("　","").trim()).toUpperCase()
                            + "（" + sysMemberInfo.getSysOrgInfo().getName() + "）" + "' value='" + sysMemberInfo.getId() + "' ");
                    sb.append(" >");
                    try {
                        sb.append(sysMemberInfo.getName() + Cn2Spell.converterToFirstSpell(sysMemberInfo.getName().replace("　","").trim()).toUpperCase()
                                + "（" + sysMemberInfo.getSysOrgInfo().getName() + "）" + "</option>");
                    } catch (Exception e) {
                        System.out.println(sysMemberInfo.getName());
                    }
                }

                // 如果是syscode
                if (tObject.getObecjtName().equals(Constants.sysCode)) {
                    SysCode sysCode = (SysCode) d;
                    sb.append("<option pvalue='" + sysCode.getCode()
                            + "'  ptext = '" + sysCode.getName()
                            + "' value='" + sysCode.getCode() + "' ");
                    if (tObject.getInitStr().contains(
                            sysCode.getCode().toString())) {
                        sb.append(" selected >");
                    } else {
                        sb.append(" >");
                    }
                    try {
                        sb.append(sysCode.getName()
                                + Cn2Spell.converterToFirstSpell(
                                sysCode.getName().replace("：", "")
                                        .replace("（", "")
                                        .replace("）", ""))
                                .toUpperCase() + "</option>");
                    } catch (Exception e) {
                        System.out.println(sysCode.getName());
                    }
                }
            } catch (Exception e) {
                System.out.println(d);
            }
        }
        sb.append("</select>");
        return sb.toString();
    }

    public static void main(String[] args) {
//		甲氧氯普胺注射液（胃复安）
//		5％葡萄糖
//		50％葡萄糖注射液
//		氢溴酸山莨菪碱（654—2）注射液
//		盐酸普鲁帕酮（心律平）注射液
//		20％甘露醇注射液
//		盐酸哌替啶（度冷丁）注射液
//		呋赛米（速尿）注射液
//		毛花苷丙（西地兰）注射液
//		地西泮（安定）注射液
//		重酒石酸间羟胺（阿拉明）注射液
//		尼可刹米（可拉明）注射液
        System.out.println(Cn2Spell.converterToFirstSpell("甲氧氯普胺注射液（胃复安）"));


    }


}
