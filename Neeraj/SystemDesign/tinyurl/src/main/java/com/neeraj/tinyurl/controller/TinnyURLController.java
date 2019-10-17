package com.neeraj.tinyurl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TinnyURLController {

    @PostMapping("/minify")
    public String createShorter(@RequestBody String largeURL) {
        return null;
    }

    @GetMapping("/expand")
    public String getLargeURL(@RequestBody String shortURL) {
        return null;
    }
}
