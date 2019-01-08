package com.antenna.blog.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Accessors(fluent=true)
public class VisitorRecord {
    private Integer id;
    /*用户主机ip*/
    private String host;
    /*用户经度*/
    private String longitude;
    /*用户纬度*/
    private String latitude;
    /*用户地理位置*/
    private String geographicalPosition;
    /*用户访问日期*/
    private LocalDate visitDate;
    /*用户访问时间*/
    private LocalTime visitTime;
}
