package com.neeraj.tinyurl.service;

import com.neeraj.tinyurl.model.dto.MinifyRequestDto;
import com.neeraj.tinyurl.model.dto.MinifyResponseDto;
import com.neeraj.tinyurl.model.entity.TinyURLEntity;
import com.neeraj.tinyurl.repository.TinyURLRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class TinnyURLService {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;

    @Value("${tiny.url.host.name}")
    private String urlHostName;
    @Value("${tiny.url.max.retries:0}")
    private Integer maxReties;
    @Autowired
    private TinyURLRepo tinyURLRepo;
    @Autowired
    private ModelMapper modelMapper;

    public MinifyResponseDto minifyURL(MinifyRequestDto minifyRequestDto) {
//        Check if the provided custom URL is already taken.
        if (minifyRequestDto.getShortURL() != null) {
//            Throw an error when a custom short URL is already taken.
            if (tinyURLAlreadyTaken(minifyRequestDto.getShortURL())) {
                throw new ResponseStatusException(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE,
                        "Short URL is already occupied. Send an empty short URL to let a random short URL to be created.");
            }
//            Check if long URL is already registered.
            final List<TinyURLEntity> longURLs = tinyURLRepo.findByLongURL(minifyRequestDto.getLongURL());
            if (!longURLs.isEmpty()) {
//                If long URL is already registered the return the existing URL.
                return modelMapper.map(longURLs.get(0), MinifyResponseDto.class);
            }
//            Else save the Long URL with the custom short URL received.
            TinyURLEntity build = createTinyEntityURL(minifyRequestDto, minifyRequestDto.getShortURL());
            return saveAndReturnResponse(build);
        }
//        If no any custom Short URL is given then create a random short URl.
        String randomString = getARandomTinyURL();
        TinyURLEntity build = createTinyEntityURL(minifyRequestDto, randomString);
        return saveAndReturnResponse(build);
    }

    private String getARandomTinyURL() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//        Generates a random short URL
        String randomShortURL = generateRandomString();
        int tryies = 0;
//        If the random shortURL is already taken then loop for maxReties and keep generating randomShort URL's.
        while (tinyURLAlreadyTaken(randomShortURL)) {
            if (tryies > maxReties) {
//                If the random generated URL's is generated for maxReties and still didn't a shortURL then return a PreCondition Filed error.
                throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                        "Short URL cannot be connected at this moment. Kindly try after some time.");
            }
            randomShortURL = generateRandomString();
            tryies++;
        }
        return randomShortURL;
    }

    private MinifyResponseDto saveAndReturnResponse(TinyURLEntity build) {
        return modelMapper.map(tinyURLRepo.save(build), MinifyResponseDto.class);
    }

    private TinyURLEntity createTinyEntityURL(MinifyRequestDto minifyRequestDto, String randomString) {
        LocalDateTime currentTime = LocalDateTime.now();
        return TinyURLEntity.builder()
                .userID(minifyRequestDto.getUserId())
                .longURL(minifyRequestDto.getLongURL())
                .shortURL(urlHostName + "/expand/" + randomString)
                .createdAt(currentTime)
                .expiringOn(currentTime.plusDays(1))
                .noOfTimesAccessed(0L)
                .build();
    }

    private boolean tinyURLAlreadyTaken(String tinyURL) {
        return tinyURLRepo.findByShortURL(tinyURL).size() > 0;
    }

    public String getExpandedURL(String shortURL) {
        String longURL = null;
        if (!shortURL.contains(urlHostName)) {
            shortURL = urlHostName + "/expand/" + shortURL;
        }
        final List<TinyURLEntity> shortURLs = tinyURLRepo.findByShortURL(shortURL);
        if (shortURLs.size() > 0) {
            final TinyURLEntity tinyURLEntity = shortURLs.get(0);
//            Check if it is expired. And send a error message if expired.
            if (tinyURLEntity.getExpiringOn().isBefore(LocalDateTime.now())) {
                throw new ResponseStatusException(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE,
                        "Short URL is expired.Try creating a new short URL.");
            }
            tinyURLEntity.setNoOfTimesAccessed(tinyURLEntity.getNoOfTimesAccessed() + 1);
            tinyURLRepo.save(tinyURLEntity);
            longURL = tinyURLEntity.getLongURL();
            log.info("Found Short URL.");
            log.info("TinyURLEntity : {}", tinyURLEntity.toString());
        }
        return longURL;
    }

    public String generateRandomString() {
        StringBuilder randStr = new StringBuilder();
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}
