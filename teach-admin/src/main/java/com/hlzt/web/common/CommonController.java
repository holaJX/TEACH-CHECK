package com.hlzt.web.common;

import com.hlzt.common.config.TeachConfig;
import com.hlzt.common.constant.Constants;
import com.hlzt.common.core.domain.AjaxResult;
import com.hlzt.common.utils.StringUtils;
import com.hlzt.common.utils.file.FileUploadUtils;
import com.hlzt.common.utils.file.FileUtils;
import com.hlzt.file.FastDFSFile;
import com.hlzt.framework.config.ServerConfig;
import com.hlzt.utils.FastDFSClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用请求处理
 *
 * @author ruo-yi
 */
@Slf4j
@Api(value = "通用controller", tags = {"通用请求处理"})
@RestController
public class CommonController {

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @ApiOperation("开放的通用下载请求")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName", value = "文件名称", dataType = "String", dataTypeClass = String.class, paramType = "query"),
            @ApiImplicitParam(name = "delete", value = "是否删除", dataType = "Boolean", dataTypeClass = Boolean.class, paramType = "query")
    })
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = TeachConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求(单张图片)
     */
    @ApiOperation("通用上传请求(单张图片)")
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = TeachConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 通用上传请求(单张图片)
     */
    @ApiOperation("开放的注册上传请求(单张图片)")
    @PostMapping("/register/uploads")
    public AjaxResult registerUploadFile(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = TeachConfig.getRegisterPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 通用上传请求(单张图片)
     */
    @ApiOperation("项目内上传请求(单张图片)")
    @PostMapping("/project/upload")
    public AjaxResult projectUploadFile(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = TeachConfig.getProjectPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 通用上传请求(单张图片)
     */
    @ApiOperation("项目内视频上传请求(单个视频)")
    @PostMapping("/project/uploadVideo")
    public AjaxResult projectUploadVideo(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = TeachConfig.getProjectPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 通用上传请求(多张图片)
     */
    @ApiOperation("项目内上传请求(多张图片/多个文件)")
    @PostMapping("/project/moreUpload")
    public AjaxResult projectMoreUploadFile(MultipartFile[] files) {
        try {
            // 上传文件路径
            String filePath = TeachConfig.getProjectPath();
            List<Map<String, Object>> list = new ArrayList<>();
            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                Map<String, Object> map = new HashMap<>();
                map.put("fileName", fileName);
                map.put("url", url);
                list.add(map);
            }
            return AjaxResult.success(list);
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 通用上传请求(单张图片)
     */
    @ApiOperation("富文本上传请求(单张图片)")
    @PostMapping("/editor/upload")
    public AjaxResult editorUploadFile(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = TeachConfig.getEditorUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @ApiOperation("开放的本地资源通用下载")
    @ApiImplicitParam(name = "resource", value = "资源文件名称", dataType = "String", dataTypeClass = Boolean.class, paramType = "query")
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletResponse response) {
        try {
            if (!FileUtils.checkAllowDownload(resource)) {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = TeachConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    @RestController
    @CrossOrigin
    public class FileController {

        /***
         * 文件上传
         * @return
         */
        @PostMapping(value = "/register/upload")
        public String upload(@RequestParam("file")MultipartFile file) throws Exception {
            //封装一个FastDFSFile
            FastDFSFile fastDFSFile = new FastDFSFile()
                    .setName(file.getOriginalFilename())
                    .setContent(file.getBytes())
                    .setExt(org.springframework.util.StringUtils.getFilenameExtension(file.getOriginalFilename()));//文件扩展名

            //文件上传
            String[] uploads = FastDFSClient.upload(fastDFSFile);
            //组装文件上传地址
            return FastDFSClient.getTrackerUrl()+"/"+uploads[0]+"/"+uploads[1];
        }
    }
}
