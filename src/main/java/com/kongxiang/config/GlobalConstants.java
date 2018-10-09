package com.kongxiang.config;

/**
 * @version 1.0
 * @description:
 * @projectName: com.kongxiang.config
 * @className: fdfs
 * @author:谭农春
 * @createTime:2018/10/8 11:13
 */
public enum GlobalConstants {

  HTTP_PROTOCOL("http://"),
  HTTPS_PROTOCOL("https://");

  private final String protocol;
  GlobalConstants(final  String protocol) {
    this.protocol = protocol;
  }

  public String getProtocol() {
    return protocol;
  }

  @Override
  public String toString(){
    return this.protocol;
  }
}
