package com.anubis.core.dao;


import com.anubis.core.entity.sensor.DHT11Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DHT11Repo extends JpaRepository<DHT11Data, Long> {
}
