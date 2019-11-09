package com.sachi.micro.tinyurl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import com.sachi.micro.tinyurl.model.TinyURL;
import com.sachi.micro.tinyurl.model.TinyURLDTO;
import com.sachi.micro.tinyurl.model.Users;
import com.sachi.micro.tinyurl.repo.URLRepository;
import com.sachi.micro.tinyurl.repo.UserRepository;
import com.sachi.micro.tinyurl.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@PropertySource("classpath:application.properties")
@Slf4j
public class URLService {

    private final URLRepository urlRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public URLService(URLRepository urlRepository, ObjectMapper objectMapper, UserRepository userRepository) {
        this.urlRepository = urlRepository;
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
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
        TinyURL tinyURL = urlRepository.findByShortURL(shortCode);
        //Invalid Short Code
        if (tinyURL == null || tinyURL.getLongURL() == null || tinyURL.getExpiryDate().before(new Date())) {
            throw new ResourceNotFoundException("URL not found for this id : " + shortCode);
        }
        tinyURL.setHits(tinyURL.getHits() + 1);
        urlRepository.save(tinyURL);
        return tinyURL;
    }


    public TinyURLDTO getShortURL(String longURL, String apiKey) throws ResourceNotFoundException {
        log.debug("getShortURL");
        Optional<Users> user = getUserFromAPI(apiKey);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("Invalid API Key");
        }
        //Create a new code and save it in DB
        TinyURL tinyURL = new TinyURL();
        tinyURL.setShortURL(getUniqueHash(longURL, user.get().getUserId()));
        tinyURL.setLongURL(longURL);
        tinyURL.setCreateDate(Util.convertLocalToUTC(new Date()));

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 2);
        cal.getTime();

        tinyURL.setExpiryDate(Util.convertLocalToUTC(cal.getTime()));
        tinyURL.setUserId(user.get().getUserId());
        TinyURL savedTinyURL = urlRepository.save(tinyURL);
        String generatedCode = savedTinyURL.getShortURL();
        savedTinyURL.setShortURL(url + generatedCode);
        return objectMapper.convertValue(savedTinyURL, TinyURLDTO.class);
    }

    private String getUniqueHash(String longURL, long userId) {
        String code = Util.generateHash(longURL, String.valueOf(userId));
        //Check if generated long URL code is unique
        TinyURL data = urlRepository.findByShortURL(code);
        if (data != null) {
            code = getUniqueHash(longURL, userId);
        }
        return code;
    }

    private Optional<Users> getUserFromAPI(String apiKey) {
        if (StringUtils.isEmpty(apiKey)) {
            return Optional.empty();
        }
        return userRepository.findByApiKey(apiKey);
    }

}
