package com.anubis.core.dao;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DisplayName("Verify the functionality of the ReminderRepo.")
@DataJpaTest
public class FamilyMemberRepoTestDB {


    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }
}
