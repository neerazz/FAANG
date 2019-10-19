package com.sachi.micro.tinyurl.service;

import com.sachi.micro.tinyurl.model.URL;
import com.sachi.micro.tinyurl.repo.URLRepository;
import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import com.sachi.micro.tinyurl.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.UndeclaredThrowableException;
import java.security.SecureRandom;
import java.util.List;

@Service
public class URLService {

    private final URLRepository urlRepository;

    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public List<URL> getAll() {
        return urlRepository.findAll();
    }

    public URL getURLById(String shortCode) throws ResourceNotFoundException {
        List<URL> url = urlRepository.findByShortURL(shortCode);
        if (url == null || url.isEmpty()) {
            throw new ResourceNotFoundException("URL not found for this id : " + shortCode);
        }
        return url.get(0);
    }


    public URL getShortURL(String longURL, String userId) {
        //Create a new code and save it in DB
        URL url = new URL();
        url.setShortURL(getUniqueHash(longURL, userId));
        url.setLongURL(longURL);
        URL savedURL = urlRepository.save(url);
        String generatedCode = savedURL.getShortURL();
        savedURL.setShortURL("http://localhost:8080/" + generatedCode);
        return savedURL;
    }

    private String getUniqueHash(String longURL, String userId) {
        String code = Util.generateHash(longURL, userId);
        //Check if generated long URL code is unique
        List<URL> data = urlRepository.findByShortURL(code);
        if (data != null && !data.isEmpty()) {
            code = getUniqueHash(longURL, userId);
        }
        return code;
    }

}
