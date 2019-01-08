package com.antenna.blog.service.impl;

import com.antenna.blog.entity.File;
import com.antenna.blog.mapper.FileMapper;
import com.antenna.blog.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public void saveFile(File file) {
        fileMapper.saveFile(file);
    }

    @Override
    public List<File> listFiles() {
        List<File> files = fileMapper.listFiles();
        return files;
    }
}
