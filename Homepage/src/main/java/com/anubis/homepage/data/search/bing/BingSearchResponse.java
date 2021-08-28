package com.anubis.homepage.data.search.bing;

import com.anubis.homepage.data.search.SearchResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BingSearchResponse extends SearchResponse {

    @JsonProperty("_type")
    private String type;
    private List<BingSearchResponseItem> value;

    public BingSearchResponse() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BingSearchResponseItem> getValue() {
        return value;
    }

    public void setValue(List<BingSearchResponseItem> value) {
        this.value = value;
    }
}
