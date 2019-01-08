package com.antenna.blog.mapper;

import com.antenna.blog.entity.VisitorRecord;

public interface VisitorRecordMapper {
    void saveVisitorRecord(VisitorRecord visitorRecord);
    String getGeoWithMaxVisitor();
    Integer getTotalVisitorNum();
    Integer getTotalVisitorNumThisMonth();
    Integer getTotalVisitorNumThisDay();
    Integer getTimeWithMaxVisitor();
}
