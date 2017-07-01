package com.zxit.service;

import com.zxit.wbss.obj.GW_RequestOpenConf;

public interface MisErmCallRemoteService {
    /**
     * 远程医疗急救webSS呼出方法
     *
     * @param json
     * @return
     */
    public String callRemote(GW_RequestOpenConf gW_RequestOpenConf);

}
