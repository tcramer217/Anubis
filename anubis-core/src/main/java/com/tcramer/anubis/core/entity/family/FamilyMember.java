package com.tcramer.anubis.core.entity.family;

import com.tcramer.anubis.core.entity.interfaces.Named;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class FamilyMember implements Named {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    @ManyToOne
    private Family family;

    public FamilyMember(String firstName, String lastName, Family family) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.family = family;
    }

    public FamilyMember() {
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String getName() {
        return this.lastName + ", " + this.firstName;
    }

    @Override
    public void setName(String name) {
        this.firstName = name;
    }
}
