package com.sachi.micro.tinyurl.repo;

import com.sachi.micro.tinyurl.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Long> {
    Optional<Users> findByApiKey(String apiKey);
}
