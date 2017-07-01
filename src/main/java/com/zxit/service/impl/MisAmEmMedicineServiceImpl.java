package com.zxit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.MisAmEmMedicine;
import com.zxit.model.TObject;
import com.zxit.service.MisAmEmMedicineService;

@Service("misAmEmMedicineService")
public class MisAmEmMedicineServiceImpl implements MisAmEmMedicineService {

    @Resource
    private ABaseDao aBaseDao;

    @Override
    public MisAmEmMedicine findMisAmEmMedicineById(Integer id) {
        MisAmEmMedicine misAmEmMedicine = aBaseDao.findById(MisAmEmMedicine.class, id);
        return misAmEmMedicine;
    }

    @Override
    public String createHQL(MisAmEmMedicine misAmEmMedicine) {
        String hql = " from MisAmEmMedicine t where ";

        if (misAmEmMedicine.getName() != null) {//药品名和拼音
            hql = hql + " t.name like '%" + misAmEmMedicine.getName() + "%' "
                    + "or t.spell like '%" + misAmEmMedicine.getSpell() + "%' "
                    + "or t.inputCode1 like '%" + misAmEmMedicine.getSpell().toUpperCase() + "%' and ";
        }
        hql = hql + " 1 = 1 order by id desc";
        return hql;
    }

    @Override
    public int findCount(String hql) {
        return aBaseDao.findTotalByHQL(hql);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MisAmEmMedicine> findMisAmEmMedicineByHql(String hql) {
        List<MisAmEmMedicine> list = aBaseDao.findByHQL(hql).list();
        return list;
    }

    @Override
    public String createMulitSelect(TObject t, List<MisAmEmMedicine> list) {
        String select = "";
        //String select = sysMultiServiceImpl.createMultiSelect(tMultiObj, tObject, list);
        return select;
    }

}
