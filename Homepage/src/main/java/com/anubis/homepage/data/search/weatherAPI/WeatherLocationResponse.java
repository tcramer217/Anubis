package com.anubis.homepage.data.search.weatherAPI;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.TimeZone;

public class WeatherLocationResponse {

    private String name;
    private String region;
    private String country;
    private BigDecimal lat;
    private BigDecimal lon;
    private TimeZone tz_id;
    private Timestamp localtime_epoch;
    private String localtime;

    public WeatherLocationResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public TimeZone getTz_id() {
        return tz_id;
    }

    public void setTz_id(TimeZone tz_id) {
        this.tz_id = tz_id;
    }

    public Timestamp getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(Timestamp localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
}
