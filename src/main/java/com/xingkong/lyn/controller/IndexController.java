package com.xingkong.lyn.controller;


import com.xingkong.lyn.comment.AjaxResults;
import com.xingkong.lyn.model.web.Banner;
import com.xingkong.lyn.model.web.News;
import com.xingkong.lyn.model.web.WebInfo;
import com.xingkong.lyn.service.IBanner;
import com.xingkong.lyn.service.INews;
import com.xingkong.lyn.service.IWebInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lyn on 2017/4/24.
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private IBanner bannerService;

    @Resource
    private INews newsService;

    @Resource
    private IWebInfo webInfoService;

    @RequestMapping(value = "/web/index/banner", method = RequestMethod.GET)
    public Object webIndexBanner(){
        AjaxResults ajaxResults = new AjaxResults();
        List<Banner> banners = bannerService.findAll();
        ajaxResults.put("banners",banners);
        return ajaxResults;
    }

    @RequestMapping(value = "/web/index/news", method = RequestMethod.GET)
    public AjaxResults webIndexNews(Integer limit){
        AjaxResults ajaxResults = new AjaxResults();
        if(null == limit){
            ajaxResults.put("news", newsService.getNewsList());
        }else{
            Sort sort = new Sort(Sort.Direction.DESC, "newsTime");
            Pageable pageable = new PageRequest(0, limit, sort);
            ajaxResults.put("news", newsService.getNewsByPageable(pageable));
        }

        return ajaxResults;
    }

    @RequestMapping(value = "/web/index/introduction", method = RequestMethod.GET)
    public Object webIndexIntroduction(){
        AjaxResults ajaxResults = new AjaxResults();
        WebInfo webInfo = webInfoService.getWebInfo();
        ajaxResults.put("title", webInfo.getTitle());
        ajaxResults.put("introduction", webInfo.getIntroduction());
        return ajaxResults;
    }

    @RequestMapping(value = "/web/index/product", method = RequestMethod.GET)
    public Object webIndexProduct(Integer limit){
        AjaxResults ajaxResults = new AjaxResults();
        WebInfo webInfo = webInfoService.getWebInfo();
        ajaxResults.put("products", webInfo);
        return ajaxResults;
    }

    @RequestMapping(value = "/web/index/contactus", method = RequestMethod.GET)
    public Object webIndexContactus(){
        AjaxResults ajaxResults = new AjaxResults();
        WebInfo webInfo = webInfoService.getWebInfo();
        ajaxResults.put("address", webInfo.getAddress());
        ajaxResults.put("map", webInfo.getMap());
        ajaxResults.put("phone", webInfo.getPhone());
        ajaxResults.put("time", webInfo.getOpenTime());
        return ajaxResults;
    }

    @RequestMapping(value = "/web/introduction", method = RequestMethod.GET)
    public Object webIntroduction(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        Map<String,Object> map2 = new HashMap<>();
        map2.put("introduction", "123");
        map.put("results", map2);
        return map;
    }

}
