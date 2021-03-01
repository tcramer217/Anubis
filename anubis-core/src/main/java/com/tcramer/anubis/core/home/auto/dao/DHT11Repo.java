package com.tcramer.anubis.core.home.auto.dao;


import com.tcramer.anubis.core.home.auto.model.DHT11Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DHT11Repo extends JpaRepository<DHT11Data, Long> {
}
