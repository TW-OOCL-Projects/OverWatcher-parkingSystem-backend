package com.oocl.overwatcher.repositories;

import com.oocl.overwatcher.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author LIULE9
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
