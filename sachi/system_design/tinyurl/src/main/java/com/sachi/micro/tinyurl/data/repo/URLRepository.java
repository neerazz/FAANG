package com.sachi.micro.tinyurl.data.repo;

import com.sachi.micro.tinyurl.data.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
}
