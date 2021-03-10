package com.tcramer.anubis.core.entity.family;

import com.tcramer.anubis.core.entity.interfaces.Named;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Family implements Named {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String familyName;

    @OneToMany
    private List<FamilyMember> familyMembers;

    public Family(String familyName) {
        this.familyName = familyName;
    }

    public Family() {
    }

    public long getId() {
        return id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public String getName() {
        return this.getFamilyName();
    }

    @Override
    public void setName(String name) {
        this.setFamilyName(name);
    }
}
