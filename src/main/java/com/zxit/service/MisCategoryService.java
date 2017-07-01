package com.zxit.service;

import java.util.List;

import com.zxit.model.MisCategory;
import com.zxit.model.MisCategorypermission;

public interface MisCategoryService extends ABaseService {

    public List<MisCategory> findMisEmrCategoryInUse(List<MisCategorypermission> misList);

}
