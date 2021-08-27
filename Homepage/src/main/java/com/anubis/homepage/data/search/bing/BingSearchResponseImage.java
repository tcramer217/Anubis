package com.anubis.homepage.data.search.bing;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BingSearchResponseImage {

    @JsonProperty("_type")
    private String type;
    private String url;
    private List<BingSearchResponseImageProvider> provider;

    public BingSearchResponseImage() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<BingSearchResponseImageProvider> getProvider() {
        return provider;
    }

    public void setProvider(List<BingSearchResponseImageProvider> provider) {
        this.provider = provider;
    }

    public static class BingSearchResponseImageProvider {

        @JsonProperty("_type")
        public String type;
        public String name;

        public BingSearchResponseImageProvider() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
