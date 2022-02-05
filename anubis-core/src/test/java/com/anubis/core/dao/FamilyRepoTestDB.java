package com.anubis.core.dao;

import com.anubis.core.entity.family.Family;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static com.anubis.core.AnubisTestConstants.FAMILY_NAME;

@DisplayName("Verify the functionality of the FamilyRepo.")
@DataJpaTest
public class FamilyRepoTestDB {



    @Autowired
    private FamilyRepo familyRepo;

    @Test
    @Rollback(false)
    void create() {
        Family family = new Family(FAMILY_NAME);

        Family createdFamily = getFamilyRepo().saveAndFlush(family);
        Assertions.assertEquals(FAMILY_NAME, createdFamily.getName());
        Assertions.assertEquals(FAMILY_NAME, createdFamily.getFamilyName());
    }

    @Test
    void read() {
        List<Family> families = getFamilyRepo().findFamilyByFamilyName(FAMILY_NAME);
        Family family = families.get(0);
        Assertions.assertEquals(1, families.size());
        Assertions.assertEquals(FAMILY_NAME, family.getFamilyName());
    }

    @Test
    void update() {
        List<Family> families = getFamilyRepo().findFamilyByFamilyName(FAMILY_NAME);
        Family family = families.get(0);
        family.setFamilyName(FAMILY_NAME + " Update");
        Family savedFamily = getFamilyRepo().save(family);
        Assertions.assertEquals(FAMILY_NAME + " Update", savedFamily.getFamilyName());
    }

    @Test
    void delete() {
        List<Family> families = getFamilyRepo().findFamilyByFamilyName(FAMILY_NAME);
        Family family = families.get(0);
        getFamilyRepo().delete(family);

        Assertions.assertEquals(0, getFamilyRepo().findFamilyByFamilyName(FAMILY_NAME).size());
    }

    public FamilyRepo getFamilyRepo() {
        return familyRepo;
    }

    public void setFamilyRepo(FamilyRepo familyRepo) {
        this.familyRepo = familyRepo;
    }
}
