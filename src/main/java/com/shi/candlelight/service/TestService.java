package com.shi.candlelight.service;

import com.shi.candlelight.mapper.TestMapper;
import com.shi.candlelight.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//一般将逻辑处理写在service
@Service//将这个service交给spring管理
public class TestService {
    @Resource//将testmapper注入进来也可以用jdk自带的resource
    private TestMapper testMapper;
    public List<Test> list(){
        return testMapper.list();
    }
}
