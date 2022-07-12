package com.anubis.core.service.family;

import com.anubis.core.dao.FamilyMemberRepo;
import com.anubis.core.entity.family.FamilyMember;
import com.anubis.core.entity.User;
import com.anubis.core.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FamilyMemberServiceImpl.class);

    private UserRepository userRepository;
    private FamilyMemberRepo familyMemberRepo;

    @Override
    public FamilyMember getFamilyMemberByUserId(long userId) {
        User user = getUserRepository().findById(userId).orElseThrow(() -> new UsernameNotFoundException("Could not find userId."));
        return getFamilyMemberRepo().findFamilyMemberByEmail(user.getEmail());
    }

    @Override
    public List<FamilyMember> getFamilyMembersByFamilyId(long familyId) {
        return getFamilyMemberRepo().findFamilyMembersByFamilyId(familyId);
    }

    @Override
    public FamilyMember getFamilyMemberByEmail(String emailAddress) {
        return getFamilyMemberRepo().findFamilyMemberByEmail(emailAddress);
    }

    @Override
    public FamilyMember save(FamilyMember familyMember) {
        return getFamilyMemberRepo().save(familyMember);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public FamilyMemberRepo getFamilyMemberRepo() {
        return familyMemberRepo;
    }

    @Autowired
    public void setFamilyMemberRepo(FamilyMemberRepo familyMemberRepo) {
        this.familyMemberRepo = familyMemberRepo;
    }
}
