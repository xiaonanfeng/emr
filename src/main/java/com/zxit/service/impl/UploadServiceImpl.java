package com.zxit.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import com.zxit.model.FileBean;
import com.zxit.service.UploadService;
import com.zxit.tools.UtilCopy;

/**
 * @author Administrator
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    @Override
    public void delFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + filePath + "不存在！");
        } else {
            if (file.isFile())
                file.delete();
        }
    }

    @Override
    public void BringFile2Server(FileBean fileBean) {
        UtilCopy utilCopy = new UtilCopy();
        utilCopy.CopyFiles(fileBean);
    }

    @Override
    public void destryServerCache(String delpath) {
        File file = new File(delpath);
        if (!file.isDirectory()) { // 如果不是文件夹
            file.delete();
        } else if (file.isDirectory()) { // 如果是文件夹
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length - 1; i++) {
                File delfile = fileList[i];
                if (!delfile.isDirectory()) {
                    delfile.delete();
                }
            }
            file.delete();
        }
    }

}
