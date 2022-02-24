package com.anubis.family.api.service.family;

import com.anubis.core.entity.family.FamilyMember;

public interface FamilyMemberService {
    FamilyMember getFamilyMemberByUserId(long userId);
}
