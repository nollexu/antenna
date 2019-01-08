package com.antenna.blog.controller;

import com.antenna.blog.service.UserService;
import com.antenna.blog.service.VisitorRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@Api(description = "登录注册相关控制器")
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    VisitorRecordService visitorRecordService;

    /*主页面跳转*/
    @GetMapping("/")
    @ApiOperation(value = "转发请求到listArticles")
    public String index() {
        return "forward:/listArticles";
    }

    /*登录页面跳转*/
    @GetMapping("/tologin")
    @ApiOperation(value = "跳转登录页面")
    public String login() {
        return "login";
    }

    /*500页面跳转*/
    @GetMapping("/to500")
    @ApiOperation(value = "跳转500页面")
    public String to500() {
        return "500";
    }

    /*404页面跳转*/
    @GetMapping("/to404")
    @ApiOperation(value = "跳转404页面")
    public String to404() {
        return "404";
    }

    /*注册页面跳转*/
    @GetMapping("/toregister")
    @ApiOperation(value = "跳转注册页面")
    public String toRegister() {
        return "registration";
    }

    @PostMapping("/checklogin")
    @ApiOperation(value = "处理登录请求判断用户名密码")
    public String checkLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println(username + " " + password);
        /*userService.getUser(username, password).map(User::username).orElse("null")*/
        if (!userService.getUser(username, password).isPresent()) {
            return "login";
        }
        /*访问最多的地区*/
        String geo = visitorRecordService.getGeoWithMaxVisitor();
        String[] split = geo.split(",");
        String geoWithMaxVisitior=split[0]+" "+split[1];
        /*访问总人数*/
        Integer totalNum=visitorRecordService.getTotalVisitorNum();
        /*本月访问总人数*/
        Integer totalNumThisMonth=visitorRecordService.getTotalVisitorNumThisMonth();
        /*今日访问人数*/
        Integer totalNumThisDay=visitorRecordService.getTotalVisitorNumThisDay();
        /*访问最多的时段*/
        Integer timeWithMaxVisitor=visitorRecordService.getTimeWithMaxVisitor();
        /*访问最多的国家*/
        String countryWithMaxVisitior=split[2];
        session.setAttribute("totalNum",totalNum);
        session.setAttribute("countryWithMaxVisitior",countryWithMaxVisitior);
        session.setAttribute("timeWithMaxVisitor",timeWithMaxVisitor);
        session.setAttribute("totalNumThisMonth",totalNumThisMonth);
        session.setAttribute("totalNumThisDay",totalNumThisDay);
        session.setAttribute("geoWithMaxVisitior",geoWithMaxVisitior);
        return "management";
    }

}
