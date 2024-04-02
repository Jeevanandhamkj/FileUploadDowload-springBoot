package com.example.pdf.Service;

import com.example.pdf.Entity.FileData;
import com.example.pdf.Entity.PdfDemo;
import com.example.pdf.Repo.FileDataRepo;
import com.example.pdf.Repo.PdfDemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class PdfService {

    @Autowired
    PdfDemoRepo pdfDemoRepo;
    @Autowired
    FileDataRepo fileDataRepo;
    private  final String Folder="C:\\Users\\ADMIN\\OneDrive\\Desktop\\SpringFile";

    public String uploading(MultipartFile file) throws IOException {
        PdfDemo pdf=pdfDemoRepo.save(PdfDemo.builder()
                .name(file.getOriginalFilename()
                        ).type(file.getContentType()).pdfdoc(file.getBytes()).build());
        if(pdf!=null){
            return "file upload"+file.getOriginalFilename();
        }
        else {
            return null;
        }
    }
   public byte[]dowling(String name){
        Optional<PdfDemo>p=pdfDemoRepo.findByName(name);
        byte[]k=p.get().getPdfdoc();
        return k;
    }

    public String uploadFileData(MultipartFile file)throws Exception{
        String filePath=Folder+file.getOriginalFilename();
        FileData fd=fileDataRepo.save(FileData.builder().name(file.getOriginalFilename())
                .type(file.getContentType())
                .filepath(filePath).build());
        file.transferTo(new File(filePath));//copy file into particular filepath
        if(fd!=null){
            return "file uploaded"+file.getOriginalFilename();
        }
        else {
            return null;
        }
    }

    public byte[]dowloadFile(String name) throws IOException {
        Optional<FileData>of=fileDataRepo.findByName(name);
        String filepath=of.get().getFilepath();//get file path
        byte[]f= Files.readAllBytes(new File(filepath).toPath());//covert to byteARRAY
        return f;
    }
    }

