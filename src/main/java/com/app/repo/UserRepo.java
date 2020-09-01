package com.app.repo;

import com.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(@Param("username") String username);
}
