package com.anubis.family.api.controller;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.model.User;
import com.anubis.family.api.repo.UserRepository;
import com.anubis.family.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@PreAuthorize("hasRole('USER')")
public class ProfileController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<FamilyMember> getUserProfile(@PathVariable Integer userId) {
        User userAccount = userRepository.findById(userId.longValue())
                .orElseThrow(() -> new UsernameNotFoundException("Could not find userId"));
        FamilyMember memberProfile = getFamilyMemberRepo().findFamilyMemberByEmail(userAccount.getEmail());

        return ResponseEntity.ok(memberProfile);
    }

    public JwtUtil getJwtUtil() {
        return jwtUtil;
    }

    public void setJwtUtil(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }
}
