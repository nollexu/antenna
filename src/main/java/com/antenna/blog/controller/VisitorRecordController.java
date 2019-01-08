package com.antenna.blog.controller;

import com.antenna.blog.entity.VisitorRecord;
import com.antenna.blog.service.VisitorRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@Api(description = "访问者纪录相关控制器")
public class VisitorRecordController {
    @Autowired
    VisitorRecordService visitorRecordService;

    @PostMapping("/saveVisitorRecord")
    @ApiOperation(value = "保存一条访问者信息")
    public String saveVisitorRecord(String longitude, String latitude,String geographicalPosition,HttpServletRequest request){
        VisitorRecord visitorRecord =new VisitorRecord();
        visitorRecord.longitude(longitude)
                .latitude(latitude)
                .host(request.getRemoteAddr())
                .geographicalPosition(geographicalPosition)
                .visitDate(LocalDate.now())
                .visitTime(LocalTime.now());
        System.out.println(visitorRecord);
        visitorRecordService.saveVisitorRecord(visitorRecord);
        return "success";
    }


}
