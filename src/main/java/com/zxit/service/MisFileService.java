package com.zxit.service;

import java.util.List;

import com.zxit.model.MisFiles;

public interface MisFileService {

    /**
     * 保存文件信息
     *
     * @param misFiles
     */
    public void save(MisFiles misFiles);

    /**
     * 通过ID找到文件信息
     *
     * @param id
     * @return
     */
    public MisFiles findMisFileById(String id);

    /**
     * 通过病历表单ID找到相关的文件列表
     *
     * @param ralatedId
     * @return
     */
    public List<MisFiles> findMisFilesByEmrId(String ralatedId);

    /**
     * 通过一个病历表单ID删掉文件
     *
     * @param list
     */
    public void delMisFiles(List<MisFiles> list);

    /**
     * 通过文件ID删掉一个文件
     *
     * @param fileId
     */
    public void delMisFilesById(String fileId);

    /**
     * 缓存一个病历表单的附件
     *
     * @param list
     */
    public void cacheFiles(List<MisFiles> list);

}
