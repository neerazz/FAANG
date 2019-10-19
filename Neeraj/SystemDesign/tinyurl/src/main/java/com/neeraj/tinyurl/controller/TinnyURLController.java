package com.neeraj.tinyurl.controller;

import com.neeraj.tinyurl.model.MinifyRequestDto;
import com.neeraj.tinyurl.model.MinifyResponseDto;
import com.neeraj.tinyurl.service.TinnyURLService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class TinnyURLController {

    private TinnyURLService tinnyURLService;

    @Autowired
    public TinnyURLController(TinnyURLService tinnyURLService) {
        this.tinnyURLService = tinnyURLService;
    }

    @PostMapping("/minify")
    @ApiOperation(value = "This endpoint will accept a user name and a Long URl and will create a short URL.")
    @ResponseBody
    public ResponseEntity<MinifyResponseDto> createShorter(@Validated @RequestBody MinifyRequestDto minifyRequestDto) {
        MinifyResponseDto minifyResponseDto = tinnyURLService.minifyURL(minifyRequestDto);
        log.info("created a short URL.");
        log.info("Request : {}", minifyRequestDto.toString());
        log.info("Response : {}", minifyResponseDto.toString());
        return new ResponseEntity<>(minifyResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/expand")
    @ApiOperation(value = "This endpoint will accept a short URL and will redirect it to the long URL.")
    public ModelAndView getLargeURL(@RequestParam String shortURL) {
        String getExpandedURL = tinnyURLService.getExpandedURL(shortURL);
        if (getExpandedURL == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL not found. It might be either expired or never created.");
        }
        return new ModelAndView("redirect:" + getExpandedURL);
    }
}
