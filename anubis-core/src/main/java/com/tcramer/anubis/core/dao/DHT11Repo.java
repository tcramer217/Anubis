package com.tcramer.anubis.core.dao;


import com.tcramer.anubis.core.model.DHT11Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DHT11Repo extends JpaRepository<DHT11Data, Long> {
}
