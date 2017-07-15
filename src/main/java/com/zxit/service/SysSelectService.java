package com.zxit.service;

import com.zxit.model.SysCode;
import com.zxit.model.TObject;

import java.util.List;


public interface SysSelectService {
    /**
     * 公共select构造方法
     * @return
     */
    String CreateSelect(TObject t, List<SysCode> list);

    /**
     * 公共radio
     *
     * @param t
     * @param list
     * @return
     */
    String CreateRadio(TObject t, List<SysCode> list);

    /**
     * 公共CheckBox
     *
     * @param t
     * @param list
     * @return
     */
    String CreateCheckBox(TObject t, List<SysCode> list);
}
