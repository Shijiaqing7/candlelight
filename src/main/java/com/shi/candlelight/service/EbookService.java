package com.shi.candlelight.service;

import com.shi.candlelight.mapper.EbookMapper;
import com.shi.candlelight.pojo.Ebook;
import com.shi.candlelight.pojo.EbookExample;
import com.shi.candlelight.req.EbookReq;
import com.shi.candlelight.resp.EbookResp;
import com.shi.candlelight.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

//一般将逻辑处理写在service
@Service//将这个service交给spring管理
public class EbookService {
    @Resource//将ebookmapper注入进来也可以用jdk自带的resource
    private EbookMapper ebookMapper;
    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        //List<EbookResp> respList = new ArrayList<>();
        //for (Ebook ebook : ebookList) {
            //EbookResp ebookResp = new EbookResp();
            //ebookResp.setId(ebook.getId());这种比较麻烦 将ebok的指赋到返回值结果类中ebbokresp
            //可以用beanutils中的copyporperties方法来完成复制
            //BeanUtils.copyProperties(ebook,ebookResp);//这样就实现了对象的复制
            //使用工具类进行对象复制
            //EbookResp ebookresp = CopyUtil.copy(ebook, EbookResp.class);
            //respList.add(ebookresp);
        //}
            //工具类列表复制
            List<EbookResp> list = CopyUtil.copyList(ebookList, EbookResp.class);



        return list;
        }
    }

