package com.anubis.core.entity.family;

import com.anubis.core.entity.interfaces.Named;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"email"})
)
@EntityListeners(AuditingEntityListener.class)
public class FamilyMember implements Named {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private int familyId;

    public FamilyMember(String firstName, String lastName, String email, int familyId) {
        EmailValidator emailValidator = EmailValidator.getInstance(true);
        Boolean emailValid = emailValidator.isValid(email);
        if (!emailValid) {
            throw new IllegalArgumentException("Valid email is required.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.familyId = familyId;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
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
