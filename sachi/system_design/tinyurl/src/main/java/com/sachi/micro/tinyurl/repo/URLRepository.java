package com.sachi.micro.tinyurl.repo;

import com.sachi.micro.tinyurl.model.TinyURL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URLRepository extends JpaRepository<TinyURL, Long> {
    TinyURL findByShortURL(String shortURL);
    List<TinyURL> findByLongURL(String longURL);
}
