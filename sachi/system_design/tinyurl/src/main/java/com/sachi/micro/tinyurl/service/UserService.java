package com.sachi.micro.tinyurl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sachi.micro.tinyurl.model.Users;
import com.sachi.micro.tinyurl.model.UsersDTO;
import com.sachi.micro.tinyurl.repo.UserRepository;
import com.sachi.micro.tinyurl.util.Util;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ObjectMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, ObjectMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UsersDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        List<UsersDTO> usersDTOS = new ArrayList<>(users.size());
        for (Users user : users) {
            usersDTOS.add(mapper.convertValue(user, UsersDTO.class));
        }
        return usersDTOS;
    }

    public Boolean isValidApiKEY(String key) {
        return userRepository.findByApiKey(key).isPresent();
    }

    public UsersDTO createUser(UsersDTO user) {
        Users dbUser = new Users();
        dbUser.setEmail(user.getEmail());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        dbUser.setUserCreateDate(Util.convertLocalToUTC(new Date()));
        dbUser.setApiKey(Util.generateHash(null));
        Users savedUser = userRepository.save(dbUser);
        return mapper.convertValue(savedUser, UsersDTO.class);
    }
}
