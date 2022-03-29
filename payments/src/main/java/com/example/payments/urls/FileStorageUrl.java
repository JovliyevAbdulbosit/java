package com.example.payments.urls;

import com.example.payments.entity.FileStorage;
import com.example.payments.services.FileStorageservic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.UriEncoder;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/file")
public class FileStorageUrl {
    private final FileStorageservic fileStorageservic;
    @Value("${upload.server.folder}")
    private String serverFolderPath;
    public FileStorageUrl(FileStorageservic fileStorageservic) {
        this.fileStorageservic = fileStorageservic;
    }
    @PostMapping("/add")
    public ResponseEntity save(@RequestParam("file")MultipartFile multipartFile){
        FileStorage result=fileStorageservic.create(multipartFile);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/get/{hashId}")
    public ResponseEntity getOne(@PathVariable String hashId) throws MalformedURLException {
       FileStorage result = fileStorageservic.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION ,"inline;fileName=\""+ UriEncoder.encode(result.getName()))
                .contentType(MediaType.parseMediaType(result.getContentType()))
                .contentLength(result.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",this.serverFolderPath,result.getUploadFolder())));
    }
    @GetMapping("/download/{hashId}")
    public ResponseEntity download(@PathVariable String hashId) throws MalformedURLException {
        FileStorage result = fileStorageservic.findByHashId(hashId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION ,"attachment;fileName=\""+ UriEncoder.encode(result.getName()))
                .contentType(MediaType.parseMediaType(result.getContentType()))
                .contentLength(result.getFileSize())
                .body(new FileUrlResource(String.format("%s/%s",this.serverFolderPath,result.getUploadFolder())));
    }
    @DeleteMapping("/delete/{hashId}")
    public   ResponseEntity delete(@PathVariable String hashId){
        fileStorageservic.delete(hashId);
        return ResponseEntity.ok("file o'chirildi");
    }
}
