package com.anubis.core.dao;

import com.anubis.core.AnubisTestConstants;
import com.anubis.core.entity.family.Family;
import com.anubis.core.entity.family.FamilyMember;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DisplayName("Verify the functionality of the FamilyMemberRepo.")
@DataJpaTest
public class FamilyMemberRepoTestDB {

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @Autowired
    private FamilyRepo familyRepo;

    @Test
    @Rollback(false)
    void create() {
//        Family family = new Family(AnubisTestConstants.FAMILY_NAME);
//        Family savedFamily = getFamilyRepo().save(family);
//        FamilyMember familyMember = new FamilyMember(
//                AnubisTestConstants.FAMILY_MEMBER_FIRST_NAME,
//                AnubisTestConstants.FAMILY_MEMBER_LAST_NAME,
//                AnubisTestConstants.FAMILY_MEMBER_EMAIL_ADDRESS,
//                savedFamily);
//
//        FamilyMember createdFamilyMember = getFamilyMemberRepo().saveAndFlush(familyMember);
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_FIRST_NAME, createdFamilyMember.getFirstName());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME, createdFamilyMember.getLastName());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME, createdFamilyMember.getFamily().getFamilyName());
    }

    @Test
    void read() {
//        List<FamilyMember> familyMembers = getFamilyMemberRepo().findFamilyMembersByLastName(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME);
//        FamilyMember familyMember = familyMembers.get(0);
//        Assertions.assertEquals(1, familyMembers.size());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_FIRST_NAME, familyMember.getFirstName());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME, familyMember.getLastName());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME, familyMember.getFamily().getFamilyName());
    }

    @Test
    void update() {
//        List<FamilyMember> families = getFamilyMemberRepo().findFamilyMembersByLastName(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME);
//        FamilyMember familyMember = families.get(0);
//        familyMember.setFirstName(AnubisTestConstants.FAMILY_MEMBER_FIRST_NAME + "UPDATE");
//        FamilyMember savedFamilyMember = getFamilyMemberRepo().save(familyMember);
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_FIRST_NAME + "UPDATE", savedFamilyMember.getFirstName());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME, savedFamilyMember.getLastName());
//        Assertions.assertEquals(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME, savedFamilyMember.getFamily().getFamilyName());
    }

    @Test
    void delete() {
//        List<FamilyMember> familyMembers = getFamilyMemberRepo().findFamilyMembersByLastName(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME);
//        FamilyMember familyMember = familyMembers.get(0);
//        getFamilyMemberRepo().delete(familyMember);
//
//        Assertions.assertEquals(0, getFamilyMemberRepo().findFamilyMembersByLastName(AnubisTestConstants.FAMILY_MEMBER_LAST_NAME).size());
    }

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }

    public FamilyRepo getFamilyRepo() {
        return familyRepo;
    }

    public void setFamilyRepo(FamilyRepo familyRepo) {
        this.familyRepo = familyRepo;
    }
}
