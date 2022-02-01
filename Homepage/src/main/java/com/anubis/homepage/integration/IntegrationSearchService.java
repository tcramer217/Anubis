package com.anubis.homepage.integration;

import com.anubis.homepage.data.search.SearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public abstract class IntegrationSearchService<T extends SearchResponse> {

    protected static final String HEADER_API_KEY = "x-rapidapi-key";
    protected static final String HEADER_HOST = "x-rapidapi-host";
    protected static final RestTemplate REST_TEMPLATE = new RestTemplate();

    @Value("${homepage.integration.header.x-rapidapi-key}")
    protected String rapidApiKey;

    protected String rapidApiHost;

    public abstract T doSearch();

    public HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HEADER_HOST, rapidApiHost);
        headers.set(HEADER_API_KEY, rapidApiKey);
        return headers;
    }
}
