package com.oocl.overwatcher.repositories;

import com.oocl.overwatcher.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String name);
    @Query(value = "update User set `status` = ?2 where id = ?1", nativeQuery = true)
    @Modifying
    void updateStatusById( Long id, String status);
}
