package com.antenna.blog.controller;

import com.antenna.blog.entity.File;
import com.antenna.blog.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@Api(description = "文件上传相关控制器")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    @ApiOperation(value = "前台为ajax请求，处理文件上传，获取文件类型、大小、文件名等元属性")
    public File singleFileUpload(@RequestParam("file") MultipartFile file) {
        /*服务器存放文件的目录*/
        String UPLOADED_FOLDER = "D:\\pic\\";
        File fileToStore = new File();
        List<String> files = new ArrayList<>();
        if (file.isEmpty()) {
            return null;
        }
        try {
            /*获取文件相关信息并存储*/
            byte[] bytes = file.getBytes();
            fileToStore.fileName(file.getOriginalFilename())/*文件名*/
                    .fileType(file.getContentType())/*获取并设置文件类型MIME*/
                    .uploadTime(LocalDateTime.now())/*设置上传时间*/
                    .fileSize(file.getSize() / 1024 + "kb");/*文件大小kb为单位*/
            System.out.println(fileToStore.fileType());
            switch (fileToStore.fileType()) {
                case "image/jpeg":
                    fileToStore.fileIcon("fa fa-file-image-o");break;
                case "image/png":
                    fileToStore.fileIcon("fa fa-file-image-o");break;
                case "application/pdf":
                    fileToStore.fileIcon("fa fa-file-pdf-o");break;
                case "video/mpeg":
                    fileToStore.fileIcon("fa fa-film");break;
                case "application/x-gzip":
                    fileToStore.fileIcon("fa fa-file-zip-o");break;
                case "application/zip":
                    fileToStore.fileIcon("fa fa-file-zip-o");break;
                case "application/x-compressed":
                    fileToStore.fileIcon("fa fa-file-zip-o");break;
                default:
                    fileToStore.fileIcon("fa fa-file-text-o");break;
            }
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            fileToStore.storeLocation(path.toString());/*文件存储路径包含文件名*/
            Files.write(path, bytes);
            System.out.println(fileToStore);
            /*文件上传成功，进行存储*/
            fileService.saveFile(fileToStore);


        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileToStore;
    }


    @GetMapping("/listFiles")
    @ResponseBody
    @ApiOperation(value = "前台为ajax请求，查询文件列表")
    public List<File> listFiles() {
        List<File> files = fileService.listFiles();
        System.out.println(files.get(0));
        return files;
    }


}
