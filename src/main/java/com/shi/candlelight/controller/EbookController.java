package com.shi.candlelight.controller;

import com.shi.candlelight.pojo.Ebook;
import com.shi.candlelight.resp.CommonResp;
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
    public CommonResp list() {
        CommonResp<List<Ebook>> resp = new CommonResp<>();
        //将返回指封装到返回指结果类中返回 方便前端校验
        List<Ebook> list = ebookService.list();
        resp.setContent(list);//返回泛型数据，自定义类型
        return resp;
    }

}
