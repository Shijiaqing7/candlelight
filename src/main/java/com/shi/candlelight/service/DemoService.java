package com.shi.candlelight.service;

import com.shi.candlelight.mapper.DemoMapper;
import com.shi.candlelight.pojo.Demo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//一般将逻辑处理写在service
@Service//将这个service交给spring管理
public class DemoService {
    @Resource//将demomapper注入进来也可以用jdk自带的resource
    private DemoMapper demoMapper;
    public List<Demo> list(){
        return demoMapper.selectByExample(null);
    }
}
