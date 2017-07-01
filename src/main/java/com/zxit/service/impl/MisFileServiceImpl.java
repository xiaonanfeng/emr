package com.zxit.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zxit.dao.ABaseDao;
import com.zxit.model.FileBean;
import com.zxit.model.MisFiles;
import com.zxit.model.SysCode;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisFileService;
import com.zxit.service.SysCodeService;
import com.zxit.service.UploadService;
import com.zxit.share.Constants;

@Service("misFileService")
public class MisFileServiceImpl implements MisFileService {

    @Resource
    private ABaseDao aBaseDao;
    @Resource
    private UploadService uploadService;
    @Resource
    private HttpServletRequest request;
    @Resource
    private SysCodeService sysCodeService;

    @Override
    public void save(MisFiles misFiles) {
        aBaseDao.saveOrUpdate(misFiles);
    }

    @Override
    public MisFiles findMisFileById(String id) {
        return aBaseDao.findById(MisFiles.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MisFiles> findMisFilesByEmrId(String ralatedId) {
//		select t.*,a.*
//		  from mis_files t,sys_code a
//		 where a.typeid = '312'
//		   and t.related_type = a.code
//		 order by a.sort_id

        String hql = " select t from MisFiles t,SysCode a where t.ralatedId = '" + ralatedId + "' "
                + "and a.sysCodeType.typeid = '" + Constants.relatedType + "' and t.relatedType = a.code order by a.sortId";
        List<MisFiles> list = aBaseDao.findByHQL(hql).list();
        for (MisFiles d : list) {
            String relatedTypeStr = "";
            SysCode sysCode = sysCodeService.findSysCodeByIdAndPid(d.getRelatedType(), Constants.relatedType);
            if (sysCode != null) {
                relatedTypeStr = sysCode.getName();
            }
            d.setRelatedTypeStr(relatedTypeStr);
        }
        return list;
    }

    @Override
    public void delMisFiles(List<MisFiles> list) {
        aBaseDao.delete(list.toArray());
    }

    @Override
    public void cacheFiles(List<MisFiles> list) {
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + Constants.UPLOAD_PATH;
        SysMemberInfo sysMemberInfo = (SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME);
        if (sysMemberInfo != null) {
            String sysMemberId = ((SysMemberInfo) request.getSession().getAttribute(Constants.USERNAME)).getId();
            ctxPath = ctxPath + sysMemberId + "/";
        } else {
            //如果是外部请求，没有用户的session变量，那么创建一个临时文件夹专门存放临时文件
            ctxPath = ctxPath + "4OtherTemp/";
        }
        File cacheFord = new File(ctxPath);
        uploadService.destryServerCache(ctxPath);
        //如果文件夹不存在则创建
        if (!cacheFord.exists() && !cacheFord.isDirectory()) {
            cacheFord.mkdir();
        }
        for (MisFiles d : list) {
            String fileName = d.getName();
            String phDiskFilePath = d.getPath();//文件在服务器上的物理路径
            FileBean fileBean = new FileBean(phDiskFilePath, ctxPath + fileName);
            //把文件从服务器物理路径拷贝到临时缓冲文件夹
            uploadService.BringFile2Server(fileBean);
        }
    }

    @Override
    public void delMisFilesById(String fileId) {
        aBaseDao.deleteById(MisFiles.class, fileId);
    }


}
