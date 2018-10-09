# FastDFS 说明

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








