package com.zxit.service;

import java.util.List;

import com.zxit.model.MisEmrChargeItems;
import com.zxit.model.TObject;

public interface MisEmrChargeItemsService extends ABaseService {

    public List<MisEmrChargeItems> findMisEmrChargeItems(String code);

    /**
     * 创建公共select
     *
     * @param list
     * @return
     */
    public String createChargeSelect(TObject t, List<MisEmrChargeItems> list);

}
