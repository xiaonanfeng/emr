package com.zxit.service;

import java.util.List;

import com.zxit.model.SysCode;
import com.zxit.model.TObject;


public interface SysSelectService {
    /**
     * 公共select构造方法
     *
     * @param slctMaper       数据库对象名
     * @param sqlWhere        其他条件
     * @param selectIdAndName id和name
     * @param style           样式
     * @param valueColumn     value字段
     * @param optionColumn    显示字段
     * @param onChgMthd       选择回调方法
     * @return
     */
    public String CreateSelect(TObject t, List<SysCode> list);

    /**
     * 公共radio
     *
     * @param t
     * @param list
     * @return
     */
    public String CreateRadio(TObject t, List<SysCode> list);

    /**
     * 公共CheckBox
     *
     * @param t
     * @param list
     * @return
     */
    public String CreateCheckBox(TObject t, List<SysCode> list);
}
