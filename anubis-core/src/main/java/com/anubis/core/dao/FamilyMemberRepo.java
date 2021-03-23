package com.anubis.core.dao;

import com.anubis.core.entity.family.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepo extends JpaRepository<FamilyMember, Long> {
}
