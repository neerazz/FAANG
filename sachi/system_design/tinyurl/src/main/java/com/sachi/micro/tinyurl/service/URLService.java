package com.sachi.micro.tinyurl.service;

import com.sachi.micro.tinyurl.model.URL;
import com.sachi.micro.tinyurl.repo.URLRepository;
import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class URLService {

    @Autowired
    private URLRepository urlRepository;

    private static final String INPUT = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

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


    public URL getShortURL(String longURL, int length) {

        //Check if Long URL already exists in DB
        List<URL> longURLData = urlRepository.findByLongURL(longURL);
        if (longURLData != null && longURLData.size() > 0) {
            URL url = longURLData.get(0);
            String code = url.getShortURL();
            url.setShortURL("http://localhost:8080/" + code);
            return url;
        }

        //We did not already cache LongURL - So build one
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(INPUT.charAt(rnd.nextInt(INPUT.length())));
        }

        //Check if generated long URL is unique
        List<URL> data = urlRepository.findByShortURL(sb.toString());
        if (data != null && !data.isEmpty()) {
            getShortURL(longURL, ++length);
        }

        //Save the new one in DB
        URL url = new URL();
        url.setShortURL(sb.toString());
        url.setLongURL(longURL);
        URL savedURL = urlRepository.save(url);
        String generatedCode = savedURL.getShortURL();
        savedURL.setShortURL("http://localhost:8080/" + generatedCode);
        return savedURL;
    }
}
