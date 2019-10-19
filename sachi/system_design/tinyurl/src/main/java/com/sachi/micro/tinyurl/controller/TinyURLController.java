package com.sachi.micro.tinyurl.controller;

import com.sachi.micro.tinyurl.data.model.InputURL;
import com.sachi.micro.tinyurl.data.model.URL;
import com.sachi.micro.tinyurl.exception.BadInput;
import com.sachi.micro.tinyurl.exception.ResourceNotFoundException;
import com.sachi.micro.tinyurl.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class TinyURLController {

    @Autowired
    private URLService urlService;

    @GetMapping("/all")
    public ResponseEntity<List<URL>> getAll() {
        return ResponseEntity.ok().body(urlService.getAll());
    }

    @GetMapping("/{shortCode}")
    public RedirectView getURLById(@PathVariable(value = "shortCode") String shortCode) throws ResourceNotFoundException, BadInput {
        if (shortCode == null || shortCode.isBlank()) {
            throw new BadInput("Code cannot be null");
        }
        URL url = urlService.getURLById(shortCode);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url.getLongURL());
        return redirectView;
    }

    @PostMapping("/shorten")
    public ResponseEntity<URL> shortenURL(@RequestBody InputURL input) throws BadInput {
        if (input == null || input.getUrl() == null || input.getUrl().isBlank()) {
            throw new BadInput("Code cannot be null");
        }
        return ResponseEntity.ok().body(urlService.getShortURL(input.getUrl(), 3));
    }
}

