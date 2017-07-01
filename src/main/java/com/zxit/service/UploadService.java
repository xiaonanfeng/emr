package com.zxit.service;

import com.zxit.model.FileBean;


public interface UploadService {

    public void delFile(String filePath);

    public void BringFile2Server(FileBean fileBean);

    public void destryServerCache(String delpath);

}
