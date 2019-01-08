package com.antenna.blog.mapper;

import com.antenna.blog.entity.File;

import java.util.List;

public interface FileMapper {
    /*将文件信息存放到数据库中*/
    void saveFile(File file);
    /*查询文件列表*/
    List<File> listFiles();
}
