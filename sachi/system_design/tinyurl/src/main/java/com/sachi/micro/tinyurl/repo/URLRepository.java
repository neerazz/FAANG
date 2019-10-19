package com.sachi.micro.tinyurl.repo;

import com.sachi.micro.tinyurl.model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
    List<URL> findByShortURL(String shortURL);
    List<URL> findByLongURL(String longURL);
}
