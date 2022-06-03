package com.shi.candlelight.controller;

import com.shi.candlelight.pojo.Ebook;
import com.shi.candlelight.service.Allservice;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AllConeroller {
    @Resource
    private Allservice allservice;
    @RequestMapping("/ebook/all")
public List<Ebook> all(){
        return allservice.all();
    }
}


