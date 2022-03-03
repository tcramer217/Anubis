package com.anubis.family.api.service.family;

import com.anubis.core.entity.family.FamilyMember;

import java.util.List;

public interface FamilyMemberService {
    FamilyMember save(FamilyMember familyMember);
    FamilyMember getFamilyMemberByEmail(String emailAddress);
    FamilyMember getFamilyMemberByUserId(long userId);
    List<FamilyMember> getFamilyMembersByFamilyId(long familyId);
}
