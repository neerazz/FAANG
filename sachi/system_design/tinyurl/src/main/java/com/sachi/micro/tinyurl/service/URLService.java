package com.sachi.micro.tinyurl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import com.sachi.micro.tinyurl.model.TinyURL;
import com.sachi.micro.tinyurl.model.TinyURLDTO;
import com.sachi.micro.tinyurl.repo.URLRepository;
import com.sachi.micro.tinyurl.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:application.properties")
@Slf4j
public class URLService {

    private final URLRepository urlRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public URLService(URLRepository urlRepository, ObjectMapper objectMapper) {
        this.urlRepository = urlRepository;
        this.objectMapper = objectMapper;
    }

    @Value("${env.url}")
    private String url;

    public List<TinyURLDTO> getAll() {
        List<TinyURL> urls = urlRepository.findAll();
        List<TinyURLDTO> urlDtos = new ArrayList<>();
        for (TinyURL tinyURL : urls) {
            TinyURLDTO urldto = objectMapper.convertValue(tinyURL, TinyURLDTO.class);
            urldto.setShortURL(url + urldto.getShortURL());
            urlDtos.add(urldto);
        }
        return urlDtos;
    }

    public TinyURL getURLById(String shortCode) throws ResourceNotFoundException {
        List<TinyURL> tinyURL = urlRepository.findByShortURL(shortCode);
        if (tinyURL == null || tinyURL.isEmpty()) {
            throw new ResourceNotFoundException("URL not found for this id : " + shortCode);
        }
        return tinyURL.get(0);
    }


    public TinyURLDTO getShortURL(String longURL, String userId) {
        log.debug("getShortURL");
        //Create a new code and save it in DB
        TinyURL tinyURL = new TinyURL();
        tinyURL.setShortURL(getUniqueHash(longURL, userId));
        tinyURL.setLongURL(longURL);
        TinyURL savedTinyURL = urlRepository.save(tinyURL);
        String generatedCode = savedTinyURL.getShortURL();
        savedTinyURL.setShortURL(url + generatedCode);
        return objectMapper.convertValue(savedTinyURL, TinyURLDTO.class);
    }

    private String getUniqueHash(String longURL, String userId) {
        String code = Util.generateHash(longURL, userId);
        //Check if generated long URL code is unique
        List<TinyURL> data = urlRepository.findByShortURL(code);
        if (data != null && !data.isEmpty()) {
            code = getUniqueHash(longURL, userId);
        }
        return code;
    }

}
