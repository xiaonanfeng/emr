package com.zxit.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.zxit.model.MisCategory;
import com.zxit.model.MisCategorypermission;
import com.zxit.service.MisCategoryService;

@Service("misCategoryService")
public class MisCategoryServiceImpl extends ABaseServiceImpl implements MisCategoryService {

    @SuppressWarnings("unchecked")
    @Override
    public List<MisCategory> findMisEmrCategoryInUse(List<MisCategorypermission> misList) {
        List<Integer> roleCodes = new ArrayList<Integer>();
        for (MisCategorypermission d : misList) {
            roleCodes.add(d.getModuleid());
        }

        //中心科长和中心质控
        //享有同等权利
        String hql =
                " from MisCategory t where t.flag = '0' and t.partId = '2000' and parentId !='0' and t.id in (:roleCodes)  order by t.sortId";
        Query query = this.findByHQL(hql);
        query.setParameterList("roleCodes", roleCodes);
        List<MisCategory> list = query.list();
        return list;
    }


}
