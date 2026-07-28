package com.example.devsupport.master.repository;

import com.example.devsupport.master.entity.SystemRole;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SystemRoleRepository extends JpaRepository<SystemRole, Long> {
    Optional<SystemRole> findByCode(String code);
}
