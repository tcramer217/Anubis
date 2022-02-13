package com.anubis.family.api.repo;

import com.anubis.family.api.model.Role;
import com.anubis.family.api.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
