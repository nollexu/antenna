package com.antenna.blog.service;

import com.antenna.blog.entity.File;

import java.util.List;

public interface FileService {
    /*将文件信息存放到数据库中*/
    void saveFile(File file);
    /*查询文件列表*/
    List<File> listFiles();

}
