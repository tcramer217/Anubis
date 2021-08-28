package com.anubis.homepage.data.search.bing;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BingSearchResponseItem {

    @JsonProperty("_type")
    private String type;
    private String name;
    private String webSearchUrl;
    private String newsSearchUrl;
    private Boolean isBreakingNews;
    private BingSearchResponseImage image;
    private BingSearchResponseQuery query;

    public BingSearchResponseItem() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebSearchUrl() {
        return webSearchUrl;
    }

    public void setWebSearchUrl(String webSearchUrl) {
        this.webSearchUrl = webSearchUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BingSearchResponseImage getImage() {
        return image;
    }

    public void setImage(BingSearchResponseImage image) {
        this.image = image;
    }

    public Boolean getIsBreakingNews() {
        return isBreakingNews;
    }

    public void setIsBreakingNews(Boolean isBreakingNews) {
        this.isBreakingNews = isBreakingNews;
    }

    public BingSearchResponseQuery getQuery() {
        return query;
    }

    public void setQuery(BingSearchResponseQuery query) {
        this.query = query;
    }

    public String getNewsSearchUrl() {
        return newsSearchUrl;
    }

    public void setNewsSearchUrl(String newsSearchUrl) {
        this.newsSearchUrl = newsSearchUrl;
    }

    public static class BingSearchResponseQuery {

        @JsonProperty("_type")
        private String type;
        private String text;

        public BingSearchResponseQuery() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
