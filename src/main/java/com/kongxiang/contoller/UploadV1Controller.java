package com.kongxiang.contoller;
import com.kongxiang.config.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadV1Controller {
  @Autowired
  private FastDFSClientWrapper dfsClient;

  // 上传附件
  @PostMapping("/filename/no")
  public String fdfsUpload(@RequestParam("file") MultipartFile file) {
    String fileUrl =null;
    try {
       fileUrl= dfsClient.uploadFile(file,false);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileUrl;
  }
  // 上传附件
  @PostMapping("/filename")
  public String fdfsUploadOriginFilename(@RequestParam("file") MultipartFile file) {
    String fileUrl =null;
    try {
      fileUrl= dfsClient.uploadFile(file,true);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return fileUrl;
  }


}
