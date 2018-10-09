package com.kongxiang.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 用于获取storage信息
@Component
public class FdfsConfig {

  @Value("${fdfs.resHost}")
  private String resHost;

  @Value("${fdfs.storagePort}")
  private String storagePort;

  public String getResHost() {
    return resHost;
  }

  public void setResHost(String resHost) {
    this.resHost = resHost;
  }

  public String getStoragePort() {
    return storagePort;
  }

  public void setStoragePort(String storagePort) {
    this.storagePort = storagePort;
  }
}

