package com.anubis.core.dao;

import com.anubis.core.entity.family.Family;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyRepo extends JpaRepository<Family, Long> {
    List<Family> findFamilyByFamilyName(String familyName);
}
