package com.zxit.service;

import java.util.List;

import com.zxit.model.MisAmEmMedicine;
import com.zxit.model.TObject;

public interface MisAmEmMedicineService {

    public MisAmEmMedicine findMisAmEmMedicineById(Integer id);

    public String createHQL(MisAmEmMedicine misAmEmMedicine);

    public int findCount(String hql);

    public List<MisAmEmMedicine> findMisAmEmMedicineByHql(String hql);

    public String createMulitSelect(TObject t, List<MisAmEmMedicine> list);


}
