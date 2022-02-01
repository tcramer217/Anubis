package com.anubis.homepage.service.weather;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.data.search.weatherAPI.WeatherAPISearchResponse;
import com.anubis.homepage.integration.bing.BingTopNewsIntegrationServiceImpl;
import com.anubis.homepage.service.news.NewsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.Logger;

@Service
public class WeatherService {

    public static final ObjectMapper MAPPER = JsonMapper.builder().findAndAddModules().build();
    public static final Logger LOGGER = Logger.getLogger(WeatherService.class.getName());

    @Value("classpath:data/WeatherAPIExampleResponse.json")
    Resource resourceFile;

    public WeatherAPISearchResponse getStaticData() throws IOException {
        return MAPPER.readValue(resourceFile.getFile(), WeatherAPISearchResponse.class);
    }
}
