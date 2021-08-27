package com.anubis.homepage.service.news;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.service.search.bing.BingTopNewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NewsService {

    public static final Logger LOGGER = Logger.getLogger(NewsService.class.getName());

    @Autowired
    private BingTopNewsServiceImpl bingTopNewsService;

    public BingSearchResponse getLatestTopNews() {
        return getBingTopNewsService().doSearch();
    }

    public BingTopNewsServiceImpl getBingTopNewsService() {
        return bingTopNewsService;
    }

    public void setBingTopNewsService(BingTopNewsServiceImpl bingTopNewsService) {
        this.bingTopNewsService = bingTopNewsService;
    }
}
