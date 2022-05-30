package com.shi.candlelight.controller;

import com.shi.candlelight.pojo.Ebook;
import com.shi.candlelight.service.EbookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController//一般用来返回字符串controller用饭返回一个页面 因为时前后段分离说一一般都用restcondleller
public class EbookController {
    @Resource//注入service
    private EbookService ebookService;

    @RequestMapping("/ebook/list")//配置接口对于的请求地址 常用的四种请求可以配置value method请求方式
    public List<Ebook> list(){
        return ebookService.list();
    }

}
