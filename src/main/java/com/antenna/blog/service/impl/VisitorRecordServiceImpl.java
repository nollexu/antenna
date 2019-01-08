package com.antenna.blog.service.impl;

import com.antenna.blog.entity.VisitorRecord;
import com.antenna.blog.mapper.VisitorRecordMapper;
import com.antenna.blog.service.VisitorRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorRecordServiceImpl implements VisitorRecordService {

    @Autowired
    VisitorRecordMapper visitorRecordMapper;

    @Override
    public void saveVisitorRecord(VisitorRecord visitorRecord) {
        visitorRecordMapper.saveVisitorRecord(visitorRecord);
    }

    @Override
    public String getGeoWithMaxVisitor() {
        String geo = visitorRecordMapper.getGeoWithMaxVisitor();
        return geo;
    }

    @Override
    public Integer getTotalVisitorNum() {
        Integer totalNum=visitorRecordMapper.getTotalVisitorNum();
        return totalNum;
    }

    @Override
    public Integer getTotalVisitorNumThisMonth() {
        Integer totalNum=visitorRecordMapper.getTotalVisitorNumThisMonth();
        return totalNum;
    }

    @Override
    public Integer getTotalVisitorNumThisDay() {
        Integer totalNum=visitorRecordMapper.getTotalVisitorNumThisDay();
        return totalNum;
    }

    @Override
    public Integer getTimeWithMaxVisitor() {
        Integer time=visitorRecordMapper.getTimeWithMaxVisitor();
        return time;
    }


}
