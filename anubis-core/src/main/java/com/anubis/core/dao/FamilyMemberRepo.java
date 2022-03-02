package com.anubis.core.dao;

import com.anubis.core.entity.family.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FamilyMemberRepo extends JpaRepository<FamilyMember, Long> {
    List<FamilyMember> findFamilyMembersByLastName(String lastName);
    List<FamilyMember> findFamilyMembersByFamilyId(long familyId);
    FamilyMember findFamilyMemberByEmail(String email);
}
