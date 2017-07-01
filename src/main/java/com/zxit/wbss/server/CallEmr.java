package com.zxit.wbss.server;

import javax.jws.WebService;

@WebService
public interface CallEmr {
    public void findEmrById(String id);

}
