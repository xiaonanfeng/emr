package com.zxit.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zxit.model.MisFiles;
import com.zxit.model.SysMemberInfo;
import com.zxit.service.MisFileService;
import com.zxit.service.UploadService;
import com.zxit.share.Constants;
import com.zxit.share.CreaterPK;
import com.zxit.share.SystemConfig;

@Controller
@RequestMapping("/misFiles.do")
public class MisFilesController {

    @Resource
    private UploadService uploadService;
    @Resource
    private MisFileService misFileService;
    @Resource
    private SystemConfig systemConfig;

    @RequestMapping(params = "method=misFilesUploader")
    public void misFilesUploader(String ralatedId, Integer relatedType, HttpServletRequest request,
                                 HttpServletResponse response) throws IllegalStateException,
            IOException {

        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 文件大小
                    // Double size = (double) file.getSize();
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    String extname = file.getOriginalFilename().substring(myFileName.lastIndexOf("."));
                    // 如果名称不为空，说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        SysMemberInfo sysMemberInfo = (SysMemberInfo) request
                                .getSession().getAttribute(Constants.USERNAME);
                        String orgId = sysMemberInfo.getSysOrgInfo().getOrgId();
                        // System.out.println(myFileName);
                        // 重命名上传后的文件名
                        String id = CreaterPK.CreatePK();
                        String fileName = orgId + id + extname;//
                        // 定义上传路径
                        String filePath = systemConfig.getFilePath() + "/" + orgId
                                + "/" + fileName;

                        File orgFord = new File(systemConfig.getFilePath() + "/"
                                + orgId);
                        // 如果文件夹不存在则创建
                        if (!orgFord.exists() && !orgFord.isDirectory()) {
                            orgFord.mkdir();
                        }
                        File localFile = new File(filePath);
                        file.transferTo(localFile);

                        // 存储数据库物理路径啥的
                        /**
                         * ID N VARCHAR2(20) N ID NAME N VARCHAR2(64) Y 文件名 TYPE
                         * N VARCHAR2(20) Y 文件类型 ALIAS N VARCHAR2(64) Y 文件别名
                         * SIZE N NUMBER(10,3) Y 文件大小。单位：KB PATH N VARCHAR2(100)
                         * Y 存储路径 PART_ID N NUMBER(4) Y 提交模块 UPLOAD_TIME N DATE
                         * Y 上传时间 UPLOAD_USERID N VARCHAR2(8) Y 上传用户ID
                         * RALATED_ID N VARCHAR2(20) Y 相关事件ID FLAG N NUMBER(1) Y
                         * 是否已删除。0是，1否 LAST_MODIFY_TIME N DATE Y 最后更新时间 XZBM N
                         * NUMBER(8) Y  行政编码
                         */
                        MisFiles misFiles = new MisFiles();
                        misFiles.setId(id);
                        misFiles.setName(fileName);
                        misFiles.setAlias(myFileName);
                        misFiles.setType(extname);
                        // misFiles.setSize(size);
                        misFiles.setPath(filePath);
                        misFiles.setPartId(0);
                        misFiles.setUploadTime(new Date());
                        misFiles.setUploadUserid(sysMemberInfo.getId());
                        misFiles.setRalatedId(ralatedId);
                        misFiles.setFlag(1);
                        misFiles.setLastModifyTime(new Date());
                        misFiles.setXzbm(sysMemberInfo.getXzbm());
                        misFiles.setRelatedType(relatedType == null ? 3 : relatedType);//如果是空就是心电图
                        misFileService.save(misFiles);
                    }
                }
            }
        }
    }

    /**
     * 便利跟病历表单相关的附件
     */
    @RequestMapping(params = "method=findMisFilesByEmrId")
    public String findMisFilesByEmrId(String emrId, HttpServletRequest request) {
        if (emrId != null && emrId != "null") {
            List<MisFiles> list = misFileService.findMisFilesByEmrId(emrId);
            // 缓存文件
            misFileService.cacheFiles(list);
            request.setAttribute("fileList", list);
        }
        return "files";
    }

    /**
     * 便利跟病历表单相关的附件
     */
    @ResponseBody
    @RequestMapping(params = "method=delMisFilesById")
    public String delMisFilesById(String fileId, String emrId,
                                  HttpServletRequest request) {
        misFileService.delMisFilesById(fileId);
        return null;
    }

}
