package com.oocl.overwatcher.security.repository;

import com.oocl.overwatcher.security.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);
}