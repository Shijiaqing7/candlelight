package com.shi.candlelight.service;

import com.shi.candlelight.mapper.EbookMapper;
import com.shi.candlelight.pojo.Ebook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//一般将逻辑处理写在service
@Service//将这个service交给spring管理
public class EbookService {
    @Resource//将ebookmapper注入进来也可以用jdk自带的resource
    private EbookMapper ebookMapper;
    public List<Ebook> list(){
        return ebookMapper.selectByExample(null);
    }
}
