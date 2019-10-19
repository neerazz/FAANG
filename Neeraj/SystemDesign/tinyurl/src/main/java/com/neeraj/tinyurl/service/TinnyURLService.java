package com.neeraj.tinyurl.service;

import com.neeraj.tinyurl.model.MinifyRequestDto;
import com.neeraj.tinyurl.model.MinifyResponseDto;
import com.neeraj.tinyurl.model.TinyURLEntity;
import com.neeraj.tinyurl.repository.TinyURLRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (minifyRequestDto.getShortURL() != null) {
            if (tinyURLNotAvailable(minifyRequestDto.getShortURL())) {
                throw new ResponseStatusException(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE,
                        "Short URL is already occupied. Send an empty short URL to let a random short URL to be created.");
            } else {
                TinyURLEntity build = createTinyEntityURL(minifyRequestDto, minifyRequestDto.getShortURL());
                return saveAndReturnResponse(build);
            }
        }
        String randomString = getARandomTinyURL();
        TinyURLEntity build = createTinyEntityURL(minifyRequestDto, randomString);
        return saveAndReturnResponse(build);
    }

    private String getARandomTinyURL() {
        String randomString = generateRandomString();
        int tryies = 0;
        while (tinyURLNotAvailable(randomString)) {
            if (tryies > maxReties) {
                throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
                        "Short URL cannot be connected at this moment. Kindly try after some time.");
            }
            randomString = generateRandomString();
            tryies++;
        }
        return randomString;
    }

    private MinifyResponseDto saveAndReturnResponse(TinyURLEntity build) {
        return modelMapper.map(tinyURLRepo.save(build), MinifyResponseDto.class);
    }

    private TinyURLEntity createTinyEntityURL(MinifyRequestDto minifyRequestDto, String randomString) {
        LocalDateTime currentTime = LocalDateTime.now();
        return TinyURLEntity.builder()
                .userID(minifyRequestDto.getUserId())
                .longURL(minifyRequestDto.getLongURL())
                .shortURL(urlHostName + "/" + randomString)
                .createdAt(currentTime)
                .expiringOn(currentTime.plusDays(1))
                .noOfTimesAccessed(0L)
                .build();
    }

    private boolean tinyURLNotAvailable(String tinyURL) {
        return tinyURLRepo.countByShortURL(tinyURL) > 0;
    }

    public String getExpandedURL(String shortURL) {
        String longURL = null;
        final List<TinyURLEntity> shortURLs = tinyURLRepo.findByShortURL(shortURL);
        if (shortURLs.size() > 0) {
            final TinyURLEntity tinyURLEntity = shortURLs.get(0);
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
