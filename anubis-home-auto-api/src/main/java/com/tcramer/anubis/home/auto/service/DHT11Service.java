package com.tcramer.anubis.home.auto.service;

import com.tcramer.anubis.core.home.auto.model.DHT11Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DHT11Service {
    DHT11Data readTempHum() throws IOException, URISyntaxException;

    List<DHT11Data> getAll();
}
