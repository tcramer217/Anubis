package com.anubis.homepage.service.integration.bing;

import com.anubis.homepage.data.search.bing.BingSearchResponse;
import com.anubis.homepage.service.integration.IntegrationSearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BingTopNewsIntegrationServiceImpl extends IntegrationSearchService<BingSearchResponse> {

    private static final String HEADER_BING_API_SDK = "x-bingapis-sdk";

    @Value("${homepage.integration.bing.header.x-rapidapi-host}")
    private String bingApiHost;

    @Value("${homepage.integration.bing.header.x-bingapis-sdk}")
    private String bingApisSdk;

    @Value("${homepage.integration.bing.resource.uri}")
    private String resourceUri;

    @Override
    public HttpHeaders buildHeaders() {
        HttpHeaders headers = super.buildHeaders();
        headers.set(HEADER_BING_API_SDK, bingApisSdk);
        headers.set(HEADER_HOST, bingApiHost);
        return headers;
    }

    @Override
    public BingSearchResponse doSearch() {
        HttpHeaders headers = buildHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<BingSearchResponse> response =
                REST_TEMPLATE.exchange(resourceUri, HttpMethod.GET, entity, BingSearchResponse.class);
        return response.getBody();
    }
}
