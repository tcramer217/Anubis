package com.anubis.family.api.controller;

import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.service.family.FamilyMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMINISTRATOR')")
@RestController
@RequestMapping("/family")
public class FamilyController {

    FamilyMemberService familyMemberService;

    @GetMapping("/{familyId}/members")
    public ResponseEntity<?> getFamilyMembers(@PathVariable long familyId) {
        List<FamilyMember> familyMemberList = getFamilyMemberService().getFamilyMembersByFamilyId(familyId);
        return ResponseEntity.ok(familyMemberList);
    }

    public FamilyMemberService getFamilyMemberService() {
        return familyMemberService;
    }

    @Autowired
    public void setFamilyMemberService(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }
}
