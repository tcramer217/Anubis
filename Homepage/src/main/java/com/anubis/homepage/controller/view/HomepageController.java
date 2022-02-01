package com.anubis.homepage.controller.view;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.data.search.weatherAPI.WeatherAPISearchResponse;
import com.anubis.homepage.service.news.NewsService;
import com.anubis.homepage.service.weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HomepageController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping(value = "/home")
    public String homePage(Model model) throws IOException {
        BingSearchResponse topNews = getNewsService().getStaticData();
        WeatherAPISearchResponse currentWeather = getWeatherService().getStaticData();
        model.addAttribute("newsTitle", topNews.getType());
        model.addAttribute("newsItems", topNews.getValue());
        model.addAttribute("weatherCurrent", currentWeather);
        return "homepage";
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }

    public void setWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
}
