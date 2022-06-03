package com.shi.candlelight.controller;

import com.shi.candlelight.req.EbookQueryReq;
import com.shi.candlelight.req.EbookSaveReq;
import com.shi.candlelight.resp.CommonResp;
import com.shi.candlelight.resp.EbookQueryResp;
import com.shi.candlelight.resp.PageResp;
import com.shi.candlelight.service.EbookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/ebook")
@RestController//一般用来返回字符串controller用饭返回一个页面 因为时前后段分离说一一般都用restcondleller
public class EbookController {
    @Resource//注入service
    private EbookService ebookService;
    @RequestMapping("/list")//配置接口对于的请求地址 常用的四种请求可以配置value method请求方式

    public CommonResp list(EbookQueryReq req) {
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();
        //将返回指封装到返回指结果类中返回 方便前端校验
        PageResp<EbookQueryResp> list = ebookService.list(req);
        resp.setContent(list);//返回泛型数据，自定义类型
        return resp;
    }
    @PostMapping("/save")
    //保存接口
    //加requestbody对应的就是post jison方式的提交
    //因为axios爱可设儿四 的post提交就是用json方式提交的所以需要加注解 才能把他接受竟来
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.save(req);
        return resp;
    }

}
