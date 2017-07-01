package com.zxit.wbss.server.impl;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.zxit.wbss.server.CallEmr;

@Component("callEmr")
@WebService(
        endpointInterface = "com.zxit.wbss.server.CallEmr",
        serviceName = "CallEmr",
        targetNamespace = "http://com.zxit.wbss.server"
)
public class CallEmrImpl implements CallEmr {

    @Override
    @WebMethod
    public void findEmrById(String id) {
        System.out.println(id);
    }

}
