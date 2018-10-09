package com.kongxiang.config;

import java.io.IOException;
import java.io.InputStream;

import com.kongxiang.config.FdfsConfig;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * 工具类
 */
@Component
public class FastDFSClientWrapper {

  @Autowired
  private FastFileStorageClient storageClient;

  @Autowired
  private FdfsConfig fdfsConfig;

  public String uploadFile(MultipartFile file, boolean isAllowDown) throws IOException {

    String filename = file.getOriginalFilename();
    StorePath storePath = storageClient.uploadFile((InputStream)file.getInputStream(),file.getSize(), FilenameUtils.getExtension(filename),null);
   // 是否允许下载
    if(isAllowDown){
      return getResAccessUrl(storePath).concat("?&attname=" + filename);
    }
    else{
      // 不允许下载
      return getResAccessUrl(storePath);
    }

  }

  /**
   * 封装文件完整URL地址
   * @param storePath
   * @return
   */
  private String getResAccessUrl(StorePath storePath) {
    String fileUrl = GlobalConstants.HTTP_PROTOCOL + fdfsConfig.getResHost() + ":" + fdfsConfig.getStoragePort() + "/" + storePath.getFullPath();
    return fileUrl;
  }
}
