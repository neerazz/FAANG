package com.neeraj.tinyurl.repository;

import com.neeraj.tinyurl.model.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, Long> {
    int countByUserID(String userID);

    UserDetailsEntity findByAccessToken(String accessToken);
}
