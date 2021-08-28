package com.anubis.homepage.service.news;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.service.integration.bing.BingTopNewsIntegrationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class NewsService {

    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final Logger LOGGER = Logger.getLogger(NewsService.class.getName());

    @Autowired
    private BingTopNewsIntegrationServiceImpl bingTopNewsService;

    @Value("classpath:data/BingExampleResponse.json")
    Resource resourceFile;

    public BingSearchResponse getLatestTopNews() {
        return getBingTopNewsService().doSearch();
    }

    public BingSearchResponse getStaticData() throws IOException {
        return MAPPER.readValue(resourceFile.getFile(), BingSearchResponse.class);
    }

    public BingTopNewsIntegrationServiceImpl getBingTopNewsService() {
        return bingTopNewsService;
    }

    public void setBingTopNewsService(BingTopNewsIntegrationServiceImpl bingTopNewsService) {
        this.bingTopNewsService = bingTopNewsService;
    }
}
