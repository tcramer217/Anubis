package com.anubis.homepage.service.search.bing;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.service.search.SearchService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BingTopNewsServiceImpl implements SearchService {

    @Override
    public BingSearchResponse doSearch() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-bingapis-sdk", "true");
        headers.set("x-rapidapi-host", "bing-news-search1.p.rapidapi.com");
        headers.set("x-rapidapi-key", "5476d5ccd4msh5133408d8bac762p1ea24fjsne63321271c84");

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        String resource = "https://bing-news-search1.p.rapidapi.com/news/trendingtopics?safeSearch=Off&textFormat=Raw";

        ResponseEntity<BingSearchResponse> response =
                restTemplate.exchange(resource, HttpMethod.GET, entity, BingSearchResponse.class);
        return response.getBody();
    }
}
