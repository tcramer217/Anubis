package com.tcramer.anubis.service;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class DHT11ServiceImpl implements DHT11Service {

    @Autowired
    public DHT11ServiceImpl() {
    }

    @Override
    public List<Double> getTemperature() throws IOException, URISyntaxException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler psh = new PumpStreamHandler(outputStream);
        //
        File file = new File("read_temp.py");
        System.out.println(file);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalFile());
        System.out.println(file.getCanonicalPath());

        String line = "python " + file.getCanonicalPath();
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
