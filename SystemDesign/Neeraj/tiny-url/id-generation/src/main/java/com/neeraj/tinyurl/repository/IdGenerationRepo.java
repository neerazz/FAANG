package com.neeraj.tinyurl.repository;

import com.neeraj.tinyurl.model.IdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IdGenerationRepo extends JpaRepository<IdEntity, Long> {

    IdEntity findFirstByTakenIsNull();
}
