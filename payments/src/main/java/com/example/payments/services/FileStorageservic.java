package com.example.payments.services;

import com.example.payments.Repasitory.FileStorageRepository;
import com.example.payments.entity.FileStorage;
import com.example.payments.entity.enums.FileStorageStatus;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileStorageservic {
    private final FileStorageRepository fileStorageRepository;
    @Value("${upload.server.folder}")
    private String serverFolderPath;
    private final Hashids hashids;
    public FileStorageservic(FileStorageRepository fileStorageRepository) {
        this.fileStorageRepository = fileStorageRepository;
        this.hashids = new Hashids(getClass().getName() , 6);
    }
    public FileStorage create(MultipartFile multipartFile)  {
        FileStorage fileStorage =new FileStorage();
        fileStorage.setName(multipartFile.getOriginalFilename());
        fileStorage.setFileSize(multipartFile.getSize());
        fileStorage.setContentType(multipartFile.getContentType());
        fileStorage.setExtention(getExt(multipartFile.getOriginalFilename()));
        fileStorage.setFileStorageStatus(FileStorageStatus.DRAFT);
        fileStorage= fileStorageRepository.save(fileStorage);
        Date data=new Date() ;
        String path = String.format("%s/upload_f/%d/%d/%d",this.serverFolderPath,1900+data.getYear(),
                1+data.getMonth(),data.getDate() );
        File uploadFile = new File(path);
        if(!uploadFile.exists()&&uploadFile.mkdirs()){
            System.out.println("keldi");
        }
        fileStorage.setHashId(hashids.encode(fileStorage.getId()));
        String path1 = String.format("upload_f/%d/%d/%d/%s.%s",1900+data.getYear(),
                1+data.getMonth(),data.getDate() ,fileStorage.getHashId(),fileStorage.getExtention());
        fileStorage.setUploadFolder(path1);
        fileStorageRepository.save(fileStorage);
        uploadFile=uploadFile.getAbsoluteFile();
        File file = new File(uploadFile,String.format( "%s.%s" , fileStorage.getHashId() , fileStorage.getExtention()));
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStorage;
    }
public FileStorage findByHashId(String hashid){
        return fileStorageRepository.findByHashId(hashid);
}
    public String getExt(String fileName){
        String ext=null;
        if(fileName!=null && !fileName.isEmpty()){
            int dot = fileName.lastIndexOf('.');
            if(dot>0 && dot<= fileName.length()-2){
                ext=fileName.substring(dot+1);

            }

        }
        return ext;
    }
    public void delete(String hashid){
        FileStorage result=fileStorageRepository.findByHashId(hashid);
        File file = new File(String.format("%s/%s", this.serverFolderPath , result.getUploadFolder()));
        if( file.delete()){
            fileStorageRepository.delete(result);
        }
    }
}
