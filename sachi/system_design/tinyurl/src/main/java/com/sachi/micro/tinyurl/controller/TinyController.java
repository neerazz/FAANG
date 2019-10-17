package com.sachi.micro.tinyurl.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
public class TinyController {
    @PostMapping("/minify")
    public String minify(@RequestBody String url) {
        return LocalDateTime.now().toString();
    }

    @GetMapping("/expand")
    public String expand(@RequestParam String url) {
        return LocalDateTime.now().toString();
    }
}
