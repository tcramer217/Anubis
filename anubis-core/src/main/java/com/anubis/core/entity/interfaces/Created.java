package com.anubis.core.entity.interfaces;

import com.anubis.core.entity.family.FamilyMember;

import java.time.LocalDateTime;

/**
 * The Created interface is for any entity that is to have a
 * CreateBy (FamilyMember) and CreatedAt (LocalDateTime)
 */
public interface Created {

    FamilyMember getCreatedBy();
    void setCreatedBy(FamilyMember familyMember);

    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime createdAt);
}
