package com.tcramer.anubis.service;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DHT11ServiceImpl implements DHT11Service {

    @Autowired
    public DHT11ServiceImpl() {
    }

    @Override
    public List<Double> getTemperature() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler psh = new PumpStreamHandler(outputStream);
        //
        File file = new File("src/main/scripts/dht11_query.py");
        String line = "python " + file.getAbsolutePath();
        //
        CommandLine commandLine = CommandLine.parse(line);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(psh);
        //
        executor.execute(commandLine);
        List<Double> result = new ArrayList<>();
        for(String resp : outputStream.toString().split("\\R")) {
            result.add(Double.parseDouble(resp));
        }
        return result;
    }
}
