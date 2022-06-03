package com.shi.candlelight.service;

import com.shi.candlelight.mapper.EbookMapper;
import com.shi.candlelight.pojo.Ebook;
import com.shi.candlelight.pojo.EbookExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Allservice {
    @Resource
    private EbookMapper ebookMapper;
    public List<Ebook> all(){
        return ebookMapper.selectByExample(null);
    }

}
