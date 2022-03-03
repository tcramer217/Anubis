package com.anubis.core.dao;

import com.anubis.core.constants.Roles;
import com.anubis.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
