package com.anubis.homepage.data.search.weatherAPI;

import com.anubis.homepage.data.search.SearchResponse;

public class WeatherAPISearchResponse extends SearchResponse {

    private WeatherLocationResponse location;
    private WeatherCurrentResponse current;

    public WeatherAPISearchResponse() {
    }

    public WeatherLocationResponse getLocation() {
        return location;
    }

    public void setLocation(WeatherLocationResponse location) {
        this.location = location;
    }

    public WeatherCurrentResponse getCurrent() {
        return current;
    }

    public void setCurrent(WeatherCurrentResponse current) {
        this.current = current;
    }
}
