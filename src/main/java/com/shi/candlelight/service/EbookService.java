package com.shi.candlelight.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shi.candlelight.mapper.EbookMapper;
import com.shi.candlelight.pojo.Ebook;
import com.shi.candlelight.pojo.EbookExample;
import com.shi.candlelight.req.EbookQueryReq;
import com.shi.candlelight.req.EbookSaveReq;
import com.shi.candlelight.resp.EbookQueryResp;
import com.shi.candlelight.resp.PageResp;
import com.shi.candlelight.util.CopyUtil;
import com.shi.candlelight.util.SnowFlake;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

//一般将逻辑处理写在service
@Service//将这个service交给spring管理
public class EbookService {
    @Resource//将ebookmapper注入进来也可以用jdk自带的resource
    private EbookMapper ebookMapper;
    @Resource
    private SnowFlake snowFlake;
    public PageResp<EbookQueryResp> list(EbookQueryReq req){
        EbookExample ebookExample = new EbookExample();//用于添加条件
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        //动态sql判断是否请求了name 如果没有则不查询 如果有则模糊查询
        if(!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(req.getPage(),req.getSize());//第几页 第几条
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        PageInfo<Ebook> ebookPageInfo = new PageInfo<>(ebookList);
        ebookPageInfo.getTotal();//总行数
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
        List<EbookQueryResp> list = CopyUtil.copyList(ebookList, EbookQueryResp.class);


        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(ebookPageInfo.getTotal());
        pageResp.setList(list);

        return pageResp;
        }
    /**
     * 保存sevice
     */
    //请求参数是ebooksavereq 变量为req
    public void save(EbookSaveReq req){
        Ebook ebook = CopyUtil.copy(req,Ebook.class);//将请求参数数据传到ebook中
        //判断是新增数据还是更新数据
        if(ObjectUtils.isEmpty(req.getId())){
            //通过请求参数中id是否有值来判断
            //新增
            ebook.setId(snowFlake.nextId());

            ebookMapper.insert(ebook);//调用insert新增

        }else {
            //更新
            ebookMapper.updateByPrimaryKey(ebook);//调用mapper新增数据 updatebyprimarykey根据id新增
            //因为这个类的参数是Ebook 所以需要将请求类中的数据copy到ebook中 再更新竟来
        }
    }
    public void delete(long id){
        ebookMapper.deleteByPrimaryKey(id);

    }

}

