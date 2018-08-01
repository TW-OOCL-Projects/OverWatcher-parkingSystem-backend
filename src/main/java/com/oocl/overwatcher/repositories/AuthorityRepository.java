package com.oocl.overwatcher.repositories;

import com.oocl.overwatcher.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    @Query(value = "select a from Authority a where a.role.id=?1")
    List<Authority> findByRoleId(Long id);
}
