package com.anubis.homepage.controller.rest;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public BingSearchResponse getBingTopNews() {
        return getNewsService().getLatestTopNews();
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
