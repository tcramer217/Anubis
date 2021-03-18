package com.anubis.core.entity.sensor;


import com.anubis.core.entity.sub.ImportedSensorData;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DHT11Data")
@EntityListeners(AuditingEntityListener.class)
public class DHT11Data extends ImportedSensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "temp", nullable = false)
    private Double temperature;

    @Column(name = "hum", nullable = false)
    private Double humidity;

    public DHT11Data() {
        super(new Date());
    }

    public DHT11Data(Double temperature, Double humidity) {
        super(new Date());
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public DHT11Data(Double temperature, Double humidity, Date importDate) {
        super(importDate);
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public long getId() {
        return id;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }
}
