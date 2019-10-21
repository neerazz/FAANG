package com.neeraj.tinyurl.service;

import com.neeraj.tinyurl.model.dto.SignUpRequestDto;
import com.neeraj.tinyurl.model.dto.SignUpResponseDto;
import com.neeraj.tinyurl.model.entity.UserDetailsAccessedEntity;
import com.neeraj.tinyurl.model.entity.UserDetailsEntity;
import com.neeraj.tinyurl.repository.UserDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagementService {

    private UserDetailsRepo userDetailsRepo;
    private ModelMapper modelMapper;

    @Value("${tiny.url.salt.key}")
    private String saltKey;

    @Autowired
    public UserManagementService(UserDetailsRepo userDetailsRepo, ModelMapper modelMapper) {
        this.userDetailsRepo = userDetailsRepo;
        this.modelMapper = modelMapper;
    }

    public SignUpResponseDto createNewUser(SignUpRequestDto signUpRequestDto) {
        if (userIDNotAvailable(signUpRequestDto.getUserID())) {
            throw new ResponseStatusException(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, "User ID is already taken.");
        }
        UserDetailsEntity userDetailsEntity = UserDetailsEntity.builder()
                .userID(signUpRequestDto.getUserID())
                .accessToken(createAccessToken(signUpRequestDto))
                .usagePlan(signUpRequestDto.getUsagePlan())
                .noOfRequestsPerDay(signUpRequestDto.getUsagePlan().getNumberOfHitsPerDay())
                .build();
        UserDetailsEntity savedObject = userDetailsRepo.save(userDetailsEntity);
        validUserAndHasAccessLimit(savedObject.getAccessToken());
        return modelMapper.map(savedObject, SignUpResponseDto.class);
    }

    public boolean validUserAndHasAccessLimit(String accessToken) {
        UserDetailsEntity userDetailsEntities = userDetailsRepo.findByAccessToken(accessToken);
        if (userDetailsEntities != null) {
            if (userDetailsEntities.getLastAccessed() == null) {
                userDetailsEntities.setLastAccessed(new ArrayList<>());
            }
            UserDetailsAccessedEntity todaysAccessedDetails = getTodaysAccessedDetails(userDetailsEntities.getLastAccessed());
            if (todaysAccessedDetails.getNoOfTimesAccessed() > userDetailsEntities.getNoOfRequestsPerDay()) {
                return false;
            } else {
                userDetailsEntities.getLastAccessed().add(todaysAccessedDetails);
                UserDetailsEntity savedEntity = userDetailsRepo.save(userDetailsEntities);
                return true;
            }
        }
        return false;
    }

    private UserDetailsAccessedEntity getTodaysAccessedDetails(List<UserDetailsAccessedEntity> lastAccessed) {
        return lastAccessed.parallelStream()
                .filter(details -> details.getAccessedDate().equals(Timestamp.valueOf(LocalDateTime.now())))
                .map(this::createUserAccessed).findAny().orElse(createUserAccessed(null));
    }

    private UserDetailsAccessedEntity createUserAccessed(UserDetailsAccessedEntity userDetailsAccessedEntity) {
        int noOfTimesAccessed = 1;
        if (userDetailsAccessedEntity != null) {
            noOfTimesAccessed += userDetailsAccessedEntity.getNoOfTimesAccessed();
        }
        return UserDetailsAccessedEntity.builder()
                .accessedDate(Timestamp.valueOf(LocalDateTime.now()))
                .noOfTimesAccessed(noOfTimesAccessed)
                .build();
    }

    private String createAccessToken(SignUpRequestDto signUpRequestDto) {
        String accessToken = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(saltKey.getBytes());
            accessToken = bytesToHex(md.digest(signUpRequestDto.toString().getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There was an internal error.");
        }
        return accessToken;
    }

    private String bytesToHex(byte[] bytes) {
        BigInteger bigInteger = new BigInteger(1, bytes);
        return bigInteger.toString(16);
    }

    private boolean userIDNotAvailable(String userID) {
        return userDetailsRepo.countByUserID(userID) > 0;
    }

    public UserDetails getUserDetails(String token, String username) {
        return new User(username, token, AuthorityUtils.createAuthorityList("USER"));
    }
}
