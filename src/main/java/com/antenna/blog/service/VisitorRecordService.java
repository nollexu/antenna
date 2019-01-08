package com.antenna.blog.service;

import com.antenna.blog.entity.VisitorRecord;

public interface VisitorRecordService {
    void saveVisitorRecord(VisitorRecord visitorRecord);
    String getGeoWithMaxVisitor();
    Integer getTotalVisitorNum();
    Integer getTotalVisitorNumThisMonth();
    Integer getTotalVisitorNumThisDay();
    Integer getTimeWithMaxVisitor();
}
