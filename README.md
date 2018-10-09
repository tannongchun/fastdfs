# FastDFS 使用说明 

## 依赖软件
  - FastDFS 源代码（libfastcommon 依赖包） 注意版本
  - Nginx 源代码 （fastdfs-nginx-module）注意版本
## 所有依赖软件整包
 - 下载地址 https://github.com/tannongchun/fastdfs/blob/master/FastDFS.zip
  
## 安裝参考
   - 方案一： https://www.cnblogs.com/chiangchou/p/fastdfs.html
   - 方案二： https://github.com/tannongchun/fastdfs/blob/master/fastdfs%E5%8D%95%E8%8A%82%E7%82%B9%E5%AE%89%E8%A3%85%E6%89%8B%E5%86%8C.pdf  


## 环境说明
- 基于Spring boot 2.0.5
- 基于单机 FastDFS 系统  


### FAQ 

- 1.下载原始文件名称 
   eg: http://192.168.1.124:8000/group2/M00/00/00/wKgB-Vkb2yuAEk80AAAABpDVNbM781.txt?attname=name.txt
-- https://blog.csdn.net/sunqingzhong44/article/details/72852751

````
    下载地址添加attname参数
    &attname=文件名.后缀
    
    nginx配置
    location /group1/M00/ {
        root /data2/fastdfs/data;
        if ($arg_attname ~ "^(.+)") {
            #设置下载
            add_header Content-Type application/x-download;
            #设置文件名
            add_header Content-Disposition "attachment;filename=$arg_attname";
        }
        ngx_fastdfs_module;
    }
    eg：** http://192.168.243.87:8888/group1/M00/00/00/wKjzV1u69RyAP42WAAACdWyPsX8129.txt?&attname=tannongchun.txt **
           返回的文件ID由group、存储目录、两级子目录、fileid、文件后缀名（由客户端指定，主要用于区分文件类型）拼接而成。
````
- 2.文件管理界面 
    - FastDFS 监控管理平台源代码 https://github.com/tannongchun/fastdfs-zyc.git
    - 主要功能有：监控，预警，预警通知,拓扑图等各种干货功能。
    
- 3.Ubuntu 默认是没有gcc ,gcc++ 编译器
    - 解决方案如下： 切记->使用apt 安装源采用Ubuntu 官方地址。使用阿里源有些依赖包下载不了。 
    
- 4.单机部署fastdfs ，主要ip 地址不能是127.0.0.1或者localhost 这种，而应该是 192.168.*.*

- 5.storage.conf 里面 http.server_port=80 端口 需要和nginx 配置的端口一致。  
           
- 6.注意防火墙。         
         








