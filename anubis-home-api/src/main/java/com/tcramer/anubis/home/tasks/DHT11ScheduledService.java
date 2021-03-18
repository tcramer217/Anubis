package com.tcramer.anubis.home.tasks;

import com.anubis.core.entity.sensor.DHT11Data;
import com.tcramer.anubis.home.service.DHT11Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DHT11ScheduledService {

    private static final Logger LOG = LoggerFactory.getLogger(DHT11ScheduledService.class);

    @Autowired
    private DHT11Service service;

    @Scheduled(cron = "0 */30 * * * *")
    public void reportCurrentTime() {
        DHT11Data data;
        //
        try {
            data = service.readTempHum();
        } catch (Exception ex) {
            LOG.error("An exception occured reading DHT11 Data: {}", ex.getMessage());
            return;
        }
        LOG.info("Adding new DHT11 reading \n" +
                "ID: {}\n" +
                "Temp: {} \n" +
                "Hum: {}\n" +
                "Date: {}", data.getId(), data.getTemperature(), data.getHumidity(), data.getImportDate());
    }
}
