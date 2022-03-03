package com.anubis.family.api.service.family;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.family.api.model.User;
import com.anubis.family.api.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FamilyMemberServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    @Override
    public FamilyMember getFamilyMemberByUserId(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UsernameNotFoundException("Could not find userId."));
        FamilyMember familyMember = familyMemberRepo.findFamilyMemberByEmail(user.getEmail());
        return familyMember;
    }

    @Override
    public List<FamilyMember> getFamilyMembersByFamilyId(long familyId) {
        List<FamilyMember> familyMembers = familyMemberRepo.findFamilyMembersByFamilyId(familyId);
        return familyMembers;
    }
}
