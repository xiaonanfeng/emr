package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisEmrMar;
import com.zxit.model.VMisEmrMarMedicine;
import com.zxit.service.MisEmrMarService;
import com.zxit.service.SysCodeService;
import com.zxit.share.Constants;

@Service("misEmrMarService")
public class MisEmrMarServiceImpl implements MisEmrMarService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private SysCodeService sysCodeService;

    @SuppressWarnings("unchecked")
    @Override
    public List<VMisEmrMarMedicine> findMisEmrMar(VMisEmrMarMedicine vMisEmrMarMedicine) {
        List<VMisEmrMarMedicine> list =
                aBaseDao.findByHQL(" from VMisEmrMarMedicine t where "
                        + "t.emrId = '" + vMisEmrMarMedicine.getEmrId() + "' and "
                        + "t.type = '" + vMisEmrMarMedicine.getType() + "' order by  t.grp asc ").list();

        for (VMisEmrMarMedicine d : list) {
            if (d.getUsage() != null) {
                String useAgeStr = "";
                if (d.getUsage().length() != 0) {
                    String[] temp = d.getUsage().split(",");
                    for (int i = 0; i < temp.length; i++) {
                        String usageName = sysCodeService.findSysCodeByIdAndPid(Integer.parseInt(temp[i]), Constants.usage).getName();
                        useAgeStr = useAgeStr + usageName;
                        if (i != temp.length - 1) {
                            useAgeStr = useAgeStr + ",";
                        }
                    }
                }
                d.setUsage(useAgeStr);
            }

            if (d.getUnits() != null) {
                if (d.getUnits() != 0) {
                    //这个情况是前台传过来的值为null，null*1=0
                    d.setUnits_text(sysCodeService.findSysCodeByIdAndPid(d.getUnits(), Constants.units).getName());//用药单位
                } else {
                    d.setUnits_text("");
                }
            }

            if (d.getFrequency() != null) {
                //这个情况是前台传过来的值为null，null*1=0
                if (d.getFrequency() != 0) {
                    d.setFrequency_text(sysCodeService.findSysCodeByIdAndPid(d.getFrequency(), Constants.frequency).getName());//用药频次
                } else {
                    d.setFrequency_text("");//用药频次
                }
            }

        }
        return list;
    }

    @Override
    public MisEmrMar findMisEmrMarById(Integer id) {
        return aBaseDao.findById(MisEmrMar.class, id);
    }

    @Override
    public void saveMisEmrMarList(List<MisEmrMar> list) {
        aBaseDao.save(list.toArray());
    }

    @Override
    public void saveMisEmrMar(MisEmrMar misEmrMar) {
        aBaseDao.saveOrUpdate(misEmrMar);

    }

    @Override
    public void delMisEmrMarById(Integer id) {
        aBaseDao.deleteById(MisEmrMar.class, id);

    }

    @Override
    public int findMaxGrpInOneEmr(String emrid) {
        String sql = "select max(grp) from MIS_EMR_MAR t where t.emr_id = '" + emrid + "' ";
        SQLQuery sqlQuery = aBaseDao.findBySQL(sql);
        Number max = (Number) sqlQuery.uniqueResult();
        if (max == null) {
            return 0;
        } else {
            return max.intValue();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void delMieEmrMarByEmrId(String id) {
        List<MisEmrMar> list = aBaseDao.findByHQL(" from MisEmrMar t where t.emrId = '" + id + "'").list();
        aBaseDao.delete(list.toArray());

    }

    //String useAgeStr = "";
//  使用方法多选，废除				
//		if(d.getUsage().length()!=0){
//			String[] temp = d.getUsage().split(",");
//			for(int i=0;i<temp.length;i++){
//				String usageName = sysCodeService.findSysCodeByIdAndPid(Integer.parseInt(temp[i]),Constants.usage).getName();
//				useAgeStr = useAgeStr + usageName ;
//				if(i!=temp.length-1){
//					useAgeStr = useAgeStr + ",";
//				}
//			}
//		}
//		d.setUsage(useAgeStr);


}
