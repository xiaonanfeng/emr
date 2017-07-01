package com.zxit.service.impl;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.zxit.service.MisErmCallRemoteService;
import com.zxit.wbss.obj.GW_RequestOpenConf;
import com.zxit.wbss.soap.Lbs;
import com.zxit.wbss.soap.LbsSoap;

@Service("misErmCallRemoteService")
public class MisErmCallRemoteServiceImpl implements MisErmCallRemoteService {

    @Override
    public String callRemote(GW_RequestOpenConf gw_RequestOpenConf) {
        String msg = JSONObject.fromObject(gw_RequestOpenConf).toString();
        LbsSoap lbsSoap = new Lbs().getLbsSoap();
        String returnStr = "";
        returnStr = lbsSoap.remoteRequire(msg);
        return returnStr;
    }

}
