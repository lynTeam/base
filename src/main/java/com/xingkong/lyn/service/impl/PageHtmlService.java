package com.xingkong.lyn.service.impl;

import com.xingkong.lyn.model.web.PageHtml;
import com.xingkong.lyn.repository.web.PageHtmlRepository;
import com.xingkong.lyn.service.IPageHtml;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lyn on 2017/6/13.
 */
@Service
public class PageHtmlService implements IPageHtml{
    @Resource
    private PageHtmlRepository pageHtmlDao;

    @Override
    public PageHtml getPageHtml(String page) {
        return pageHtmlDao.findByPage(page);
    }

    @Override
    public Page<PageHtml> getPageHtmls(Pageable pageable) {
        return pageHtmlDao.findAll(pageable);
    }

    @Override
    public PageHtml getPageHtml(Long id) {
        return pageHtmlDao.findOne(id);
    }

    @Override
    public boolean addPageHtml(PageHtml pageHtml) {
        pageHtmlDao.saveAndFlush(pageHtml);
        return true;
    }

    @Override
    public boolean updatePageHtml(PageHtml pageHtml) {
        pageHtmlDao.saveAndFlush(pageHtml);
        return true;
    }

    @Override
    @Transactional
    public boolean deletePageHtml(List<Long> id) {
        pageHtmlDao.deleteInBatch(pageHtmlDao.findAll(id));
        return true;
    }

    @Override
    public List<PageHtml> getPageHtmlList(List<String> pages) {
        return pageHtmlDao.findByPage(pages);
    }
}
