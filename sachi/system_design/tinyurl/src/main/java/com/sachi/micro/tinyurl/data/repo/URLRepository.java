package com.sachi.micro.tinyurl.data.repo;

import com.sachi.micro.tinyurl.data.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
    List<URL> findByShortURL(String shortURL);
    List<URL> findByLongURL(String longURL);
}
