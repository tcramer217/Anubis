package com.anubis.homepage.controller.view;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomepageController {

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/home")
    public String homePage(Model model) throws IOException {
        BingSearchResponse response = getNewsService().getStaticData();
        model.addAttribute("newsTitle", response.getType());
        model.addAttribute("newsItems", response.getValue());
        return "homepage";
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }
}
