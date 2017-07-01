package com.zxit.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zxit.dao.impl.ABaseDaoImpl;
import com.zxit.model.MisEmrTemplatePage;
import com.zxit.service.MisEmrTemplatePageService;

@Service("misEmrTemplatePageService")
public class MisEmrTemplatePageServiceImpl extends ABaseDaoImpl implements MisEmrTemplatePageService {

    @SuppressWarnings("unchecked")
    @Override
    public List<MisEmrTemplatePage> findMisEmrTemplatePageByHql() {
        String hql = " from MisEmrTemplatePage t where t.flag = '0'";
        List<MisEmrTemplatePage> list = this.findByHQL(hql).list();
        return list;
    }

}
