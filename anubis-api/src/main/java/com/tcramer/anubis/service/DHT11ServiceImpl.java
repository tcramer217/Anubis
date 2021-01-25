package com.tcramer.anubis.service;

import com.tcramer.anubis.core.dao.DHT11Repo;
import com.tcramer.anubis.core.model.DHT11Data;
import com.tcramer.anubis.core.util.PythonExecUtil;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class DHT11ServiceImpl implements DHT11Service {

    @Autowired
    private DHT11Repo repo;

    @Autowired
    public DHT11ServiceImpl() {
    }

    @Override
    public DHT11Data readTempHum() throws IOException {
        List<Double> result = new ArrayList<>();
        String[] tempHum = PythonExecUtil.executePythonScript("src/main/resources/read_temp.py");
        for(String resp : Optional.ofNullable(tempHum).orElse(new String[0])) {
            result.add(Double.parseDouble(resp));
        }
        return repo.save(new DHT11Data(result.get(0), result.get(1)));
    }

    @Override
    public List<DHT11Data> getAll() {
        return repo.findAll();
    }

}
