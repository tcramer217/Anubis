package com.anubis.homepage.data.search.weatherAPI;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class WeatherCurrentResponse {

    private Timestamp last_updated_epoch;
    private String last_updated;
    private BigDecimal temp_c;
    private BigDecimal temp_f;
    private BigInteger is_day;
    private WeatherCurrentConditionResponse condition;
    private BigDecimal wind_mph;
    private BigInteger wind_kph;
    private BigInteger wind_degree;
    private String wind_dir;
    private BigInteger pressure_mb;
    private BigDecimal pressure_in;
    private BigInteger precip_mm;
    private BigDecimal precip_in;
    private BigInteger humidity;
    private BigInteger cloud;
    private BigDecimal feelslike_c;
    private BigDecimal feelslike_f;
    private BigInteger vis_km;
    private BigInteger vis_miles;
    private BigInteger uv;
    private BigDecimal gust_mph;
    private BigDecimal gust_kph;

    public WeatherCurrentResponse() {
    }

    public Timestamp getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(Timestamp last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public BigDecimal getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(BigDecimal temp_c) {
        this.temp_c = temp_c;
    }

    public BigDecimal getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(BigDecimal temp_f) {
        this.temp_f = temp_f;
    }

    public BigInteger getIs_day() {
        return is_day;
    }

    public void setIs_day(BigInteger is_day) {
        this.is_day = is_day;
    }

    public WeatherCurrentConditionResponse getCondition() {
        return condition;
    }

    public void setCondition(WeatherCurrentConditionResponse condition) {
        this.condition = condition;
    }

    public BigDecimal getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(BigDecimal wind_mph) {
        this.wind_mph = wind_mph;
    }

    public BigInteger getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(BigInteger wind_kph) {
        this.wind_kph = wind_kph;
    }

    public BigInteger getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(BigInteger wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public BigInteger getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(BigInteger pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public BigDecimal getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(BigDecimal pressure_in) {
        this.pressure_in = pressure_in;
    }

    public BigInteger getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(BigInteger precip_mm) {
        this.precip_mm = precip_mm;
    }

    public BigDecimal getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(BigDecimal precip_in) {
        this.precip_in = precip_in;
    }

    public BigInteger getHumidity() {
        return humidity;
    }

    public void setHumidity(BigInteger humidity) {
        this.humidity = humidity;
    }

    public BigInteger getCloud() {
        return cloud;
    }

    public void setCloud(BigInteger cloud) {
        this.cloud = cloud;
    }

    public BigDecimal getFeelslike_c() {
        return feelslike_c;
    }

    public void setFeelslike_c(BigDecimal feelslike_c) {
        this.feelslike_c = feelslike_c;
    }

    public BigDecimal getFeelslike_f() {
        return feelslike_f;
    }

    public void setFeelslike_f(BigDecimal feelslike_f) {
        this.feelslike_f = feelslike_f;
    }

    public BigInteger getVis_km() {
        return vis_km;
    }

    public void setVis_km(BigInteger vis_km) {
        this.vis_km = vis_km;
    }

    public BigInteger getVis_miles() {
        return vis_miles;
    }

    public void setVis_miles(BigInteger vis_miles) {
        this.vis_miles = vis_miles;
    }

    public BigInteger getUv() {
        return uv;
    }

    public void setUv(BigInteger uv) {
        this.uv = uv;
    }

    public BigDecimal getGust_mph() {
        return gust_mph;
    }

    public void setGust_mph(BigDecimal gust_mph) {
        this.gust_mph = gust_mph;
    }

    public BigDecimal getGust_kph() {
        return gust_kph;
    }

    public void setGust_kph(BigDecimal gust_kph) {
        this.gust_kph = gust_kph;
    }
}
