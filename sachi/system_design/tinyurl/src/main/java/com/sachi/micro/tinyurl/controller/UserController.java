package com.sachi.micro.tinyurl.controller;

import com.sachi.micro.tinyurl.model.UsersDTO;
import com.sachi.micro.tinyurl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UsersDTO>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @GetMapping("/{apiKey}")
    public ResponseEntity<Boolean> isValidApiKEY(@PathVariable(value = "apiKey")
                                                 @NotBlank(message = "API KEY Cannot be empty")
                                                         String apiKey) {
        return ResponseEntity.ok().body(userService.isValidApiKEY(apiKey));
    }

    @PostMapping("/create")
    public ResponseEntity<UsersDTO> createUser(@Valid @RequestBody UsersDTO user) {
        return ResponseEntity.ok().body(userService.createUser(user));
    }
}
