package com.neeraj.tinyurl.controller;

import com.neeraj.tinyurl.model.dto.MinifyRequestDto;
import com.neeraj.tinyurl.model.dto.MinifyResponseDto;
import com.neeraj.tinyurl.model.dto.SignUpRequestDto;
import com.neeraj.tinyurl.model.dto.SignUpResponseDto;
import com.neeraj.tinyurl.service.TinnyURLService;
import com.neeraj.tinyurl.service.UserManagementService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Slf4j
public class TinnyURLController {

    private TinnyURLService tinnyURLService;
    private UserManagementService userManagementService;

    @Autowired
    public TinnyURLController(TinnyURLService tinnyURLService, UserManagementService userManagementService) {
        this.tinnyURLService = tinnyURLService;
        this.userManagementService = userManagementService;
    }

    @PostMapping("/signup")
    @ApiOperation(value = "This endpoint is to signup and create a new user.")
    public ResponseEntity<SignUpResponseDto> signUp(@Validated @RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userManagementService.createNewUser(signUpRequestDto));
    }

    @PostMapping("/minify")
    @ApiOperation(value = "This endpoint will accept a user name and a Long URl and will create a short URL.")
    public ResponseEntity<MinifyResponseDto> createShorter(@Validated @RequestBody MinifyRequestDto minifyRequestDto) {
        MinifyResponseDto minifyResponseDto = tinnyURLService.minifyURL(minifyRequestDto);
        log.info("created a short URL.");
        log.info("Request : {}", minifyRequestDto.toString());
        log.info("Response : {}", minifyResponseDto.toString());
        return new ResponseEntity<>(minifyResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/expand")
    @ApiOperation(value = "This endpoint will accept a short URL and will redirect it to the long URL.")
    public RedirectView getLargeURL(@RequestParam("shortURL") String shortURL) {
        String getExpandedURL = tinnyURLService.getExpandedURL(shortURL);
        if (getExpandedURL == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL not found. It might be either expired or never created.");
        }
        return new RedirectView(getExpandedURL);
    }

    @GetMapping("/expand/{shortURL}")
    @ApiOperation(value = "This endpoint will accept a short URL and will redirect it to the long URL.")
    public RedirectView getRedirectToLongURL(@PathVariable("shortURL") String shortURL) {
        String redirectURL = null;
        if (shortURL.contains("swagger-ui.html")) {
            redirectURL = shortURL;
        } else {
            redirectURL = tinnyURLService.getExpandedURL(shortURL);
            if (redirectURL == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL not found. It might be either expired or never created.");
            }
        }
        return new RedirectView(redirectURL);
    }

    @GetMapping("/expandedURL")
    @ApiOperation(value = "This endpoint will accept a short URL and will redirect it to the long URL.")
    public String getExpandedURL(@RequestParam("shortURL") String shortURL) {
        String getExpandedURL = tinnyURLService.getExpandedURL(shortURL);
        if (getExpandedURL == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL not found. It might be either expired or never created.");
        }
        return getExpandedURL;
    }
}
