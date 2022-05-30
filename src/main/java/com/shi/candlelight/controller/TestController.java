package com.shi.candlelight.controller;

import com.shi.candlelight.pojo.Test;
import com.shi.candlelight.service.TestService;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController//一般用来返回字符串controller用饭返回一个页面 因为时前后段分离说一一般都用restcondleller
public class TestController {
    @Resource//注入service
    private TestService testService;
    @RequestMapping("/hello")//配置接口对于的请求地址 常用的四种请求可以配置value method请求方式
    public String hello(){
        return "candlelight";
    }
    @PostMapping("/hello/post")
    public String hellopost(String name){
        return "candlelight"+ name;
    }
    @RequestMapping("/test/list")//配置接口对于的请求地址 常用的四种请求可以配置value method请求方式
    public List<Test> list(){
        return testService.list();
    }

}
