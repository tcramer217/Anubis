package com.tcramer.anubis.service;

import com.tcramer.anubis.core.model.DHT11Data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface DHT11Service {
    DHT11Data readTempHum() throws IOException, URISyntaxException;

    List<DHT11Data> getAll();
}
