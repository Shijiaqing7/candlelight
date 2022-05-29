package com.shi.candlelight.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//一般用来返回字符串controller用饭返回一个页面 因为时前后段分离说一一般都用restcondleller
public class TestController {
    @RequestMapping("/hello")//配置接口对于的请求地址 常用的四种请求可以配置value method请求方式
    public String hello(){
        return "candlelight";
    }
    @PostMapping("/hello/post")
    public String hellopost(String name){
        return "candlelight"+ name;
    }

}
