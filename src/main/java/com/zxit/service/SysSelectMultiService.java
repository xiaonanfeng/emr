package com.zxit.service;

import java.util.List;

import com.zxit.model.TObject;

/**
 * 公共多选组件构造
 *
 * @author Administrator
 */
public interface SysSelectMultiService {

    public <T> String createMultiSelect(TObject tObject, List<T> list);

}
