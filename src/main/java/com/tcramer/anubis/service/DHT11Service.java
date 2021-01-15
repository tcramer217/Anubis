package com.tcramer.anubis.service;

import java.io.IOException;
import java.util.List;

public interface DHT11Service {
    List<Double> getTemperature() throws IOException;
}
